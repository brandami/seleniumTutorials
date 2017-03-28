package de.selenium.tutorial.outsourcing.testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SendEmailTest extends AbstractBasicSendEmailTest {

	public static String mapRessource;
	public WebDriver driver;

	@Before
	public void setUp() {
		driver = getDriver("Firefox");
		mapRessource = "./ressources/kontakt.properties";
	}

	@Test
	public void test() throws Exception {
		//given
		setDriver(driver);
		setMapRessource(mapRessource);
		//expect
		navigateToContactPage();
		//when
		fillOutForm();
		//then
		verifyMailSentAway();
	}

	@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}

}
