package solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import common.ads.Ad;
import common.ads.AdsConstants;
import common.CommonConstants;

public class SolrModule {

  private HttpSolrServer solr = null;
  
  public SolrModule() {
    solr = new HttpSolrServer(CommonConstants.SOLR_BASE_URL);
  }
  
  public SolrModule(String host) {
    solr = new HttpSolrServer(host);
  }
  
  public static SolrInputDocument convertFromAd(Ad ad) {
    SolrInputDocument doc = new SolrInputDocument();
    doc.addField(AdsConstants.ID, ad.getID());
    doc.addField(AdsConstants.TITLE , ad.getTitle());
    doc.addField(AdsConstants.DESCRIPTION , ad.getDescription());
    doc.addField(AdsConstants.CITY , ad.getCity());
    doc.addField(AdsConstants.DISTRICT , ad.getDistrict());
    doc.addField(AdsConstants.STREET , ad.getStreet());
    doc.addField(AdsConstants.PRICE , ad.getPrice());
    doc.addField(AdsConstants.PRICE_PER_METER , ad.getPricePerMeter());
    doc.addField(AdsConstants.AREA , ad.getArea());
    doc.addField(AdsConstants.LINK , ad.getLink());
    doc.addField(AdsConstants.NUM_BEDROOMS , ad.getNumBedrooms());
    doc.addField(AdsConstants.NUM_BATHROOMS , ad.getNumBathrooms());
    doc.addField(AdsConstants.FLOOR , ad.getFloor());
    doc.addField(AdsConstants.NUM_FLOORS , ad.getNumFloors());
    doc.addField(AdsConstants.LAST_UPDATE , ad.getLastUpdate());
    doc.addField(AdsConstants.CREATION_DATE , ad.getCreationDate());
    doc.addField(AdsConstants.CONSTRUCTION_YEAR , ad.getConstructionYear());
    doc.addField(AdsConstants.WEBSITE , ad.getWebsite());
    return doc;
  }
  
  /**
   * For use with single ad
   * @param ad
   */
  public void indexInSolr(Ad ad) {
    try {
      SolrInputDocument doc = convertFromAd(ad);
      solr.add(doc);
      solr.commit();
    } catch (SolrServerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  /**
   * For use with multiple ads
   * @param ads
   * @param count count of added ads; when exceeded docs added to Solr will be commited
   */
  public void indexInSolr(List<Ad> ads, int count) {
    List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
    for(Ad ad : ads) {
      SolrInputDocument doc = convertFromAd(ad);
      docs.add(doc);
    }
    try {
      solr.add(docs);
      solr.commit();
    } catch (SolrServerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public QueryResponse query(SolrQuery query) throws SolrServerException {
    return solr.query(query);
  }
}
