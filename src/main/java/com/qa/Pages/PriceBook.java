package com.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class PriceBook extends TestBase {
	
	@FindBy(xpath="(//span[@class='slds-truncate'])[9]")
    WebElement PriceBook;
	
	@FindBy(xpath="(//li[@class='slds-button slds-button--neutral'])[1]")
    WebElement New;
	
	@FindBy(xpath="(//input[@class=' input'])[1]")
    WebElement PBname;
	
	@FindBy(xpath="(//input[@type='checkbox'])[6]")
    WebElement Active;
	
	@FindBy(xpath="//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")
    WebElement Save;
	
	

	@FindBy(xpath="//a[@title='DecPriceBook']")
	WebElement DecPriceBook;
	
	@FindBy(xpath="(//span[@class='title'])[1]")
    WebElement RelatedTab;
	
	@FindBy(xpath="(//li[@class='slds-button slds-button--neutral'])[5]")
    WebElement AddProduct;
	
	@FindBy(xpath="(//span[@class='slds-checkbox--faux'])[16]")
    WebElement ColdDrink;
	
	@FindBy(xpath="//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
    WebElement Next;
	
	@FindBy(xpath="//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
    WebElement Save1;
	
	
	public PriceBook() {
		PageFactory.initElements(driver, this);
	}
	public void NewPriceBook(String PriceBookName) {
		TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
	     js.executeScript("arguments[0].click();",PriceBook);
		
	     New.click();
	     JavascriptExecutor js1=(JavascriptExecutor)TestBase.driver;
	     js1.executeScript("arguments[0].click();",PBname);
	     PBname.sendKeys(PriceBookName);
		
	     JavascriptExecutor js2=(JavascriptExecutor)TestBase.driver;
	     js2.executeScript("arguments[0].click();",Active);
	     Save.click();
	}
	
	public void AddProduct() {
		TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor js1=(JavascriptExecutor)TestBase.driver;
	     js1.executeScript("arguments[0].click();",PriceBook);
		JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
	     js.executeScript("arguments[0].click();",DecPriceBook);
		
	     RelatedTab.click();
	     AddProduct.click();
	     ColdDrink.click();
	     Next.click();
	     JavascriptExecutor js2=(JavascriptExecutor)TestBase.driver;
	     js2.executeScript("arguments[0].click();",Save1);
	     
	     
	}

}
