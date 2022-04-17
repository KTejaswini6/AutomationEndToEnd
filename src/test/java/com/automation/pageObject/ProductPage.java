package com.automation.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.main.BasePage;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By description=By.xpath("//a[contains(text(),'Description')]");
	By des_paragraph= By.xpath("//div[@id='tab-description']/div/div/div/p");
	By reviews=By.xpath("//a[contains(text(),'Reviews (0)')]");
	By rev_paragraph=By.xpath("//div[@id='reviews']/div/p");
	By addToBasket=By.xpath("//button[contains(text(),'Add to basket')]");
	By add_message=By.cssSelector(".woocommerce-message");
	public void description()
	{
		boolean flag=getElement(description).isSelected();
		System.out.println(flag);
		if(!flag)
		{
			getElement(description).click();
			System.out.println(getElement(des_paragraph).getTagName());
			Assert.assertEquals(getElement(des_paragraph).getTagName(),"q");
		}
	}

	public void reviews()
	{
		boolean flag=getElement(reviews).isSelected();
		if(flag)
		{
			getElement(reviews).click();
			System.out.println(getElement(rev_paragraph).getTagName());
			Assert.assertEquals(getElement(rev_paragraph).getTagName(),"q");
		}
	}
	public void addToBasket()
	{
		getElement(addToBasket).click();
		String message=getElement(add_message).getText().split("\n")[1].trim();
		System.out.println(message);
		Assert.assertEquals(message, "“Mastering JavaScript” has been added to your basket.");
	}
}
