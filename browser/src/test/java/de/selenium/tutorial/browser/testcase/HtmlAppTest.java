package de.selenium.tutorial.browser.testcase;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.selenium.tutorial.browser.base.SeleniumBaseSpec;
import de.selenium.tutorial.browser.pagepattern.FormsPage;

public class HtmlAppTest extends SeleniumBaseSpec {

	public WebDriver driver;
	private FormsPage form;
	
	@Before
	public void setUp() throws Exception {
		driver = createDriver("Firefox");
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		form = new FormsPage(driver);
		driver.get("file:///E:/HTML%20test%20app/forms.html");
		System.out.println("RADIO_LIST: " + form.radioList.size());
	}

}
