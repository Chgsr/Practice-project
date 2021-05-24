package com.Automation.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.CustomisedExceptions.FrameWorkExceptions;
import com.Automation.Guna.Base.BaseTest;
import com.Automation.Utilities.POJO_Utility;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends BaseTest {
	
	@FindBy(id = "input-email")
	private static WebElement Email;
	
	@FindBy(id = "input-password")
	private static WebElement Password;
	
	@FindBy(xpath  = "//input[@value='Login']")
	private static WebElement Login;
	
	@FindBy(xpath = "//h2[text()='My Account']")
	private static WebElement Login_Confirmation;
	
	static
	{
		PageFactory.initElements(getDriver(), LoginPage.class);
	}
	
	public static void Enter_Email_Password() throws FrameWorkExceptions, IOException {

		Email.clear();
		String email = POJO_Utility.GetExcel().GetCellValue("index", "0", 0, 0);
		Email.sendKeys(email);
		getExtenttest().log(LogStatus.PASS, "Entered Email as: "+email);
		Password.clear();
		String password= POJO_Utility.GetExcel().GetCellValue("index", "0", 0, 1);
		Password.sendKeys(password);
		getExtenttest().log(LogStatus.PASS, "Entered Password as: "+password);
		
	}
	
	public static void Click_Login() {

		if(Login.isEnabled()&Login.isDisplayed())
		{
			Login.click();
			getExtenttest().log(LogStatus.PASS, "Clicked On Login Button");
			
		}
	}
	
	public static void validate_Login() {

			if(Login_Confirmation.isEnabled()&Login_Confirmation.isDisplayed())
			{
				String LoginTest=Login_Confirmation.getText();
				if(LoginTest.equalsIgnoreCase("My Account"))
				{
					getExtenttest().log(LogStatus.PASS, "Successfully logged into the Opencart");
				}
				else
				{
					getExtenttest().log(LogStatus.FAIL, "Entered Email and Password are Not matched with records");
				}
			}
	}

}
