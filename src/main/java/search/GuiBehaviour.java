package search;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;

import java.awt.EventQueue;

public class GuiBehaviour extends OneShotBehaviour {
  
  private SearchAgent agent;
  private SearchWindow frame;
  
  public GuiBehaviour(SearchAgent a) {
    super(a);
    this.agent = a;
  }
  
  @Override
  public void action() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame = new SearchWindow(agent);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  
}
