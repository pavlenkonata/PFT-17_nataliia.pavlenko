package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    
    //action
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group1";
    group.header = "header1";
    group.footer = "footer1";
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupForm();
    app.getGroupHelper().returntoGroupPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    //compare states
    
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
  // @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
    app.getGroupHelper().submitGroupForm();
    app.getGroupHelper().returntoGroupPage();
  }
}
