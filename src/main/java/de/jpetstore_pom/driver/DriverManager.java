package de.jpetstore_pom.driver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import de.jpetstore_pom.util.PropertyReader;

public class DriverManager extends DriverFactory {

	@BeforeAll
	public static void setUp() {

		prop = PropertyReader.getInstance();
		driver = getDriver();
	}

	@AfterAll
	public static void tearDown() {

		driver = null;
		quitDriver();
	}

	@BeforeEach
	public void beforeEachMethod() {
		getDriver().manage().deleteAllCookies();
	}
}
