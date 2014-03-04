package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
 
  @Test
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    gotoNewContact();
    ContactData contact = new ContactData();
    contact.firstname = "First_Name";
	contact.lastname = "Last_Name";
	contact.address = "Name Surname\n01234 City\n12 Some.str\nCOUNTRY";
	contact.homephone = "(044)123-45-67";
	contact.mobilephone = "+3-8-010-123-45-67";
	contact.workphone = "044-1234567";
	contact.email = "email1@adress.com";
	contact.email2 = "email2@address.com";
	contact.bday = "29";
	contact.bmonth = "September";
	contact.byear = "2001";
	contact.choosengroup = "group1";
	contact.address2 = "Name Surname\n01234 City\n12 Some.str\nCOUNTRY2";
	contact.homephone2 = "http://site.com";
	fillContactForm(contact);
    returnHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
    openMainPage();
    gotoNewContact();
    ContactData contact = new ContactData();
    contact.firstname = "";
	contact.lastname = "";
	contact.address = "";
	contact.homephone = "";
	contact.mobilephone = "";
	contact.workphone = "";
	contact.email = "";
	contact.email2 = "";
	contact.bday = "-";
	contact.bmonth = "-";
	contact.byear = "";
	contact.choosengroup = "[none]";
	contact.address2 = "";
	contact.homephone2 = "";
	fillContactForm(contact);
    returnHomePage();
  }


}
