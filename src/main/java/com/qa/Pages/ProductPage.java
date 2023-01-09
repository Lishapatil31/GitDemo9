package com.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class ProductPage extends TestBase{

	@FindBy(xpath="(//span[@class='slds-truncate'])[8]")
    WebElement Product;
	
	@FindBy(linkText = "New")
	WebElement newpro;
	
	@FindBy(xpath=" (//input[@type='text'])[1]")
    WebElement ProdName;
	
	@FindBy(xpath=" (//input[@type='checkbox'])[4]")
    WebElement Active;
	
	@FindBy(xpath="//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")
    WebElement Save;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	public void NewProduct(String ProductName) {
		TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
	     js.executeScript("arguments[0].click();",Product);
		
newpro.click();
	     
	     JavascriptExecutor js1=(JavascriptExecutor)TestBase.driver;
	     js1.executeScript("arguments[0].click();",ProdName);
		
	     ProdName.sendKeys(ProductName);
		
	     Active.click();
	     
	     Save.click();
	}
}
