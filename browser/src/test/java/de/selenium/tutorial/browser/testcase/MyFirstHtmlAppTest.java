package de.selenium.tutorial.browser.testcase;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import de.selenium.tutorial.browser.base.SeleniumBaseSpec;
import de.selenium.tutorial.browser.pagepattern.FormsPage;


public class MyFirstHtmlAppTest extends AbstractMyFirstHtmlAppTest {

	public WebDriver driver;

	// @BeforeClass
	// public void setUpBeforeClass() throws Exception {

	// }

	/*
	 * @AfterClass public void tearDownAfterClass() throws Exception {
	 * driver.quit(); }
	 */

	@Before
	public void setUp() throws Exception {
		driver = createDriver("firefox");
//		driver.manage().window().maximize();
		driver.get("file:///E:/HTML%20test%20app/forms.html");
	}

	@Test
	public void fillFormTest1() {
		driver.findElement(By.id("vorname")).sendKeys("Maria");
		driver.findElement(By.id("nachname")).sendKeys("Mustermann");
		driver.findElement(By.id("email")).sendKeys("maria.mustermann@seleniumCoaching.com");
		driver.findElement(By.id("password1")).sendKeys("abcd1234");
		driver.findElement(By.id("password2")).sendKeys("abcd1234");
		final Select dropdown = new Select(driver.findElement(By.id("anrede")));
		dropdown.selectByVisibleText("Frau");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}
/*
	@Test
	public void fillFormTest2() {
		final FormsPage form = new FormsPage(driver);
		form.vornameId.sendKeys("Maria");
		form.nachnameId.sendKeys("Mustermann");
		form.emailId.sendKeys("maria.mustermann@seleniumCoaching.com");
		form.password1Id.sendKeys("abcd1234");
		form.password2Id.sendKeys("abcd1234");
		final Select dropdown2 = new Select(form.anredeId);
		dropdown2.selectByValue("Frau");
		form.submit.click();
	}
	
	@Test
	public void fillFormTest3() {
		setDriver(driver);
		// Expected:
		Assert.assertTrue(navigateToFormPage());
		// When:
		fillOutForm("Frau", "Maria", "Mustermann", "maria.mustermann@seleniumCoaching.com", "abcd1234");
		// Then:
		Assert.assertTrue(formSubmited());
	}
*/
}
