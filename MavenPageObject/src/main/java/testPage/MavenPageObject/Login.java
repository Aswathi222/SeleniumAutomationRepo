package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utilPack.BasePge;

//import basePackage.BasePge;

public class Login extends BasePge {

	 BasePge base;

	public Login(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
Assert asrt;
   
    By userName1=By.xpath("//*[@id=\"loginform-username\"]");
    By passWord1 = By.xpath("//input[@type='password']");
	By submitBtn = By.xpath("//button[@type='submit']");
	By successfulLoginHeader = By.xpath("//p[text()='Welcome to Payroll Application']");
	By errorMesage= By.xpath("//p[text()='Incorrect username or password.']");
    By errorMesage1=By.xpath("//p[text()='Incorrect username or password.']");
	public void loginToApplication(String usrName, String pWord) {
		
		
		base.setData(userName1, usrName);
	
		base.setData(passWord1, pWord);
		
		base.buttonClick(submitBtn);
	}
	public void checkSuccfulLogin(String expectedPgeHeader) {
		
		
    // String actualPageHeader = driver.findElement(successfulLoginHeader).getText();
		String actualPageHeader = GetText(successfulLoginHeader);
		asrt.assertEquals(actualPageHeader, expectedPgeHeader);
}
	public void checkLoginFailed(String expectedMesage) {
		
		if(base.isExsist(errorMesage)) {
		    
			base.validateText(errorMesage, expectedMesage);
			
		  }
		else {
			System.out.println("Expected error message not displyed");
		}
		
		}
	public void invalidUsername(String expectedMesage1) {
		String actualMesage=GetText(errorMesage1);
		asrt.assertEquals(actualMesage, expectedMesage1);
		}
	public void invalidPassword(String expectedMesage1) {
		String actualMesage=GetText(errorMesage1);
		asrt.assertEquals(actualMesage, expectedMesage1);
	}
	}
