package testPage.MavenPageObject;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sun.org.apache.bcel.internal.generic.RETURN;

//import basePackage.BasePge;
import sun.tools.serialver.resources.serialver;
import utilPack.BasePge;

public class Company extends BasePge{
	 protected WebDriver driver;
	 
	
	
 public Company(WebDriver driver) {
		super(driver);
	}
 
   By comName = By.xpath("//input[@id='company-company_name']");
   By comEmail = By.xpath("//input[@id='company-company_email']");
   By comAddress = By.xpath("//textarea[@id='company-company_address']");
   By comDate = By.xpath("//input[@id='company-started_at']");
   By saveBtn = By.xpath("//button[text()='Save']");
   By comList = By.xpath("//table[@class='table table-striped table-bordered']//td");
   By editBtn = By.xpath("(//span[@class='glyphicon glyphicon-pencil'])[1]");
   By newSaveBtn = By.xpath("//button[@type='submit']");
   By branchName = By.xpath("//input[@name='Branch[branch_name]']");
   
   
   
   public void createCompany(String companyName,String email,String address,String date) throws InterruptedException {
	   
	   setData(comName, companyName);
	   setData(comEmail, email);
	   setData(comAddress, address);
	   setData(comDate, date);
	   buttonClick(saveBtn);
       Thread.sleep(3000);
	   
   }

   public void editBranchName(String BranchName) {
	     excuteJsClick(editBtn);
		 setData(branchName,BranchName);
		 excuteJsClick(newSaveBtn);
		 checkEditedBranch(BranchName);
	 }
   
   
   public void checkEditedBranch(String branchName) {
	   By chkBranch = By.xpath("//td[text()='"+branchName+"']");
	   
	   if(validateText(chkBranch)) {
		   
		   System.out.println("Branch name edited successfully");
		   
	   }
	   
	   else {
		   System.out.println("Branch name didn't edited successfully");
	   }
   }
		   
	  
  }


 
