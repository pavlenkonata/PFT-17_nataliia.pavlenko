package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

		@Test (dataProvider = "randomValidContactGenerator")
		public void  modifySomeContact(ContactData contact) {
			app.getNavigationHelper().openMainPage();
			
			//save new state
			List<ContactData> oldList = app.getContactHelper().getContacts();
			
		    Random rnd = new Random();
		    int index = rnd.nextInt(oldList.size()-1);	
			
			//actions
			app.getContactHelper().openContactByIndex(index);
			app.getContactHelper().fillContactForm(contact);
			app.getContactHelper().submitContactModificatin();
		    app.getContactHelper().returnHomePage();
		    
		    //save old state
		    List<ContactData> newList = app.getContactHelper().getContacts();
		    
		    //compare states
		    oldList.remove(index);
		    oldList.add(contact);
		    	System.out.println(oldList);
		    Collections.sort(oldList);
		    Collections.sort(newList);
		    	System.out.println(oldList);
		    	System.out.println(newList);
		    assertEquals(oldList, newList);
		    	//System.out.println(newList);
		}

}
