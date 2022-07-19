package com.crm.earthwood.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener
{

	public void onTestFailure(ITestResult result) {
		String failedTestName = result.getMethod().getMethodName();
		TakesScreenshot ts= (TakesScreenshot)BaseClass.listenerDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String date = new Date().toString().replace(":","_").replace(" ","_");
		File trg = new File("./screenshot/"+failedTestName+date+".png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
