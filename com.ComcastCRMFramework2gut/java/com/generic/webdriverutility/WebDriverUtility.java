package com.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	Actions act;
	public void waitForpageToload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver, String partailTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String windowID = it.next();
			driver.switchTo().window(windowID);
			
			String actUrl = driver.getTitle();
			if (actUrl.contains(partailTitle)) {
				break;
			}
		}
		
	}public void switchtoFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}	
    public void switchtoFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
    }
	public void switchtoFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchtoAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchtoAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void select(WebElement element, String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		
	}
	public Actions Action(WebDriver driver) {
		act = new Actions(driver);
		return act;				
	     }
	
         public void doubleclick(WebDriver driver, WebElement element) {
    	 Action(driver).doubleClick(element).perform(); 
         }
         public void contextclick(WebDriver driver,WebElement element) {
    	 Action(driver).moveToElement(element).perform(); 
         }
         public void logOut(WebDriver driver, WebElement signoutOpt) {
         act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
         }
         public void scrollUntillElementLocation(WebDriver driver, WebElement element) {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].scrollIntoView(true);", element);
    	 
    	 
     }
         public void scrollByAmount(WebDriver driver, int y) {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("window.scrollby(0,"+y+")");
     }
         
        public static void takesScreenhot(WebDriver  driver, String destPath) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver; 
        	File src = ts.getScreenshotAs(OutputType.FILE);
        	File dest=new File(destPath);
        	Files.copy(src,dest);
	
		}

		public void switchToWindowOnUrl(WebDriver driver, String string) {
			// TODO Auto-generated method stub
			
		}


		public void waitForPageToLoad(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void mousehoverOnElement(WebDriver driver, WebElement signoutOpt) {
			// TODO Auto-generated method stub
			
		}

		public void maximizeWindow(WebDriver driver) {
			// TODO Auto-generated method stub
			driver.manage().window().maximize();
		}

		public void click(WebDriver driver, WebElement signoutOpt) {
			WebElement web=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			// TODO Auto-generated method stub
			act.moveToElement(web).perform();
	
			driver.findElement(By.linkText("Sign Out")).click();
			
		}

    	 
     }
     

