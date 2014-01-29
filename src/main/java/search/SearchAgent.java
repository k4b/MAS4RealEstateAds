package search;

import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;

import jade.core.Agent;
import jade.domain.FIPAAgentManagement.ServiceDescription;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import solr.SolrModule;
import common.CommunicationModule;
import common.ads.AdsConstants;

public class SearchAgent extends Agent{
  
  private CommunicationModule communication;
  private SolrModule solr;
  private GuiBehaviour guiBehaviour;
  
  protected void setup() 
  { 
    System.out.println("SearchAgent starting...");
    guiBehaviour = new GuiBehaviour(this);
    addBehaviour(guiBehaviour);
    addBehaviour(new ReceiverBehaviour(this));
    communication = new CommunicationModule(this);
    communication.register(getSearcherServiceDescription());
    solr = new SolrModule();
  }
  
  ServiceDescription getSearcherServiceDescription() {
    ServiceDescription sd  = new ServiceDescription();
    sd.setType("searcher");
    sd.setName(getLocalName());
    return sd;
  }
  
  public void loadData(String sender) {
    System.out.println(sender);
    SolrQuery query = new SolrQuery();
    query.setQuery("*:*");
    query.setRows(1000000);
    query.setFields(
        AdsConstants.ID,
        AdsConstants.CITY,
//        AdsConstants.DISTRICT,
//        AdsConstants.STREET,
        AdsConstants.PRICE,
        AdsConstants.PRICE_PER_METER,
        AdsConstants.NUM_BEDROOMS,
        AdsConstants.AREA,
        AdsConstants.FLOOR,
        AdsConstants.WEBSITE);
    query.setStart(0);    
    query.set("defType", "edismax");

    QueryResponse response = null;
    try {
      response = solr.query(query);
    } catch (SolrServerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if(response == null) {
      return;
    }
    SolrDocumentList results = response.getResults();
    System.out.println(results.get(0));
    SolrDocsTableModel tableModel = guiBehaviour.getFrame().getTableModel();
    tableModel.setData(results);
    System.out.println(guiBehaviour.getFrame().getTableModel().getRowCount());
    System.out.println(">>> " + results.size() + " results");
  }
  
  public SolrDocument searchOne(String id) {
    SolrQuery query = new SolrQuery();
    query.setQuery("*:*");
    query.setRows(1000000);
    query.setStart(0);    
    query.set("defType", "edismax");

    QueryResponse response = null;
    try {
      response = solr.query(query);
    } catch (SolrServerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if(response == null) {
      return null;
    }
    SolrDocumentList list = response.getResults();
    SolrDocument doc = list.get(0);
    return doc;
  }

  /**
   * @return the communication
   */
  public CommunicationModule getCommunication() {
    return communication;
  }

  /**
   * @param communication the communication to set
   */
  public void setCommunication(CommunicationModule communication) {
    this.communication = communication;
  }

  /**
   * @return the solr
   */
  public SolrModule getSolr() {
    return solr;
  }

  /**
   * @param solr the solr to set
   */
  public void setSolr(SolrModule solr) {
    this.solr = solr;
  }
}
