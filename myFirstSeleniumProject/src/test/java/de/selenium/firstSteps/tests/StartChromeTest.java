package test.java.de.selenium.firstSteps.tests;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartChromeTest {

	static String driverPath = "./ressources/chromedriver.exe";
	public WebDriver driver;
	
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
	public void setUp() throws Exception {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		// System properties für Firefox
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test1() {
		fail("Not yet implemented");
	}

	@Test
	public void test2() {
		fail("Not yet implemented");
	}

}
