package com.qa.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.LoginPage;
import com.qa.Pages.OpportunityPage;
import com.qa.Utilities.ExcelUtiities;

public class OpportunityTest extends TestBase {

	LoginPage loginpage;
	OpportunityPage opportunitypage;
	String websheet="Opportunity";
	
	
	public OpportunityTest()
	{
		super();
	}
	
	@BeforeMethod
	public void login() throws InterruptedException
	{
		
		launch();
		loginpage=new LoginPage();
	    opportunitypage=new OpportunityPage();
	    loginpage.login(p.getProperty("username"),p.getProperty("password"));
	   
	}
	
	@DataProvider
	public Object getOpportunity() {
		Object[][] obj1=ExcelUtiities.getExcel(websheet);
		return obj1;
	}
	@Test(dataProvider="getOpportunity")
	public void createlead(String OpportunityName, String CloseDate, String Stage, String AccountName, String CampName,String UpdateStage) throws InterruptedException
	{
		
		opportunitypage.creatopp(OpportunityName, CloseDate, Stage, AccountName, CampName, UpdateStage);
		Assert.assertEquals(opportunitypage.verifyedopp(),OpportunityName,"Opportunity creation is failed");
		System.out.println("Assertion pass");
		
	}
	
	
	
	
}
	
	
