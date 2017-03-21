package test.de.java.de.selenium.firstSteps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class StartChrome {

	private static WebDriver driver;
	

	public static void main(String arg[]) {
		
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		//Browser maximieren
		driver.manage().window().maximize();
		//Sync-Timeout setzen
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
}
