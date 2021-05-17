package com.Automation.Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.CustomisedExceptions.FrameWorkExceptions;
import com.Automation.Guna.Base.BaseTest;
import com.Automation.Utilities.POJO_Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Registration extends BaseTest {
	
	@FindBy(id = "input-firstname")
	private static WebElement Firstname;
	
	@FindBy(id = "input-lastname")
	private static WebElement lastname;
	
	@FindBy(id = "input-email")
	private static WebElement Email;
	
	@FindBy(id = "input-telephone")
	private static WebElement Telephone;
	
	@FindBy(id = "input-password")
	private static WebElement Password;
	
	@FindBy(id = "input-confirm")
	private static WebElement ConfirmPassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	private static WebElement Agree_PrivacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private static WebElement Continue;
	
	@FindBy(linkText = "Success")
	private static WebElement Validate_Sucess;
	
	static
	{
		PageFactory.initElements(getDriver(), Registration.class);
	}
	
	
	
	public static void Entercredentials() throws  FrameWorkExceptions, IOException {

		Firstname.clear();
		String firstname=POJO_Utility.GetExcel().GetCellValue("index","0" , 5, 0);
		Firstname.sendKeys(firstname);
		getExtenttest().log(LogStatus.PASS, "Firstname entered as : "+firstname);
		lastname.clear();
		String Lastname = POJO_Utility.GetExcel().GetCellValue("index", "0", 5, 1);
		lastname.sendKeys(Lastname);
		getExtenttest().log(LogStatus.PASS, "Lastname entered as : "+Lastname);
		Email.clear();
		String email = POJO_Utility.GetExcel().GetCellValue("index", "0", 5, 2);
		Email.sendKeys(System.currentTimeMillis()+email);
		getExtenttest().log(LogStatus.PASS, "Email entered as : "+email);
		Telephone.clear();
		String telephone= POJO_Utility.GetExcel().GetCellValue("index", "0", 5, 3);
		Telephone.sendKeys(telephone);
		getExtenttest().log(LogStatus.PASS, "Telephone entgered as : "+telephone);
		Password.clear();
		String password = POJO_Utility.GetExcel().GetCellValue("index", "0", 5, 4);
		Password.sendKeys(password);
		getExtenttest().log(LogStatus.PASS, "Password entered as : "+password);
		ConfirmPassword.clear();
		String Cpass= POJO_Utility.GetExcel().GetCellValue("index", "0", 5, 4);
		ConfirmPassword.sendKeys(Cpass);
		getExtenttest().log(LogStatus.PASS, "Confirm Password entered as : "+Cpass);
		
	}
	
	public static void Click_Agree() {

		if(Agree_PrivacyPolicy.isEnabled()&Agree_PrivacyPolicy.isDisplayed())
		{
			Agree_PrivacyPolicy.click();
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, "Privacy Policy button is disabled");
		}
	}
	
	public static void Click_Continue()
	{
		if(Continue.isEnabled()&Continue.isDisplayed())
		{
			Continue.click();
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, "Continue button is disabled");
		}
	}
	
	public static void Validate_AccountCreation() {

		if(Validate_Sucess.isEnabled()&Validate_Sucess.isDisplayed())
		{
			getExtenttest().log(LogStatus.PASS, "Account Registered Successfully");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, "Account Not Registered");
		}
	}

}
