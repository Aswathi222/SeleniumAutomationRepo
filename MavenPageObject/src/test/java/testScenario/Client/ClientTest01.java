package testScenario.Client;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testPage.MavenPageObject.Clients;
import testPage.MavenPageObject.Company;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.MainMenu;
import utilPack.BaseTest;
//import basePackage.BaseTest;
import utilPack.ExcelUtility;
import utilPack.ReadPropFile;

public class ClientTest01 extends BaseTest {
	Company comp;
	ReadPropFile prop;
	Login login;
	MainMenu mnMenue;
	Clients clnt;
	ExcelUtility x;
	
	@Test
	public void clientTest() throws Exception {
		
		clnt=new Clients(getDriver());
		comp = new Company(getDriver());
		login = new Login(getDriver());
		mnMenue = new MainMenu(getDriver());
		prop= new ReadPropFile();
		 x = new ExcelUtility("clientData");//sheet Name
		
		login.loginToApplication(prop.getPropData().getProperty("UserName1"),prop.getPropData().getProperty("PassWord1"));
		login.checkSuccfulLogin(prop.getPropData().getProperty("ExpectedTitle1"));
		mnMenue.selectMainMenu("Clients");
		clnt.searchClientDetails("Middleton Grove","3");
		mnMenue.selectMainMenu("Create Client");
		System.out.println("client name ="+x.ReadData("CLIENT_NAME"));
		System.out.println("client address ="+x.ReadData("CLIENT_ADRESS"));
		
        clnt.setClientDetailsfromExcel(x.ReadData("CLIENT_NAME"),x.ReadData("CLIENT_ADRESS"),x.ReadData("POST_CODE"),
		x.ReadData("COUNTRY"),x.ReadData("YOUR_REF"),x.ReadData("INVOICE_CONDACT"),x.ReadData("PHONE NO"),
		x.ReadData("FAX"),x.ReadData("EMAIL"),x.ReadData("COMPANY_REG"),x.ReadData("SETTLEMENT_DAYS"),
		"ijkl","Testing-Team2","Work location","Electronic","Print","VAT 5.00%");

//x.ReadData("BRANCH"),x.ReadData("INVOIC_ORDER")x.ReadData("DIVISION"),
//,x.ReadData("MASTER_DOCUMENT"),x.ReadData("INVOICE_DELIVERY_METHOD"),x.ReadData("INVOICE_DELIVERY_METHOD")

//
//x.ReadData("BRANCH"),x.ReadData("INVOIC_ORDER"),x.ReadData("DIVISION"),x.ReadData("MASTER_DOCUMENT"),
//x.ReadData("INVOICE_DELIVERY_METHOD"),x.ReadData("VAT_RATE")
		
		}
							

	}

