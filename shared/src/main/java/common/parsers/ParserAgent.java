package common.parsers;

import jade.core.Agent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import common.ads.Ad;
import common.ads.AdsConstants;

abstract public class ParserAgent extends Agent {

  /**
   * Maximum number of parsed pages
   */
  protected int maxPages = 0;
  protected int pagesCounter = 0;
  protected ArrayList<Ad> ads;
  protected boolean isRunning = true;
  
  public ParserAgent(int maxPages) {
    this.maxPages = maxPages;
    ads = new ArrayList<Ad>();
  }
  
  public ArrayList<Ad> getAds() {
      return ads;
  }
  
  abstract public URL constructRequestUrl();
  
  abstract public void startParsing(URL url, int maxPages);
  
  abstract public void parseSearchResults(URL url);
  
  abstract public void parseDetails(URL url, Ad a);
  
  /**
   * Downloads webpage and returns it as Jsoup Document
   * @param url URL to webpage
   * @return Jsoup webpage Document object
   */
  public Document downloadWebpage(URL url) {
      if(url.equals(""))
          return null;
      
      Document d = null;
      try {
          Connection conn = Jsoup.connect(url.toString());
          d = conn.get();
      } catch (Exception ex) {
          Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
          try {
              System.out.println("waiting 3s...");
              Thread.sleep(3000);
          } catch (InterruptedException ex1) {
              try {
                  d = Jsoup.connect(url.getPath()).get();
              } catch (IOException ex2) {
                  Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex2);
              }
          }
          
      }
      return d;
  }
  
  public void isRunning(int counterMax) {
      if(pagesCounter < counterMax) {
          isRunning = true;
      } else {
          isRunning = false;
      }
  }
  
  public String arrayListToString(ArrayList ar) {
      String s = "";
      for(Object o : ar) {
          s += o.toString();
          s +=AdsConstants.LINE + AdsConstants.NEWLINE;
      }
      return s;
  }

  public String adsTitlesToString(ArrayList<Ad> ar) {
      String s = "";
      for(Ad a : ar) {
          s += a.getID() + "| " + a.getTitle() + AdsConstants.NEWLINE;
          s += AdsConstants.LINE + AdsConstants.NEWLINE;
      }
      return s;
  }
}
