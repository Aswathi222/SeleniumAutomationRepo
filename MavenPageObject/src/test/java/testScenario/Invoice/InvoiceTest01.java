package testScenario.Invoice;

import java.io.IOException;

import org.testng.annotations.Test;

import testPage.MavenPageObject.Invoice;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.MainMenu;
import utilPack.BaseTest;
//import basePackage.BaseTest;
import utilPack.ReadPropFile;

public class InvoiceTest01 extends BaseTest {
	Login login;
	MainMenu mnMenu;
	Invoice invc;
	ReadPropFile prop;
	
	
	
	@Test
	
	public void invoiceTest() throws IOException {
		invc = new Invoice(getDriver());
		login = new Login(getDriver());
		mnMenu = new MainMenu(getDriver());
		prop= new ReadPropFile();
		
login.loginToApplication(prop.getPropData().getProperty("UserName1"),prop.getPropData().getProperty("PassWord1"));
login.checkSuccfulLogin(prop.getPropData().getProperty("ExpectedTitle1"));
mnMenu.selectMainMenu("Invoice");

	}
	
}
