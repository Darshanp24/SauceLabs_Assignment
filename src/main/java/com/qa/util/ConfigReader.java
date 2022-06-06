package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;
	public Properties init_prop() {
		 prop = new Properties();

		 try {
			 FileInputStream file = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;
	}

}
