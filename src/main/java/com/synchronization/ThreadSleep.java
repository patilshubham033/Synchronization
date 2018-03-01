package com.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ThreadSleep {

	static WebDriver driver;

	@Test
	public void main() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/chromedriver");
		driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/dynamic_controls");

		driver.findElement(By.xpath("//button[@id='btn']")).click();

		
		
		// Thread.Sleep()
		Thread.sleep(1000);

		WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkbox']"));

		Assert.assertTrue(checkBox.isDisplayed(), "checkBox is not displayed");

		driver.findElement(By.xpath("//button[text()='Remove']")).click();


		
		// Thread.Sleep()
		Thread.sleep(10000);

		WebElement message = driver.findElement(By.id("message"));

		Assert.assertTrue(message.isDisplayed(), "Message is not displayed");

	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
