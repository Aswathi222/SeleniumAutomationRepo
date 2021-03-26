package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

//import basePackage.BasePge;
import sun.net.www.content.text.plain;
import utilPack.BasePge;

public class Clients extends BasePge{
	 protected WebDriver driver;
     
	public Clients(WebDriver driver) {
		super(driver);
	}
	By name = By.xpath("//input[@name='ClientSearch[client_name]']");
    By clientId = By.xpath("//input[@id='clientsearch-id']");
	By srch = By.xpath("//button[text()='Search']");
	By clntId = By.xpath("//td[1]");
	By clntName = By.xpath("//td[2]");
	By postCode = By.xpath("//td[5]");
	
	//****Create client**********//
	By clntNme =By.xpath("//input[@id='client-client_name']");
	By clientAddrs = By.xpath("//textarea[@id='client-client_address']");
	By postcode = By.xpath("//input[@id='client-postcode']");
	By country = By.xpath("//input[@id='client-country']");
	By yourRef = By.xpath("//input[@id='client-your_ref']");
    By invoiceCondact = By.xpath("//input[@id='client-invoice_contact']");
    By phone = By.xpath("//input[@id='client-phone']");
    By fax = By.xpath("//input[@id='client-fax']");
    By email = By.xpath("//input[@id='client-email']");
    By companyReg = By.xpath("//input[@id='client-company_reg']");
    By setlmentDays = By.xpath("//input[@id='client-settilement_days']");
    
    //*****checkBox*******
    By requirePo = By.xpath("//input[@id='client-require_po']");
    By directClient = By.xpath("//input[@id='client-direct_client']");
    By ukPublicSectorClient = By.xpath("//input[@id='client-uk_public_sector_client']");
    
    
    //******SAVEBTN*******//
    By sveBtn = By.xpath("//button[@type='submit']");
    
public void searchClientDetails(String clientName,String Id) throws InterruptedException {
	   setData(name,clientName );
	   setData(clientId,Id );
	   buttonClick(srch);
	   Thread.sleep(4000);
	   validateText(clntId, Id);
	   validateText(clntName, clientName);
	  
	   
 if(validateText(postCode)) {
		   System.out.println("post code displayed successfully");
	   }
	   
	   else {
		   System.out.println("post code didn't displayed ");
	   }
}
	
	//****excel file reading****
	
 public void setClientDetailsfromExcel(String ClntName,String ClntAdr,String PostCde,String cntry,String urRef,
		 String invcCondact,String phNo,String fx,String emil,String cmpnyRg,
		 String setlmntDys,String brnch,String dvsion,String invoice,String invcDlvry,String msterDoc, String vtRate) throws InterruptedException {
	 
	//
	//***dropDwn*******
	    By branch = By.xpath("//select[@id='client-branch_id']");
	    By division = By.xpath("//select[@id='client-division_id']");
	    By invoiceOrder = By.xpath("//select[@id='client-invoice_order']");
	    By invoiceDelivryMethod = By.xpath("//select[@id='client-invoice_delivery_method']");
        By masterDocument = By.xpath("//select[@id='client-master_document']");
	    By vatRate = By.xpath("//select[@id='client-vat_rate']");
      
      
       setData(clntNme, ClntName);
       setData(clientAddrs,ClntAdr);
	   setData(postcode,PostCde );
	   setData(country,cntry);
	   setData(yourRef, urRef);
       setData(invoiceCondact, invcCondact);
       setData(phone, phNo); 
	   setData(fax, fx);
	   setData(email, emil);
	   setData(companyReg, cmpnyRg);
	   setData(setlmentDays, setlmntDys);
	   
 selectorByVisibleText(branch, brnch);
 selectorByVisibleText(division, dvsion);
 selectorByVisibleText(invoiceOrder, invoice);
 selectorByVisibleText(invoiceDelivryMethod, invcDlvry);
 selectorByVisibleText(masterDocument, msterDoc);
 selectorByVisibleText(vatRate, vtRate); 

 selectCheckBox(directClient);
 excuteJsClick(sveBtn);
 
 
 
 
      
      
       
       /* JavascriptExecutor js = (JavascriptExecutor)driver;
		buttonClick(clntNme);
	    js.executeScript("document.getElementById('client-client_name').value='"+ClntName+"'");*/
		 
 }
	
}