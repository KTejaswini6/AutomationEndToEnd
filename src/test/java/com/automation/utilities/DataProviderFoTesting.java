package com.automation.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderFoTesting {
	
	@DataProvider(name="DataForNegativeTesting")
	public Object[][] dataForNegativeTesting()
	{
		Object[][] data={{"asda@asf","dsd"},{"pink.monk@gamil.com",""},{"","dsd23rDA"},{"",""}};
		
		return data;
	}
	
	
}
