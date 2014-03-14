package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().deleteGroup(1);
	    app.getGroupHelper().returntoGroupPage();
}
	@Test
	public void deleteFewGroups() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
	    int [] groupsToDelete = {1,3,5};
		app.getGroupHelper().deleteFewGroups(groupsToDelete);
	    app.getGroupHelper().returntoGroupPage();
}
	
}