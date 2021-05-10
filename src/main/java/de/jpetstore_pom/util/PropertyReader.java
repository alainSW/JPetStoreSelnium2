package de.jpetstore_pom.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	// Diese Class wird in der TestBase instanzieren.
	private static volatile PropertyReader propInstance;

	private PropertyReader() {

	}

	/**
	 * synchronized = keyword in Java is used to provide mutually exclusive access
	 * to a shared resource with multiple threads in Java. Synchronization in Java
	 * guarantees that no two threads can execute a synchronized method which
	 * requires the same lock simultaneously or concurrently.
	 **/

	public static synchronized PropertyReader getInstance() {

		if (propInstance == null) {

			propInstance = new PropertyReader();
		}
		return propInstance;
	}

	/**
	 * Method to return property value
	 * 
	 * @param propertyName
	 * @return
	 */
	public String getProperty(String propertyName) {

		Properties prop = new Properties();

		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
			prop.load(inputStream);

			if (prop.getProperty(propertyName) != null) {
				return prop.getProperty(propertyName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
