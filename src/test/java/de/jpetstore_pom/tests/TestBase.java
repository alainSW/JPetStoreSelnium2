package de.jpetstore_pom.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import de.jpetstore_pom.util.PropKey;
import de.jpetstore_pom.util.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	static WebDriver driver;
	static PropertyReader prop = PropertyReader.getInstance();

	@BeforeAll
	public static void init() {

		if (prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("FIREFOX")) {

			if (prop.getProperty(PropKey.BROWSER_MANAGER.getPropVal()).equalsIgnoreCase("webDriverManager")) {

				WebDriverManager.firefoxdriver().setup();
			} else {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/mac/geckodriver");
			}

			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			// Accept Untrusted Certificates
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			// Use No Proxy Settings
			profile.setPreference("network.proxy.type", 0);
			// Set Firefox profile to capabilities
			options.setCapability(FirefoxDriver.PROFILE, profile);
			driver = new FirefoxDriver(options);

		} else if (prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("CHROME")) {

			if (prop.getProperty(PropKey.BROWSER_MANAGER.getPropVal()).equalsIgnoreCase("webDriverManager")) {

				WebDriverManager.chromedriver().setup();

			} else {

				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/mac/chromedriver");
			}

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--incognito");
			options.addArguments("--window-size=1920,1080");
			options.setAcceptInsecureCerts(true);

			driver = new ChromeDriver(options);
		}

	}

	@AfterAll
	public static void cleanUp() {
		driver.quit();
	}
}
