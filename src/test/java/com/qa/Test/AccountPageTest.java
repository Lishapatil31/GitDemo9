package com.qa.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.qa.Base.TestBase;
import com.qa.Pages.AccountPage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.OpportunityPage;
import com.qa.Utilities.ExcelUtiities;

public class AccountPageTest extends TestBase {

	LoginPage loginpage;
	AccountPage accountpage;
	String websheet="Account";
	
	public AccountPageTest() {
		super();
	}
	@Parameters("browser")
	@BeforeMethod
	public void login(String browser) throws InterruptedException
	{
		launch(browser);
		loginpage=new LoginPage();
		accountpage=new AccountPage();
	    loginpage.login(p.getProperty("username"),p.getProperty("password"));
	   
	}
	
	@DataProvider
	public Object getAccount() {
        Object[][] obj1=ExcelUtiities.getExcel(websheet);
        return obj1;
    }
	
	@Test(priority = 2,dataProvider="getAccount")
    public void createAcc(String AccountName,String ChildAccountName) throws InterruptedException, IOException
    {
        accountpage.newaccount(AccountName,ChildAccountName);
        Assert.assertEquals(accountpage.verifyaccname(),AccountName,"Account Creation failed");
        System.out.println("Assertion Pass Lisha Patil");

    }
	
	@Test(priority = 1,dataProvider="getAccount")
    public void addparentacc(String AccountName,String ChildAccountName) throws InterruptedException, IOException
    {

        accountpage.addparentaccount(AccountName,ChildAccountName);
        System.out.println("Added parent account");
    }
	
	@AfterMethod
    public void teardown() throws IOException
     {
         //driver.close();
          //takeScreenshotAtEndOfTest("company creation");
      }
	
	
}
