package search;

import jade.core.behaviours.OneShotBehaviour;

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

  /**
   * @return the frame
   */
  public SearchWindow getFrame() {
    return frame;
  }
  
}
