package com.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class ContactPage extends TestBase {

	@FindBy(xpath="(//span[@class='slds-truncate'])[6]")
	WebElement Cont;
	
	@FindBy(linkText ="New")
	WebElement newcont;
	
	@FindBy(xpath="(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")
	WebElement sal;
	
	@FindBy(xpath="(//input[@class='slds-input'])[3]")
	WebElement fname1;
	
	@FindBy(xpath="(//input[@class='slds-input'])[4]")
	WebElement lname2;
	
	@FindBy(xpath="//button[@class='slds-button slds-button_brand']")
	WebElement save;
	
	@FindBy(xpath="//span[@class='custom-truncate uiOutputText']")
	WebElement verconname;
	
	
	public ContactPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void newcontact(String FirstName, String LastName) throws InterruptedException {
		
		TestBase.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
        js.executeScript("arguments[0].click();",Cont);
        
        newcont.click();
        JavascriptExecutor js1=(JavascriptExecutor)TestBase.driver;
        js1.executeScript("arguments[0].click();",sal);
       
        sal.sendKeys(Keys.ARROW_DOWN);
        sal.sendKeys(Keys.ARROW_DOWN);
        sal.sendKeys(Keys.ENTER);
        
        fname1.click();
        fname1.sendKeys(FirstName);
        
        lname2.click();
        lname2.sendKeys(LastName);
        save.click();
		
	}
	
	public String verifycontactname() {
		
		return verconname.getText();
	}
}








