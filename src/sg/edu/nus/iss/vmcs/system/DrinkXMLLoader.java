package sg.edu.nus.iss.vmcs.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DrinkXMLLoader extends AbstractDrinkLoader {

	private final String propertyXML;
	
	public DrinkXMLLoader(String propertyFile) {
		this.propertyXML = propertyFile;
	}
	

	public void initialize() throws IOException {
		properties = new Properties(System.getProperties());
		FileInputStream stream = new FileInputStream(propertyXML);
		properties.loadFromXML(stream);
		stream.close();

	}

	public void saveProperty() throws IOException {
		
		FileOutputStream stream = new FileOutputStream(propertyXML);
		properties.storeToXML(stream, "");
		stream.close();

	}

}
