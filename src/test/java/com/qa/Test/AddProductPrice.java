package com.qa.Test;


import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.LoginPage;
import com.qa.Pages.PriceBook;

public class AddProductPrice extends TestBase {

	LoginPage loginpage;
	PriceBook pricebookpage;
	
	
	public AddProductPrice() 
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
	@Test(priority = 1)
  public void AddPrice()
  {
		pricebookpage.AddProduct();
  
  
  }
	 @Test(priority = 2,dataProvider="getAccount")
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
	
	
	
	
	
	
	
	
	