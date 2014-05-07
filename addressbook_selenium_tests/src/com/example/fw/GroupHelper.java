package com.example.fw;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.tests.TestBase;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	/*private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null){
			rebuildCache();
		}
		return cachedGroups;
	}*/
	
	public  SortedListOf<GroupData> getUiGroups() {
		SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			//group.name = title.substring("Select (".length(), title.length() - ")".length());
			String name = title.substring(title.indexOf("(")+1, title.indexOf(")"));
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}

	
	public GroupHelper createGroup(GroupData group) {
		
    	initGroupCreation();
    	fillGroupForm(group);
    	submitGroupForm();
    	returntoGroupPage();
    	//manager.getModel().addGroup(group);
    	return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
 		returntoGroupPage();
 		//manager.getModel().removeGroup(index);
		return this;
	}

	
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
	    returntoGroupPage();
	   // manager.getModel().removeGroup(index).addGroup(group);
		return this;
	}

	
	//===================================================================================
 

	public GroupHelper initGroupCreation() {
		manager.navigateTo().groupsPage();
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper submitGroupForm() {
		click(By.name("submit"));
		return this;
	}

	public GroupHelper returntoGroupPage() {
	    click(By.linkText("group page"));
		return this;
	} 
	
	public GroupHelper deleteFewGroups(int[] index) {
		for (int i=0; i<index.length; i++){
			selectGroupByIndex(index[i]);	
		}
		submitGroupDeletion();
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update")); 
		return this;
		
	}
	private void submitGroupDeletion() {
		click(By.name("delete"));
	}
	

	
}
