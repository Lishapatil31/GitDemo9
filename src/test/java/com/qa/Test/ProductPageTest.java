package com.qa.Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.LoginPage;
import com.qa.Pages.ProductPage;
import com.qa.Utilities.ExcelUtiities;

public class ProductPageTest extends TestBase{
	//private static final String ExcelUtiities = null;
    LoginPage loginpage;
    ProductPage productpage;
    String websheet="Products";
    
    public ProductPageTest() 
    {
        super();
    }
    @BeforeMethod
    public void login() throws InterruptedException
    {
        
        launch();
        loginpage=new LoginPage();
        productpage=new ProductPage();
        loginpage.login(p.getProperty("username"),p.getProperty("password"));
//        Assert.assertEquals(loginpage.loginverify(),"Setup","Login fail");
//        System.out.println("Assertion pass");
        
    }
    

    @DataProvider
	public Object getProducts() {
        Object[][] obj1=ExcelUtiities.getExcel(websheet);
        return obj1;
    }
  

    @Test(dataProvider="getProducts")
    public void products(String ProductName) throws InterruptedException, IOException
    {
        productpage.NewProduct(ProductName);
    
    
    }
    @AfterMethod
    public void teardown() throws IOException
    {
        //driver.close();
        //takeScreenshotAtEndOfTest("company creation");
    }
}