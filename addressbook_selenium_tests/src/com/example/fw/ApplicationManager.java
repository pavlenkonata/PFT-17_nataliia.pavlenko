package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class ApplicationManager {
	
	private WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private ApplicationModel model;
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
		model = new ApplicationModel();
	}
	
	public void stop() {
		driver.quit();
		
	}
	
	public ApplicationModel getModel (){
		return model;
	}
	
	public NavigationHelper navigateTo() {
		if (navigationHelper == null){
			navigationHelper = new NavigationHelper (this);
		}
		return navigationHelper;
	}
		
	public GroupHelper getGroupHelper() {
		if (groupHelper == null){
			groupHelper = new GroupHelper (this);
		}
		return groupHelper;
	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null){
			contactHelper = new ContactHelper (this);
		}
		return contactHelper;
	}
	
	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public WebDriver getDriver() {
		String browser = properties.getProperty("browser");
		if (driver == null){
		if("firefox".equals(browser)){
			driver = new FirefoxDriver();
		} else if ("chrome".equals(browser)){
			System.setProperty("webdriver.chrome.driver","/Users/nataliiapavlenko/Documents/Java_dev/PFT-17_nataliia.pavlenko.addressbook_selenium_tests/chromedriver");
			driver = new ChromeDriver();
		} else {
			throw new Error ("Unsupported browser" + browser);
		}
	    baseUrl = properties.getProperty("baseUrl");
	   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
		}
		return driver;
	}

	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null){
			hibernateHelper = new HibernateHelper (this);
		}
		return hibernateHelper;
	}

	public String getProperty(String key) {
		return properties.getProperty(key); 
	}

	
}
