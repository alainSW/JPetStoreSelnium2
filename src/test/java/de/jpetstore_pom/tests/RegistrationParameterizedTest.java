package de.jpetstore_pom.tests;

import static de.jpetstore_pom.tags.JPetStoreTags.REGRESSION;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import de.jpetstore_pom.steps.JPetStoreSteps;

@ExtendWith(TestListener.class)
public class RegistrationParameterizedTest extends JPetStoreSteps {

	@Tag(REGRESSION)
	@ParameterizedTest
	@DisplayName("Register multiple users to the jpetstore & verify" + " if new user can login")
	@CsvFileSource(resources = "/data/registration-test.csv", numLinesToSkip = 1)
	void addNewUserToStoreAndVerifyLogin(String userName, String password, String repeatPassword, String firstName,
			String lastName, String email, String phoneNumber, String addr1, String addr2, String city, String state,
			String zipCode, String country) {

		navigateToApp();

		navigateToSignOnPage();

		navigateToRegistrationPage();

		addNewUserInformation(userName, password, repeatPassword);

		addAccountInformation(firstName, lastName, email, phoneNumber, addr1, addr2, city, state, zipCode, country);

		addProfileInformation("english", "DOGS", true, true);

		clickSaveAccountInformation();

		// Login & verify account creation

		doLogin(userName, password);

		String greetingMsg = getGreetingMessage();

		assertEquals("Welcome " + firstName + "!", greetingMsg);

	}
}
