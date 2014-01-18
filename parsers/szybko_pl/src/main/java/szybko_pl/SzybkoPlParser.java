package szybko_pl;

import java.net.MalformedURLException;
import java.net.URL;

import common.ads.Filter;
import common.parsers.ParserAgent;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class SzybkoPlParser extends ParserAgent {


    @Override
    public void startParsing(Filter filter) {
        System.out.println("startuje parsowanie");
        SzybkoFilterBuilder szybkoFilterBuilder = new SzybkoFilterBuilder(filter);
        String builtUrlWithFilters = szybkoFilterBuilder.build();
        System.out.println(builtUrlWithFilters);
        long timeLimit;
        try{
              timeLimit = Math.abs(Long.parseLong(filter.getTimeLimit()));
        } catch(NumberFormatException e){
             timeLimit = 5;
            System.out.print("3");
        }
        try {
            timeLimit = 5000;
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


}
