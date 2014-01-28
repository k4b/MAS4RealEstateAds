package gumtree_pl;

import java.net.URL;

import common.ads.Filter;
import common.parsers.ParserAgent;

public class GumtreePlParser extends ParserAgent {

	private static final long serialVersionUID = 1L;

	@Override
	public void startParsing(Filter filter) {                
        GumtreeFilterBuilder filterBuilder = new GumtreeFilterBuilder(filter);
        String urlWithFilters = filterBuilder.build();
        System.out.println(urlWithFilters);
        try {
            URL url = new URL(urlWithFilters);
            GumtreePlParsingThread parsingThread = new GumtreePlParsingThread(url, ads);
            parsingThread.start();
            
            long timeLimit  = Long.parseLong(filter.getTimeLimit());
            Thread.sleep(timeLimit);
            parsingThread.setStopExecution(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
