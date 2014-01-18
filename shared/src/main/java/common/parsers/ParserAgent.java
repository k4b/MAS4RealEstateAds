package common.parsers;

import common.CommunicationModule;
import common.ads.Filter;
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
  protected ArrayList<Ad> ads;
  protected CommunicationModule communicationModule;
  
  public ParserAgent() {
    ads = new ArrayList<Ad>();
    communicationModule = new CommunicationModule(this);
  }
  
  protected void setup() {
    System.out.println("Starting Parser " + this.getName());

  }
  
  public ArrayList<Ad> getAds() {
      return ads;
  }

  abstract public void startParsing(Filter filter);


  /**
   * Downloads webpage and returns it as Jsoup Document
   * @param url URL to webpage
   * @return Jsoup webpage Document object
   */
  public static Document downloadWebpage(URL url) {
      if(url.equals(""))
          return null;
      
      Document d = null;
      try {
          Connection conn = Jsoup.connect(url.toString());
          conn.timeout(10000);
          conn.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");
          d = conn.get();
      } catch (Exception ex) {
          ex.printStackTrace();
          try {
              System.out.println("waiting 3s...");
              Thread.sleep(3000);
          } catch (InterruptedException ex1) {
              try {
                  d = Jsoup.connect(url.getPath()).get();
              } catch (IOException ex2) {
                 ex2.printStackTrace();
              }
          }
          
      }
      return d;
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
