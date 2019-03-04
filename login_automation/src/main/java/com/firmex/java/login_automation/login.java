package com.firmex.java.login_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	public static final String baseURL="https://www.firmex.com/";

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		TestCases test1 = new TestCases();
		test1.verifyPageTitle(driver);
		test1.verifyLoginPage(driver);
		test1.verifyInvalidCredentials(driver);
		test1.verifyNoPwd(driver);
		test1.verifyNoEmail(driver);
		test1.verifyInvalidEmail(driver);
		driver.close();

	}
}