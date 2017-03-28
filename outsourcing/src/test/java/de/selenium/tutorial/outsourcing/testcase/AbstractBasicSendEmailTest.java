package de.selenium.tutorial.outsourcing.testcase;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.selenium.tutorial.outsourcing.base.ObjectMap;
import de.selenium.tutorial.outsourcing.base.SeleniumBaseSpec;

public abstract class AbstractBasicSendEmailTest extends SeleniumBaseSpec{
	
	public WebDriver theDriver;
	public ObjectMap thePage;
	
	public boolean setDriver(WebDriver driver) {
		theDriver = driver;
		return true;
	}
	
	public boolean setMapRessource(String mapRessource) {
		thePage = new ObjectMap(mapRessource);
		return true;
	}
	
	public boolean navigateToContactPage() {
		theDriver.navigate().to("http://spirit-testing.com/kontakt");
		Assert.assertEquals("Kontakt | Spirit Testing", theDriver.getTitle());
		return true;
	}
	
	public boolean fillOutForm() throws Exception {
		WebElement vname = theDriver.findElement(thePage.getLocator("firstName"));
		vname.sendKeys("Test");
		WebElement nname = theDriver.findElement(thePage.getLocator("lastName"));
		nname.sendKeys("Vader");
		WebElement email = theDriver.findElement(thePage.getLocator("emailAdress"));
		email.sendKeys("testVader@spirit-onside.com");
		WebElement text = theDriver.findElement(thePage.getLocator("testField"));
		text.sendKeys("Herzliche Grüße von der geilsten Selenium-Schulung!");
		WebElement submit = theDriver.findElement(thePage.getLocator("sendButton"));
		submit.click();
		return true;
	}
	
	public boolean verifyMailSentAway() throws Exception {
		WebElement successMsg = theDriver.findElement(thePage.getLocator("successMessage"));
		Assert.assertEquals("Vielen Dank, wir haben Ihre Nachricht erhalten und werden uns umgehend bei Ihnen melden.", successMsg);
		return true;
	}
}


//kp.fillInEmailAddress("pawel.albrant@spirit-testing.com");
//kp.fillInMailBody("ein einfacher Text zum Testen der Kontaktseite");
//kp = kp.sendForm();		
