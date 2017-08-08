package de.selenium.tutorial.browser.testcase;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import de.selenium.tutorial.browser.base.SeleniumBaseSpec;
import de.selenium.tutorial.browser.pagepattern.FormsPage;



public abstract class AbstractMyFirstHtmlAppTest  extends SeleniumBaseSpec{
	protected WebDriver driver;
	private FormsPage page;
	
	public boolean setDriver(WebDriver driver) {
		this.driver = driver;
		return true;
	}

	public boolean navigateToFormPage() {
		page = new FormsPage(driver);
		driver.get(page.URL);
		Assert.assertEquals("Forms", page.title);
		return true;
	}
	
	public boolean fillOutForm1(String anrede, String vorname, String nachname, String email, String password) {
		Assert.assertEquals(page.TITLE, page.title);
		page.vornameId.sendKeys(vorname);
		page.nachnameId.sendKeys(nachname);
		page.emailId.sendKeys(email);
		page.password1Id.sendKeys(password);
		page.password2Id.sendKeys(password);
		final Select dropdown2 = new Select(page.anredeId);
		dropdown2.selectByValue(anrede);
		page.submit.click();
		return true;
	}
	
	public boolean fillOutForm2(String anrede, String vorname, String nachname, String email, String password) {
		Assert.assertEquals(page.TITLE, page.title);
		page.sendKeysToInput(page.vornameId, vorname);
		page.sendKeysToInput(page.nachnameId, nachname);
		page.sendKeysToInput(page.emailId, email);
		page.sendKeysToInput(page.password1Id, password);
		page.sendKeysToInput(page.password2Id, password);
		final Select dropdown2 = new Select(page.anredeId);
		dropdown2.selectByValue(anrede);
		page.submit.click();
		return true;
	}
	
	public boolean formSubmited() {
		return true;
	}
}
