package com.automation.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.testCases.BaseTest;

public class Listeners implements ITestListener {

	BaseTest bt=new BaseTest();
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("the test is initialized"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test is successful"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

     System.out.println("test failed");
     TakesScreenshot ts=(TakesScreenshot)BaseTest.getDriver();
     File source=ts.getScreenshotAs(OutputType.FILE);
     File target=new File(System.getProperty("user.dir")+"/Screenshot/"+result.getName()+".png");
	try {
		FileUtils.copyFile(source, target);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test is skipped"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("Test failed but within success rate");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("test failed with timeout"+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("test execution is started "+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
	System.out.println("test is successfully finished"+context.getName());
	}

}
