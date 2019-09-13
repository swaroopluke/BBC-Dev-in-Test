package commons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	Properties prop;
	BufferedReader reader;
	String dir;
	String configPropsPath = "/configs/config.properties";

	public ConfigFileReader() {
		dir = System.getProperty("user.dir");
		try {
			reader = new BufferedReader(new FileReader(dir + configPropsPath));
			try {
				prop = new Properties();
				prop.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configurtion File not Found" + configPropsPath);
		}
	}

	public String getURI() {
		String urlPath = prop.getProperty("BaseURI");
		if (urlPath != null)
			return urlPath;
		else
			throw new RuntimeException("url not found in config.properties");
	}

}
