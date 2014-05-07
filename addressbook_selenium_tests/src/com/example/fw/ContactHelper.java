package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;


	public class ContactHelper extends WebDriverHelperBase {
		
		public static boolean CREATION = true;
		public static boolean MODIFICATION = false;

		public ContactHelper(ApplicationManager manager) {
			super(manager);
		}
		
		public ContactHelper createContact(ContactData contact, boolean CREATION) {
			manager.navigateTo().mainPage();
		    gotoNewContact();
			fillContactForm(contact, ContactHelper.CREATION);
			submitContactForm();
		    returnHomePage();
		    return this;
		}
		

		public ContactHelper deleteContact(int index) {
			openContactByIndex(index);
			submitContactDelition();
			returnHomePage();
		    return this;
		}
		
		public ContactHelper modifyContact(int index, ContactData contact,boolean MODIFICATION) {
			manager.navigateTo().mainPage();
			openContactByIndex(index);
			fillContactForm(contact, MODIFICATION);
			submitContactModification();
		    returnHomePage();
		    return this;
		}
		
	//------------------------------------------------------------------------------------	

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHomephone());
		type(By.name("mobile"), contact.getMobilephone());
		type(By.name("work"), contact.getWorkphone());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getEmail2());
		type(By.name("mobile"), contact.getMobilephone()); 
	    selectByText(By.name("bday"), contact.getBday()); 
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"), contact.getByear());
	    if(formType == CREATION){
	    	
	    } else {
	    	if (driver.findElements(By.name("new_groups")).size() != 0){
	    		throw new Error ("Error");
	    	}
	    }
	    //selectByText(By.name("new_group"), contact.choosengroup);
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getHomephone2());
	    return this;
	}

	


	public ContactHelper submitContactForm() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper gotoNewContact() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper returnHomePage() {
		click(By.linkText("home page"));
		return this;
	}


	
	public ContactHelper openContactByIndex(int index) {
		click(By.xpath("//*/tr["+ (index + 2) +"]/td[7]/a"));
		return this;
	}
	

	public ContactHelper submitContactDelition() {
		click(By.xpath("//*/input[@value = \"Delete\"]"));
		return this;
		
	}

	

	public ContactHelper submitContactModification() {
		click(By.xpath("//*/input[@value=\"Update\"]"));
		return this;
		
	}

	/*private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if(cachedContacts == null){
			rebuildCache();
		}
		return cachedContacts;
	}*/
	
	
	/*private void rebuildCache() {
		
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> rowsFirstname = driver.findElements(By.xpath("//td[3]")); // bug. firstname -> lastname. correct "//td[2]"
		List<WebElement> rowsLastname = driver.findElements(By.xpath("//td[2]"));
		rowsFirstname.remove(rowsFirstname.size()-1);
		rowsLastname.remove(rowsLastname.size()-1);
		for (int i=0; i<rowsFirstname.size(); i++) {
			String firstname = rowsFirstname.get(i).getText();
			String lastname = rowsLastname.get(i).getText();
			//title.substring("Select (".length(), title.length() - ")".length());
			//contact.firstname = title.substring(title.indexOf("(")+1, title.indexOf(")"));
			cachedContacts.add(new ContactData().withFirstname(firstname).withLastname(lastname));
		}
	}*/
	
		public  SortedListOf<ContactData> getUiContacts(){
		
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> rowsFirstname = driver.findElements(By.xpath("//td[3]")); // bug. firstname -> lastname. correct "//td[2]"
		List<WebElement> rowsLastname = driver.findElements(By.xpath("//td[2]"));
		rowsFirstname.remove(rowsFirstname.size()-1);
		rowsLastname.remove(rowsLastname.size()-1);
		for (int i=0; i<rowsFirstname.size(); i++) {
			String firstname = rowsFirstname.get(i).getText();
			String lastname = rowsLastname.get(i).getText();
			//title.substring("Select (".length(), title.length() - ")".length());
			//contact.firstname = title.substring(title.indexOf("(")+1, title.indexOf(")"));
			contacts.add(new ContactData().withFirstname(firstname).withLastname(lastname));
		}
		return contacts;
	}
	

		
}
