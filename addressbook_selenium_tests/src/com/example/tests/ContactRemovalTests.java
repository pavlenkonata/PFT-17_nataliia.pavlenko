package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	//@Test
	public void  deleteSomeContact() {
		app.navigateTo().mainPage();
		
		//save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
		
		//actions
	    app.getContactHelper().deleteContact(index);
		
		
		//save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	  
		//compare states
	    assertThat(newList, equalTo(oldList.without(index)));
	    
	  System.out.println(oldList);
	    		//System.out.println(oldList);
	}
	
	@Test
	public void  deleteAllContacts() {
		
		//save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		int toDelete = oldList.size();
		for (int i = 0; i < toDelete; i++){
			//actions
			app.getContactHelper().deleteContact(0);
					
		}


		//save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		
		//compare states
		assertThat(newList.size(), equalTo(0));
	    		//System.out.println(oldList);
	}

	
}
