package sg.edu.nus.iss.vmcs.customer;

import java.util.ArrayList;
import java.util.Arrays;

public class TransactionMediator implements Mediator {
	private ArrayList<Colleague> colleagues;
	
	public TransactionMediator() {
		colleagues = new ArrayList<Colleague>();
	}
	
	public void addColleague(Colleague colleague) {
		colleagues.add(colleague);
	}
	
	public void send(String message, String[] params, Colleague originator) {
		System.out.println("Mediator >> Origin:" + originator.getClass().getSimpleName() + " Message:" + message + " Param(s):" + Arrays.toString(params));
		
		for(Colleague colleague: colleagues) {
			if(colleague != originator) {
				colleague.receiveMessage(message, params);
			}
		}
	}
}