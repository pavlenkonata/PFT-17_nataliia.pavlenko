package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

		@Test
		public void  ModifySomeContact() {
			app.getNavigationHelper().openMainPage();
			app.getContactHelper().openContactByIndex(2);
			ContactData contact = new ContactData();
			contact.lastname = "new_Last_Name";
			contact.bmonth = "May";
			app.getContactHelper().fillContactForm(contact);
			app.getContactHelper().submitContactModificatin();
		    app.getContactHelper().returnHomePage();
	
		}

}
