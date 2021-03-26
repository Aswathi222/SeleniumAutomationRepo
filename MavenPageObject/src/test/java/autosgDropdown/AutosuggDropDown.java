package autosgDropdown;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilPack.BasePge;

public class AutosuggDropDown  {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		By ele = By.xpath("//ul[@class='erkvQe']//li");
		
		 String path=System.getProperty("user.dir");//making reference to the current directory
	     System.out.println(path);
	     System.setProperty("webdriver.chrome.driver", path+"\\Utils\\chromedriver.exe");
	     driver = new ChromeDriver();
	     BasePge bs = new BasePge(driver);
	     driver.manage().window().maximize();
	     driver.navigate().to("https://www.google.com/");
	     Thread.sleep(3000);
	     driver.findElement(By.name("q")).sendKeys("sele");
	     bs.autoSuggestiveDropDown(ele,"select");
		

	}

}
