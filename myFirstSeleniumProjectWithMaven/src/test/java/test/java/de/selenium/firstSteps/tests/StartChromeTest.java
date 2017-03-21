package test.java.de.selenium.firstSteps.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartChromeTest {

	private static String driverPath = "./ressources/chromedriver.exe";
	public static WebDriver driver;
	
	/**
	 * @BeforeClass bedeutet, dass diese Methode einmalig vor allen Tests dieser Klasse ausgeführt wird.
	 * Dies wird genutzt, um zeitaufwendige Vorbedingungen, wie bspw. eine Datenbankverbindung einmalig
	 * vor allen Tests zu etablieren.
	 * Häufig ist es auch sinnvoll den Browser nur einmal zu starten, da dies bei vielen Tests innerhalb
	 *  der Klasse auch recht zeitaufwendig werden kann und es schneller geht den Browser nur zurückzusetzen
	 *  anstatt ihn komplett neu zu starten
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp(){
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		// System properties für Firefox
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
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
	public void test() {
		fail("Not yet implemented");
	}

}
