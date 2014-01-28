package szybko_pl;

import java.net.MalformedURLException;
import java.net.URL;

import common.ads.Filter;
import common.parsers.ParserAgent;

public class SzybkoPlParser extends ParserAgent {


    @Override
    public void startParsing(Filter filter) {
        System.out.println("startuje parsowanie");
        SzybkoFilterBuilder szybkoFilterBuilder = new SzybkoFilterBuilder(filter);
        String builtUrlWithFilters = szybkoFilterBuilder.build();

        builtUrlWithFilters = replaceSpecialCharactersToAscii(builtUrlWithFilters);
        System.out.println(builtUrlWithFilters);
        long timeLimit;
        try{
              timeLimit = Math.abs(Long.parseLong(filter.getTimeLimit()));
        } catch(NumberFormatException e){
             timeLimit = 15000;
            System.out.print("3");
        }
        try {
            System.out.print(timeLimit);
            URL url = new URL(builtUrlWithFilters);
            SzybkoPlParsingThread parsingThread = new SzybkoPlParsingThread(url, ads);
            parsingThread.start();
            Thread.sleep(timeLimit);
            parsingThread.setStopExecution(true);
        } catch (MalformedURLException e) {
            System.out.print("1");
        } catch (InterruptedException e) {
            System.out.print("2");
        } catch(Exception e){
            System.out.print("3");
        }

        System.out.println("skonczylem");

    }

    private String replaceSpecialCharactersToAscii(String builtUrlWithFilters) {
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[Ł]","%C5%81");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[ł]","%C5%82");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[Ó]","%C3%93");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[ó]","%C3%B3");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[Ź]","%C5%B9");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[ź]","%C5%BA");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[ż]","%C5%BC");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[Ż]","%C5%BB");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[ć]","%C4%87");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[Ć]","%C4%86");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[ś]","%C5%9B");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[Ś]","%C5%9A");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[ę]","%C4%99");
        builtUrlWithFilters = builtUrlWithFilters.replaceAll("[ą]","%C4%85");
        return builtUrlWithFilters;
    }


}
