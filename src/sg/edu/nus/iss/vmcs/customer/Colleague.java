package sg.edu.nus.iss.vmcs.customer;

public interface Colleague {
	public void sendMessage(String message, String params[]);
	public void receiveMessage(String message, String params[]);
}