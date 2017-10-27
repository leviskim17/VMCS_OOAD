package sg.edu.nus.iss.vmcs.system;

import java.io.IOException;
import java.util.Properties;

import sg.edu.nus.iss.vmcs.store.CashStoreItem;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.DrinksStoreItem;
import sg.edu.nus.iss.vmcs.store.PropertyLoader;
import sg.edu.nus.iss.vmcs.store.StoreItem;

public abstract class AbstractDrinkLoader implements PropertyLoader {

	private static final String NAME_LABEL     = "Name";
	private static final String PRICE_LABEL    = "Price";
	private static final String QUANTITY_LABEL = "Quantity";
	private static final String PROP_NUM_ITEMS = "NumOfItems";
	
	protected Properties properties;
	

	public abstract void initialize() throws IOException;

	public abstract void saveProperty() throws IOException;

	public int getNumOfItems() {
		String numItems = properties.getProperty(PROP_NUM_ITEMS);
		int num_item = Integer.parseInt(numItems);
		return num_item;
	}

	public void setNumOfItems(int numItems) {
		properties.setProperty(PROP_NUM_ITEMS, String.valueOf(numItems));
	}

	public StoreItem getItem(int index) {
		int idx = index + 1;
		DrinksBrand brand = new DrinksBrand();

		String name = new String(NAME_LABEL + idx);
		String value = getValue(name);
		brand.setName(value);
		
		name = new String(PRICE_LABEL + idx);
		value = getValue(name);
		brand.setPrice(Integer.parseInt(value));
		
		name = new String(QUANTITY_LABEL + idx);
		value = getValue(name);
		int qty = Integer.parseInt(value);

		DrinksStoreItem item = new DrinksStoreItem(brand, qty);
		return item;
	}

	public void setItem(int index, StoreItem drinksItem) {
		int idx = index + 1;

		DrinksStoreItem item = (DrinksStoreItem) drinksItem;
		DrinksBrand brand = (DrinksBrand) item.getContent();
		String itn = new String(NAME_LABEL + idx);
		setValue(itn, brand.getName());

		itn = new String(PRICE_LABEL + idx);
		setValue(itn, String.valueOf(brand.getPrice()));

		itn = new String(QUANTITY_LABEL + idx);
		setValue(itn, String.valueOf(item.getQuantity()));

	}
	
	public String getValue(String key) {
		return properties.getProperty(key);
	}

	public void setValue(String key, String value) {
		properties.setProperty(key, value);
	}

}
