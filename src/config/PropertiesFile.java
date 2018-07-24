package config;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import testy.FifthSeleniumTest;

public class PropertiesFile {

	static Properties prop = new Properties();

	public static void main(String[] args) {
		readPropertiesFile();
		writePropertiesFile();
	}
	
	public static void readPropertiesFile() {
		try {
			InputStream input = new FileInputStream("C:\\Users\\Les\\eclipse-workspace\\fifthSeleniumTest\\src\\config\\config.properties");
			prop.load(input);
			FifthSeleniumTest.browser=prop.getProperty("browser");
			System.out.println(FifthSeleniumTest.browser);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void writePropertiesFile() {
		try {
			OutputStream output = new FileOutputStream("C:\\Users\\Les\\eclipse-workspace\\fifthSeleniumTest\\src\\config\\config.properties");
			if (prop.getProperty("browser").contains("Firefox")) {
				

				prop.setProperty("browser", "InternetExplorer");
				prop.store(output, "blah blah blo blah");
			}
			else {
				prop.setProperty("browser", "Firefox");
				prop.store(output, "blah blah bleah blah");
			} 
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
