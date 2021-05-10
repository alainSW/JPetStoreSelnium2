package de.jpetstore_pom.driver;

import static de.jpetstore_pom.util.Helper.isWebDriverManager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import de.jpetstore_pom.util.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;

public enum BrowserType implements DriverSetup {

	CHROME {
		@Override
		public Capabilities getBrowserCapabilities() {

			Capabilities capabilities = getBrowserOptions();
			return capabilities;
		}

		@Override
		public ChromeOptions getBrowserOptions() {
			ChromeOptions chromeOptions = new ChromeOptions();

			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--ignore-certificate-errors");
			chromeOptions.addArguments("--disable-popup-blocking");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--window-size=1920,1080");
			chromeOptions.setAcceptInsecureCerts(true);

			return chromeOptions;
		}

		@Override
		public WebDriver getWebDriver() {

			String browserPath = Helper.getBrowserPath();

			if (isWebDriverManager()) {
				WebDriverManager.chromedriver().setup();
			} else {
				System.setProperty("webdriver.chrome.driver", browserPath);
			}

			ChromeOptions chromeOptions = getBrowserOptions();
			return new ChromeDriver(chromeOptions);
		}
	},

	FIREFOX {
		@Override
		public Capabilities getBrowserCapabilities() {

			Capabilities capabilities = getBrowserOptions();
			return capabilities;
		}

		@Override
		public FirefoxOptions getBrowserOptions() {

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();

			// Accept Untrusted Certificates
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);

			// Set Firefox profile to capabilities
			firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);
			return firefoxOptions;
		}

		@Override
		public WebDriver getWebDriver() {

			String browserPath = Helper.getBrowserPath();

			if (isWebDriverManager()) {
				WebDriverManager.firefoxdriver().setup();
			} else {
				System.setProperty("webdriver.gecko.driver", browserPath);
			}

			FirefoxOptions firefoxOptions = getBrowserOptions();
			return new FirefoxDriver(firefoxOptions);
		}
	},

	IE {
		@Override
		public Capabilities getBrowserCapabilities() {

			Capabilities capabilities = getBrowserOptions();
			return capabilities;
		}

		@Override
		public InternetExplorerOptions getBrowserOptions() {
			InternetExplorerOptions capabilities = new InternetExplorerOptions();
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
			return capabilities;

		}

		@Override
		public WebDriver getWebDriver() {

			String browserPath = Helper.getBrowserPath();

			if (isWebDriverManager()) {
				WebDriverManager.iedriver().setup();
			} else {
				System.setProperty("webdriver.ie.driver", browserPath);
			}
			InternetExplorerOptions internetExplorerOptions = getBrowserOptions();
			return new InternetExplorerDriver(internetExplorerOptions);
		}
	}
};
