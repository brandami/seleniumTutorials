package test.java.de.selenium.firstSteps.tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StartFirefoxTest {
	
	static String driverPath = "./ressources/geckodriver.exe";
	public WebDriver driver;
	
	/**
	 * @Before bedeutet, dass diese Methode vor jedem Test innerhalb dieser Klasse ausgef�hrt wird.
	 * Dies wird bspw. genutzt, um notwendige Vorbedingungen f�r den entsprechenden Test auszuf�hren
	 * @throws Exception
	 */
	@Before
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching firefox browser");
		// System properties f�r Firefox
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
