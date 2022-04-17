package com.automation.pageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.main.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	By shopButton=By.linkText("Shop");
	By myAccountButton=By.linkText("My Account");
	By homeButton=By.linkText("Home");
	By slider=By.xpath("//div[@class='n2-ss-slide-background']/img");
	By newArrivals=By.xpath("//div[@class='woocommerce']//img");
	
	public RegistrationOrLoginPage clickMyAccount()
	{
		getElement(myAccountButton).click();
		return getInstance(RegistrationOrLoginPage.class);
	}
	public ShopePage clickShop()
	{
		getElement(shopButton).click();
		return getInstance(ShopePage.class);
		
	}
	public void sliders()
	{
		int numberOfSliders=getElements(slider).size();
		System.out.println("Number Of Sliders :"+numberOfSliders);
		Assert.assertEquals(numberOfSliders, 3);
	}

	public void arrivals()
	{
		int numberOfNewArrivals=getElements(newArrivals).size();
		System.out.println("Number Of New Arrivals :"+numberOfNewArrivals);
		Assert.assertEquals(numberOfNewArrivals, 3);
	}
	public ProductPage arrivalNavigation()
	{
		arrivals();
		List<WebElement> list=getElements(newArrivals);
		Object url_1=driver.getCurrentUrl();
	//	list.stream().forEach(x-> x.getAttribute("title").contains("Mastering JavaScript"));
		
		for(WebElement e:list)
		{
			if(e.getAttribute("title").contains("Mastering JavaScript"))
				e.click();
		}
		Object url_2=driver.getCurrentUrl();
		Assert.assertNotEquals(url_1, url_2);
		System.out.println("the image is successfully navigating to next page");
		
		return getInstance(ProductPage.class);
	}
	
}
