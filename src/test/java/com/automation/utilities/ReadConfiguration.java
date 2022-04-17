package com.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration {
	
	Properties prop;
	
	public ReadConfiguration()
	{
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+
					"/Configuration/Config.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public String getBrowserName()
	{
		return prop.getProperty("browser");
		
	}
	public String getURL()
	{
		return prop.getProperty("url");
		
	}
	public String getUserId()
	{
		return prop.getProperty("userName");
	}

	public String getPassword()
	{
		return prop.getProperty("password");
	}
}
