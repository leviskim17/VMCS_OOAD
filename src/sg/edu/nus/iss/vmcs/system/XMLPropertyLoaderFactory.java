package sg.edu.nus.iss.vmcs.system;

public class XMLPropertyLoaderFactory implements AbstractPropertyLoaderFactory {

	@Override
	public AbstractCashLoader createCashLoader() {
		return new CashXMLLoader(Environment.getCashPropFile());

	}

	@Override
	public AbstractDrinkLoader createDrinkLoader() {
		return new DrinkXMLLoader(Environment.getDrinkPropFile());

	}

}
