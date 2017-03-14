package de.selenium.tutorial.browser.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract class SeleniumRemoteBaseSpec {
	protected static final long DEFAULT_TIMEOUT = 30;
	protected RemoteWebDriver driver;
	private static String useBrowser;

	public RemoteWebDriver createDriver(String vBrowser) throws MalformedURLException {
		useBrowser = vBrowser.toLowerCase();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getBrowserCapabilities());
		driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}
	
	private static DesiredCapabilities getBrowserCapabilities() {
        switch (useBrowser) {
            case "firefox":
                System.out.println("Opening firefox driver");
                return new FirefoxSettings().capabilities;
            case "chrome":
                System.out.println("Opening chrome driver");
                return new ChromeSettings().capabilities;
            case "internet explorer":
                System.out.println("Opening IE driver");
                return new IESettings().capabilities;
            case "edge":
            	System.out.println("Opening edge driver");
            	return new EdgeSettings().capabilities;
            default:
                System.out.println("browser : " + useBrowser + " is invalid, Launching Chrome as browser of choice..");
                return DesiredCapabilities.chrome();
        }
    }

	
}
