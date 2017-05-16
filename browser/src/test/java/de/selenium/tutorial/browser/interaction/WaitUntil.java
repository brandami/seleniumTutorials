package de.selenium.tutorial.browser.interaction;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntil {
	private static final long DEFAULT_WAIT = 10;
	private WebDriverWait wait;

	public WaitUntil(WebDriver driver) {
		wait = new WebDriverWait(driver, DEFAULT_WAIT);
	}

	public boolean elementIsPresent(By theElementLocator) {
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(theElementLocator));
			flag = true;

		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
			flag = false;
		} catch (NoSuchElementException e) {
			System.out.println(
					"Element with locator " + theElementLocator + " was not found in DOM " + e.getStackTrace());
			flag = false;
		} catch (Exception e) {
			System.out.println("Element with locator " + theElementLocator + " was not clickable " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}

	public boolean elementIsPresent(WebElement theElement) {
		boolean flag = false;
		Dimension theElementSize = theElement.getSize();
		try {
			if (theElementSize.width > 0 && theElementSize.height > 0) {
				System.out.println("Element is present and visible!");
				flag = true;
			} else {
				System.out.println("Element is not visible!");
				flag = true;
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
			flag = false;
		} catch (NoSuchElementException e) {
			System.out.println(
					"Element " + theElement + " was not found in DOM " + e.getStackTrace());
			flag = false;
		} catch (Exception e) {
			System.out.println("Element " + theElement + " was not clickable " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}
	
	public boolean elementClickablity(By theElementLocator) {
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(theElementLocator));
			flag = true;

		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
			flag = false;
		} catch (NoSuchElementException e) {
			System.out.println(
					"Element with locator " + theElementLocator + " was not found in DOM " + e.getStackTrace());
			flag = false;
		} catch (Exception e) {
			System.out.println("Element with locator " + theElementLocator + " was not clickable " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}
	
	public boolean elementIsVisible(By theElementLocator) {
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(theElementLocator));
			flag = true;

		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
			flag = false;
		} catch (NoSuchElementException e) {
			System.out.println(
					"Element with locator " + theElementLocator + " was not found in DOM " + e.getStackTrace());
			flag = false;
		} catch (Exception e) {
			System.out.println("Element with locator " + theElementLocator + " was not clickable " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}

	public boolean elementIsVisible(WebElement theElement) {
		boolean flag = false;
		try {
			 wait.until(ExpectedConditions.visibilityOf(theElement));
			flag = true;
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
			flag = false;
		} catch (NoSuchElementException e) {
			System.out.println(
					"Element " + theElement + " was not found in DOM " + e.getStackTrace());
			flag = false;
		} catch (Exception e) {
			System.out.println("Element " + theElement + " was not clickable " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}
	
	
}
