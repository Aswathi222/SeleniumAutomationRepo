package testScenario.Login;

import java.io.IOException;

import org.testng.annotations.Test;

import testPage.MavenPageObject.Login;
import utilPack.BaseTest;
import utilPack.ReadPropFile;

public class LoginTest04 extends BaseTest{
	Login login;
	ReadPropFile prop;
	@Test
public void invalidPassword() throws IOException {
		prop = new ReadPropFile();
		login = new Login(getDriver());
		login.loginToApplication(prop.getPropData().getProperty("UserName1"),prop.getPropData().getProperty("PassWord2"));
		login.invalidPassword(prop.getPropData().getProperty("ExpectedMesage1"));
	}

}
