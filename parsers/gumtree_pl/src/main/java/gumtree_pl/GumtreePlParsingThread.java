package gumtree_pl;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import common.ads.Ad;
import common.parsers.ParserAgent;

public class GumtreePlParsingThread extends Thread {

	private static final String ADDRESS_KEY = "Adres";
	private static final String PRICE_KEY = "Cena";
	private static final String NUM_BEDROOMS_KEY = "Liczba pokoi";
	private static final String NUM_BATHROOMS_KEY = "Liczba łazienek";
	private static final String AREA_KEY = "Wielkość (m2)";
	private static final String LAST_UPDATE_KEY = "Ostatnio zmieniony";
	private static final String CREATION_DATE_KEY = "Data dodania";
	
    private URL url;
    private List<Ad> ads;
    private boolean stopExecution;
    
    public GumtreePlParsingThread(URL url, List<Ad> ads){
    	this.url = url;
        this.ads = ads;
        stopExecution = false;
    }
    
    public boolean isStopExecution() {
        return stopExecution;
    }

    public void setStopExecution(boolean stopExecution) {
        this.stopExecution = stopExecution;
    }
    
    @Override
    public void run() {
    	startParsing();
    	
  		System.out.println("Ilość: " + ads.size());
//  		for(Ad ad : ads) {
//  			System.out.println(ad.toString());
//  		}
    }
    
	public void startParsing() {
		Document doc  = ParserAgent.downloadWebpage(url);
		Elements elements = doc.getElementsByClass("adLinkSB");
		Iterator<Element> iterator = elements.iterator();
		while(!stopExecution) {
			try {
				Element element = iterator.next();
				URL current = new URL(element.attr("href"));
				parseSearchResults(current);
			} catch(NoSuchElementException e) {
				url = getNextURL(doc);
				if(url != null) {
					startParsing();
					break;
				} else {
					break;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
    
	public void parseSearchResults(URL url) {
		Document doc = ParserAgent.downloadWebpage(url);
		Ad ad = new Ad();
		
		String title = doc.getElementById("preview-local-title").text().trim();
		ad.setTitle(title);
		
		String description = doc.getElementById("preview-local-desc").text().trim();
		ad.setDescription(description);

		Element table = doc.getElementById("attributeTable");
		Elements rows = table.getElementsByTag("tr");

		String key, value;
		for (Element row : rows) {
			Elements columns = row.children();
			key = columns.get(0).text().trim();
			value = columns.get(1).text().trim();

			try {
				switch (key) {
					case ADDRESS_KEY:
						Map<String, String> parts = getAddress(value);
						ad.setCity(parts.get("city"));
						ad.setDistrict(parts.get("district"));
						ad.setStreet(parts.get("street"));
						break;
					case PRICE_KEY:
						int price = getPrice(value);
						ad.setPrice(price);
						break;
					case NUM_BEDROOMS_KEY:
						int numBedrooms = getNumberOfBedrooms(value);
						ad.setNumBedrooms(numBedrooms);
						break;
					case NUM_BATHROOMS_KEY:
						int numBathrooms = getNumberOfBathrooms(value);
						ad.setNumBathrooms(numBathrooms);
						break;
					case AREA_KEY:
						double area = getArea(value);
						ad.setArea(area);
						break;
					case LAST_UPDATE_KEY:
						Date lastUpdate = getLastUpdate(value);
						ad.setLastUpdate(lastUpdate);
						break;
					case CREATION_DATE_KEY:
						Date creationDate = getCreationDate(value);
						ad.setCreationDate(creationDate);
						break;
				}
			} catch(Exception e) {
				e.printStackTrace();
				return;
			}
		}

		int pricePerMeter = calculatePricePerMeter(ad.getPrice(), ad.getArea());
		ad.setPricePerMeter(pricePerMeter);
				
		String link = url.toString();
		ad.setLink(link);
		ad.setWebsite("gumtree.pl");
		
		ads.add(ad);
	}

	private Map<String, String> getAddress(String value) {
		String address = value.replaceAll("Polska|Pokaż mapę|[0-9]{2}-[0-9]{3}|[0-9]+[a-zA-Z]*", "").trim();
		String[] parts = address.split(",");
		
		String city = null, district = null, street = null;
		Map<String, String> result = new HashMap<String, String>();
		if(parts.length == 1) {
			city = parts[0].trim();
		} else if (parts.length == 2) {
			city = parts[1].trim();
			street = parts[0].trim();
		}
		
		result.put("city", city);
		result.put("district", district);
		result.put("street", street);
		return result;
	}

	private int getPrice(String value) {
		String onlyNumbers = value.replaceAll("[^0-9]", "");
		String withoutDecimals = onlyNumbers.substring(0, onlyNumbers.length() - 2);
		int price = Integer.parseInt(withoutDecimals);
		return price;
	}

	private int getNumberOfBedrooms(String value) {
		if(value.equals("Kawalerka lub garsoniera")) {
			return 1;
		}
		String onlyNumbers = value.replaceAll("[^0-9]", "");
		int numBedrooms = Integer.parseInt(onlyNumbers);
		return numBedrooms;
	}
	
	private int getNumberOfBathrooms(String value) {
		String onlyNumbers = value.replaceAll("[^0-9]", "");
		int numBathrooms = Integer.parseInt(onlyNumbers);
		return numBathrooms;
	}

	private double getArea(String value) {
		double area = Double.parseDouble(value);
		return area;
	}
	
	private Date getLastUpdate(String value) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date lastUpdate = dateFormat.parse(value);
		return lastUpdate;
	}

	private Date getCreationDate(String value) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date creationDate = dateFormat.parse(value);
		return creationDate;
	}
	
	private int calculatePricePerMeter(int price, double area) {
		int pricePerMeter = (int) (price / area);
		return pricePerMeter;
	}
	
	private URL getNextURL(Document doc) {
		URL result = null;
		Element element = doc.getElementsByClass("prevNextLink").last();
		try {
			if(element.text().startsWith("Następne")) {
				String link = element.attr("href");
				result = new URL(link);
				System.out.println(link);
			}
		} catch(Exception e) {
			return null;
		}
		return result;
	}

}
