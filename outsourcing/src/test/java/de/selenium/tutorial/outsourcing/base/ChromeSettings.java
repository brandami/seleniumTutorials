package de.selenium.tutorial.outsourcing.base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeSettings {
	protected DesiredCapabilities capabilities;
	private static String deviceName;

	protected ChromeSettings() {
		capabilities = createChromeCapabilities();
	}
	
	protected ChromeSettings(String device) {
        deviceName = device;
        capabilities = createMobileChromeCapabilities();
    }
	
	private DesiredCapabilities createChromeCapabilities() {
		final DesiredCapabilities dCaps = DesiredCapabilities.chrome();
        dCaps.setCapability(ChromeOptions.CAPABILITY, createChromeOptions());
		return dCaps;
	}
	
	private DesiredCapabilities createMobileChromeCapabilities() {
        DesiredCapabilities mobileDCaps = DesiredCapabilities.chrome();
        mobileDCaps.setCapability(ChromeOptions.CAPABILITY, createMobileChromeOptions());
        return mobileDCaps;
	}
	
	private ChromeOptions createMobileChromeOptions() {
		ChromeOptions mobileOptions = createChromeOptions();
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", deviceName);
		mobileOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		return mobileOptions;
	}
	
	private ChromeOptions createChromeOptions() {
		ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.addArguments("ignore-certificate-errors");
				options.addArguments("disable-application-cache");
				return options;
	}
}
