package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		File src = new File("D:\\java chinmay\\iNetBankingV3\\Configruation\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is " +e.getMessage());
		}
		
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getuserName() {
		String userName = pro.getProperty("userName");
		return userName;
	}
	public String getpassword() {
		String password = pro.getProperty("password");
		return password;
	}
	public String getchromePath() {
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
	}
	public String getedgePath() {
		String edgePath = pro.getProperty("edgePath");
		return edgePath;
	}

}
