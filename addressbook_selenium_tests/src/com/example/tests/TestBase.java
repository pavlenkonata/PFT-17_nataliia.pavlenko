package com.example.tests;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
 
public class TestBase {

	protected static ApplicationManager app;
	private int checkCounter;
	private int checkFrequency;
	

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
		//checkCounter = 0;
		//checkFrequency = Integer.parseInt(properties.getProperty("check.frequency", "0"));
	  }
	
	protected boolean wantToCheck(){
		checkCounter++;
		if(checkCounter > checkFrequency){
			checkCounter = 0;
			return true;
		} else {
			return false;
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }
	
	
	@DataProvider
	 public Iterator<Object[]> randomValidGroupGenerator() {
	 List<Object[]> list = new ArrayList<Object[]>();
	 	
	 for (int i=0; i<5; i++){
	 GroupData group = new GroupData(generateRandomString("groupname"), generateRandomString("groupheader"), generateRandomString("groupfooter"));
	 		list.add(new Object[]{group});
	 	}
	 	return list.iterator();
	 } 
	 
	 public String generateRandomString(String input) {
		 		Random rnd = new Random();
		 		if (rnd.nextInt(3) == 0){
		 			return "";
		 		} else {
		 			return input + rnd.nextInt(); 
		 		}
		 		
		 	}
	 
	 @DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
	 	
	 		for (int i=0; i<5; i++){
	 			ContactData contact = new ContactData()
	 					.withFirstname(generateRandomString("firstname"))
	 					.withLastname(generateRandomString("lastname"))  
	 					.withAddress(generateRandomString("address"))  
	 					.withHomephone(generateRandomString("homephone") ) 
	 					.withMobilephone(generateRandomString("mobilephone"))
	 					.withWorkphone(generateRandomString("workphone")) 
	 					.withEmail(generateRandomString("email")) 
	 					.withEmail2(generateRandomString("email2")) 
	 					.withBday(generateRandomRange(1,31)) 
	 					.withBmonth("-") 
	 					.withByear(generateRandomRange(0,9999)) 
	 					.withChoosengroup("[none]") 
	 					.withAddress2(generateRandomString("address2")) 
	 					.withHomephone2(generateRandomString("homephone2"));
	 			
	 			/*contact.firstname = generateRandomString("firstname");
	 			contact.lastname = generateRandomString("lastname");
	 			contact.address = generateRandomString("address");
	 			contact.homephone = generateRandomString("homephone");
	 			contact.mobilephone = generateRandomString("mobilephone");
	 			contact.workphone = generateRandomString("workphone");
	 			contact.email = generateRandomString("email");
	 			contact.email2 = generateRandomString("email2");
				contact.bday = generateRandomRange(1,31);
	 			contact.bmonth = "-";
				contact.byear = generateRandomRange(0,9999);
				contact.choosengroup = "[none]";
	 			contact.address2 = generateRandomString("address2");
	 			contact.homephone2 = generateRandomString("homephone2");*/
	 			
	 			list.add(new Object[]{contact});
	 		}
	 		return list.iterator();
	 	}
	
	public String generateRandomRange(int start, int end) {
		 		Random rnd = new Random();
		 		if (rnd.nextInt(4) == 0){
		 			return "-";
		 		} else {
		 			return "" + (rnd.nextInt(end-start) + start);
		 		}
		 		
		 	}

	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for(GroupData group:groups){
			list.add(new Object[]{group});
		}
		return list;
	}


	public static List<Object[]> wrapContactsToDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact:contacts){
			list.add(new Object[]{contact});
		}
		return list; 
	}

}

