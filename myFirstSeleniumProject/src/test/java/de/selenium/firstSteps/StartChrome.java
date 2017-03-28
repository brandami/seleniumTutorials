/**
 * 
 */
package test.java.de.selenium.firstSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author brandami
 *
 */
public class StartChrome {
	
	public static void main(String arg[]) {
		/**
		 * !!! statische Definition von Pfad nicht gut !!! 
		 * gleiches gilt für angebundene Libraries :)
		 * besser MAVEN benutzen
		 */
		//Pfad zur geckodriver.exe
		String driverPath = "./ressources/chromedriver.exe";

		System.out.println("*******************");
		System.out.println("launching chrome browser");
		// System properties für Firefox
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
	}

}