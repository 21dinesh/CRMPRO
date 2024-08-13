package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {		
	
	WebDriver driver;	
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy (name="accountname")
    private WebElement orgNameEdt;
    
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
    
    @FindBy(name="industry")
    WebElement Industry;
    
    @FindBy(name="phone")
    WebElement Phone;
    
    @FindBy(name="email1")
    WebElement Email;
    
    public WebElement getsaveBtn() {
    	return saveBtn;
    }
    public WebElement getorgNameEdt() {
    	return orgNameEdt;
    }
    public void createOrg(String orgName) {
    	orgNameEdt.sendKeys(orgName);
    	saveBtn.click();
    }
    
    
}
