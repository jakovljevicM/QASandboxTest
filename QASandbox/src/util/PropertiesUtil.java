package util;

import java.util.Properties;

public class PropertiesUtil {

	public Properties properties = null;
	
	public PropertiesUtil(String file){
		properties = new Properties();
		//properties.load(getClass().getResourceAsStream("./bin/main/resources/data/"+file));
		try {
            properties.load(getClass().getResourceAsStream("/data/"+file));
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
	}
	
	public String getValue(String key) {
		return properties.getProperty(key);
	}
	
	public String setValue(String key, String value) {
		return (String) properties.setProperty(key, value);
	}
}
