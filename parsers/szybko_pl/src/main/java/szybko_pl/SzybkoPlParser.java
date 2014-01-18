package szybko_pl;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import common.ads.Ad;
import common.ads.Filter;
import common.parsers.ParserAgent;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SzybkoPlParser extends ParserAgent {


    @Override
    protected void setup() {
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setName(getLocalName());
        serviceDescription.setType("parser");
        communicationModule.register(serviceDescription);
        System.out.println("Starting Parser " + this.getName());
        addBehaviour(new ReceiverBehaviourReceivePing(this));

    }


    @Override
    public void startParsing(Filter filter) {
        System.out.println("startuje parsowanie");
        SzybkoFilterBuilder szybkoFilterBuilder = new SzybkoFilterBuilder(filter);
        String builtUrlWithFilters = szybkoFilterBuilder.build();
        try {
            URL url = new URL(builtUrlWithFilters);
            ParsingThread parsingThread = new ParsingThread(url, ads);
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
