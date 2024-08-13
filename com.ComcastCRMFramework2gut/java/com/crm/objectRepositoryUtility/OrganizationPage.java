package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
     @FindBy(xpath="img[@alt='Create Organization...']")
     private WebElement CreateOrg;
   //
     @FindBy(id="dtlview_Organization Name")
     private WebElement OrgName;
     

	public WebElement getCreateOrg() {
		return CreateOrg;
	}

	public WebElement getOrgName() {
		return OrgName;
	}

}
