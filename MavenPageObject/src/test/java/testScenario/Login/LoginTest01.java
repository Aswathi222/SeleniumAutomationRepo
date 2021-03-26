package testScenario.Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testPage.MavenPageObject.Company;
import testPage.MavenPageObject.Login;
import utilPack.BaseTest;
//import basePackage.BaseTest;
import utilPack.ReadPropFile;

public class LoginTest01 extends BaseTest{
	
	//Company cmp;
	//Test commit
	ReadPropFile prop;
	Login login;	
	@Test
	public void checkLogin() throws IOException {
	    login = new Login(getDriver());
		prop = new ReadPropFile();
		login.loginToApplication(prop.getPropData().getProperty("UserName1"),prop.getPropData().getProperty("PassWord1"));
		login.checkSuccfulLogin(prop.getPropData().getProperty("ExpectedTitle1"));
		
	}
	
	
	}
