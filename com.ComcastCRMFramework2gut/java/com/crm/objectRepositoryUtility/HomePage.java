package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="query_string")
	private WebElement Search;
    
	@FindBy(linkText="Organizations")
	private WebElement OrgLink;
	
	@FindBy(linkText = "contact")
	private WebElement  contactlnk;
	
	@FindBy(linkText = "More")
	private WebElement  Morelnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement  Campaignlnk;
	
	@FindBy(xpath = "img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@FindBy(linkText = "SingOut")
	private WebElement  SingOutlnk;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;

	public WebElement getSearch() {
		return Search;
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getMorelnk() {
		return Morelnk;
	}

	public WebElement getCampaignlnk() {
		return Campaignlnk;
	}
	public void getOrgLink(WebElement orgLink) {
		this.OrgLink = orgLink;
	}
     

	//
	public void navigateToCampaignPage() {
		Actions act = new Actions(driver);
		act.moveToElement(Morelnk).perform();
		Campaignlnk.click();		
	}
	public void logout(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		SingOutlnk.click();
	}
	public void createOrgnization(WebDriver driver) {
	hp.getOrgnization().click();
	}
	
} 

