package gumtree_pl;

import java.util.HashMap;
import java.util.Map;

public class GumtreeLocCodes {

	private static Map<String, String> locCodesMap = new HashMap<String, String>();
	
	static {
		locCodesMap.put("Warszawa", "warszawa/XXXl3200008");
		locCodesMap.put("Żoliborz", "zoliborz/XXXl3200026");
		locCodesMap.put("Wola", "wola/XXXl3200025");
		locCodesMap.put("Włochy", "wlochy/XXXl3200024");
		locCodesMap.put("Wesoła", "wesola/XXXl3200022");
		locCodesMap.put("Wawer", "wawer/XXXl3200021");
		locCodesMap.put("Ursynów", "ursynow/XXXl3200020");
		locCodesMap.put("Ursus", "ursus/XXXl3200019");
		locCodesMap.put("Targówek", "targowek/XXXl3200018");
		locCodesMap.put("Śródmieście", "srodmiescie/XXXl3200017");
		locCodesMap.put("Rembertów", "rembertow/XXXl3200016");
		locCodesMap.put("Praga Południe", "praga-poludnie/XXXl3200015");
		locCodesMap.put("Praga Północ", "praga-polnoc/XXXl3200014");
		locCodesMap.put("Ochota", "ochota/XXXl3200013");
		locCodesMap.put("Mokotów", "mokotow/XXXl3200012");
		locCodesMap.put("Bielany", "bielany/XXXl3200011");
		locCodesMap.put("Białołęka", "bialoleka/XXXl3200010");
		locCodesMap.put("Bemowo", "bemowo/XXXl3200009");
	}
	
	public static String addCode(String key, String base)
	{
		String result = base;
		
		String value = locCodesMap.get(key);
		if(value != null) {
			String prefix = base.substring(base.length() - 5, base.length());
			result = base.replace(prefix, "") + value.replace("XXX", prefix);
		}
		
		return result;
	}
	
}
