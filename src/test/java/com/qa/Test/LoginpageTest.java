package com.qa.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.LoginPage;

public class LoginpageTest extends TestBase {
LoginPage loginpage;
    
    public LoginpageTest()
    {
        super();
    }
    
    @BeforeMethod
    public void setup() {
        launch();
        loginpage=new LoginPage();
         
    }
    
//    @Test(priority=1)
//    public void verifyLoginPage() 
//    {
//        //loginpage.loginverify();
//        //Assert.assertEquals(loginpage.loginverify(),"Setup","Login fail");
//    }
    
    @Test(priority=1)
    public void loginT() throws InterruptedException
    {
        loginpage.login(p.getProperty("username"),p.getProperty("password"));
        
    }
    
    @AfterMethod
    public void tearDown() 
    {
        //driver.close();
    }
    
}
