package search;

import jade.core.Agent;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import solr.SolrModule;

import common.CommunicationModule;

public class SearchAgent extends Agent{
  
  private CommunicationModule communication;
  private SolrModule solr;
  
  protected void setup() 
  { 
    System.out.println("SearchAgent starting...");
    addBehaviour(new GuiBehaviour(this));
    communication = new CommunicationModule(this);
    communication.register(getSearcherServiceDescription());
    solr = new SolrModule();
    solr.sampleSearch();
  }
  
  ServiceDescription getSearcherServiceDescription() {
    ServiceDescription sd  = new ServiceDescription();
    sd.setType("searcher");
    sd.setName(getLocalName());
    return sd;
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
