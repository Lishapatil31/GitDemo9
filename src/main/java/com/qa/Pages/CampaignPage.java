package com.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class CampaignPage extends TestBase {
	
	@FindBy(xpath="(//span[@class='slds-truncate'])[7]")
    WebElement Camp;

    @FindBy(linkText = "New")
    WebElement newcamp;

    @FindBy(xpath="(//input[@type='text'])[1]")
    WebElement campname;

    @FindBy(xpath="(//label [@class='label inputLabel uiLabel-left form-element__label uiLabel'])[2]")
    WebElement Active;

    @FindBy(xpath="(//a[@class='select'])[1]")
    WebElement type;

    @FindBy(xpath="(//a[@class='select'])[2]")
    WebElement status;

    @FindBy(xpath="//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")
    WebElement save;

    @FindBy(xpath="//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']")
    WebElement parentcmp;

    @FindBy(xpath= "(//a[@title='Sales&Service Better Choice'])[1]")
    WebElement SPP;

    @FindBy(xpath="//a[@title='Add Leads']")
    WebElement Addlead;

    @FindBy(xpath="(//label[@class='slds-checkbox'])[14]")
    WebElement John;

    @FindBy(xpath="//button[@class='slds-button slds-button_neutral button-brand uiButton--default uiButton--brand uiButton']")
    WebElement Next;

    @FindBy(xpath="//button[@class='slds-button slds-button_neutral button-brand uiButton--default uiButton--brand uiButton']")
    WebElement Submit;

    @FindBy(xpath="//lightning-formatted-text[@class='custom-truncate']")
    WebElement verifycmp;

	
	

    public CampaignPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void newcampaigns(String CampaignName,String ChildCampName) 
    {
        TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
         js.executeScript("arguments[0].click();",Camp);

         newcamp.click();

         campname.click();

         campname.sendKeys(CampaignName);

         Active.click();

         type.click();
         type.sendKeys(Keys.ARROW_DOWN);
         type.sendKeys(Keys.ARROW_DOWN);
         type.sendKeys(Keys.ENTER);

         status.click();
         status.sendKeys(Keys.ARROW_DOWN);
         status.sendKeys(Keys.ARROW_DOWN);
         status.sendKeys(Keys.ENTER);
         save.click();

    }

	
    public void NewChildCamp(String CampaignName,String ChildCampName) throws InterruptedException 
    {
        TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
                 js.executeScript("arguments[0].click();",Camp);

                 newcamp.click();

                 campname.click();
                 campname.sendKeys(ChildCampName);

                 Active.click();

                 type.click();
                 type.sendKeys(Keys.ARROW_DOWN);
                 type.sendKeys(Keys.ARROW_DOWN);
                 type.sendKeys(Keys.ENTER);
                 status.click();
                 status.sendKeys(Keys.ARROW_DOWN);
                 status.sendKeys(Keys.ARROW_DOWN);
                 status.sendKeys(Keys.ENTER);
                 Thread.sleep(5000);
                 JavascriptExecutor js1=(JavascriptExecutor)TestBase.driver;
                 js1.executeScript("arguments[0].click();",parentcmp);
                 Thread.sleep(8000);
                 parentcmp.sendKeys(Keys.ARROW_DOWN);
                 parentcmp.sendKeys(Keys.ENTER);

                 save.click();

            }

    public void AddMember() 
    {
        TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
                js.executeScript("arguments[0].click();",Camp);
                //Thread.sleep(5000);

                JavascriptExecutor js1=(JavascriptExecutor)TestBase.driver;
                js1.executeScript("arguments[0].click();",SPP);

                JavascriptExecutor js2=(JavascriptExecutor)TestBase.driver;
                js2.executeScript("arguments[0].click();",Addlead);

                JavascriptExecutor js3=(JavascriptExecutor)TestBase.driver;
                js3.executeScript("arguments[0].click();",John);
                JavascriptExecutor js4=(JavascriptExecutor)TestBase.driver;
                js4.executeScript("arguments[0].click();",Next);
                Submit.click();

    }
    public String verifyedcmp() {
        return verifycmp.getText();
    }
}