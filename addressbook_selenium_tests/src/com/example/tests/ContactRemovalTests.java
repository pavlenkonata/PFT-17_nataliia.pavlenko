package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void  deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
		
		//actions
		app.getContactHelper().openContactByIndex(index);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnHomePage();
		
		//save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
		
		//compare states
		oldList.remove(index);
				//System.out.println(oldList);
		Collections.sort(oldList);
				//System.out.println(oldList);
	    assertEquals(newList, oldList);
	    		//System.out.println(oldList);
	}
	
	//@Test
	public void  deleteAllContacts() {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		int toDelete = oldList.size();
		for (int i = 0; i < toDelete; i++){
			//actions
			app.getContactHelper().openContactByIndex(0);
			app.getContactHelper().deleteContact();
			app.getContactHelper().returnHomePage();			
		}


		//save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
	    assertEquals(newList.size(), 0);
	    		//System.out.println(oldList);
	}
}
