package sg.edu.nus.iss.vmcs.system;

/**
 * This object is the interface of mediator.
 *
 * @version 4.0 30/10/2017
 * @author Hyuntae Kim
 */

//MediatorPattern - Interface
public interface Mediator {
	public void send(String message, String[] params, Colleague colleague);
}
