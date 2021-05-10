package de.jpetstore_pom.tests;

import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import de.jpetstore_pom.driver.DriverManager;
import de.jpetstore_pom.util.Helper;

public class TestListener extends DriverManager implements TestWatcher {

	@Override
	public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {

	}

	@Override
	public void testSuccessful(ExtensionContext extensionContext) {

	}

	@Override
	public void testAborted(ExtensionContext extensionContext, Throwable throwable) {

	}

	@Override
	public void testFailed(ExtensionContext extensionContext, Throwable throwable) {

		Helper.takeScreenShot(driver, extensionContext.getDisplayName());
	}
}
