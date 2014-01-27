package szybko_pl;

import com.google.gson.Gson;
import common.ads.Filter;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Gelu on 15.01.14.
 */
public class Main {

    public static void main(String[] args) {
        String filterAsString ="{\"SolrUrl\":\"http://localhost:8983/solr\",\"filter\":{\"city\":\"Warszawa\",\"district\":\"Praga\",\"street\":\"\",\"priceMin\":\"100000\",\"priceMax\":\"320000\",\"pricePerMeterMin\":\"2000\",\"pricePerMeterMax\":\"6500\",\"areaMin\":\"30\",\"areaMax\":\"50\",\"estateType\":\"Mieszkanie\",\"transactionType\":\"Kupno/Sprzeda�\",\"roomsNumMin\":\"1\",\"roomsNumMax\":\"3\",\"adType\":\"Oferowane\",\"advertiser\":\"W�a�ciciel\",\"timeLimit\":\"60000\"}}\n";
        Gson gson = new Gson();
        System.out.println("kłóżźć");
        Filter filter = gson.fromJson(filterAsString,Filter.class);
//        Filter filter = new Filter();
//        filter.setCity("Warszawa");
//        filter.setDistrict("Bemowo");
//        filter.setPriceMin("50000");
//        filter.setPriceMax("300000");
//        filter.setPricePerMeterMin("2000");
//        filter.setPricePerMeterMax("12000");
//        filter.setAreaMin("25");
//        filter.setAreaMax("100");
//        filter.setRoomsNumMin("2");
//        filter.setRoomsNumMax("10");
//        filter.setConstructionYearMin("1990");
//        filter.setConstructionYearMax("2006");
//        filter.setFloorMin("1");
//        filter.setFloorMax("4");
//        filter.setNumFloorsMin("1");
//        filter.setNumFloorsMax("4");
//        SzybkoFilterBuilder builder = new SzybkoFilterBuilder(filter);
//        System.out.print(builder.build());
//        SzybkoFilterBuilder szybkoFilterBuilder = new SzybkoFilterBuilder();
//        String builded = szybkoFilterBuilder.withCity("Warszawa").withPriceMax(500000).build();
//        System.out.println(builded);
        SzybkoPlParser parser = new SzybkoPlParser();
        URL url = null;
//        try {
//             url = new URL (builded);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        parser.startParsing(filter);


    }
}
