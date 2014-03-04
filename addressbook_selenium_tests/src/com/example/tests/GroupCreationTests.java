package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group1";
    group.header = "header1";
    group.footer = "footer1";
	fillGroupForm(group);
    returntoGroupPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    returntoGroupPage();
  }
}
