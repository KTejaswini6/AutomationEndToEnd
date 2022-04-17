package com.automation.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.pageObject.HomePage;
import com.automation.pageObject.RegistrationOrLoginPage;
import com.automation.utilities.DataProviderFoTesting;
@Listeners(com.automation.utilities.Listeners.class)


public class Login_Test extends BaseTest{
	
	@Test(enabled=true)
	public void loginTestWithValidCredentials()
	{
		page.getInstance(HomePage.class).clickMyAccount().doLogin_PositiveTest(userId, password);
	}

	@Test(dataProvider="DataForNegativeTesting",dataProviderClass=DataProviderFoTesting.class,enabled=true)
	public void loginTestWithInvalidCreedentials(String userName,String Password) {
		page.getInstance(HomePage.class).clickMyAccount().doLogin_NegativeTest(userName, Password);
		
	}
	@Test(enabled=true)
	public void passwordFiled_Test() {
		page.getInstance(HomePage.class).clickMyAccount().
		getInstance(RegistrationOrLoginPage.class).passwordFieldTest("sfas");
		
	}
	@Test(enabled=true)
	public void caseChange_Test()
	{
		page.getInstance(HomePage.class).clickMyAccount().
		getInstance(RegistrationOrLoginPage.class).caseChangeTest(userId, password);
				
	}
	@Test
	public void loginAuthontication()
	{
		page.getInstance(HomePage.class).clickMyAccount().
		getInstance(RegistrationOrLoginPage.class).login_Autho(userId, password);
	}
	
}
