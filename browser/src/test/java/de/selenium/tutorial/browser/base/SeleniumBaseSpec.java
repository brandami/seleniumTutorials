package de.selenium.tutorial.browser.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class SeleniumBaseSpec {
	protected static final long DEFAULT_TIMEOUT = 30;
	protected WebDriver driver;
	private String useBrowser;

	protected WebDriver createDriver(String vBrowser) {
		useBrowser = vBrowser.toLowerCase();
		switch (useBrowser) {
		case "firefox":
			System.out.println("launching firefox browser");
			System.setProperty("webdriver.gecko.driver", "./ressources/geckodriver.exe");
			driver = new FirefoxDriver(new FirefoxSettings().capabilities);
			break;
		case "chrome":
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", "./ressources/chromedriver.exe");
			driver = chromeDriver();
			break;
		case "internet explorer":
			System.out.println("launching IE browser");
			System.setProperty("webdriver.ie.driver", "./ressources/IEDriverServer.exe");
			driver = ieDriver();
			break;
		case "edge":
			System.out.println("launching Microsoft Edge browser");
			System.setProperty("webdriver.edge.driver", "./ressources/MicrosoftWebDriver.exe");
			driver = edgeDriver();
			break;
		default:
			System.out.println("launching (default) chrome browser");
			System.setProperty("webdriver.chrome.driver", "./ressources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}

	public void report(String testcaseName) {
		String path;
		try{
            File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            path = ".target/screenshots/" + testcaseName + source.getName();
            FileUtils.copyFile(source, new File(path));
		} catch(IOException e) {
			System.out.println("Failed to capture screenshot: " + e.getStackTrace());
		}
    }

	// private FirefoxDriver firefoxDriver() {
	// final DesiredCapabilities dCaps = new FirefoxSettings().capabilities;
	// return new FirefoxDriver(dCaps);
	// }

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