package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

  
	
  @Test (dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    
    //action
    app.getGroupHelper().initGroupCreation();
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupForm();
    app.getGroupHelper().returntoGroupPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    //compare states
    
    oldList.add(group);
   // System.out.println(oldList);
   Collections.sort(oldList);
   //System.out.println(oldList);
    assertEquals(newList, oldList);
  }
  

}
