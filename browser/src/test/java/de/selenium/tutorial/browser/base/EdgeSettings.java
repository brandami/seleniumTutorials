package de.selenium.tutorial.browser.base;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeSettings {
	protected DesiredCapabilities capabilities;

	public EdgeSettings() {
		capabilities = createEdgeCapabilities();
	}
	
	private DesiredCapabilities createEdgeCapabilities() {
		final DesiredCapabilities dCaps = DesiredCapabilities.edge();
		dCaps.setCapability(EdgeOptions.CAPABILITY, createEdgeOptions());
		return dCaps;
	}
	
	private EdgeOptions createEdgeOptions(){
		EdgeOptions options = new EdgeOptions();
		return options;
	}
}