package search;

import jade.core.Agent;
import jade.domain.FIPAAgentManagement.ServiceDescription;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import solr.SolrModule;
import common.CommunicationModule;

public class SearchAgent extends Agent{
  
  private CommunicationModule communication;
  private SolrModule solr;
  
  protected void setup() 
  { 
    System.out.println("SearchAgent starting...");
    addBehaviour(new GuiBehaviour(this));
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
    query.setQuery("website:*");
//    query.addFilterQuery("website:*");
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
    System.out.println(">>> " + results.size() + " results");
    for (int i = 0; i < results.size(); ++i) {
      System.out.println(results.get(i));
    }
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
