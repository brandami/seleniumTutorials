package com.spirit_testing.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KontaktPage {

	@FindBy(css = "#edit-submitted-vorname")
	private WebElement vname;
	
	@FindBy(css = "#edit-submitted-nachname")
	private WebElement nname;
	
	@FindBy(xpath = "//label[contains(.,'E-Mail: ')]/../input")
	private WebElement email;
	
	@FindBy(id = "edit-submitted-darum-geht-es")
	private WebElement textField;
	
	@FindBy(id = "edit-submitted-darum-geht-es")
	private WebElement sendButton;

	@FindBy(xpath = "//*[@id=\"content-content\"]/div[1]/p")
	private WebElement successMessage;
	
	public void fillInVorname(String vorname){
		vname.click();
		vname.clear();
		vname.sendKeys(vorname);
	}
	
	public void fillInNachname(String nachname){
		nname.click();
		nname.clear();
		nname.sendKeys(nachname);
	}
	
	public void fillInEmailAddress(String email){
		this.email.click();
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void fillInMailBody(String text) {
		textField.click();
		textField.clear();
		textField.sendKeys(text);
	}
	
	public KontaktPage sendForm(){
		sendButton.click();
		return new KontaktPage();
	}
	
	public String getSuccessMessage(){
		return successMessage.getText();
	}
}
