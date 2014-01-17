package search;

import common.CommunicationModule;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;

import java.awt.EventQueue;

public class GuiBehaviour extends OneShotBehaviour {
  
  private Agent agent;
  private SearchWindow frame;
  private CommunicationModule communicationModule;
  
  public GuiBehaviour(Agent a, CommunicationModule communicationModule) {
    super(a);
    this.communicationModule = communicationModule;
    this.agent = a;
  }
  
  @Override
  public void action() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame = new SearchWindow(communicationModule);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  
}
