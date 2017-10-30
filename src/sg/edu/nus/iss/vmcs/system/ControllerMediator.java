package sg.edu.nus.iss.vmcs.system;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This object is the concrete mediator for Contollers.
 *
 * @version 4.0 30/10/2017
 * @author Hyuntae Kim
 */

//MediatorPattern Concrete Mediator
public class ControllerMediator implements Mediator {
	private ArrayList<Colleague> colleagues;
	
	public ControllerMediator() {
		colleagues = new ArrayList<Colleague>();
	}
	
	public void addColleague(Colleague colleague) {
		colleagues.add(colleague);
	}
	
	public void send(String message, String[] params, Colleague originator) {
		System.out.println("\nMediator >> Origin:" + originator.getClass().getSimpleName() + " Message:" + message + " Param(s):" + Arrays.toString(params));
		
		for(Colleague colleague: colleagues) {
			if(colleague != originator) {
				colleague.receiveEvent(message, params);
			}
		}
	}
}
