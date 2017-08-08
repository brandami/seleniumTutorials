package de.selenium.tutorial.browser.testcase;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import de.selenium.tutorial.browser.base.SeleniumBaseSpec;

public class Testcase extends SeleniumBaseSpec {

	public WebDriver driver;
	
	@Rule public TestName name = new TestName();

	@Test
	public void testFirefox() {
		driver = createDriver("Firefox");
		driver.manage().window().maximize();
		driver.get("https://www.google.de");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}

	@Test
	public void testChrome() {
		driver = createDriver("Chrome");
		driver.navigate().to("https://www.google.de");
		Assert.assertEquals("Google", driver.getTitle());
		driver.close();
	}

	@Test
	public void testInternetExplorer() {
		driver = createDriver("Internet Explorer");
		driver.manage().window().maximize();
		driver.get("https://www.google.de");
		Assert.assertEquals("Google", driver.getTitle());
		driver.close();
	}
	
	@Test
	public void testEdge() {
		driver = createDriver("Edge");
		driver.get("https://www.google.de");
		Assert.assertEquals("Google", driver.getTitle());
		driver.close();
	}
	
	@Test
	public void testChrome2() {
		driver = createDriver("Chrome");
		driver.navigate().to("https://www.google.de");
		Assert.assertEquals("Google", driver.getTitle());
		report(name.getMethodName());
		driver.close();

	}

}
