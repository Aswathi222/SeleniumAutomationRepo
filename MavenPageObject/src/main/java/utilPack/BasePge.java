package utilPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sun.tools.javac.util.List;

public class BasePge {
	protected WebDriver driver;
	WebElement webElement;
	Assert asrt;
	JavascriptExecutor js;
	Select select;
	String data;
	int exitVal;
	public BasePge(WebDriver driver) {
		this.driver=driver;	
	}
	
	public void buttonClick(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement =driver.findElement(locator);
		webElement.click();
	}
	
	public void setData(By locator, String text) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement =driver.findElement(locator);
		webElement.clear();
		webElement.sendKeys(text);
		
	}
	
	public String GetText(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement =driver.findElement(locator);
		data = webElement.getText(); 
		return data;
	}
	
	public void switchToFrame(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		webElement =driver.findElement(locator);
		driver.switchTo().frame(webElement);
		
	}
	
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	
	
	
	
	public void validateText(By locator,String expectedText) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		String actualText = webElement.getText();
		asrt.assertEquals(actualText, expectedText);
		
		
	}
	
   public boolean validateText(By locator) {
	    WebDriverWait wait = getWait();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		boolean status = webElement.isDisplayed();
		asrt.assertTrue(status);
		return status;		
	}
   
   
   public WebDriverWait getWait() {   //explicit wait
	   
	   WebDriverWait wait = new WebDriverWait(driver, 60);
	   wait.pollingEvery(250,TimeUnit.MILLISECONDS);
	   wait.ignoring(NoSuchElementException.class);
	   return wait;
	   
   }
	
   
   public void excuteJsClick(By locator) {
	   
	    js = (JavascriptExecutor)driver;
	    WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement =driver.findElement(locator);
	    js.executeScript("arguments[0].click();", webElement);
   }
   
   public void selectorByVisibleText(By locator,String text) {     //drpdown
	    WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		select = new Select(webElement);
	    select.selectByVisibleText(text);
	   
   }
   public void autoSuggestiveDropDown(By locator,String text) {
	    WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    ArrayList<WebElement> elementList = new ArrayList<>(driver.findElements(locator)) ;
	     for(int i=0;i<elementList.size();i++) {
	    	 
	    	  if(elementList.get(i).getText().equalsIgnoreCase(text)) {
	    		  elementList.get(i).click();
	    		  break;
	    	  }
	     }
	     
   }
   
   public boolean isExsist(By locator) {
	    boolean status= false;
	    WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	   
		try {
			webElement = driver.findElement(locator);
			if(webElement.isDisplayed())
				status=true;
				return status;
		}
		catch(Exception e) {
			e.printStackTrace();
			return status;
		}
		   
   }
   
   
   public void selectCheckBox(By locator) {
	   webElement  = driver.findElement(locator);
	    boolean isSelected = webElement.isSelected();
		//performing click operation if element is not checked
	 if(isSelected == false) {
		 webElement.click();
	    
	  }
   }
   
   
    }


	


