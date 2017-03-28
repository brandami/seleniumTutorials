package test.java.de.selenium.usingAssertions;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class ExplicitAndImplicitWaits {

public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		//Browser maximieren
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void tearDown() {
		//Browser schlieﬂen
		driver.quit();
	}

	@Test
	public void implicityWaits() {
		//Sync-Timeout auf 3 Sekunden setzen
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void explicityWaits() {
		
		
	}

}
