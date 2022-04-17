package com.automation.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.pageObject.HomePage;
@Listeners(com.automation.utilities.Listeners.class)
public class HomePage_Test extends BaseTest{
	
	@Test
	public void slider_Test()
	{
		page.getInstance(HomePage.class).sliders();
	}

	@Test()
	public void arrivals_Test()
	{
		page.getInstance(HomePage.class).arrivals();
	}
	@Test 
	public void arrivalNavigationTest()
	{
		page.getInstance(HomePage.class).arrivalNavigation();
	}
	
}
