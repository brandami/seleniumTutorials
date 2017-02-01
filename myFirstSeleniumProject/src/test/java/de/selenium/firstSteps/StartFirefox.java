/**
 * 
 */
package test.java.de.selenium.firstSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author brandami
 *
 */
public class StartFirefox {
	
	public static void main(String arg[]) {
		/**
		 * !!! statische Definition von Pfad nicht gut !!! 
		 * gleiches gilt f�r angebundene Libraries :)
		 * besser MAVEN benutzen
		 */
		//Pfad zur geckodriver.exe
		String driverPath = "./ressources/geckodriver.exe";

		System.out.println("*******************");
		System.out.println("launching firefox browser");
		// System properties f�r Firefox
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();

	}

}