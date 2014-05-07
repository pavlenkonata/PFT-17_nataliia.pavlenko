package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;


public class ContactCreationTests extends TestBase{
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
		return wrapContactsToDataProvider(loadContactsFromXmlFile(new File ("contacts.xml"))).iterator();
	} 
 

@Test (dataProvider = "contactsFromFile")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    
    //save old state
	  SortedListOf<ContactData> oldList = new  SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
    
    //action
    app.getContactHelper().createContact(contact, ContactHelper.CREATION);
    
    
    //save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getUiContacts();
    
    //compare states
    	//System.out.println(oldList);
		//System.out.println(newList);
    assertThat(newList, equalTo(oldList.withAdded(contact)));
    
  //compare UI and DB lists
    assertThat(app.getContactHelper().getUiContacts(), equalTo(app.getHibernateHelper().listContacts()));
    		
   
  }

}
