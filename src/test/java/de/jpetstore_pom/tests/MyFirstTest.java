package de.jpetstore_pom.tests;

import static de.jpetstore_pom.util.PropKey.PORT;
import static de.jpetstore_pom.util.PropKey.URL;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import de.jpetstore_pom.driver.DriverManager;

@Disabled
@DisplayName("My Browser Tests")
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class MyFirstTest extends DriverManager {

	@Test
	@DisplayName("This is my first selenium test!!!")
	void this_is_my_first_selenium_test() throws InterruptedException {

		String url = prop.getProperty(URL.getPropVal());
		String port = prop.getProperty(PORT.getPropVal());

		String finalUrl = url + port;

		driver.get(finalUrl);
		Thread.sleep(2000);

	}
}
