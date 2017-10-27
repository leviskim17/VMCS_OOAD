package sg.edu.nus.iss.vmcs.customer;

import java.util.ArrayList;

public class TransactionMediator implements Mediator {
	private ArrayList<Colleague> colleagues;
	
	public TransactionMediator() {
		colleagues = new ArrayList<Colleague>();
	}
	
	public void addColleague(Colleague colleague) {
		colleagues.add(colleague);
	}
	
	public void send(String message, Colleague originator) {
		for(Colleague colleague: colleagues) {
			if(colleague != originator) {
				colleague.receive(message);
				System.out.println("Message : " + message + ", " + originator);
			}
		}
	}
}