package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
	    
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //action
		app.getGroupHelper().deleteGroup(index);
	    app.getGroupHelper().returntoGroupPage();
	    
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    //compare states
	    
	    oldList.remove(index);
	   // System.out.println(oldList);
	   Collections.sort(oldList);
	   //System.out.println(oldList);
	    assertEquals(newList, oldList);
}
	@Test
	public void deleteFewGroups() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
	    
	    //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    //create test groups
	    for (int i=1; i<3; i++) {
	    	app.getGroupHelper().initGroupCreation();
	    	GroupData group = new GroupData();
	    	group.name = "group1";
	    	group.header = "header1";
	    	group.footer = "footer1";
	    	app.getGroupHelper().fillGroupForm(group);
	    	app.getGroupHelper().submitGroupForm();
	    	app.getGroupHelper().returntoGroupPage();
	    }
	    
	  
	    
	    //action
	    	int [] groupsToDelete = {0,1};
	    	app.getGroupHelper().deleteFewGroups(groupsToDelete);
	    	 app.getGroupHelper().returntoGroupPage();
	    	
	    	 //save new state
	 	    List<GroupData> newList = app.getGroupHelper().getGroups();
	 	    
	 	    //compare states
	 	    assertEquals(newList, oldList);
	    	 
		}
	
}