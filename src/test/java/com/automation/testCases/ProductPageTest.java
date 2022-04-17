package com.automation.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.pageObject.HomePage;
@Listeners(com.automation.utilities.Listeners.class)

public class ProductPageTest extends BaseTest{

	@Test
	public void descriptionTest()
	{
		page.getInstance(HomePage.class).arrivalNavigation().description();
	}
	@Test(enabled=false)
	public void reviewTest()
	{
		page.getInstance(HomePage.class).arrivalNavigation().reviews();
	}
	@Test(enabled=false)
	public void addToCartTest()
	{
		page.getInstance(HomePage.class).arrivalNavigation().addToBasket();
	}
}
