package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase{
 
  @Test (dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    app.getNavigationHelper().openMainPage();
   
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //action
    app.getContactHelper().gotoNewContact();
	app.getContactHelper().fillContactForm( contact);
	app.getContactHelper().submitContactForm();
    app.getContactHelper().returnHomePage();
    
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    oldList.add(contact);
    		//System.out.println(oldList);
    Collections.sort(oldList);
    Collections.sort(newList);
    		//System.out.println(oldList);
    		//System.out.println(newList);
    assertEquals(newList, oldList);
   
  }

}
