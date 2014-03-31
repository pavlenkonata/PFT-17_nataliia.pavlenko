package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.MODIFICATION;;

public class ContactModificationTests extends TestBase {

		@Test (dataProvider = "randomValidContactGenerator")
		public void  modifySomeContact(ContactData contact) {
			
			//save new state
			SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
			
		    Random rnd = new Random();
		    int index = rnd.nextInt(oldList.size()-1);	
			
			//actions
		    app.getContactHelper().modifyContact(index, contact, MODIFICATION);
		    
		    //save old state
		    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		    
		    //compare states
		    System.out.println(oldList);
		    System.out.println(newList);
		    
		    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
		}

}
