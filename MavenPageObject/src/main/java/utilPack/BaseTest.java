package utilPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
private WebDriver driver;

	@BeforeTest
	@Parameters("Browser")
	public void initializeDriver(String browser) {
		
		  if(browser.equalsIgnoreCase("Chrome")) {
		     String path=System.getProperty("user.dir");//making reference to the current directory
		     System.out.println(path);
		     System.setProperty("webdriver.chrome.driver", path+"\\Utils\\chromedriver.exe");
		     ChromeOptions options = new ChromeOptions();
		     options.setAcceptInsecureCerts(true);  //This is to handle the ssl certification issue of chrome browser
	         driver=new ChromeDriver(options);
		     
		  }
		 
		 if(browser.equalsIgnoreCase("Firefox")) {
			 String path=System.getProperty("user.dir");//making reference to the current directory
		     System.out.println(path);
		     System.setProperty("webdriver.gecko.driver", path+"\\Utils\\geckodriver.exe");
		     System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
	         driver=new FirefoxDriver();	 
		 }
		 
		 else {
			 System.out.println("Invalid browser type");
		 }
			 
			 driver.manage().window().maximize();
		     driver.navigate().to("http://www.qabible.in/payrollapp");
		
	}
	
	@AfterTest
	public void closeDriver() {
		if (driver!=null) {
			 //driver.quit();
		}
	}
	public WebDriver getDriver() {
		return driver;
	}

}
