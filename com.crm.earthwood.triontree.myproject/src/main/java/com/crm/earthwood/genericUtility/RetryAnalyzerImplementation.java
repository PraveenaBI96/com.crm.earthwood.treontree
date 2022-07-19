package com.crm.earthwood.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {

	public boolean retry(ITestResult result) {
		return false;
	}

}
