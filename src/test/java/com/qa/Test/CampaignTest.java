package com.qa.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import com.qa.Utilities.ExcelUtiities;
//import com.aventstack.extentreports.util.Assert;
import com.qa.Base.TestBase;
import com.qa.Pages.CampaignPage;
import com.qa.Pages.LoginPage;
public class CampaignTest extends TestBase {

	LoginPage loginpage;
	CampaignPage campaingspage;
	String websheet="Campaigns";
	
	
	public CampaignTest()
	{
		super();
	}
	
	@BeforeMethod
	public void login() throws InterruptedException
	{
		
		launch();
		loginpage=new LoginPage();
		campaingspage=new CampaignPage();
		loginpage.login(p.getProperty("username"),p.getProperty("password"));
//		Assert.assertEquals(loginpage.loginverify(),"Setup","Login fail");
//		System.out.println("Assertion pass");
		
		
	}
	@DataProvider
    public Object getCampaigns() {
        Object[][] obj1=ExcelUtiities.getExcel(websheet);
        return obj1;
    }

 

    @Test(priority = 0,dataProvider="getCampaigns")
    public void createcmp(String CampaignName,String ChildCampName) 
    {
        campaingspage.newcampaigns(CampaignName,ChildCampName);
        Assert.assertEquals(campaingspage.verifyedcmp(),CampaignName,"campaigns creation is failed");
        System.out.println("Assertion pass");

    }
    @Test(priority = 1,dataProvider="getCampaigns")
    public void createchildcmp(String CampaignName,String ChildCampName) throws InterruptedException 
    {
        campaingspage.NewChildCamp(CampaignName,ChildCampName);
        System.out.println("child camp created");
    }
    @Test(priority = 2)
    public void addmembers() 
    {
        campaingspage.AddMember();
        System.out.println("member added");

    }
    @AfterMethod
    public void teardown() throws IOException
    {
        driver.close();
        //takeScreenshotAtEndOfTest("company creation");
    }
}