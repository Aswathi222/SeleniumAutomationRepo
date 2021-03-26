package testScenario.Login;

import java.io.IOException;

import org.testng.annotations.Test;

import testPage.MavenPageObject.Company;
import testPage.MavenPageObject.Login;
import utilPack.BaseTest;
import utilPack.ReadPropFile;
//this is to test the invalid login case
public class LoginTest02 extends BaseTest{
Company cmp;
 Login login;
 ReadPropFile prop;
  
 
 
 @Test
 public void checkLoginPageIvalidCase() throws IOException {
	 login = new Login(getDriver());
	 prop = new ReadPropFile();
	 login.loginToApplication(prop.getPropData().getProperty("UserName"),prop.getPropData().getProperty("PassWord"));
	 login.checkLoginFailed(prop.getPropData().getProperty("ExpectedMesage"));
 }
}
