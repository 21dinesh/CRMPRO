package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { 
	                  //rule1 create seprate java class
	                 
	WebDriver driver;
		
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")//rule2 object creation
	private WebElement usernameTexFld;
	
	@FindBy(name="user_password")
	private WebElement userPassword;
	
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	// Rule 4: Object Encapsulation
	
		//Rule 5: provide Action
	public WebElement getUsernameTexFld() {
		return usernameTexFld;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}	
	
	public void loginToapp(String url, String username, String Password){
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameTexFld.sendKeys(username);
		userPassword.sendKeys(Password);
		LoginBtn.click(); 
	}
	
}
