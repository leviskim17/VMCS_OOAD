package sg.edu.nus.iss.vmcs.system;

import java.io.IOException;
import java.util.Properties;

import sg.edu.nus.iss.vmcs.store.CashStoreItem;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.PropertyLoader;
import sg.edu.nus.iss.vmcs.store.StoreItem;

public abstract class AbstractCashLoader implements PropertyLoader {
	
	private static final String NAME_LABEL     = "Name";
	private static final String WEIGHT_LABEL   = "Weight";
	private static final String VALUE_LABEL    = "Value";
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
		Coin coin = new Coin();

		String name = new String(NAME_LABEL + idx);
		String value = getValue(name);
		coin.setName(value);

		name = new String(WEIGHT_LABEL + idx);
		value = getValue(name);
		coin.setWeight(Double.parseDouble(value));

		name = new String(VALUE_LABEL + idx);
		value = getValue(name);
		coin.setValue(Integer.parseInt(value));

		name = new String(QUANTITY_LABEL + idx);
		value = getValue(name);
		int qty = Integer.parseInt(value);

		CashStoreItem item = new CashStoreItem(coin, qty);
		return item;
	}

	public void setItem(int index, StoreItem storeItem) {
		int idx = index + 1;

		CashStoreItem item = (CashStoreItem) storeItem;
		Coin cn = (Coin) item.getContent();
		String itn = new String(NAME_LABEL + idx);

		setValue(itn, cn.getName());

		itn = new String(WEIGHT_LABEL + idx);
		setValue(itn, String.valueOf(cn.getWeight()));

		itn = new String(VALUE_LABEL + idx);
		setValue(itn, String.valueOf(cn.getValue()));

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
