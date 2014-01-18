package gumtree_pl;

import java.net.URL;

import common.ads.Filter;
import common.parsers.ParserAgent;

public class GumtreePlParser extends ParserAgent {

	private static final long serialVersionUID = 1L;

	@Override
	public void startParsing(Filter filter) {                
//        GumtreeFilterBuilder filterBuilder = new GumtreeFilterBuilder(filter);
//        String urlWithFilters = filterBuilder.build();
        
        try {
        	//TODO do testu na sztywno jakis link
            URL url = new URL("http://www.gumtree.pl/fp-domy-i-mieszkania-sprzedam-i-kupie/targowek/c9073l3200018?A_AreaInMeters_max=250&A_AreaInMeters_min=50&A_NumberRooms=3&maxPrice=1000000&maxPriceBackend=100000000&minPrice=50+000&minPriceBackend=5000000");
            GumtreePlParsingThread parsingThread = new GumtreePlParsingThread(url, ads);
            parsingThread.start();
            
            //TODO do testów na sztywno 15 sekund parsowania
            //int timeLimit  = Integer.parseInt(filter.getTimeLimit()) * 1000 * 60;
            Thread.sleep(15000);
            parsingThread.setStopExecution(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
