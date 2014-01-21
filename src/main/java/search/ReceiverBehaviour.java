package search;

import com.google.gson.Gson;

import common.CommonConstants;
import common.RequestMessage;
import common.ResponseMessage;
import common.ads.Filter;
import common.parsers.ParserAgent;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import javax.swing.text.html.parser.Parser;

/**
 * this is a simple behavior and it will run until it is done
 */
class ReceiverBehaviour extends SimpleBehaviour {
	boolean finished = false;
  SearchAgent agent;


	public ReceiverBehaviour(SearchAgent agent) {
		super(agent);
    this.agent = agent;
	}


	public void action() {
		ACLMessage msg = myAgent.receive(MessageTemplate.MatchConversationId("ParserConversation"));
		if (msg != null) {//sometimes the message queue might be empty for example the first time this behavior runs
		  String sender = msg.getSender().getName();
      System.out.println("Message from " + sender);
      String message = msg.getContent();
      System.out.println(message);
      agent.loadData(sender);
      Gson gson = new Gson();
      ResponseMessage rmessage = gson.fromJson(message, ResponseMessage.class);
      if(rmessage.getResponse().equals(CommonConstants.RESPONSE_OK)) {
        agent.loadData(sender);
      }
		}
		else{
      System.out.println("Empty message");
			block();//free the thread until a new message appears in the message queue
		}
	}

	@Override
	public boolean done() {//when this method returns true the behavior is no longer activated when a message is received
		return finished;
	}

}