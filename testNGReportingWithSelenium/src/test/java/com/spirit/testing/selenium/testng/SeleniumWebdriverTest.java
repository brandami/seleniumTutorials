package com.spirit.testing.selenium.testng;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumWebdriverTest {

	WebDriver ffd;

	@Test
	public void functionToPass() {
		// ffd.manage().window().fullscreen();
		WebElement we = ffd.findElement(By.linkText("Leistungen"));
		we.click();
	}

	@Test
	public void functionToFail() {
		WebElement we = ffd.findElement(By.linkText("Job")); //cannot be found cause not exists 
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
		ffd = new ChromeDriver();
		ffd.navigate().to("http://www.spirit-testing.com");
	}

	@AfterMethod
	public void afterMethod() {
		ffd.close();
	}

}
