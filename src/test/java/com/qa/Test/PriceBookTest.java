package com.qa.Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.LoginPage;
import com.qa.Pages.PriceBook;
import com.qa.Utilities.ExcelUtiities;

public class PriceBookTest extends TestBase {

	LoginPage loginpage;
	PriceBook pricebookpage;
	String websheet="PriceBook";
	
	public PriceBookTest() 
	{
		super();
	}
	
	@BeforeMethod
    public void login() throws InterruptedException
    {
        
        launch();
        loginpage=new LoginPage();
        pricebookpage=new PriceBook();
        loginpage.login(p.getProperty("username"),p.getProperty("password"));
//      Assert.assertEquals(loginpage.loginverify(),"Setup","Login fail");
//      System.out.println("Assertion pass");
      
  }
	
	@DataProvider
	   public Object getPriceBook() {
		 Object[][] obj1=ExcelUtiities.getExcel(websheet);
	       return obj1;
	  }
	
	@Test(priority = 2)
  public void AddPrice()
  {
		pricebookpage.AddProduct();
  
  
  }
	 @Test(priority = 1,dataProvider="getPriceBook")
	 public void products(String PriceBookName) throws InterruptedException, IOException
	    {
		   pricebookpage.NewPriceBook(PriceBookName);
	    
	    }
	    @AfterMethod
	    public void teardown() throws IOException
	    {
	        //driver.close();
	        //takeScreenshotAtEndOfTest("company creation");
	    }
}