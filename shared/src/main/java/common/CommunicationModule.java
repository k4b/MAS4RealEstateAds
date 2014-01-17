package common;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class CommunicationModule {
  
  private Agent agent;
  
  public CommunicationModule(Agent agent) {
    this.agent = agent;
    run();
  }
  
  public void run() {
    register(getSearcherServiceDescription());
    try {
      searchAgents();
    } catch (FIPAException e) {
      e.printStackTrace();
    }
  }
  
  public DFAgentDescription[] searchAgents() throws FIPAException {
    DFAgentDescription dfd = new DFAgentDescription();
    ServiceDescription sd  = new ServiceDescription();
    sd.setType("searcher");
    dfd.addServices(sd);
    SearchConstraints constraints = new SearchConstraints();
    constraints.setMaxResults(-1L);
    
    DFAgentDescription[] result = DFService.search(agent, dfd, constraints);
    System.out.println("results: " + result.length);
    return result;
  }
  
  public void register( ServiceDescription sd) {
    DFAgentDescription dfd = new DFAgentDescription();
    dfd.setName(agent.getAID());
    dfd.addServices(sd);

    try {  
        DFService.register(agent, dfd);  
    }
    catch (FIPAException fe) {
      fe.printStackTrace();
    }
  }
  
  ServiceDescription getSearcherServiceDescription() {
    ServiceDescription sd  = new ServiceDescription();
    sd.setType("searcher");
    sd.setName(agent.getLocalName());
    return sd;
  }
}
