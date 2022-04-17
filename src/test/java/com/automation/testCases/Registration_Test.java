package com.automation.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.pageObject.HomePage;
import com.automation.pageObject.RegistrationOrLoginPage;
@Listeners(com.automation.utilities.Listeners.class)

public class Registration_Test extends BaseTest {
	
	@Test(priority=1)
	public void regTest_validCredentials()
	{
		RegistrationOrLoginPage register=page.getInstance(HomePage.class).clickMyAccount();
		register.doRegistration(userId, password);
		
	}
	@Test(priority=2)
	public void regTest_invalid_emailId()
	{
		RegistrationOrLoginPage register=page.getInstance(HomePage.class).clickMyAccount();
		register.doRegistration("sjcbsdijcb", password);
		
	}
}
