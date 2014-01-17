package common;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class CommunicationModule {
  
  private Agent agent;
  private DFAgentDescription[] result;

    public CommunicationModule(Agent agent) {
    this.agent = agent;

  }
  
  public void run() {
  //  register(getSearcherServiceDescription());
    try {
      searchAgents();
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.setContent("pajac");
        msg.setConversationId("elo");
        msg.addReceiver( result[0].getName());
        agent.send(msg);
    } catch (FIPAException e) {
      e.printStackTrace();
    }
  }
  
  public DFAgentDescription[] searchAgents() throws FIPAException {
    DFAgentDescription dfd = new DFAgentDescription();
    ServiceDescription sd  = new ServiceDescription();
    sd.setType("parser");
    dfd.addServices(sd);
    SearchConstraints constraints = new SearchConstraints();
    constraints.setMaxResults(-1L);
    
    result = DFService.search(agent, dfd, constraints);
    System.out.println("parser: " + result[0].getName());
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
