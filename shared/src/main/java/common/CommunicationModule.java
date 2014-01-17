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
  }

  public DFAgentDescription[] searchAgents(String type) throws FIPAException {
    DFAgentDescription dfd = new DFAgentDescription();
    ServiceDescription sd  = new ServiceDescription();
    sd.setType(type);
    dfd.addServices(sd);
    SearchConstraints constraints = new SearchConstraints();
    constraints.setMaxResults(-1L);
    
    DFAgentDescription[] result = DFService.search(agent, dfd, constraints);
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
  
  public void printResults(DFAgentDescription[] results) {
    System.out.println("results: " + results.length);
    if(results.length > 0) {
      System.out.println(results[0].getName());
    }
  }
}
