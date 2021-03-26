package testScenario.Invoice;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xwpf.usermodel.ISDTContent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testPage.MavenPageObject.Login;

public class FileDowload {
	
	WebDriver driver;
	File folder;
	
	@BeforeTest
	public void setUp() {
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		String path=System.getProperty("user.dir");//making reference to the current directory
	     System.out.println(path);
	     System.setProperty("webdriver.chrome.driver", path+"\\Utils\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		Map<String,Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		opt.setExperimentalOption("prefs", prefs);
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, opt);
		
		
		driver = new ChromeDriver(cap);
	}
	
	
	@Test
	public void downloadFile() throws InterruptedException {
		
		driver.navigate().to("https://the-internet.herokuapp.com/download");
		
		
		driver.findElement(By.xpath("//a[text()='fileUpload.txt']")).click();
		
		Thread.sleep(2000);
		File list[] = folder.listFiles();
		
		Assert.assertTrue(list.length>0);
		
		for(File file:list) {
			Assert.assertTrue(list.length>0);
		}
	}
	
	
	@AfterTest
	public void tearDown(){
		
		driver.quit();
		
		for(File file:folder.listFiles()) {
			file.delete();
		}
		folder.delete(); 
	} 
	
	
	

}
