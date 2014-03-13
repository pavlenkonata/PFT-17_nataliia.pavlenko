package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group1";
    group.header = "header1";
    group.footer = "footer1";
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupForm();
    app.getGroupHelper().returntoGroupPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
    app.getGroupHelper().submitGroupForm();
    app.getGroupHelper().returntoGroupPage();
  }
}
