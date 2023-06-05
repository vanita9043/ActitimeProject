package com.Actitime.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import graphql.org.antlr.v4.runtime.tree.xpath.XPath;

public class TaskPage {
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement addnew;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newcust;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesc;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createbtn;
	
	//initialization
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getAddnew() {
		return addnew;
	}


	public WebElement getNewcust() {
		return newcust;
	}


	public WebElement getCustname() {
		return custname;
	}


	public WebElement getCustdesc() {
		return custdesc;
	}


	public WebElement getCreatebtn() {
		return createbtn;
	}


	


	
	
		

}
