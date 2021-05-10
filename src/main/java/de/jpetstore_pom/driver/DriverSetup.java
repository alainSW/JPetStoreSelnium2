package de.jpetstore_pom.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface DriverSetup {

	Capabilities getBrowserCapabilities();

	Object getBrowserOptions();

	WebDriver getWebDriver();
}
