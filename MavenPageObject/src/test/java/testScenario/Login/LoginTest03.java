package testScenario.Login;

import java.io.IOException;

import org.testng.annotations.Test;

import testPage.MavenPageObject.Login;
import utilPack.BaseTest;
import utilPack.ReadPropFile;

public class LoginTest03 extends BaseTest {
	Login login;
	ReadPropFile prop;
	@Test
	public void checkLoginNonValidUserName() throws IOException {
		login=new Login(getDriver());
		prop=new ReadPropFile();
		login.loginToApplication(prop.getPropData().getProperty("UserName2"),prop.getPropData().getProperty("PassWord1"));
		login.invalidUsername(prop.getPropData().getProperty("ExpectedMesage1"));
	}

}
