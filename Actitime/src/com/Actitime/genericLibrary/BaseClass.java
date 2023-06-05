package com.Actitime.genericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.Pom.LoginPage;

public class BaseClass 

    {
	 FileLibrary f1=new FileLibrary();
	public  static WebDriver driver;
	@BeforeSuite
	public void databaseconnecion() {
		Reporter.log("database connected",true);
	}

	@BeforeClass
	public void launchbrowser() throws IOException {
	
     driver=new  ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    
     String acttimeurl = f1.readDataFromPropertyFile("url");
     driver.get(acttimeurl);
     
     Reporter.log("browser launched",true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String un = f1.readDataFromPropertyFile("username");
		lp.getUntbx().sendKeys(un);
		
		
		String pwd = f1.readDataFromPropertyFile("password");
		lp.getPwtbx().sendKeys(pwd);
		lp.getLgbtn().click();
		
		Reporter.log("logged in to acttime",true);
		
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink"));
		Reporter.log("logout successfully",true);
	}
	@AfterClass 
	public void closebrowser() {
		driver.close();
		Reporter.log("browser closed",true);
	}
	
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("databasedisconnected",true);
	}

}
