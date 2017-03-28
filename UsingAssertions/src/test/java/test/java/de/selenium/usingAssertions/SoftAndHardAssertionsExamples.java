package test.java.de.selenium.usingAssertions;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SoftAndHardAssertionsExamples {

	public static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {

		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		// Browser maximieren
		driver.manage().window().maximize();

		// Kontaktformular von Spirit-Testing aufrufen
		driver.get("http://www.spirit-testing.com/kontakt");
	}

	@AfterClass
	public static void tearDown() {
		// Browser schließen
		driver.quit();
	}

	@Test
	public void hardAssertion() {

		// Geschäftsführer prüfen
		assertEquals("Jürgen Volles\nGeschäftsführer Spirit-Testing",
				driver.findElement(By.xpath("//*[@id='node-23']/div[1]/table/tbody/tr[1]/td[3]/p[1]")).getText());
		// Geschäftsführerin prüfen
		assertEquals("Andreas Hofmann\n2. Geschäftsführer Spirit-Testing",
				driver.findElement(By.xpath("//*[@id='node-23']/div[1]/table/tbody/tr[3]/td[3]/p[1]")).getText());
		// Leiter Entwicklung testofficePrüfen
		assertEquals("Tobias Roloff\nLeiter Entwicklung testOFFICE",
				driver.findElement(By.xpath("//*[@id='node-23']/div[1]/table/tbody/tr[5]/td[3]/p[1]")).getText());
	}

	@Test
	public void SoftAssertion() {

		SoftAssert mySoftAssert = new SoftAssert();

		// Geschäftsführer prüfen
		mySoftAssert.assertEquals("Jürgen Volles\nGeschäftsführer Spirit-Testing",
				driver.findElement(By.xpath("//*[@id='node-23']/div[1]/table/tbody/tr[1]/td[3]/p[1]")).getText(), "Failed: Geschäftsführer prüfen");
		// Geschäftsführerin prüfen
		mySoftAssert.assertEquals("Andreas Hofmann\n2. Geschäftsführer Spirit-Testing",
				driver.findElement(By.xpath("//*[@id='node-23']/div[1]/table/tbody/tr[3]/td[3]/p[1]")).getText(), "Failed: Geschäftsführerin prüfen");
		// Leiter Entwicklung testofficePrüfen
		mySoftAssert.assertEquals("Tobias Roloff\nLeiter Entwicklung testOFFICE",
				driver.findElement(By.xpath("//*[@id='node-23']/div[1]/table/tbody/tr[5]/td[3]/p[1]")).getText(), "Failed: Leiter testOffice prüfen");
		
		mySoftAssert.assertAll();
	}

}
