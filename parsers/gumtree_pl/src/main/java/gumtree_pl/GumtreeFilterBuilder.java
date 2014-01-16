package gumtree_pl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GumtreeFilterBuilder {

	private static final String BASE_URL = "http://www.gumtree.pl/fp-domy-i-mieszkania-sprzedam-i-kupie/c9073";
	private List<String> parameters = new ArrayList<String>();
		
	public GumtreeFilterBuilder addMinArea(double minArea) {
		String value = "A_AreaInMeters_min=" + minArea;
		parameters.add(value.replace(".", "%2C"));
		return this;
	}
	
	public GumtreeFilterBuilder addMaxArea(double maxArea) {
		String value = "A_AreaInMeters_max=" + maxArea;
		parameters.add(value.replace(".", "%2C"));
		return this;
	}
	
	public GumtreeFilterBuilder addNumOfRooms(int numOfRooms) {
		if(numOfRooms == 1) {
			numOfRooms = 10;
		}
		String value = "A_NumberRooms=" + numOfRooms;
		parameters.add(value);
		return this;
	}
	
	public GumtreeFilterBuilder addMinPrie(int minPrice) {
		String value = "minPrice=" + minPrice;
		parameters.add(value);
		return this;
	}
	
	public GumtreeFilterBuilder addMaxPrice(int maxPrice) {
		String value = "maxPrice=" + maxPrice;
		parameters.add(value);
		return this;
	}
	
	public String build() {
		StringBuilder builder = new StringBuilder(BASE_URL);
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
