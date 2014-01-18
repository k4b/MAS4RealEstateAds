package szybko_pl;

import common.ads.Filter;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Gelu on 15.01.14.
 */
public class Main {

    public static void main(String[] args) {
        Filter filter = new Filter();
        filter.setCity("Warszawa");
        filter.setDistrict("Bemowo");
        filter.setPriceMin("50000");
        filter.setPriceMax("300000");
        filter.setPricePerMeterMin("2000");
        filter.setPricePerMeterMax("12000");
        filter.setAreaMin("25");
        filter.setAreaMax("100");
        filter.setRoomsNumMin("2");
        filter.setRoomsNumMax("10");
        filter.setConstructionYearMin("1990");
        filter.setConstructionYearMax("2006");
        filter.setFloorMin("1");
        filter.setFloorMax("4");
        filter.setNumFloorsMin("1");
        filter.setNumFloorsMax("4");
        SzybkoFilterBuilder builder = new SzybkoFilterBuilder(filter);
        System.out.print(builder.build());
//        SzybkoFilterBuilder szybkoFilterBuilder = new SzybkoFilterBuilder();
//        String builded = szybkoFilterBuilder.withCity("Warszawa").withPriceMax(500000).build();
//        System.out.println(builded);
//        SzybkoPlParser parser = new SzybkoPlParser();
//        URL url = null;
//        try {
//             url = new URL (builded);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        parser.startParsing(url,30);


    }
}
