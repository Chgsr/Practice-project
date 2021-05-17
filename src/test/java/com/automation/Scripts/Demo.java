package com.automation.Scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Automation.CustomisedExceptions.FrameWorkExceptions;
import com.Automation.Guna.Base.BaseTest;
import com.Automation.Utilities.POJO_Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Demo extends BaseTest{
	
	
	
	@Test
	public void Demotest() throws FrameWorkExceptions, IOException {
		
		
		
		getExtenttest().log(LogStatus.PASS, "Browser Opened Successfully");
		getDriver().get(POJO_Utility.GetConf().GetPropertyValue("URL"));
		getExtenttest().log(LogStatus.PASS, "URL taken From Configuration file: "+POJO_Utility.GetConf().GetPropertyValue("URL"));
	}
	

}
