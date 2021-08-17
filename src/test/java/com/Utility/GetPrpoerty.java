package com.Utility;

import java.io.FileInputStream;

import java.util.Properties;

public class GetPrpoerty {
	
	public static Properties prop;
	
	public static Properties getProperties() {
		if (prop == null) {

			// INITIALIZE PROPERTY OBJECT
			prop = new Properties();

			try {
				FileInputStream file = new FileInputStream("C:\\Users\\pawan\\eclipse-workspace\\AxisBankProject\\Resources\\InputProperties.properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return prop;
	}
	
}
