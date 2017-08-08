package de.selenium.tutorial.browser.pagepattern;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {
	protected WebDriver driver;
	public final String URL = "file:///E:/HTML%20test%20app/forms.html";
	public final String TITLE= "Forms";

	public FormsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	// ================================================
	// Page-Title
	// ================================================
	public String title = driver.getTitle();
	// ================================================
	// Anrede
	// ================================================
	// einfach HTML-Selektoren
	@FindBy(id = "anrede")
	public WebElement anredeId;

	@FindBy(className = ".select.anrede")
	public WebElement anredeClass;

	@FindBy(name = "anrede")
	public WebElement anredeName;

	// xPath
	@FindBy(xpath = "/html/body/div/main/form/div[1]/div[1]/div[1]/div[2]/select")
	public WebElement anredeFullXPath;

	@FindBy(xpath = "//select[@id='anrede']")
	public WebElement anredeXPath;

	@FindBy(xpath = "//*[@id='anrede']")
	public WebElement anredeShortXPath;

	// css-Selektoren
	@FindBy(css = "select[id='anrede']")
	public WebElement anredeCss1;

	@FindBy(css = "select#anrede")
	public WebElement anredeCss2;

	// ================================================
	// Vorname
	// ================================================
	// einfach HTML-Selektoren
	@FindBy(id = "vorname")
	public WebElement vornameId;

	@FindBy(className = ".input.vorname")
	public WebElement vornameClass;

	@FindBy(name = "vorname")
	public WebElement vornameName;

	// ================================================
	// Nachname
	// ================================================
	// einfach HTML-Selektoren
	@FindBy(id = "nachname")
	public WebElement nachnameId;

	// ================================================
	// E-Mailadresse
	// ================================================
	// einfach HTML-Selektoren
	@FindBy(id = "email")
	public WebElement emailId;

	// ================================================
	// Passwort
	// ================================================
	// einfach HTML-Selektoren
	@FindBy(id = "password1")
	public WebElement password1Id;

	// ================================================
	// wiederholen
	// ================================================
	// einfach HTML-Selektoren
	@FindBy(id = "password2")
	public WebElement password2Id;

	// ================================================
	// radio-List
	// ================================================
	@FindBy(css = "input[type='radio']")
	public List<WebElement> radioList;

	// ================================================
	// submit-Button
	// ================================================
	@FindBy(css = "input[type='submit']")
	public WebElement submit;

	public void sendKeysToInput(WebElement element, String keys) {
		element.clear();
		element.click();
		element.sendKeys(keys);
	}
}



