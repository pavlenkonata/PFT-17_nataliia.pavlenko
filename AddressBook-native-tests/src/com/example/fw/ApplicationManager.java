package com.example.fw;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class ApplicationManager {
		
	public Properties properties;
	private ContactHelper contactHelper;
	private ProcessHelper processHelper;
	private AutoItHelper autoItHelper;  
	
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
	}
	
	public void start() throws IOException {	
		getProcessHelper().startAppUnderTest(); 
	}

	public void stop() throws IOException {	
		getProcessHelper().stopAppUnderTest();
	}

	public ProcessHelper getProcessHelper() {
		if (processHelper == null){
			processHelper = new ProcessHelper(this);
		}
		return processHelper;
	}

public ContactHelper getContactHelper() {
	if (contactHelper == null){
		contactHelper = new ContactHelper(this);
	}
	return contactHelper;
}

public AutoItHelper getAutoItHelper() {
	if (autoItHelper == null){
		autoItHelper = new AutoItHelper(this);
	}
	return autoItHelper;
}



/*public void setProperties(Properties properties) {
	this.properties = properties;	
	}
*/
	public String getProperty(String key) {
		return properties.getProperty(key);
	}








}