package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileData 
{
	public String getProperty(String key)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/test/resources/PropertyFile.properties");
		} catch (FileNotFoundException e) {
		
		}
		Properties property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			
		}
		
		String data = key;
		return data;
		
	}
	
}
