package com.automation.testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.main.BasePage;
import com.automation.main.Page;
import com.automation.utilities.ReadConfiguration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	//WebDriver driver;
	public Page page;
	public ReadConfiguration rc=new ReadConfiguration();
	String browserName=rc.getBrowserName();
	String url=rc.getURL();
	String userId=rc.getUserId();
	String password=rc.getPassword();
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	@BeforeMethod
	public void initialization()
	{
		if(browserName.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver()) ;
		}
		else if(browserName.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());;
		}
		else if(browserName.contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());;
		}
		page=new BasePage(getDriver());
		getDriver().get(url);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@AfterMethod
	public void tearDown()
	{
		getDriver().close();
	}
}
