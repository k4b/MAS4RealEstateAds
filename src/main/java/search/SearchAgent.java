package search;

import common.CommunicationModule;
import jade.core.Agent;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class SearchAgent extends Agent{
  
  private CommunicationModule communication;
  
  protected void setup() 
  { 
    System.out.println("SearchAgent starting...");
    addBehaviour(new GuiBehaviour(this));
    communication = new CommunicationModule(this);
    communication.register(getSearcherServiceDescription());
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
}
