package testScenario.Company;

import java.io.IOException;

import org.testng.annotations.Test;

import testPage.MavenPageObject.Company;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.MainMenu;
import utilPack.BaseTest;
//import basePackage.BaseTest;
import utilPack.ReadPropFile;

public class CompanyTest01 extends BaseTest {
	
	Company comp;
	ReadPropFile prop;
	Login login;
	MainMenu mnMenu;
	
	
	@Test
	public void companyTest() throws IOException, InterruptedException {
		
		login = new Login(getDriver());
    	comp = new Company(getDriver());
		mnMenu = new MainMenu(getDriver());
		prop= new ReadPropFile();
		
		login.loginToApplication(prop.getPropData().getProperty("UserName1"),prop.getPropData().getProperty("PassWord1"));
		login.checkSuccfulLogin(prop.getPropData().getProperty("ExpectedTitle1"));
		mnMenu.selectMainMenu("Company");
		comp.createCompany("Comp1", "com1@mail.com", "Comp1,Tvm", "01/01/1990");
		mnMenu.selectMainMenu("Branch");
	    comp.editBranchName("ijkl");
		
		
		
		
		}
	
	   
	
	
	}
