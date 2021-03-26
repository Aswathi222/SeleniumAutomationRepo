package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilPack.BasePge;
//import basePackage.BasePge;
import utilPack.ReadPropFile;

public class Invoice extends BasePge {
	 protected WebDriver driver;
	 
	 By pdf = By.xpath("(//span[@class='glyphicon glyphicon-paperclip'])[1]");
	public Invoice(WebDriver driver) {
		super(driver);
		this.driver=driver;
}
	
	

	

}
