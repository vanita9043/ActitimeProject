package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.Pom.HomePage;
import com.Actitime.Pom.TaskPage;
import com.Actitime.genericLibrary.BaseClass;
import com.Actitime.genericLibrary.FileLibrary;

public class CreateCustomer extends BaseClass {
	
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasktab().click();
		
	TaskPage taskPage=new TaskPage(driver);
	taskPage.getAddnew().click();
	taskPage.getNewcust().click();
	FileLibrary fl=new FileLibrary();
	String customer = fl.readdataFromExcel("Sheet1", 3, 1);
	taskPage.getCustname().sendKeys(customer);
	String description = fl.readdataFromExcel("Sheet1", 3, 2);
	taskPage.getCustdesc().sendKeys(description);
	taskPage.getCreatebtn().click();
	String expectedresult = customer;
	String actualresult = driver.findElement(By.xpath("(//div[.='"+customer+"'])[2]")).getText();
	SoftAssert S=SoftAssert();
	S.assertEquals(actualresult, expectedresult);
	
	
	
		
		
		
		
		
		
	}

	private SoftAssert SoftAssert() {
		// TODO Auto-generated method stub
		return null;
	}
}
