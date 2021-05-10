package de.jpetstore_pom.steps;

import de.jpetstore_pom.driver.DriverManager;
import de.jpetstore_pom.pages.AccountsPage;
import de.jpetstore_pom.pages.BasePage;
import de.jpetstore_pom.pages.DashBoardPage;
import de.jpetstore_pom.pages.HelpPage;
import de.jpetstore_pom.pages.LoginPage;
import de.jpetstore_pom.pages.PetCategories;
import de.jpetstore_pom.pages.ProductsPage;
import io.qameta.allure.Step;

public class JPetStoreSteps extends DriverManager {

	private BasePage basePage = new BasePage(getDriver());
	private LoginPage loginPage = new LoginPage(getDriver());
	private DashBoardPage dashBoardPage = new DashBoardPage(getDriver());
	private AccountsPage accountsPage = new AccountsPage(driver);

	/************************************************************************************************
	 * **********************************************************************************************
	 *
	 * BASE PAGE STEPS
	 *
	 *************************************************************************************************
	 *************************************************************************************************/
	@Step("Navigating to JPetStore Application")
	public void navigateToApp() {
		basePage.navigateToApp();
	}

	@Step("Navigating to Login Page")
	public LoginPage navigateToSignOnPage() {

		return basePage.navigateToSignOnPage();
	}

	@Step("Navigating to products page by cliking on : {0} link on header")
	public ProductsPage navigateToProductCategory(PetCategories productCategory) {

		return basePage.navigateToProductCategory(productCategory);
	}

	@Step("Navigating to Products Page by clicking on shopping cart")
	public ProductsPage navigateToShoppingCartPage() {

		return basePage.navigateToShoppingCart();
	}

	@Step("Navigating to Help Page")
	public HelpPage navigateToHelpPage() {

		return basePage.navigateToHelpPage();
	}

	@Step("Clicking on Company Logo & navigating to the DashBoard")
	public DashBoardPage navigateToDashBoard() {

		return basePage.navigateToDashBoard();
	}

	@Step("Navigating to Accounts Page")
	public AccountsPage navigateToMyAccountsPage() {

		return basePage.navigateToAccountPage();
	}

	@Step("Searching for product: {0}")
	public ProductsPage searchForProduct(String productName) {

		return basePage.searchForProduct(productName);
	}

	/************************************************************************************************
	 * **********************************************************************************************
	 *
	 * LOGIN PAGE STEPS
	 *
	 *************************************************************************************************
	 *************************************************************************************************/

	@Step("Logging in with username: {0} & password: {1}")
	public DashBoardPage doLogin(String userName, String password) {

		basePage.clickSignInLink();
		return loginPage.doLogin(userName, password);
	}

	@Step("Return message on invalid login")
	public String getMessageOnInvalidLogin() {
		return loginPage.getMessageOnInvalidLogin();
	}

	@Step("Navigating to user registration page")
	public AccountsPage navigateToRegistrationPage() {

		return loginPage.navigateToRegistrationPage();
	}

	/************************************************************************************************
	 * **********************************************************************************************
	 *
	 * DASHBOARD PAGE STEPS
	 *
	 *************************************************************************************************
	 *************************************************************************************************/

	@Step("Get greeting message")
	public String getGreetingMessage() {
		return dashBoardPage.getGreetingMessage();
	}

	/************************************************************************************************
	 * **********************************************************************************************
	 *
	 * ACCOUNTS PAGE STEPS
	 *
	 *************************************************************************************************
	 *************************************************************************************************/

	@Step("Adding new user information with userName: {0} , password: {1} , repeatPassword {2}")
	public AccountsPage addNewUserInformation(String userName, String password, String repeatPassword) {

		return accountsPage.addNewUserInformation(userName, password, repeatPassword);
	}

	@Step("Adding account information- firstname:{0} , lastName:{1},"
			+ " email:{2}, phone:{3}, addr1:{4}, addr2: {5}, city:{6}, " + "state:{7}, zip:{8}, country:{9} ")
	public AccountsPage addAccountInformation(String firstName, String lastName, String email, String phone,
			String addr1, String addr2, String city, String state, String zip, String country) {

		return accountsPage.addAccountInformation(firstName, lastName, email, phone, addr1, addr2, city, state, zip,
				country);
	}

	@Step("Adding profile information - language:{0} ,category: {1} ,myList: {2} ,myBanner:{3}")
	public AccountsPage addProfileInformation(String language, String category, boolean myList, boolean myBanner) {

		return accountsPage.addProfileInformation(language, category, myList, myBanner);
	}

	@Step("Saving account information")
	public DashBoardPage clickSaveAccountInformation() {

		return accountsPage.clickSaveAccountInformation();

	}

}
