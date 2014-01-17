package search;

import common.CommunicationModule;

import jade.core.Agent;

public class SearchAgent extends Agent{
  
  public CommunicationModule communication;
  
  protected void setup() 
  { 
    System.out.println("SearchAgent starting...");
    communication = new CommunicationModule(this);
    addBehaviour(new GuiBehaviour(this,communication));

  }
}
