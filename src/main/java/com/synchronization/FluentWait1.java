package com.synchronization;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FluentWait1 {

	static WebDriver driver;

	@Test
	public void main() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/chromedriver");
		driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.xpath("//button[text()='Start']")).click();

		// Fluent Wait
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)

				.withTimeout(30, TimeUnit.SECONDS)

				.pollingEvery(1, TimeUnit.SECONDS)

				.ignoring(NoSuchElementException.class);

		WebElement content = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//h4[text()='Hello World!']"));
			}
		});

		System.out.println(content.getText());
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
