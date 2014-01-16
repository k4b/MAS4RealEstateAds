package search;

import jade.core.Agent;

public class SearchAgent extends Agent{
  
  protected void setup() 
  { 
    System.out.println("SearchAgent starting...");
    addBehaviour(new GuiBehaviour(this));
  }
}
