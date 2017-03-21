package test.de.java.de.selenium.firstSteps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class StartFireFox {

	private static WebDriver driver;
	

	public static void main(String arg[]) {
		
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		//Browser maximieren
		driver.manage().window().maximize();
		//Sync-Timeout setzen
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
}