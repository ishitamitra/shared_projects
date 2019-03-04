package com.firmex.java.login_automation;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCases {

	public void verifyPageTitle(WebDriver driver) {
		// *Test Case 1: Verify Page title*//
		try {
		String pageTitle = driver.getTitle();
		System.out.println("Page title is :" + pageTitle);
		String expTitle = "The World's Most Trusted Virtual Data Room | Firmex";
		if (pageTitle.equals(expTitle)) {
			System.out.println("Test cased passed, Title is matching");
		} else {
			System.out.println("Test case failed, Title is not matching");
		}
		}catch(Exception ex) {
			System.out.println("Exception printed from verifyPageTitle"+ex);
		}
	}

	public void verifyLoginPage(WebDriver driver) throws InterruptedException {
		// Test Case 2: Verify Login Page
		try {
			driver.findElement(By.linkText("Login")).click();
			String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is :" + currentURL);
		if (currentURL.contains("https://login.firmex.com")) {
			System.out.println("Test case passed, you are in Login page");
		} else {
			System.out.println("Test case failed, URL verified incorrect");
		}
		Thread.sleep(2000);
		}catch(Exception ex) {
			System.out.println("Exception printed from verifyLoginPage"+ex);
		}
	}

	public void verifyInvalidCredentials(WebDriver driver) throws InterruptedException {
		// Test Case 3: Invalid Credentials
		try {
			driver.findElement(By.id("login_user")).sendKeys("mitra.ishita89@gmail.com");
			driver.findElement(By.id("login_pw")).sendKeys("march2019");
			driver.findElement(By.id("login_btn")).click();
			WebElement HeaderTxtElem = new WebDriverWait(driver, 20)
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//div[@class='form-container loginTriggerBox form-error']/div/p")));
			String currentError = HeaderTxtElem.getText();
			System.out.println("invalid credentials error is :" + currentError);
			String expError = "User credentials are invalid.";
			if (currentError.contains(expError)) {
				System.out.println("Test Case passed, Error validated");
			} else {
				System.out.println("Test Case failed");
			}
			Thread.sleep(2000);
			driver.findElement(By.id("login_user")).clear();
			driver.findElement(By.id("login_pw")).clear();
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println("Exception printed from verifyInvalidCredentials"+ex);
		}
	}

	public void verifyNoPwd(WebDriver driver) throws InterruptedException {
		// Test Case 4: Password not given
		try {
		driver.findElement(By.id("login_user")).sendKeys("mitra.ishita89@gmail.com");
		driver.findElement(By.id("login_btn")).click();
		String pwdError = driver.findElement(By.xpath("(.//div[@class='form-message'])[2]")).getText();
		System.out.println("Password not given error :" + pwdError);
		String expectedError = "Please enter your password.";
		if (pwdError.equals(expectedError)) {
			System.out.println("Test Case passed, password not given");
		} else {
			System.out.println("Test Case failed");
		}
		Thread.sleep(2000);
		driver.findElement(By.id("login_user")).clear();
		driver.findElement(By.id("login_pw")).clear();
		Thread.sleep(2000);
		}catch(Exception ex) {
			System.out.println("Exception printed from verifyNoPwd "+ex);
		}
	}

	public void verifyNoEmail(WebDriver driver) throws InterruptedException {
		// Test Case 4: Email id not given
		try {
		driver.findElement(By.id("login_pw")).sendKeys("march2019");
		driver.findElement(By.id("login_btn")).click();
		String idError = driver.findElement(By.xpath(".//div[@class='form-message']/p")).getText();
		System.out.println("Email id not given error :" + idError);
		String idExpectedError = "Please enter your email address.";
		if (idError.equals(idExpectedError)) {
			System.out.println("Test Case passed, email id not given");
		} else {
			System.out.println("Test Case failed");
		}
		Thread.sleep(2000);
		driver.findElement(By.id("login_user")).clear();
		driver.findElement(By.id("login_pw")).clear();
		Thread.sleep(2000);
		}catch(Exception ex) {
			System.out.println("Exception printed from verifyNoEmail "+ex);
		}
	}

	public void verifyInvalidEmail(WebDriver driver) throws InterruptedException {
		// Test Case 5: Invalid Email ID
		try {
		driver.findElement(By.id("login_user")).sendKeys("mitra.ishita89gmailcom");
		driver.findElement(By.id("login_pw")).sendKeys("march2019");
		driver.findElement(By.id("login_btn")).click();
		String validIdError = driver.findElement(By.xpath("(.//div[@class='form-message'])[1]")).getText();
		System.out.println("invalid email id error :" + validIdError);
		String invalidIdExpectedError = "Please enter a valid email address.";
		if (validIdError.equals(invalidIdExpectedError)) {
			System.out.println("Test Case passed, email id invalid");
		} else {
			System.out.println("Test Case failed");
		}
		Thread.sleep(2000);
		}catch(Exception ex) {
			System.out.println("Exception printed from verifyInvalidEmail "+ex);
		}
	}
}
