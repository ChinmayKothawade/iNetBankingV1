package com.inetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;



public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String userName = readconfig.getuserName();
	public String password  = readconfig.getpassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	
	public void setUp(String br) {
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")){
			System.setProperty("webDriver.chrome.driver",readconfig.getchromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("edge")) {
			System.setProperty("webDriver.edge.driver",readconfig.getedgePath());
			driver = new EdgeDriver();
		}
		driver.get(baseURL);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public String randomestring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);	
	}
	public String randomeNum() {
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}	
	

}
