package de.selenium.tutorial.browser.base;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IESettings {
	protected DesiredCapabilities capabilities;

	public IESettings() {
		capabilities = createIECapabilities();
	}

	private DesiredCapabilities createIECapabilities() {
		DesiredCapabilities dCaps = DesiredCapabilities.internetExplorer();
		// Required, because IEDriverServer looses Window-Focus and as result of this, the typing is very slow.
		dCaps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		dCaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		dCaps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		dCaps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "IGNORE");
		// Required, because IEDriverServer doesn't work with empty StartPage
		dCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.google.com/");
		return dCaps;
	}

}
