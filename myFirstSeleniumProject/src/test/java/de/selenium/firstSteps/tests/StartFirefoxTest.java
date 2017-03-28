package test.java.de.selenium.firstSteps.tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StartFirefoxTest {
	
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
	public void test() {
		fail("Not yet implemented");
	}

}