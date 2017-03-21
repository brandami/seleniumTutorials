package test.java.de.selenium.firstSteps.tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestKontaktFormularSpiritOnsideFireFox {
	
	private static String driverPath = "./ressources/geckodriver.exe";
	public static WebDriver driver;
	
	/**
	 * @Before bedeutet, dass diese Methode vor jedem Test innerhalb dieser Klasse ausgeführt wird.
	 * Dies wird bspw. genutzt, um notwendige Vorbedingungen für den entsprechenden Test auszuführen
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() {
		System.out.println("*******************");
		System.out.println("launching firefox browser");
		// System properties für Firefox
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		//Browser maximieren
		driver.manage().window().maximize();
		//Sync-Timeout setzen
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() {
		//Browser schließen
		driver.quit();
	}

	
	@Test
	public void testErrorMessageEmailIsNull() {
		//Kontaktformular von Spirit-Testing aufrufen
		driver.get("http://www.spirit-testing.com/kontakt");
		//Vorname eingeben
		driver.findElement(By.id("edit-submitted-vorname")).sendKeys("Max");
		//Nachname eingeben
		driver.findElement(By.id("edit-submitted-nachname")).sendKeys("Mustermann");
		//Firma eingeben
		driver.findElement(By.id("edit-submitted-firma")).sendKeys("Musterfirma");
		//E-Mail Adresse leer lassen
		driver.findElement(By.id("edit-submitted-e-mail")).sendKeys("");
		//Darum geht es ausfüllen
		driver.findElement(By.id("edit-submitted-darum-geht-es")).sendKeys("Dies ist ein Test!");
		//Abschicken klicken
		driver.findElement(By.id("edit-submit")).click();
		
		//Prüfen, ob Fehlermeldung wegen fehlender E-Mail Adresse erscheint
		Assert.assertEquals("Das Feld E-Mail ist erforderlich.", driver.findElement(By.xpath("//*[@class='messages error']")).getText());
	}
	
	@Test
	public void testErrorMessageEmailIsNotValid() {
		//Kontaktformular von Spirit-Testing aufrufen
		driver.get("http://www.spirit-testing.com/kontakt");
		//Vorname eingeben
		driver.findElement(By.id("edit-submitted-vorname")).sendKeys("Max");
		//Nachname eingeben
		driver.findElement(By.id("edit-submitted-nachname")).sendKeys("Mustermann");
		//Firma eingeben
		driver.findElement(By.id("edit-submitted-firma")).sendKeys("Musterfirma");
		//fehlerhafte E-Mail Adresse eingeben
		driver.findElement(By.id("edit-submitted-e-mail")).sendKeys("test");
		//Darum geht es ausfüllen
		driver.findElement(By.id("edit-submitted-darum-geht-es")).sendKeys("Dies ist ein Test!");
		//Abschicken klicken
		driver.findElement(By.id("edit-submit")).click();
		
		//Prüfen, ob Fehlermeldung wegen fehlender E-Mail Adresse erscheint
		Assert.assertEquals("test is not a valid email address.", driver.findElement(By.xpath("//*[@class='messages error']")).getText());
	}
	
	@Test
	public void testErrorMessageVornameIsNull() {
		//Kontaktformular von Spirit-Testing aufrufen
		driver.get("http://www.spirit-testing.com/kontakt");
		//Vorname leer lassen
		driver.findElement(By.id("edit-submitted-vorname")).sendKeys("");
		//Nachname eingeben
		driver.findElement(By.id("edit-submitted-nachname")).sendKeys("Mustermann");
		//Firma eingeben
		driver.findElement(By.id("edit-submitted-firma")).sendKeys("Musterfirma");
		//E-Mail Adresse leer lassen
		driver.findElement(By.id("edit-submitted-e-mail")).sendKeys("max.mustermann@musterfirma.com");
		//Darum geht es ausfüllen
		driver.findElement(By.id("edit-submitted-darum-geht-es")).sendKeys("Dies ist ein Test!");
		//Abschicken klicken
		driver.findElement(By.id("edit-submit")).click();
		
		//Prüfen, ob Fehlermeldung wegen fehlender E-Mail Adresse erscheint
		Assert.assertEquals("Das Feld Vorname ist erforderlich.", driver.findElement(By.xpath("//*[@class='messages error']")).getText());
	}
	
	@Test
	public void testErrorMessageNachnameIsNull() {
		//Kontaktformular von Spirit-Testing aufrufen
		driver.get("http://www.spirit-testing.com/kontakt");
		//Vorname eingeben
		driver.findElement(By.id("edit-submitted-vorname")).sendKeys("Max");
		//Nachname leer lassen
		driver.findElement(By.id("edit-submitted-nachname")).sendKeys("");
		//Firma eingeben
		driver.findElement(By.id("edit-submitted-firma")).sendKeys("Musterfirma");
		//E-Mail Adresse ausfüllen
		driver.findElement(By.id("edit-submitted-e-mail")).sendKeys("max.mustermann@musterfirma.com");
		//Darum geht es ausfüllen
		driver.findElement(By.id("edit-submitted-darum-geht-es")).sendKeys("Dies ist ein Test!");
		//Abschicken klicken
		driver.findElement(By.id("edit-submit")).click();
		
		//Prüfen, ob Fehlermeldung wegen fehlender E-Mail Adresse erscheint
		Assert.assertEquals("Das Feld Nachname ist erforderlich.", driver.findElement(By.xpath("//*[@class='messages error']")).getText());
	}
	
	@Test
	public void testErrorMessagesRequiredFieldsAreNull() {
		//Kontaktformular von Spirit-Testing aufrufen
		driver.get("http://www.spirit-testing.com/kontakt");
		//Vorname leer lassen
		driver.findElement(By.id("edit-submitted-vorname")).sendKeys("");
		//Nachname leer lassen
		driver.findElement(By.id("edit-submitted-nachname")).sendKeys("");
		//E-Mail Adresse leer lassen
		driver.findElement(By.id("edit-submitted-e-mail")).sendKeys("");
		//Abschicken klicken
		driver.findElement(By.id("edit-submit")).click();
		
		//Prüfen, ob Fehlermeldungen wegen fehlender Vorname, Nachname und E-Mail Adresse erscheint
		Assert.assertEquals("Das Feld Vorname ist erforderlich.\nDas Feld Nachname ist erforderlich.\nDas Feld E-Mail ist erforderlich.", driver.findElement(By.xpath("//*[@class='messages error']")).getText());
	}

}
