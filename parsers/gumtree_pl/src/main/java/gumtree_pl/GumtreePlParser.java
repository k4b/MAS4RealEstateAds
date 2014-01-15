package gumtree_pl;

import jade.core.NotFoundException;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import common.ads.Ad;
import common.parsers.ParserAgent;

public class GumtreePlParser extends ParserAgent {

	private static final String ADDRESS_KEY = "Adres";
	private static final String PRICE_KEY = "Cena";
	private static final String NUM_BEDROOMS_KEY = "Liczba pokoi";
	private static final String NUM_BATHROOMS_KEY = "Liczba ³azienek";
	private static final String AREA_KEY = "Wielkoœæ (m2)";
	private static final String LAST_UPDATE_KEY = "Ostatnio zmieniony";
	private static final String CREATION_DATE_KEY = "Data dodania";
	
	public GumtreePlParser(int maxPages) {
		super(maxPages);
	}

	@Override
	public URL constructRequestUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startParsing(URL url, int maxPages) {
		int i = 1;
		boolean hasNext = true;
		while(hasNext) {			
			Document doc  = downloadWebpage(url);
			Elements elements = doc.getElementsByClass("adLinkSB");
			for(Element element : elements) {
				System.out.println(i + " " + element.attr("href"));
				i++;
			}
			try {
				url = getNextURL(doc);
			} catch(Exception e) {
				e.printStackTrace();
				hasNext = false;
			}
		}
	}

	@Override
	public void parseSearchResults(URL url) {
		Document doc = downloadWebpage(url);
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
				continue;
			}
		}

		int pricePerMeter = calculatePricePerMeter(ad.getPrice(), ad.getArea());
		ad.setPricePerMeter(pricePerMeter);
		
		// int floor; BD
		// int constructionYear; BD
		// int numFloors; BD
		
		String link = url.toString();
		ad.setLink(link);
		
		System.out.println(ad.toString());
	}

	@Override
	public void parseDetails(URL url, Ad a) {
		throw new UnsupportedOperationException();
	}

	private Map<String, String> getAddress(String value) {
		String withoutShowMap = value.replace("Poka¿ mapê", "");
		String withoutCountry = withoutShowMap.replace("Polska", "");
		String withoutCommas = withoutCountry.replaceAll(",", "").trim();
		String[] parts = withoutCommas.split(" ");
		
		String city = null, street = null;
		Map<String, String> result = new HashMap<String, String>();
		if(parts.length == 1) {
			city = parts[0];
		} else if (parts.length == 2) {
			city = parts[1];
			street = parts[0];
		}
		// String district; BD
		
		result.put("city", city);
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
	
	private URL getNextURL(Document doc) throws MalformedURLException, NotFoundException {
		Element element = doc.getElementsByClass("prevNextLink").last();
		if(element.text().startsWith("Nastêpne")) {
			String link = element.attr("href");
			return new URL(link);	
		}
		throw new NotFoundException();
	}
}
