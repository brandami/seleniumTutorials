package de.selenium.tutorial.outsourcing.base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxSettings {
	protected DesiredCapabilities capabilities;

	public FirefoxSettings() {
		capabilities = createFirefoxCapabilities();
	}
	
	/**
	 * Den SeleniumServer zur Auswahl des Browsers nutzen
	 * @browserName Name des verwendeten Browsers (optional)
	 * @Platform Möglichkeit zum spezifizieren auf welchen Platform der Test laufen soll (optional)
	 * 
	 * @SUPPORT_ALERTS Unterstützung für Handling von Alert-PopUps
	 * @UNEXPECTED_ALERT_BEHAVIOUR Handling von unerwarteten Alerts
	 * @SUPPORT_FINDIND_BY_CSS Ermöglicht den Einsatz von CSS-Selektoren
	 * @ACCEPT_SSL_CERTS Automatische Annahme von SSL-Zertifikaten wenn "true"
	 * @return
	 */
	private DesiredCapabilities createFirefoxCapabilities() {
		final DesiredCapabilities dCaps = new DesiredCapabilities();
		dCaps.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
		dCaps.setPlatform(Platform.getCurrent());
        dCaps.setCapability(FirefoxDriver.PROFILE, createFirefoxProfile());
        dCaps.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
        dCaps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "IGNORE");
        dCaps.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
        dCaps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return dCaps;
	}
	
	private FirefoxProfile createFirefoxProfile() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", false);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);
        return profile;
    }
	
}
