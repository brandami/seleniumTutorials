package de.selenium.tutorial.outsourcing.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class SeleniumBaseSpec {
	protected static final long DEFAULT_TIMEOUT = 30;
	public WebDriver driver;
	private String useBrowser;
	
	public WebDriver getDriver(String vBrowser) {
		useBrowser = vBrowser.toLowerCase();
		driver = createDriver();
		driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}

	private WebDriver createDriver() {
		switch (useBrowser) {
		case "firefox":
			System.out.println("launching firefox browser");
			System.setProperty("webdriver.gecko.driver", "./ressources/geckodriver.exe");
			return new FirefoxDriver(new FirefoxSettings().capabilities);
		case "chrome":
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", "./ressources/chromedriver.exe");
			return new ChromeDriver(new ChromeSettings().capabilities);
		case "internet explorer":
			System.out.println("launching IE browser");
			System.setProperty("webdriver.ie.driver", "./ressources/IEDriverServer.exe");
			return new InternetExplorerDriver(new IESettings().capabilities);
		case "edge":
			System.out.println("launching Microsoft Edge browser");
			System.setProperty("webdriver.edge.driver", "./ressources/MicrosoftWebDriver.exe");
			return new EdgeDriver(new EdgeSettings().capabilities);
		default:
			System.out.println("launching (default) chrome browser");
			System.setProperty("webdriver.chrome.driver", "./ressources/chromedriver.exe");
			return new ChromeDriver(DesiredCapabilities.chrome());
		}
	}
}