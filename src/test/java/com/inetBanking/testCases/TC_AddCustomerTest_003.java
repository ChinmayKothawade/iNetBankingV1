package com.inetBanking.testCases;


import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		addcust.custName("Chinmay");
		addcust.custgender("male");
		addcust.custdob("10","12","1856");
		Thread.sleep(3000);
		
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("MH");
		addcust.custpinno("456789");
		addcust.custtelephoneno("1234567878");
		
		String email = randomestring()+"gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);	
		}
		else {
			Assert.assertTrue(false);
		}
				
		
		
	}
	
}
