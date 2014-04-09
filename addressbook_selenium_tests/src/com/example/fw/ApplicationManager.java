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
	
	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
		String browser = properties.getProperty("browser");
		if("firefox".equals(browser)){
			driver = new FirefoxDriver();
		} else if ("safari".equals(browser)){
			driver = new SafariDriver();
		} else {
			throw new Error ("Unsupported browser" + browser);
		}
	    baseUrl = properties.getProperty("baseUrl");
	   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	    
	}
	
	public void stop() {
		driver.quit();
		
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

	

	
}
