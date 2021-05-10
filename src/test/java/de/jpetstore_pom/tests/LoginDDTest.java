package de.jpetstore_pom.tests;

import static de.jpetstore_pom.tags.JPetStoreTags.REGRESSION;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import de.jpetstore_pom.steps.JPetStoreSteps;
import de.jpetstore_pom.util.ExcelDataReader;

@ExtendWith(TestListener.class)
public class LoginDDTest extends JPetStoreSteps {

	static Object[][] getDatadoLogin() {
		return ExcelDataReader.getData("src/test/resources/data/LoginDDTest.xlsx", "doLogin");
	}

	@Tag(REGRESSION)
	@ParameterizedTest
	@DisplayName("Login to application with multiple users & verify greeting message")
	@MethodSource("getDatadoLogin")
	void doLogin(String userName, String password, String expectedResult) {

		navigateToApp();
		navigateToSignOnPage();
		doLogin(userName, password);

		assertEquals(expectedResult, getGreetingMessage());

	}
}
