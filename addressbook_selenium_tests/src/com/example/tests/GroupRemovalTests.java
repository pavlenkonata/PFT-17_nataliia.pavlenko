package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeGroup() {
	    
	    // save old state
	  SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	  Random rnd = new Random();
	  int index = rnd.nextInt(oldList.size()-1);
	    
	    //action
		app.getGroupHelper().deleteGroup(index);
	    
	    //save new state
	   SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    //compare states
	   //System.out.println(oldList);
	    
	  assertThat(newList,equalTo(oldList.without(index)));

}
	/* @Test
	public void deleteFewGroups() {
	    
	    //save old state
	    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    //create test groups
	    for (int i=1; i<3; i++) {
	    	GroupData group = new GroupData("name", "footer", "header");
	    	app.getGroupHelper().createGroup(group);
	    }
	  
	    //action
	    	int [] groupsToDelete = {0,1};
	    	app.getGroupHelper().deleteGroup(index);
	    	
	    	 //save new state
	 	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	 	    
	 	    //compare states
	 	   assertThat(newList,equalTo(oldList));
	    	 
		} */
}