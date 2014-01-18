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
        try {
            URL url = new URL(builtUrlWithFilters);
            SzybkoPlParsingThread parsingThread = new SzybkoPlParsingThread(url, ads);
            parsingThread.start();
            Thread.sleep(15000);
            parsingThread.setStopExecution(true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("skonczylem");

    }



}
