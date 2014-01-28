package gumtree_pl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.ads.Filter;

public class GumtreeFilterBuilder {

	private String BASE_URL_SELL_BUY = "http://www.gumtree.pl/fp-domy-i-mieszkania-sprzedam-i-kupie/c9073";
	private String BASE_URL_FOR_RENT = "http://www.gumtree.pl/fp-domy-i-mieszkania-do-wynajecia/c9008";
	
	private Filter filter;
	private List<String> parameters = new ArrayList<String>();
		
	public GumtreeFilterBuilder(Filter filter) {
		this.filter = filter;
		
		addAddress();
		addPrice();
		addArea();
		addEstateType();
		addNumberOfRooms();
		addAdvertismentType();
		addAdvertiser();
	}
	
	private void addAddress() {
		String district = filter.getDistrict();
		String city = filter.getCity();
		
		if(district != null && !district.isEmpty()) {
			BASE_URL_SELL_BUY = GumtreeLocCodes.addCode(district, BASE_URL_SELL_BUY);
			BASE_URL_FOR_RENT = GumtreeLocCodes.addCode(district, BASE_URL_FOR_RENT);
		} else if(city != null && !city.isEmpty()) {
			BASE_URL_SELL_BUY = GumtreeLocCodes.addCode(city, BASE_URL_SELL_BUY);
			BASE_URL_FOR_RENT = GumtreeLocCodes.addCode(city, BASE_URL_FOR_RENT);
		}
	}
	
	private void addPrice() {
		String priceMin = filter.getPriceMin();
		if(priceMin != null && !priceMin.isEmpty()) {
			String value = "minPrice=" + priceMin;
			parameters.add(value);
		}
		
		String priceMax = filter.getPriceMax();
		if(priceMax != null && !priceMax.isEmpty()) {
			String value = "maxPrice=" + priceMax;
			parameters.add(value);
		}	
	}
	
	private void addArea() {
		String areaMin = filter.getAreaMin();
		if(areaMin != null && !areaMin.isEmpty()) {
			String value = "A_AreaInMeters_min=" + areaMin;
			parameters.add(value);
		}
		
		String areaMax = filter.getAreaMax();
		if(areaMax != null && !areaMax.isEmpty()) {
			String value = "A_AreaInMeters_max=" + areaMax;
			parameters.add(value);
		}
	}
	
	private void addEstateType() {
		String estateType = filter.getEstateType();
		if(estateType != null && !estateType.isEmpty()) {
			String value = "A_DwellingType=";
			switch(estateType) {
				case "Mieszkanie":
					value += "flat";
					break;
				case "Dom":
					value += "house";
					break;
				case "Inne":
					value += "other";
					break;
			}
			parameters.add(value);
		}
	}
	
	private void addNumberOfRooms() {
		String roomsNumMin = filter.getRoomsNumMin();
		String roomsNumMax = filter.getRoomsNumMax();
		
		boolean minCond = roomsNumMin != null && !roomsNumMin.isEmpty();
		boolean maxCond = roomsNumMax != null && !roomsNumMax.isEmpty();
		if(!minCond && !maxCond) {
			return;
		}
		
		int min = minCond ? Integer.parseInt(roomsNumMin) : 1;
		int max = maxCond ? Integer.parseInt(roomsNumMax) : 6;
		
		String value = "A_NumberRooms=";
		for(int i = min; i <= max; ++i) {
			value += i == 1 ? i + "0" : i;
			if(i != max) {
				value += "%2C";
			}
		}
		
		parameters.add(value);
	}
	
	private void addAdvertismentType() {
		String adType = filter.getAdType();
		if(adType != null && !adType.isEmpty()) {
			String value = "AdType=";
			switch(adType) {
				case "Oferowane":
					value += "2";
					break;
				case "Poszukiwane":
					value += "1";
					break;
			}
			parameters.add(value);
		}
	}
	
	private void addAdvertiser() {
		String advertiser = filter.getAdvertiser();
		if(advertiser != null && !advertiser.isEmpty()) {
			String value = filter.getTransactionType() == "Kupno/Sprzedaż" ? "A_DwellingForSaleBy=" : "A_ForRentBy=";
			switch(advertiser) {
				case "Właściciel":
					value += "ownr";
					break;
				case "Agencja":
					value += "agncy";
					break;
			}
			parameters.add(value);
		}
	}
	
	public String build() {
		StringBuilder builder = new StringBuilder();
		
		String transactionType = filter.getTransactionType();
		if(transactionType != null && !transactionType.isEmpty()) {
			switch(transactionType) {
				case "Kupno/Sprzedaż":
					builder.append(BASE_URL_SELL_BUY);
					break;
				case "Wynajem":
					builder.append(BASE_URL_FOR_RENT);
					break;
			}
		}
			
		Iterator<String> iterator = parameters.iterator();
	
		boolean first = true;
		while(iterator.hasNext()) {
			String param = iterator.next();
			if(first) {
				builder.append("?");
				first = false;
			} else {
				builder.append("&");
			}
			builder.append(param);
		}
		
		return builder.toString();
	}
}
