package com.example.fw;

public class ContactHelper extends HelperBase {

	
	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
			fillContactForm(contact);
			confirmContactCreation();
		
	}

	private void confirmContactCreation() {
		manager.getAutoItHelper()
		.click("Save") 
		.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
		.send("TDBEdit12", contact.firstname)
		.send("TDBEdit11", contact.lastname);
	}

	private void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("Add").winWaitAndActivate("Add Contact", "", 5000);
	}

	public Contact getFirstContact() {
		selectFirstContact();
		manager.getAutoItHelper()
		.click("Edit")
		.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
		.setFirstname(manager.getAutoItHelper().getText("TDBEdit12"))
		.setLastname(manager.getAutoItHelper().getText("TDBEdit11"));
		return contact;
		
	}

	public void selectFirstContact() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("TListView1")
		.send("{DOWN}{SPACE}");
	}
	
	public void deleteFirstContact() {
		manager.getAutoItHelper()
		.click("Delete")
		.winWaitAndActivate("Confirm", "", 5000)
		.click("TButton2");
	}
}
