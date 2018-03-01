package com.synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class PageLoadTimeOut {

	static WebDriver driver;

	@Test
	public void main() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/chromedriver");
		driver = new ChromeDriver();

		// Page Load Time Out
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MILLISECONDS);

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

	}

	@AfterTest
	public void close() {
		driver.quit();
	}

}
