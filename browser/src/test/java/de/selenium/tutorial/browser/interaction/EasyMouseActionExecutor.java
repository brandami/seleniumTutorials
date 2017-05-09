package de.selenium.tutorial.browser.interaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EasyMouseActionExecutor {

	private Actions action;
	private String theMouseAction;

	public EasyMouseActionExecutor(WebDriver driver) {
		action = new Actions(driver);
	}

	public boolean executeMouseAction(String mouseAction, WebElement theElement) {
		boolean flag;
		theMouseAction = mouseAction.toLowerCase();
		switch (theMouseAction) {
		case "doubleclick":
			action.doubleClick(theElement).build().perform();
			flag = true;
		case "rightclick":
			action.contextClick(theElement).build().perform();
			flag = true;
		case "mouseover":
			action.moveToElement(theElement).build().perform();
		case "dragndrop":
			System.out.println("Destination element missing in method call!");
			flag = false;
		default:
			System.out.println("Command " + mouseAction + " not found!");
			flag = false;
		}
		return flag;
	}

	public boolean executeMouseAction(String mouseAction, WebElement sourceElement, WebElement destinationElement) {
		theMouseAction = mouseAction.toLowerCase();
		switch (theMouseAction) {
		case "draganddrop":
			action.dragAndDrop(sourceElement, destinationElement).build().perform();
			return true;
		default:
			return executeMouseAction(mouseAction, sourceElement);
		}
	}
}
