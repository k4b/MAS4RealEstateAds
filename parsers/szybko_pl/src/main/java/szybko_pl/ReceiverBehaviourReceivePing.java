package szybko_pl;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * this is a simple behavior and it will run until it is done
 */
class ReceiverBehaviourReceivePing extends SimpleBehaviour {
	boolean finished = false;


	public ReceiverBehaviourReceivePing(Agent a) {
		super(a);
	}


	public void action() {
		ACLMessage msg = myAgent.receive(MessageTemplate.MatchConversationId("ParserConversation"));
		if (msg != null) {//sometimes the message queue might be empty for example the first time this behavior runs

			System.out.println("Receiver: I am  " + myAgent.getLocalName()
					+ " and I have received: " + msg.getContent() +" from "+msg.getSender().getLocalName());

		}
		else{
			block();//free the thread until a new message appears in the message queue
		}
	}

	@Override
	public boolean done() {//when this method returns true the behavior is no longer activated when a message is received
		return finished;
	}

}