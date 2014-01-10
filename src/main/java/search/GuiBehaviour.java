package search;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;

import java.awt.EventQueue;

public class GuiBehaviour extends OneShotBehaviour {
  
  public GuiBehaviour(Agent a) {
    super(a);
  }
  
  @Override
  public void action() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SearchWindow frame = new SearchWindow();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  
}
