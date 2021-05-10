package de.jpetstore_pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import de.jpetstore_pom.driver.DriverFactory;

public class AccountsPage extends BasePage {

	public AccountsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private static final String USER_NAME_INPUT = "//*[@id='Catalog']//input[@name='username']";

	private static final String PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='password']";

	private static final String REAPEATED_PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='repeatedPassword']";

	private static final String FIRST_NAME_INPUT = "//*[@id='Catalog']//input[@name='account.firstName']";

	private static final String LAST_NAME_INPUT = "//*[@id='Catalog']//input[@name='account.lastName']";

	private static final String EMAIL_INPUT = "//*[@id='Catalog']//input[@name='account.email']";

	private static final String PHONE_INPUT = "//*[@id='Catalog']//input[@name='account.phone']";

	private static final String ADDR1_INPUT = "//*[@id='Catalog']//input[@name='account.address1']";

	private static final String ADDR2_INPUT = "//*[@id='Catalog']//input[@name='account.address2']";

	private static final String CITY_INPUT = "//*[@id='Catalog']//input[@name='account.city']";

	private static final String STATE_INPUT = "//*[@id='Catalog']//input[@name='account.state']";

	private static final String ZIP_INPUT = "//*[@id='Catalog']//input[@name='account.zip']";

	private static final String COUNTRY_INPUT = "//*[@id='Catalog']//input[@name='account.country']";

	private static final String LANGUAGE_PREFERENCE_DROPDOWN = "//*[@id='Catalog']//select[@name='account.languagePreference']";

	private static final String FAVOURITE_CATEGORY_DROPDOWN = "//*[@id='Catalog']//select[@name='account.favouriteCategoryId']";

	private static final String ENABLE_MY_LIST_CHECKBOX = "//*[@id='Catalog']//input[@name='account.listOption']";

	private static final String ENABLE_BANNER_CHECKBOX = "//*[@id='Catalog']//input[@name='account.bannerOption']";

	private static final String SAVE_ACCT_INFO_BUTTON = "//*[@id='Catalog']//input[@value='Save Account Information']";

	/**
	 *
	 * @param userName
	 * @param password
	 * @param repeatPassword
	 * @return
	 */
	public AccountsPage addNewUserInformation(String userName, String password, String repeatPassword) {

		isTextPresentOnPage("User Information");

		enterTextIntoTextBox(By.xpath(USER_NAME_INPUT), userName);
		enterTextIntoTextBox(By.xpath(PASSWORD_INPUT), password);
		enterTextIntoTextBox(By.xpath(REAPEATED_PASSWORD_INPUT), repeatPassword);

		return this;
	}

	/**
	 * Method to enter account info
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phone
	 * @param addr1
	 * @param addr2
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @return
	 */
	public AccountsPage addAccountInformation(String firstName, String lastName, String email, String phone,
			String addr1, String addr2, String city, String state, String zip, String country) {

		isTextPresentOnPage("Account Information");

		enterTextIntoTextBox(By.xpath(FIRST_NAME_INPUT), firstName);
		enterTextIntoTextBox(By.xpath(LAST_NAME_INPUT), lastName);
		enterTextIntoTextBox(By.xpath(EMAIL_INPUT), email);
		enterTextIntoTextBox(By.xpath(PHONE_INPUT), phone);
		enterTextIntoTextBox(By.xpath(ADDR1_INPUT), addr1);
		enterTextIntoTextBox(By.xpath(ADDR2_INPUT), addr2);
		enterTextIntoTextBox(By.xpath(CITY_INPUT), city);
		enterTextIntoTextBox(By.xpath(STATE_INPUT), state);
		enterTextIntoTextBox(By.xpath(ZIP_INPUT), zip);
		enterTextIntoTextBox(By.xpath(COUNTRY_INPUT), country);

		return this;
	}

	/**
	 *
	 * @param language
	 * @param category
	 * @param myList
	 * @param myBanner
	 * @return
	 */
	public AccountsPage addProfileInformation(String language, String category, boolean myList, boolean myBanner) {

		isTextPresentOnPage("Profile Information");

		selectByVisibleText(By.xpath(LANGUAGE_PREFERENCE_DROPDOWN), language);

		selectByVisibleText(By.xpath(FAVOURITE_CATEGORY_DROPDOWN), category);

		selectCheckBox(By.xpath(ENABLE_MY_LIST_CHECKBOX));

		selectCheckBox(By.xpath(ENABLE_BANNER_CHECKBOX));

		return this;
	}

	/**
	 * Saving Account Info
	 * 
	 * @return
	 */
	public DashBoardPage clickSaveAccountInformation() {

		clickLinkOrBtn(By.xpath(SAVE_ACCT_INFO_BUTTON));
		return new DashBoardPage(DriverFactory.driver);
	}

}
