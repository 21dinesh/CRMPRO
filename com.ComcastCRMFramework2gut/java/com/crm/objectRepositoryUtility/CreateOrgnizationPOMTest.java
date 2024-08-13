package com.crm.objectRepositoryUtility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.generic.fileutility.ExcelUtility;
import com.generic.fileutility.FileUtility;
import com.generic.webdriverutility.JavaUtility;
import com.generic.webdriverutility.WebDriverUtility;

public class CreateOrgnizationPOMTest {
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib =new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		String orgName = eLib.getDataFromExcel("org", 4, 2)+ jLib.getRandomNumber();
		
		WebDriver driver=null;	
			
			if (BROWSER.equals("chrome")) {
				 driver = new ChromeDriver();
			}else if (BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			driver.get(URL);
	
	LoginPage lp = new LoginPage(driver);
	lp.loginToapp(USERNAME, PASSWORD);
	
	//step2 : navigate to org module  
	HomePage hp = new HomePage(driver);
	hp.getOrgLink().click();
	
	
	//step3 : click on "create orgnization" button

	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	cnop.createOrg(orgName);
	
	OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	//verify header msg expected reasult 
	String actOrgName= oip.getHeaderMsg().getText();
	if (actOrgName.contains(orgName)) {
		System.out.println(orgName + " PASS");	
	}else {
		System.out.println(orgName +"FAIL");
	}
     
	//step4 : enter all the details & create new ognization
	
	//verify header orgName info Expected Result
	//step5 : logout 
	hp.logout(driver);
	driver.quit();		
}
}