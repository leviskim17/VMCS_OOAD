package sg.edu.nus.iss.vmcs.system;

/**
 * This object is an abstract class of colleague of mediator.
 *
 * @version 4.0 30/10/2017
 * @author Hyuntae Kim
 */

//MediatorPattern - Colleague
public abstract class Colleague{
  private Mediator mediator;
  public Colleague(Mediator m) {
	  mediator = m;
  }
  
  public void sendEvent(String message, String[] params) {
	  mediator.send(message, params, this);
  }

  public Mediator getMediator() {return mediator;}
  public abstract void receiveEvent(String message, String[] params);
}