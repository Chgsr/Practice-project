package com.Automation.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Automation.Guna.Base.BaseTest;



public interface ScreenshotUtility {
	
	public static void Takescreenshot(String Name) throws IOException
	{
		TakesScreenshot screenshot= (TakesScreenshot) BaseTest.getDriver();
		File Img=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Img, new File(BaseTest.getCurrentDirectory()+"\\Screenshots\\"+Name+".jpeg"));
	}
	
	public static String Takescreenshot() throws IOException {
		
		TakesScreenshot screenshot= (TakesScreenshot) BaseTest.getDriver();
		 File Img=screenshot.getScreenshotAs(OutputType.FILE);
		String dstfile= BaseTest.getCurrentDirectory()+"\\Screenshots\\"+BaseTest.getName()+".jpeg";
		FileUtils.copyFile(Img, new File(dstfile));
		return dstfile;
	}

}
