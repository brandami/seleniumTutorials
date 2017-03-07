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
		dCaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		return dCaps;
	}

}
