package sg.edu.nus.iss.vmcs.system;

import java.io.IOException;

public interface AbstractPropertyLoaderFactory {
	/**
	 * This method call the related CashLoader generation function to generate a CashLoader and return.
	 * @return 
	 *
	 */
	public AbstractCashLoader createCashLoader();
	
	/**
	 * This method call the related DrinkLoader generation function to generate a DrinkLoader and return.
	 * 
	 */
	public AbstractDrinkLoader createDrinkLoader(); 

}
