package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() {
		
		
		logger.info("URL is open");
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		logger.info("Enter Username");
		
		lp.setPassword(password);
		lp.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}

}
