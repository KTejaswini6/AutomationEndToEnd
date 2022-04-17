package com.automation.main;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public Page(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver,Duration.ofSeconds(15));
	}
	
	public abstract String getPageTitle();
	public abstract WebElement getElement(By locator);
	public abstract void waitForElementPresent(By locator);
	public abstract void WaitForPageTitle(String title);
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass)
	{
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			
			e.printStackTrace();
		}
		return null ;
		
	}

}
