package search;

import common.CommunicationModule;

import jade.core.Agent;

public class SearchAgent extends Agent{
  
  private CommunicationModule communication;
  
  protected void setup() 
  { 
    System.out.println("SearchAgent starting...");
    addBehaviour(new GuiBehaviour(this));
    communication = new CommunicationModule(this);
  }
}
