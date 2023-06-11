package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);	
		}
		else {
			Assert.assertTrue(true);
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
			}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	@DataProvider(name = "LoginData")
	String [][] getData() throws IOException 
	{
		String path = "D:\\java chinmay\\iNetBankingV3\\src\\test\\java\\com\\inetBanking\\testData\\user_login_data.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String[rownum][colnum];
		
		for(int i=1; i<=rownum; i++) {
			
			for(int j=0; j<colnum; j++) {
				loginData[i-1][j]=XLUtils.getCellData(path,"sheet1", i, j);
			}
		}
		return loginData;
		
	}
}
