package com.qa.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.LeadPage;
import com.qa.Pages.LoginPage;
import com.qa.Utilities.ExcelUtiities;

public class LeadTest extends TestBase {

	
	LoginPage loginpage;
	LeadPage leadpage;
	String websheet="Lead";
	
	public LeadTest()
	{
		super();
	}
	
	@BeforeMethod
	public void login() throws InterruptedException
	{
		
		launch();
		loginpage=new LoginPage();
	    leadpage=new LeadPage();
	    loginpage.login(p.getProperty("username"),p.getProperty("password"));
}
	
	@DataProvider
	public Object getLead() {
		Object[][] obj1=ExcelUtiities.getExcel(websheet);
		return obj1;
	}
	

	@Test(dataProvider="getLead")
	public void createlead(String FirstName,String LastName,String Company,String Street,String City,String State,String Zipcode,String Country ) throws InterruptedException, IOException
	{
	
		leadpage.newlead(FirstName, LastName, Company, Street, City, State, Zipcode, Country);
		 String fullname="Mr. "+FirstName+" "+LastName;
		 Assert.assertEquals(leadpage.verifyedlead(),fullname,"Opportunity creation is failed");
			System.out.println("Assertion pass");
	
	}
	
	
}