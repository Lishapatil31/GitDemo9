package com.qa.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.ContactPage;
import com.qa.Pages.LoginPage;
import com.qa.Utilities.ExcelUtiities;

public class ContactPageTest extends TestBase {

	LoginPage loginpage;
	ContactPage contactpage;
	String websheet="Contact";
	
	public ContactPageTest() {
		super();
	}
	
	@Parameters("browser")
	@BeforeTest
    public void login(String browser) throws InterruptedException
    {
        
        launch(browser);
		//getDriver().get("url");
        loginpage=new LoginPage();
        contactpage=new ContactPage();
        loginpage.login(p.getProperty("username"),p.getProperty("password"));
	
	
    }
	@DataProvider
    public Object getContact() {
        Object[][] obj1=ExcelUtiities.getExcel(websheet);
        return obj1;
    }
	
	 @Test(dataProvider="getContact")
	    public void createcontact(String FirstName, String LastName) throws InterruptedException, IOException
	    {
		    contactpage.newcontact(FirstName, LastName);
		    String fullname="Ms. "+FirstName+" "+LastName;
	    	Assert.assertEquals(contactpage.verifycontactname(),fullname,"Contact Creation failed");
	        System.out.println("Assertion Pass");
	        
	    }
	 
//	 @AfterMethod
//	  public void teardown() throws IOException
//	   {
//	      // driver.close();
//	        //takeScreenshotAtEndOfTest("company creation");
//	    }
//	
	
	
}
