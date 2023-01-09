package com.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class CasePage extends TestBase {

	@FindBy(xpath="(//span[@class='slds-truncate'])[10]")
    WebElement Cases;
	
	@FindBy(xpath="(//a[@class='forceActionLink'])[1]")
    WebElement New;
	
	@FindBy(xpath="(//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[1]")
    WebElement ContactName;
	
	@FindBy(xpath="(//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[2]")
    WebElement AccountName;
	
	@FindBy(xpath="//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")
    WebElement Status;
	
	@FindBy(xpath="(//a[@role='button'])[25]")
    WebElement CaseOrigin;
	
	@FindBy(xpath="//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")
    WebElement Save;

	public CasePage() {
		PageFactory.initElements(driver, this);
	}
	public void NewCase() throws InterruptedException {
		TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
	     js.executeScript("arguments[0].click();",Cases);
		
	     New.click();
	     JavascriptExecutor js1=(JavascriptExecutor)TestBase.driver;
	     js1.executeScript("arguments[0].click();",ContactName);
	     Thread.sleep(5000);
	     ContactName.sendKeys(Keys.ARROW_DOWN);
	     ContactName.sendKeys(Keys.ARROW_DOWN);
	     ContactName.sendKeys(Keys.ENTER);
	     
	     JavascriptExecutor js3=(JavascriptExecutor)TestBase.driver;
	     js3.executeScript("arguments[0].click();",AccountName);
	     Thread.sleep(5000);
	     AccountName.sendKeys(Keys.ARROW_DOWN);
	     AccountName.sendKeys(Keys.ENTER);
	     Thread.sleep(5000);
	     JavascriptExecutor js4=(JavascriptExecutor)TestBase.driver;
	     js4.executeScript("arguments[0].click();",Status);
	     Status.sendKeys(Keys.ARROW_DOWN);
	     Status.sendKeys(Keys.ARROW_DOWN);
	     Status.sendKeys(Keys.ENTER);
	     Thread.sleep(5000);
	     JavascriptExecutor js2=(JavascriptExecutor)TestBase.driver;
	     js2.executeScript("arguments[0].click();",CaseOrigin);
	     CaseOrigin.sendKeys(Keys.ARROW_DOWN);
	     CaseOrigin.sendKeys(Keys.ARROW_DOWN);
	     CaseOrigin.sendKeys(Keys.ENTER);
	     
	     Save.click();
	}

}
