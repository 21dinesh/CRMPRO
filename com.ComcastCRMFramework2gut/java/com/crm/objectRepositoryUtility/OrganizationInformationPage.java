package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver = driver;
				PageFactory.initElements(driver, this);
	}
	public WebElement getHeaderMsg() {
		return HeaderMsg;
	}

	public WebElement getPhone() {
		return Phone;
	}
	@FindBy (className="dvHeaderText")
    private WebElement HeaderMsg;
	
	@FindBy (id="dtlview_Phone")
	private WebElement Phone;
	

}
