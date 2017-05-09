package de.selenium.tutorial.browser.interaction;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActionExecutor {

	private Actions action;
	private WebElement theElement;
	private String theMouseAction;

	public MouseActionExecutor(WebDriver driver) {
		action = new Actions(driver);
	}

	public boolean executeMouseAction(String mouseAction, WebElement sourceElement) {
		theElement = sourceElement;
		theMouseAction = mouseAction.toLowerCase();
		switch (theMouseAction) {
		case "doubleclick":
			return doubleClick();
		case "rightclick":
			return rightClick();
		case "mouseover":
			return moveTo();
		case "dragndrop":
			System.out.println("Destination element missing in method call!");
			return false;
		default:
			System.out.println("Command " + mouseAction + " not found!");
			return false;
		}
	}

	public boolean executeMouseAction(String mouseAction, WebElement sourceElement, WebElement destinationElement) {
		theElement = sourceElement;
		theMouseAction = mouseAction.toLowerCase();
		switch (theMouseAction) {
		case "draganddrop":
			return dragAndDrop(sourceElement, destinationElement);
		default:
			return executeMouseAction(mouseAction, sourceElement);
		}
	}

	private boolean doubleClick() {
		boolean flag = false;
		try {
			action.doubleClick(theElement);
			action.build().perform();
			System.out.println("Succesfully Double clicked the element " + theElement);
			flag = true;
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
			flag = false;
		} catch (NoSuchElementException e) {
			System.out.println("Element " + theElement + " was not found in DOM " + e.getStackTrace());
			flag = false;
		} catch (Exception e) {
			System.out.println("Element " + theElement + " was not clickable " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}

	private boolean rightClick() {
		boolean flag = false;
		try {
			action.contextClick(theElement).build().perform();
			System.out.println("Sucessfully Right clicked on the element " + theElement);
			flag = true;
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
			flag = false;
		} catch (NoSuchElementException e) {
			System.out.println("Element " + theElement + " was not found in DOM " + e.getStackTrace());
			flag = false;
		} catch (Exception e) {
			System.out.println("Element " + theElement + " was not clickable " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}

	private boolean moveTo() {
		boolean flag = false;
		try {
			action.moveToElement(theElement).build().perform();
			System.out.println("Sucessfully moved to Element" + theElement);
			flag = true;
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
			flag = false;
		} catch (NoSuchElementException e) {
			System.out.println("Element " + theElement + " was not found in DOM " + e.getStackTrace());
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}

	public boolean dragAndDrop(WebElement source, WebElement destination) {
		boolean flag = false;
		try {
			if (source.isDisplayed() && destination.isDisplayed()) {
				action.dragAndDrop(source, destination).build().perform();
				System.out.println("Sucessfully moved " + source + " to Element " + destination);
				flag = true;
			} else {
				System.out.println("Element was not displayed to drag");
				flag = false;
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + source + " or " + destination + " is not attached to the page document "
					+ e.getStackTrace());
			flag = false;
		} catch (NoSuchElementException e) {
			System.out.println("Element " + source + " or " + destination + " was not found in DOM " + e.getStackTrace());
			flag = false;
		} catch (Exception e) {
			System.out.println("Error occurred while performing drag and drop operation " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}

	/*
	 * ToDo: Hold + Release
	 */

}
