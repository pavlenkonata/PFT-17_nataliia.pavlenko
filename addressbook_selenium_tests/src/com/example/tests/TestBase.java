package com.example.tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;


public class TestBase {

	protected static ApplicationManager app;
	

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
	List<Object[]> list = new ArrayList<Object[]>();
	
	for (int i=0; i<5; i++){
		GroupData group = new GroupData()
		.withName(generateRandomString("groupname"))
		.withHeader(generateRandomString("groupheader"))
		.withFooter(generateRandomString("groupfooter"));
		list.add(new Object[]{group});
	}
	return list.iterator();
} 
	

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i=0; i<2; i++){
			ContactData contact = new ContactData()
			
			.withFirstname(generateRandomString("firstname"))
			.withLastname(generateRandomString("lastname"))
			.withAddress(generateRandomString("address"))
			.withHomephone(generateRandomString("homephone"))
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
			
			list.add(new Object[]{contact});
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
	//random byear, random bday
	public String generateRandomRange(int start, int end) {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0){
			return "-";
		} else {
			return "" + (rnd.nextInt(end-start) + start);
		}
		
	}
	
	public String chooseRandomDate(int start, int end) {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0){
			return "-";
		} else {
			return "" + (rnd.nextInt(end-start) + start);
		}
		
	}
}

