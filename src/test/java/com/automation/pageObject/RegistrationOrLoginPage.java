package com.automation.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.main.BasePage;

public class RegistrationOrLoginPage extends BasePage {

	public RegistrationOrLoginPage(WebDriver driver) {
		super(driver);
		
	}

	By Login=By.xpath("//h2[contains(text(),'Login')]/parent::div");
	By register=By.xpath("//h2[contains(text(),'Register')]/parent::div");
	By email=By.id("reg_email");
	By password=By.id("reg_password");
	By alert=By.xpath("//div[contains(text(),'Strong')]");
	By registerButton=By.cssSelector("input[name='register']");

//For Login
	By login_email=By.id("username");
	By login_pwd=By.id("password");
	By loginButton=By.cssSelector("input[name='login']");
	By signoutbtn=By.linkText("Sign out");
	By errorMessage=By.xpath("//strong/parent::li");
	By loginTitle=By.xpath("//h2[contains(text(),'Login')]");

	public MyAccountPage doRegistration(String emailId,String pwd)
	{
		getElement(email).sendKeys(emailId);
		getElement(password).sendKeys(pwd);
		String text=getElement(alert).getText();
		if(text.contains("Strong"))
		{
		getElement(registerButton).click();
		Assert.assertEquals(getElement(signoutbtn).getText(), "Sign out");
		}
		else
		{
			System.out.println("Please enter a strong password");
		}
		return new MyAccountPage(driver);
	}
	public MyAccountPage doRegistration(String text)
	{
		getElement(email).sendKeys(text);
		getElement(password).sendKeys(text);
		
		return new MyAccountPage(driver);
	}
	public MyAccountPage doLogin_PositiveTest(String emailId,String pwd)
	{
		getElement(login_email).sendKeys(emailId);
		getElement(login_pwd).sendKeys(pwd);
		getElement(loginButton).click();
		Assert.assertEquals(getElement(signoutbtn).getText(), "Sign out");
		return new MyAccountPage(driver);
	}
	public void doLogin_NegativeTest(String emailId,String pwd)
	{
		getElement(login_email).sendKeys(emailId);
		getElement(login_pwd).sendKeys(pwd);
		getElement(loginButton).click();
		String errorMessage="getElement(errorMessage).getText()";
		
		switch(errorMessage)
		{
		case "ERROR: Invalid username. Lost your password?":
			Assert.assertEquals(errorMessage, "ERROR: Invalid username. Lost your password?");
		break;
		case "Error: Password is required.":
			Assert.assertEquals(errorMessage, "Error: Password is required.");
		break;
		case "Error: Username is required.":
			Assert.assertEquals(errorMessage, "Error: Username is required.");
		break;
		}
		
	}
	public void passwordFieldTest(String pwd)
	{
		getElement(login_pwd).sendKeys(pwd);
		String type=getElement(login_pwd).getAttribute("type");
		System.out.println(type);
		Assert.assertEquals(type, "password");
	}
	public void caseChangeTest(String userName,String password)
	{
		getElement(login_email).sendKeys(Keys.SHIFT,userName);
		getElement(login_pwd).sendKeys(Keys.SHIFT,password);
		getElement(loginButton).click();
		String error=getElement(errorMessage).getText();
		Assert.assertEquals(error, "ERROR: Invalid username. Lost your password?");
				
	}
	public void login_Autho(String emailId,String pwd)
	{
		getElement(login_email).sendKeys(emailId);
		getElement(login_pwd).sendKeys(pwd);
		getElement(loginButton).click();
		getElement(signoutbtn).click();
		driver.navigate().back();
		boolean flag=getElement(loginTitle).isDisplayed();
		System.out.println(flag);
		Assert.assertTrue(flag);
	//	Assert.assertEquals(getElement(errorMessage).getText(), "ERROR: Invalid username. Lost your password?");
		
	}
}
