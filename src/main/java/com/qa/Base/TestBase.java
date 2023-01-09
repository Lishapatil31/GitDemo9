package com.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	static XSSFReader reader;

	public static WebDriver driver;
	public static Properties p;
	public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	public TestBase()
    {
        try {
            p=new Properties();
        //    FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"C:\\Users\\Hp\\Desktop\\Salesforce Automation jan2022\\Automation_Salesforce-main\\Payroll360\\src\\main\\java\\Properties\\Config.properties" );
            
            FileInputStream f=new FileInputStream("G:\\Selenium Automation\\SalesnService\\src\\main\\java\\com\\qa\\Config\\Config.properties" );

            p.load(f);
            ;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
	
    public static void launch(String browser)
    {
    	System.out.println("browser name=" +browser);
        if (browser.equalsIgnoreCase("chrome")) {
        	
        WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--disable-notifications");
         driver=new ChromeDriver(options);
         driver.manage().deleteAllCookies();
         driver.get(p.getProperty("url"));
         driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
         e_driver = new EventFiringWebDriver(driver);
         //eventListener = new WebEventListener();
         //    e_driver.register((WebDriverEventListener) eventListener);
             driver = e_driver;
        }
        else if(browser.equalsIgnoreCase("firefox")){
        	WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-notifications");
            driver=new FirefoxDriver(options);
            driver.manage().deleteAllCookies();
            driver.get(p.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            e_driver = new EventFiringWebDriver(driver);
            //eventListener = new WebEventListener();
            //    e_driver.register((WebDriverEventListener) eventListener);
                driver = e_driver;
        }
//        else if(browser.equalsIgnoreCase("edge")) {
//        	System.setProperty("webdriver.edge.driver","G:\\Edge\\msedgedriver.exe");
//           EdgeOptions options = new EdgeOptions();
//            //options.addArguments("--disable-notifications");
//            driver=new EdgeDriver(options);
//            driver.manage().deleteAllCookies();
//            driver.get(p.getProperty("url"));
//            driver.manage().window().maximize();
//            driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//            e_driver = new EventFiringWebDriver(driver);
//            //eventListener = new WebEventListener();
//            //    e_driver.register((WebDriverEventListener) eventListener);
//                driver = e_driver;
//        }
    }
    
    public static boolean verify(By webEle) {
        boolean check=driver.findElement(webEle).isDisplayed();
        System.out.println(check);
        return check;

    }

    public static void clickOnElement(By webEle)
    {
        driver.findElement((webEle)).click();
    }

    public static void sendKey(By webEle,String text) {
        driver.findElement(webEle).sendKeys(text);
    }

    public static void clickoncheckbox(By webEle) {

        boolean check=driver.findElement(webEle).isSelected();
        if(!check)
        {
            driver.findElement(webEle).click();

       }
    }
    public String titleTest() {
        return driver.getTitle();
    }

    public static void pressEnter() {
       Actions action=new Actions(driver);
        action.sendKeys(Keys.ENTER);
  }
    
    public static void scrollupto(By webEle) {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",webEle);

    }

    public static void clickonElementbyjs(WebElement webEle) {
        JavascriptExecutor js=(JavascriptExecutor)driver;
       js.executeScript("arguments[0].click();", webEle);
   }
    
   
    
   public static void takeScreenshotAtEndOfTest(String filename) throws IOException {
      File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
      FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + filename + ".png"));
   }
    
  

}
