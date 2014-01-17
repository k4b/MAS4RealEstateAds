package szybko_pl;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Gelu on 15.01.14.
 */
public class Main {

    public static void main(String[] args){
        SzybkoFilterBuilder szybkoFilterBuilder = new SzybkoFilterBuilder();
        String builded = szybkoFilterBuilder.withCity("Warszawa").withPriceMax(500000).build();
        System.out.println(builded);
        SzybkoPlParser parser = new SzybkoPlParser();
        URL url = null;
        try {
             url = new URL (builded);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        parser.startParsing(url,30);


    }
}
