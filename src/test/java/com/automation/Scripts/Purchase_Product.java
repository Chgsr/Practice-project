package com.automation.Scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Automation.CustomisedExceptions.FrameWorkExceptions;
import com.Automation.Guna.Base.BaseTest;
import com.Automation.Pages.HeadersSection;
import com.Automation.Pages.Laptop_Notebooks_Page;
import com.Automation.Pages.LoginPage;
import com.Automation.Pages.ProductPage;
import com.Automation.Utilities.POJO_Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Purchase_Product extends BaseTest {
	
	@Test
	public void Opencart_PurchaseProduct() throws FrameWorkExceptions, IOException {
		
		getExtenttest().log(LogStatus.PASS, "Browser Opened Successfully");
		getDriver().get(POJO_Utility.GetConf().GetPropertyValue("OpenCart_URL"));
		HeadersSection.Click_MyAccount();
		HeadersSection.Click_Login();
		LoginPage.Enter_Email_Password();
		LoginPage.Click_Login();
		LoginPage.validate_Login();
		HeadersSection.MouseOver_Laptop_Notebooks();
		HeadersSection.Click_AllLaptops_Notebooks();
		Laptop_Notebooks_Page.ShowallLaptops();
		Laptop_Notebooks_Page.Select_HPLaptop();
		ProductPage.CheckDefaultQuantity();
		ProductPage.EnterQuantity("3");
		
	}

}
