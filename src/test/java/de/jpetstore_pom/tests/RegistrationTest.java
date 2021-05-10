package de.jpetstore_pom.tests;

import static de.jpetstore_pom.tags.JPetStoreTags.REGISTRATION;
import static de.jpetstore_pom.tags.JPetStoreTags.REGRESSION;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.github.javafaker.Faker;

import de.jpetstore_pom.steps.JPetStoreSteps;

@Tag(REGRESSION)
@ExtendWith(TestListener.class)
public class RegistrationTest extends JPetStoreSteps {

	@Tag(REGISTRATION)
	@Test
	@DisplayName("Add a new user to the store & verify if the user can login")
	void addNewUserToStoreAndVerifyLogin() {

		Faker faker = new Faker();

		String userName = "j2ee" + faker.number().randomNumber(10, false);

		String password = faker.internet().password();
		String repeatPassword = password;

		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String phoneNumber = faker.phoneNumber().cellPhone();
		String addr1 = faker.address().buildingNumber();
		String addr2 = faker.address().streetAddress();
		String city = faker.address().city();
		String state = faker.address().state();
		String zipCode = faker.address().zipCode();
		String country = faker.address().country();

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
