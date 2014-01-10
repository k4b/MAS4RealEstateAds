package search;

import jade.core.Agent;

public class SearchAgent extends Agent{
  
  protected void setup() 
  { 
      addBehaviour(new GuiBehaviour(this));
  }
}
