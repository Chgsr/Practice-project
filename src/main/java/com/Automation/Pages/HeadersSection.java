package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.CustomisedExceptions.FrameWorkExceptions;
import com.Automation.Guna.Base.ActionsTest;
import com.relevantcodes.extentreports.LogStatus;

public class HeadersSection extends ActionsTest{
	
	
	
	@FindBy(xpath = "//span[text()='My Account']")
	private static WebElement MyAccount;
	
	@FindBy(linkText = "Register")
	private static WebElement Register;
	
	@FindBy(linkText = "Login")
	private static WebElement Login;
	
	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	private static WebElement Laptop_Notebooks;
	
	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	private static WebElement ShowAll_Laptops_Notebooks;
	
	
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
	
	public static void MouseOver_Laptop_Notebooks() throws FrameWorkExceptions {

		if(Laptop_Notebooks.isEnabled()&Laptop_Notebooks.isDisplayed())
		{
			Laptop_Notebooks.click();
			getExtenttest().log(LogStatus.PASS, "Clicked On Laptop and Notebooks Button");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, "Laptop_Notebooks Button is not Displayed");
		}
	}
	
	public static void Click_AllLaptops_Notebooks() {

		if(ShowAll_Laptops_Notebooks.isEnabled()&ShowAll_Laptops_Notebooks.isDisplayed())
		{
			ShowAll_Laptops_Notebooks.click();
			getExtenttest().log(LogStatus.PASS, "Clicked On Show all laptops and Notebooks Button");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, "Show all Laptop_Notebooks Button is not Displayed");
		}
	}

}
