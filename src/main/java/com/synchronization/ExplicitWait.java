package com.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ExplicitWait {

	static WebDriver driver;

	@Test
	public void main() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/chromedriver");
		driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.xpath("//button[text()='Start']")).click();
		WebElement content = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

		// Explicit Wait
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.visibilityOf(content));

		Assert.assertTrue(content.isDisplayed(), "Content is not displayed");
		System.out.println(content.getText());

	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
