package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;
import com.example.tests.TestBase;


	public class ContactHelper extends HelperBase {

		public ContactHelper(ApplicationManager manager) {
			super(manager);
		}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.homephone);
		type(By.name("mobile"), contact.mobilephone);
		type(By.name("work"), contact.workphone);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		type(By.name("mobile"), contact.mobilephone);
	    selectByText(By.name("bday"), contact.bday); 
	    selectByText(By.name("bmonth"), contact.bmonth);
	    type(By.name("byear"), contact.byear);
	    //selectByText(By.name("new_group"), contact.choosengroup);
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.homephone2);
	}

	


	public void submitContactForm() {
		click(By.name("submit"));
	}

	public void gotoNewContact() {
		click(By.linkText("add new"));
	}

	public void returnHomePage() {
		click(By.linkText("home page"));
	}


	
	public void openContactByIndex(int index) {
		click(By.xpath("//*/tr["+index+"]/td[7]/a"));
	}

	public void deleteContact() {
		click(By.xpath("//*/input[@value = \"Delete\"]"));
		
	}

	public void submitContactModificatin() {
		click(By.xpath("//*/input[@value=\"Update\"]"));
		
	}

		
}
