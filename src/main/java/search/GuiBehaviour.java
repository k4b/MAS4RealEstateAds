package search;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;

import java.awt.EventQueue;

public class GuiBehaviour extends OneShotBehaviour {
  
  private Agent agent;
  private SearchWindow frame;
  
  public GuiBehaviour(Agent a) {
    super(a);
    this.agent = a;
  }
  
  @Override
  public void action() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame = new SearchWindow();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  
}
