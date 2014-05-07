 package com.example.tests;

 import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@Test (dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
	    
	 // save old state
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		SortedListOf<GroupData> oldList = new  SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //action
	    app.getGroupHelper().modifyGroup(index, group);
	    
	  //save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	    
	    
	   /* @Test (dataProvider = "randomValidGroupGenerator")
	    public void modifySomeGroup(GroupData group) {
	    	
	    	SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
	    	
	     		app.getNavigationHelper().openMainPage();
	     	    app.getNavigationHelper().gotoGroupPage();
	     	    app.getGroupHelper().initGroupModification(0);
	  			GroupData group = new GroupData();
	   			group.name = "new name";
	    
	  //save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));*/
	    
}
}
