package szybko_pl;

import common.ads.Ad;
import common.parsers.ParserAgent;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gelu on 18.01.14.
 */
public class SzybkoPlParsingThread extends  Thread {

    private URL url;
    private final static String BASE_URL = "http://szybko.pl";
    private final static String AREA_KEY = "powierzchnia";
    private final static String FLOOR_KEY = "piętro";
    private final static String NUMBER_OF_BUILDING_FLOORS_KEY = "liczba pięter w budynku";
    private final static String NUMBER_OF_BEDROOMS_KEY = "liczba sypialni";
    private final static String NUMBER_OF_BATHROOMS_KEY = "liczba łazienek";
    private final static String CONSTRUCTION_YEAR_KEY = "rok budowy";
    private final static String LAST_UPDATE_KEY = "data ostatniej aktualizacji";
    private  boolean stopExecution;

    private List<Ad> ads;

    public SzybkoPlParsingThread(URL url, List<Ad> ads){
        this.url = url;
        this.ads = ads;
        stopExecution = false;
    }

    @Override
    public void run()
    {
        boolean endOfResults = false;
        while (!endOfResults && !stopExecution) {
            Document doc = ParserAgent.downloadWebpage(url);
            Elements elements = doc.getElementsByClass("search-classic");
            Iterator<Element> iterator = elements.iterator();
            while (iterator.hasNext() && !stopExecution) {
                Elements selectedLink = iterator.next().select("a");
                String relativePath = selectedLink.first().attr("href");
                try {
                    URL createdUrl = new URL(BASE_URL + relativePath);
                    parseSearchResults(createdUrl);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

            Elements paginationElements = doc.getElementsByClass("pagination");
            if (paginationElements != null) {
                Element nextPageElementAvaiable = paginationElements.first().select("li").select(":contains(Następna)").first();
                if (nextPageElementAvaiable != null) {
                    Element nextPageElement = paginationElements.first().select("li").last();
                    try {
                        String relativePath = nextPageElement.select("a").attr("href");
                        url = new URL(BASE_URL + relativePath);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        endOfResults = true;
                    }
                } else {
                    endOfResults = true;
                }
            } else {
                endOfResults = true;
            }
        }
    }

    public void parseSearchResults(URL url) {
        System.out.println(url.toString());
        Document doc = ParserAgent.downloadWebpage(url);
        Ad ad = new Ad();
        if (doc == null) {
            System.out.println(" no site");
            return;
        }
        ad.setLink(url.toString());
        fillAdWithTitleAndDescription(doc, ad);
        fillAdWithCityAndDistrict(doc, ad);
        fillAdWithPrices(doc, ad);
        fillAdWithDetails(doc, ad);
        ads.add(ad);

    }


    private static void fillAdWithDetails(Document doc, Ad ad) {
        Elements e = doc.getElementsByClass("list-unstyled").addClass("det-details");
        Elements elements = e.first().getAllElements().select("li");
        for (Element element : elements) {
            String key = element.text().substring(0, element.text().indexOf(":"));

            switch (key) {
                case AREA_KEY:
                    String area = element.text().replaceAll("m2", "").replaceAll("\\D", "");
                    ad.setArea(Double.parseDouble(area));
                    break;
                case FLOOR_KEY:
                    String floor = element.text().replaceAll("\\D", "");
                    if (floor.equals(""))
                        ad.setFloor(0);
                    else
                        ad.setFloor(Integer.parseInt(floor));
                    break;
                case NUMBER_OF_BUILDING_FLOORS_KEY:
                    String numOfBuildingFloors = element.text().replaceAll("\\D", "");
                    ad.setNumFloors(Integer.parseInt(numOfBuildingFloors));
                    break;
                case NUMBER_OF_BEDROOMS_KEY:
                    String numOfBedrooms = element.text().replaceAll("\\D", "");
                    ad.setNumBedrooms(Integer.parseInt(numOfBedrooms));
                    break;
                case NUMBER_OF_BATHROOMS_KEY:
                    String numOfBathrooms = element.text().replaceAll("\\D", "");
                    ad.setNumBathrooms(Integer.parseInt(numOfBathrooms));
                    break;
                case CONSTRUCTION_YEAR_KEY:
                    String constructionYear = element.text().replaceAll("\\D", "");
                    ad.setConstructionYear(Integer.parseInt(constructionYear));
                    break;
                case LAST_UPDATE_KEY:
                    String lastUpdate = element.text().substring(element.text().indexOf(":") + 1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date lastUpdateDate = null;
                    try {
                        lastUpdateDate = simpleDateFormat.parse(lastUpdate);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    ad.setLastUpdate(lastUpdateDate);
                    break;
            }

        }

    }

    private static void fillAdWithPrices(Document doc, Ad ad) {
        Element kolejnyElement = doc.getElementsByClass("list-inline").addClass("blog-tags").first();
        Element pajac = kolejnyElement.getAllElements().select("li").select("em").first();
        Elements el = pajac.getElementsByTag("span");
        Element price = el.get(1);
        Element pricePerMeter = el.get(2);
        ad.setPrice(Integer.parseInt(price.text()));
        ad.setPricePerMeter(Integer.parseInt(pricePerMeter.text()));
    }

    private static void fillAdWithCityAndDistrict(Document doc, Ad ad) {
        Element bar = doc.getElementsByClass("page-breadcrumb").addClass("breadcrumb").first();
        Elements elka = bar.getAllElements().select("li");
        Element city = elka.get(4);
        Element district = elka.get(5);
        ad.setCity(city.select("a").select("span").text());
        ad.setDistrict(district.select("a").select("span").text());
    }

    private static void fillAdWithTitleAndDescription(Document doc, Ad ad) {
        Element title = doc.getElementsByTag("h1").first();
        ad.setTitle(title.text());
        Element desc = doc.getElementsByClass("more-block").first();
        ad.setDescription(desc.text());
    }



    public boolean isStopExecution() {
        return stopExecution;
    }

    public void setStopExecution(boolean stopExecution) {
        this.stopExecution = stopExecution;
    }
}
