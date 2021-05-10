package de.jpetstore_pom.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import de.jpetstore_pom.driver.DriverManager;

@DisplayName("My Browser Tests")
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class MySecondTest extends DriverManager {

	@Disabled
	@Test
	@DisplayName("This is my Second selenium test!!!")
	void this_is_my_first_selenium_test() throws InterruptedException {

		String url = prop.getProperty("url");
		String port = prop.getProperty("port");
		String finalUrl = url + port;

		driver.get(finalUrl);
		driver.findElement(By.xpath("//*[@id=\"Content\"]/p[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/input[1]")).sendKeys("Hello");
		Thread.sleep(2000);

	}

}
