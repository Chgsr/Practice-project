package com.automation.Scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Automation.CustomisedExceptions.FrameWorkExceptions;
import com.Automation.Guna.Base.BaseTest;
import com.Automation.Pages.HeadersSection;
import com.Automation.Pages.Registration;
import com.Automation.Utilities.POJO_Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Opencart extends BaseTest {
	
	
	@Test
	public void Opencart_Registration() throws FrameWorkExceptions, IOException {

		getExtenttest().log(LogStatus.PASS, "Browser Opened Successfully");
		getDriver().get(POJO_Utility.GetConf().GetPropertyValue("OpenCart_URL"));
		getExtenttest().log(LogStatus.PASS, "Navigated to Opencart");
		HeadersSection.Click_MyAccount();
		HeadersSection.Click_Register();
		Registration.Entercredentials();
		Registration.Click_Agree();
		Registration.Click_Continue();
		
	}

}
