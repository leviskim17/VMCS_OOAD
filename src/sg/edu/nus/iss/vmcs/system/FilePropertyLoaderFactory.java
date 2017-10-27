package sg.edu.nus.iss.vmcs.system;

public class FilePropertyLoaderFactory implements AbstractPropertyLoaderFactory {

	@Override
	public AbstractCashLoader createCashLoader(){
		return new CashFileLoader(Environment.getCashPropFile());
	}

	@Override
	public AbstractDrinkLoader createDrinkLoader() {
		return new DrinkFileLoader(Environment.getDrinkPropFile());

	}

}
