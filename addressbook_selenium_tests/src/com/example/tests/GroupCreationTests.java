package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;



public class GroupCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException{
	return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File ("groups.xml"))).iterator();
} 
 

	@Test (dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
    
    // save old state
		//SortedListOf<GroupData> oldList = app.getModel().getGroups();
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		SortedListOf<GroupData> oldList = new  SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		//assertThat(oldList, equalTo(oldListDB));
		//System.out.println(oldList);
		//System.out.println(oldListDB);
    
    //action
    app.getGroupHelper().createGroup(group);
    
    //save new state
    //SortedListOf<GroupData> newList = app.getModel().getGroups();
    SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
    
    //compare states
   assertThat(newList, equalTo(oldList.withAdded(group)));
   //compare UI and DB lists
   assertThat(app.getGroupHelper().getUiGroups(), equalTo(app.getHibernateHelper().listGroups()));
   
  
  /* if (wantToCheck()){
   	if("yes".equals(app.getProperty("check.db"))){
   assertThat (app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
   	}
   	
   	if("yes".equals(app.getProperty("check.ui"))){
   assertThat (app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
   	}
   }*/
	}
}
