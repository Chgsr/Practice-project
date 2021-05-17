package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Guna.Base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class HeadersSection extends BaseTest{
	
	@FindBy(xpath = "//span[text()='My Account']")
	private static WebElement MyAccount;
	
	@FindBy(linkText = "Register")
	private static WebElement Register;
	
	@FindBy(linkText = "Login")
	private static WebElement Login;
	
	static
	{
		PageFactory.initElements(getDriver(), HeadersSection.class);
	}
	
	public static void Click_MyAccount() {

		if(MyAccount.isDisplayed()&&MyAccount.isEnabled())
		{
			MyAccount.click();
			getExtenttest().log(LogStatus.PASS, "Clicked On My Account Button");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, "MyAccount Button is not Displayed");
			
		}
	}
	
	public static void Click_Register() {

		if(Register.isEnabled()&Register.isDisplayed())
		{
			Register.click();
			getExtenttest().log(LogStatus.PASS, "Clicked On Register Button");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, "Register Button is not Displayed");
		}
	}
	
	public static void Click_Login() {

		if(Login.isEnabled()&Login.isDisplayed())
		{
			Login.click();
			getExtenttest().log(LogStatus.PASS, "Clicked On Login Button");
			
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, "Register Button is not Displayed");
		}
	}

}
