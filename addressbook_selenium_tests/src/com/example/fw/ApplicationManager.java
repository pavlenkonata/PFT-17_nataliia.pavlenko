package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	
	public ApplicationManager() {
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8888/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	}
	
	public void stop() {
		driver.quit();
		
	}
	
	public NavigationHelper getNavigationHelper() {
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





















