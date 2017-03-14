package com.spirit_testing.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	public HomePage() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/pa/workspace/UsingLocators/tests/resources/driver/chromedriver.exe");
//		System.setProperty("webdriver.firefox.bin",
//				"C:/Users/pa/workspace/UsingLocators/tests/resources/firefox_portable/FirefoxPortable.exe");
//
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		capabilities.setCapability("marionette", true);
//		capabilities.setBrowserName("firefox");
//		capabilities.setPlatform(Platform.ANY);

		WebDriver driver = new ChromeDriver();
		driver.get("http://spirit-testing.com/");
		driver.manage().window().maximize();
	}

	@FindBy(xpath = "//a[@title ='Kontakt']")
	private WebElement kontakt;

	public KontaktPage openContactPage() {
		kontakt.click();
		return new KontaktPage();
	}
}
