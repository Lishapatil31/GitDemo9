package com.qa.Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.CasePage;
import com.qa.Pages.LoginPage;

public class CaseTest extends TestBase {

	LoginPage loginpage;
	CasePage casepage;
	
	
	public CaseTest() 
	{
		super();
	}
	
	@BeforeMethod
    public void login() throws InterruptedException
    {
        
        launch();
        loginpage=new LoginPage();
        casepage=new CasePage();
        loginpage.login(p.getProperty("username"),p.getProperty("password"));
//        Assert.assertEquals(loginpage.loginverify(),"Setup","Login fail");
//        System.out.println("Assertion pass");
        
    }
	
//	@DataProvider
//  public Object getPrices() {
//  Object[][] obj1=ExcelUtiities.getExcel(websheet);
//  return obj1;
//}


@Test()
public void products() throws InterruptedException, IOException
{
	casepage.NewCase();


}
@AfterMethod
public void teardown() throws IOException
{
   //driver.close();
   //takeScreenshotAtEndOfTest("company creation");
}




}
