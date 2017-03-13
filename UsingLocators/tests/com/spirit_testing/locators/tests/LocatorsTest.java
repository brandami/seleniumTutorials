package com.spirit_testing.locators.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.spirit_testing.locators.HomePage;
import com.spirit_testing.locators.KontaktPage;

public class LocatorsTest {

	@Test
	public void test() {
		HomePage hp = new HomePage();
		
		KontaktPage kp = hp.openContactPage();
		kp.fillInVorname("Pawel");
		kp.fillInNachname("Albrant");
		kp.fillInEmailAddress("pawel.albrant@spirit-testing.com");
		kp.fillInMailBody("ein einfacher Text zum Testen der Kontaktseite");
		kp = kp.sendForm();		
		
		assertEquals("wurde nicht erfolgreich abgesendet",kp.getSuccessMessage(),"Vielen Dank, wir haben Ihre Nachricht erhalten und werden uns umgehend bei Ihnen melden.");
	}

}
