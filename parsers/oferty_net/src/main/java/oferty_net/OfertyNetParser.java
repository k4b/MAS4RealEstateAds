package oferty_net;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import parser.AbstractParser;
import common.ads.Ad;
import common.ads.AdsConstants;

/**
 * Extracts ad data from downloaded webpage. Uses Jsoup library.
 * @author Karol Abramczyk
 */
public class OfertyNetParser extends AbstractParser {
    
    public OfertyNetParser(int maxPages) {
      super(maxPages);
    }

    private static final String TAG = "tbody";
    
    /**
     * Parses ad search results. Starts with first page of advertising website results and then continues to <i>counterMax</i>-th page of results. 
     * @param url URL to first page of search results
     * @param TAG Table element containing search results
     * @param counterMax Maximum number of analyzed pages 
     */
    public void startParsing(URL url, int counterMax) {
        while(isRunning) {
            parseSearchResults(url);
            URL nextUrl = getNextUrl(url);
            isRunning(counterMax);
            if((nextUrl.getPath()).isEmpty())
                isRunning = false;
        }
    }
    
    /**
     * Parses one page of ad serching results
     * @param url URL of results webpage
     * @param TAG Tag containing multiple ads
     */
    public void parseSearchResults(URL url) {
        pagesCounter++;
        Document doc = downloadWebpage(url);
        if(doc == null) {
            System.out.println(pagesCounter + " no site");
            return;
        }
        Element e = getElementByTag(doc, TAG);
        if(e == null) {
            System.out.println(pagesCounter + " no <" + TAG + "> tags in source of URL " + url);
            return;
        }
        createObjects(e, ads);
        System.out.println(pagesCounter + " " + ads.size());
    }
    
    /**
     * Returns first element of specified Tag within Document
     * @param doc Document for tag extraction
     * @param tag Searched tag
     * @return First element of specified tag
     */
    private Element getElementByTag(Document doc, String tag) {
        Elements all = doc.select(tag);
//        Elements all = doc.getElementsByTag(tag);
        if(all.size() == 0)
            return null;
        else
            return all.first();
    }
    
    private Element getElementByClass(Document doc, String classname) {
        Elements all = doc.getElementsByClass(classname);
        return all.first();
    }
    
    private void createObjects( Element element, ArrayList ads) {
        StringTokenizer st;
        
        if(element == null)
            return ;
        
        Elements children = element.children();
        if(children == null)
            return ;
        
        for(Element child : children) {
            if(child.className().trim().contains("property")) {
                Ad a = new Ad();
                //get location
                Element e1 = child.getElementsByClass("cell_location").first();
                Element e2 = null;
                if(e1!=null && e1.childNodeSize() > 0)
                    e2 = e1.getElementsByTag("a").first();
                String location = ",";
                if(e2 != null && e2.hasText()) {
                    location = e2.text();
                    st = new StringTokenizer(location, ",");
                    a.setCity(st.nextToken().trim());
                    a.setDistrict(st.nextToken().trim());
                }
                
                //get last update
                String dateString = child.getElementsByClass("cell_location").first().getElementsByTag("p").first().text();
                dateString.trim();
                st = new StringTokenizer(dateString, " ");
                int length = st.countTokens();
                if(length > 1) {
                    st.nextToken();
                    dateString = st.nextToken();
                }
                dateString.trim();
                DateFormat formatter = new SimpleDateFormat("DD-MM-YYYY");
                Date date = null;
                if(dateString.equals("dziś")) {
                    date = new Date();
                } else {
                    try {
                        date = formatter.parse(dateString);
                    } catch (ParseException ex) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
                a.setLastUpdate(date);
                
                //get street
                String street = child.getElementsByClass("cell_street").first().getElementsByTag("div").first().text();
                street.trim();
                a.setStreet(street);
                
                //get rooms
                String rooms = child.getElementsByClass("cell_rooms").first().text();
                rooms.trim();
                int b = -1;
                b = Integer.parseInt(rooms);
                a.setNumBedrooms(b);
                
                //get area
                String area = child.getElementsByClass("cell_area").first().text();
                area.trim();
                double ar = -1.0;
                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                Number number = 0;
                try {
                    number = format.parse(area);
                } catch (ParseException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                }
                ar = number.doubleValue();
                a.setArea(ar);
                
                //get title
                a.setTitle(a.getCity() + ", " + a.getDistrict() + ", " + a.getStreet() + ", " + a.getArea());
                
                //get floor
                String floor = child.getElementsByClass("cell_floor").first().text();
                floor.trim();
                if(floor.equals("parter")) {
                    floor = "0";
                }
                int f = -1;
                if(isNumeric(floor)) {
                    f = Integer.parseInt(floor);
                }
                a.setFloor(f);
                
                //get price
                String priceString = child.getElementsByClass("cell_price").first().getElementsByTag("div").first().text();
                priceString.trim();
                // remove "&nbsp;"
                priceString = priceString.replace("\u00a0","");
                priceString = priceString.replaceAll("PLN", "");
                priceString =  priceString.replaceAll("\\s", "");
                int p = -1;
                p = Integer.parseInt(priceString);
                a.setPrice(p);
                
                //get price per meter
                if(a.getPrice() > -1 && a.getArea() > -1) {
                    int ppm = (int)(a.getPrice()/a.getArea());
                    a.setPricePerMeter(ppm);
                }
                
                //get link
                String link = null;
                if(a.getCity() != null || a.getDistrict() != null)
                    link = child.getElementsByClass("cell_location").first().getElementsByTag("a").first().attr("href");
                if(link != null) {
                    link.trim();
                    a.setLink(link);
                    URL url = null;
                    try {
                      url = new URL(link);
                    } catch (MalformedURLException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
                    }
                    parseDetails(url, a);
                }
                
                ads.add(a);
            }
        }
    }
    
    public void parseDetails(URL url, Ad a) {
        if(url == null) {
          System.out.println("Empty url");
          return;
        }
        Document doc = downloadWebpage(url);
        if(doc == null) {
            System.out.println("no details");
            return;
        }
        Element desc = doc.select("#description").first();
        String description = desc.text();
        if(description != null) {
            a.setDescription(description);
        }
    }
   
    public URL getNextUrl(URL url) {
        String output = "";
        URL nextURL = null;
        
        Document doc = downloadWebpage(url);
        if(doc == null) {
            return null;
        }
        
        Element element = doc.select(".navigateNext").select("a").first();
        if(element != null) {
            output += "http://www.oferty.net";
            output += element.attr("href");
        }
        try {
          nextURL = new URL(output);
        } catch (MalformedURLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return nextURL;
    }
    
    public static boolean isNumeric(String str)
    {
      return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    @Override
    public URL constructRequestUrl() {
      throw new UnsupportedOperationException();
    }
}
