package sg.edu.nus.iss.vmcs.customer;

//Mediator interface
public interface Mediator {
	public void send(String message, Colleague colleague);
}