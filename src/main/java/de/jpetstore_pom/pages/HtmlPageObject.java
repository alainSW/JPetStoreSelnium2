package de.jpetstore_pom.pages;

import static de.jpetstore_pom.util.TimeUtil.getExplicitWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.jpetstore_pom.driver.DriverManager;
import de.jpetstore_pom.util.Helper;
import de.jpetstore_pom.util.LogHelper;

public class HtmlPageObject extends DriverManager {

	private WebDriver driver = getDriver();

	/**
	 * Method to find element by css
	 * 
	 * @param cssLocator
	 * @return
	 */
	public WebElement findElementByCss(String cssLocator) {

		try {

			By by = By.cssSelector(cssLocator);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));

			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		} catch (TimeoutException t) {
			throw new TimeoutException();
		}
	}

	/**
	 * Method to find element by xpath
	 * 
	 * @param xpathLocator
	 * @return
	 */
	public WebElement findElementByXpath(String xpathLocator) {

		try {

			By by = By.xpath(xpathLocator);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));

			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		} catch (TimeoutException t) {
			throw new TimeoutException();
		}
	}

	/**
	 * Method to find element by Id
	 * 
	 * @param IdLocator
	 * @return
	 */
	public WebElement findElementById(String IdLocator) {

		try {

			By by = By.id(IdLocator);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));

			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		} catch (TimeoutException t) {
			throw new TimeoutException();
		}
	}

	/**
	 * Method to find an element by using By locator
	 * 
	 * @param by
	 * @return
	 */
	public WebElement findElementBy(By by) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));

			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		} catch (TimeoutException t) {
			throw new TimeoutException();
		}
	}

	/**
	 * Method to find an element by using By locator
	 * 
	 * @param by
	 * @return
	 */
	public List<WebElement> findElementsBy(By by) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));

			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

		} catch (TimeoutException t) {
			throw new TimeoutException();
		}
	}

	/**
	 * Method to enter text inside textbox
	 * 
	 * @param by
	 * @param text
	 */
	public void enterTextIntoTextBox(By by, String text) {

		WebElement textBox = findElementBy(by);
		textBox.clear();
		textBox.sendKeys(text);

		Helper.takeElementScreenShot(textBox, "textbox");

		LogHelper.logToReport("Typing text : " + text + "inside textbox" + " with locator: " + by);

	}

	/**
	 * Method to enter text inside textbox
	 * 
	 * @param element
	 * @param text
	 */
	public void enterTextIntoTextBox(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);

		Helper.takeElementScreenShot(element, "textbox");

		LogHelper.logToReport("Typing text : " + text + "inside textbox" + " with locator: " + element.toString());
	}

	/**
	 * Method to click a link or button
	 * 
	 * @param by
	 */
	public void clickLinkOrBtn(By by) {

		WebElement btnOrLink = findElementBy(by);
		btnOrLink.click();
	}

	/**
	 * Method to click a link or button
	 * 
	 * @param element
	 */
	public void clickLinkOrBtn(WebElement element) {

		element.click();
	}

	/**
	 * Method to return text
	 * 
	 * @param by
	 * @return
	 */
	public String getTextFromElement(By by) {
		WebElement element = findElementBy(by);
		return element.getText();
	}

	/**
	 * Method to return text
	 * 
	 * @param element
	 * @return
	 */
	public String getTextFromElement(WebElement element) {

		return element.getText();
	}

	/**
	 * Method to return the attribute value
	 * 
	 * @param by
	 * @param attr
	 * @return
	 */
	public String getAttribute(By by, String attr) {
		WebElement element = findElementBy(by);
		return element.getAttribute(attr);
	}

	/**
	 * Method to return the attribute value
	 * 
	 * @param element
	 * @param attr
	 * @return
	 */
	public String getAttribute(WebElement element, String attr) {
		return element.getAttribute(attr);
	}

	/**
	 * Method to select by visible text
	 * 
	 * @param by
	 * @param textValue
	 */
	public void selectByVisibleText(By by, String textValue) {

		WebElement selectBox = findElementBy(by);
		Select select = new Select(selectBox);
		select.selectByVisibleText(textValue);
	}

	/**
	 * Method to select by visible text
	 * 
	 * @param element
	 * @param textValue
	 */
	public void selectByVisibleText(WebElement element, String textValue) {

		Select select = new Select(element);
		select.selectByVisibleText(textValue);
	}

	/**
	 * Method to select checkbox
	 * 
	 * @param by
	 * @return
	 */
	public boolean selectCheckBox(By by) {

		WebElement webElement = findElementBy(by);
		if (webElement.isSelected()) {
			return true;
		}
		webElement.click();
		return true;
	}

	/**
	 * Method to select checkbox
	 * 
	 * @param webElement
	 * @return
	 */
	public boolean selectCheckBox(WebElement webElement) {

		if (webElement.isSelected()) {
			return true;
		}
		webElement.click();
		return true;
	}

	/**
	 * Method to check if text is present on page
	 * 
	 * @param text
	 * @return
	 */
	public boolean isTextPresentOnPage(String text) {
		String pageSource = driver.getPageSource();
		if (pageSource.contains(text)) {
			return true;
		}
		return false;
	}
}
