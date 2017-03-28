package test.java.de.selenium.usingAssertions;

import static org.junit.Assert.*;

import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class AssertionsExamples {

	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		//Browser maximieren
		driver.manage().window().maximize();
		
		//Kontaktformular von Spirit-Testing aufrufen
		driver.get("http://www.spirit-testing.com/kontakt");
	}
	
	@AfterClass
	public static void tearDown() {
		//Browser schließen
		driver.quit();
	}

	@Test
	public void methodAssertEquals() {
	
		//Titel der Seite prüfen
		Assert.assertEquals(driver.getTitle(), "Kontakt | Spirit Testing");
	}
	
	@Test
	public void methodAssertNotEquals() {

		//Titel der Seite prüfen
		Assert.assertNotEquals(driver.findElement(By.id("edit-submitted-vorname")).getText(), "Andreas");
	}
	
	@Test (expected=NoSuchElementException.class)
	public void methodAssertNull() {
		WebElement errorMessageBox = driver.findElement(By.xpath("//*[@class='messages error']"));
		assertNull(errorMessageBox);
	}
	
	@Test
	public void methodAssertNotNull() {
		WebElement sendButton = driver.findElement(By.id("edit-submit"));
		assertNotNull(sendButton);
	}
	
	@Test
	public void methodAssertFalse() {

		//Prüfen, dass das Feld Vorname selektiert ist
		assertFalse(driver.findElement(By.id("edit-submitted-vorname")).isSelected());
	}
	
	@Test
	public void methodAssertTrue() {
		
		//Prüfen, dass das Feld Vorname aktiviert ist
		assertTrue(driver.findElement(By.id("edit-submitted-vorname")).isEnabled());
	}
	
}
