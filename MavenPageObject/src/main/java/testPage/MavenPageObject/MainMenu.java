package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilPack.BasePge;

//import basePackage.BasePge;

public class MainMenu extends BasePge {

	public MainMenu(WebDriver driver) {
		super(driver);
		
	}
	public void selectMainMenu(String option) {
		
		By menuSelection =By.xpath("//a[text()='"+option+"']");
		
		switch(option) {
	
		case "Company":
			buttonClick(menuSelection);
			break;
		    
		case "Clients":
			buttonClick(menuSelection);
			break;
		
		case "Workers":
			buttonClick(menuSelection);
			break;
		case "Branch":
			buttonClick(menuSelection);
			break;
		case "Create Client":
			buttonClick(menuSelection);
			break;
		case "Invoice":
			buttonClick(menuSelection);
			break;
			}
		}
	}
