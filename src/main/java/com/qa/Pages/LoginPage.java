package com.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//input[@class='input r4 wide mb16 mt8 username']")
	WebElement uname;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password1;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	WebElement Applauncher;

	@FindBy(xpath = "(//p[@class='slds-truncate'])[1]")
	WebElement Serviceapp;

	@FindBy(xpath="(//button[@class='slds-button'])[2]")
	WebElement ViewAll;
  
    @FindBy(xpath="(//p[@class='slds-truncate'])[8]")
    WebElement Sales;

    //@FindBy(xpath="//div[@class='appName slds-context-bar__label-action slds-context-bar__app-name']")
//  WebElement Homeverify;

    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }
    
    
    public void login(String un,String pass) throws InterruptedException
    {
        TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
		uname.sendKeys(un);
		password1.sendKeys(pass);
		loginBtn.click();
	//	 Applauncher.click();
//		    Thread.sleep(5000);
//		    JavascriptExecutor js1=(JavascriptExecutor)TestBase.driver;
//		     js1.executeScript("arguments[0].click();",viewall);	
//		     
//		     JavascriptExecutor js2=(JavascriptExecutor)TestBase.driver;
//		     js2.executeScript("arguments[0].click();",Sales);	
//			
    }
    

//    public String loginverify() {
//        //return Homeverify.getText();
//    }
}
