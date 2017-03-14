package de.selenium.tutorial.browser.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

abstract class SeleniumBaseSpec {
	protected static final long DEFAULT_TIMEOUT = 30;
	protected WebDriver driver;
	private String useBrowser;

	protected WebDriver createDriver(String vBrowser) {
		useBrowser = vBrowser.toLowerCase();
		switch (useBrowser) {
		case "firefox":
			System.out.println("launching firefox browser");
			System.setProperty("webdriver.gecko.driver", "./ressources/geckodriver.exe");
			return new FirefoxDriver(new FirefoxSettings().capabilities);
		case "chrome":
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", "./ressources/chromedriver.exe");
			return chromeDriver();
		case "internet explorer":
			System.out.println("launching IE browser");
			System.setProperty("webdriver.ie.driver", "./ressources/IEDriverServer.exe");
			driver = ieDriver();
		case "edge":
			System.out.println("launching Microsoft Edge browser");
			System.setProperty("webdriver.edge.driver", "./ressources/MicrosoftWebDriver.exe");
			driver = edgeDriver();
		default:
			System.out.println("launching (default) chrome browser");
			System.setProperty("webdriver.chrome.driver", "./ressources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}
	
//	private FirefoxDriver firefoxDriver() {
//		final DesiredCapabilities dCaps = new FirefoxSettings().capabilities;
//		return new FirefoxDriver(dCaps);
//	}
	
	private ChromeDriver chromeDriver() {
		final DesiredCapabilities dCaps = new ChromeSettings().capabilities;
		return new ChromeDriver(dCaps);
	}
	
	private InternetExplorerDriver ieDriver() {
		final DesiredCapabilities dCaps = new IESettings().capabilities;
		return new InternetExplorerDriver(dCaps);
	}
	
	private EdgeDriver edgeDriver() {
		final DesiredCapabilities dCaps = new EdgeSettings().capabilities;
		return new EdgeDriver(dCaps);
	}
}