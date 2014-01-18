package common.parsers;

import com.google.gson.Gson;
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
class ReceiverBehaviourReceivePing extends SimpleBehaviour {
	boolean finished = false;
    ParserAgent agent;


	public ReceiverBehaviourReceivePing(ParserAgent agent) {
		super(agent);
        this.agent = agent;
	}


	public void action() {
		ACLMessage msg = myAgent.receive(MessageTemplate.MatchConversationId("ParserConversation"));
		if (msg != null) {//sometimes the message queue might be empty for example the first time this behavior runs
            System.out.println("Wiadomosc przyszla");
            String message = msg.getContent();
            Gson gson = new Gson();
            Filter filter = gson.fromJson(message, Filter.class);
            agent.startParsing(filter);
            agent.getCommunicationModule().sendReply(msg, "done");


		}
		else{
            System.out.println("Zwolnij wątek");
			block();//free the thread until a new message appears in the message queue
		}
	}

	@Override
	public boolean done() {//when this method returns true the behavior is no longer activated when a message is received
		return finished;
	}

}