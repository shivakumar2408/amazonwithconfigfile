package amazonTest;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import amazonTest.createAccount;
import amazonTest.searchProduct;




public class amazonMain {

	ConfigFileReader configReader;
	WebDriver driver;
    createAccount createacc;
    searchProduct prodSearch;

    @BeforeTest

    public void setup() throws FileNotFoundException{
    	
    	Properties prop = new Properties();
		InputStream in = new FileInputStream("C:\\Users\\u26494\\eclipse-workspace\\amazonTestUnoSquare\\configs\\Configuration.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("driverPath"));
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
			        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

    }

 
    @Test (priority = 2)

    public void account_Creation(){

        

    createacc = new createAccount(driver);
  
    createacc.createAccount();
    createacc.account_Create("Shivakumar", "shivakumar.chandramouli.desai@gmail.com", "Shivakumar", "Shivakumar");
   

    }
    @Test (priority = 1)

    public void search_Product(){

        //Create Login Page object

    prodSearch = new searchProduct(driver);
    prodSearch.driver_wait();
    prodSearch.setSearch("Samsung S9 ");
    prodSearch.driver_wait();
    prodSearch.clickSearch();
    prodSearch.driver_wait();
    prodSearch.clickProduct();
    prodSearch.driver_wait();
    //prodSearch.clickaddtoCart();
    prodSearch.driver_wait();
    prodSearch.clickHome();
    prodSearch.driver_wait();
    prodSearch.clicksignIn();
    prodSearch.driver_wait();
   

    }
    @AfterClass
    public void after_Test() {
  	  if (driver != null) {
            try {
               System.out.println("Closing Window"); 
            } finally {
                driver.quit(); 
            }
          } 
    }
   
}
