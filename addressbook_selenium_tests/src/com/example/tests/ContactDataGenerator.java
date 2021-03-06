package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {


		public static void main(String[] args) throws IOException {
			if(args.length < 3){
				System.out.println("Please, specify parametrs: <amount of test data> <file> <format>");;
				return;
			}
			int amount = Integer.parseInt(args[0]);
			File file = new File (args[1]); 
			String format = args[2];
			
			if(file.exists()){
				System.out.println("File exists, please remove it manually: " + file);
				return;
			}
			
			List<ContactData> contacts = generateRandomContacts(amount);
			if("csv".equals(format)){
				saveContactsToCsvFile(contacts, file);
			} else if ("xml".equals(format)){
				saveContactsToXmlFile(contacts, file);
			} else {
				System.out.println("Unknown format "+ format);
			}
		}

		private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException{
			XStream xstream = new XStream();
			xstream.alias("contact", ContactData.class);
			String xml = xstream.toXML(contacts);
			FileWriter writer = new FileWriter (file);
			writer.write(xml);
			writer.close();
		}
		
		public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException{
			XStream xstream = new XStream();
			xstream.alias("contact", ContactData.class);
			return (List<ContactData>) xstream.fromXML(file);
		}

		private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException  {
			FileWriter writer = new FileWriter(file);
			for (ContactData contact:contacts){
				writer.write(contact.getFirstname() + "," + contact.getLastname()+ "," + contact.getAddress() + ",!" + "\n");
			}
			writer.close();
			
		}

		public static List<ContactData> generateRandomContacts(int amount) {
			List<ContactData> list = new ArrayList<ContactData>();
			
			for (int i=0; i<amount; i++){
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
				
				list.add(contact);
			}
			return list;
		}

		public static String generateRandomString(String input) {
			Random rnd = new Random();
			if (rnd.nextInt(3) == 0){
				return "";
			} else {
				return input + rnd.nextInt(); 
			}
			
		}
		
		//random byear, random bday
		public static String generateRandomRange(int start, int end) {
			Random rnd = new Random();
			if (rnd.nextInt(4) == 0){
				return "-";
			} else {
				return "" + (rnd.nextInt(end-start) + start);
			}

		}
}


