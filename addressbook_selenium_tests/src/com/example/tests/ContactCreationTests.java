package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;



import static com.example.fw.ContactHelper.CREATION;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;


public class ContactCreationTests extends TestBase{
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
		return wrapContactsToDataProvider(loadContactsFromXmlFile(new File ("contacts.xml"))).iterator();
	} 
 

@Test (dataProvider = "contactsFromFile")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    
    //save old state
	  SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    
    //action
    app.getContactHelper().createContact(contact, ContactHelper.CREATION);
    
    
    //save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    	//System.out.println(oldList);
		//System.out.println(newList);
    assertThat(newList, equalTo(oldList.withAdded(contact)));
    		
   
  }

}
