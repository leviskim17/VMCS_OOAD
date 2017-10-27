package sg.edu.nus.iss.vmcs.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CashFileLoader extends AbstractCashLoader {

	private final String propertyFile;
	
	public CashFileLoader(String propertyFile) {
		this.propertyFile = propertyFile;
	}
	

	public void initialize() throws IOException {
		properties = new Properties(System.getProperties());
		FileInputStream stream = new FileInputStream(propertyFile);
		properties.load(stream);
		stream.close();

	}

	public void saveProperty() throws IOException {
		
		FileOutputStream stream = new FileOutputStream(propertyFile);
		properties.store(stream, "");
		stream.close();

	}
}
