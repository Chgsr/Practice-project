package com.Automation.Guna.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Automation.CustomisedExceptions.FrameWorkExceptions;
import com.relevantcodes.extentreports.LogStatus;

public class ActionsTest extends BaseTest {
	
private static Actions actions;
	
	public static void Click(WebElement element) throws FrameWorkExceptions {

		if(element!=null)
		{
			element.click();
			getExtenttest().log(LogStatus.PASS, "Cliked on Webelement"+element);
		}
		else
		{
			FrameWorkExceptions FW = new FrameWorkExceptions("Element having Null Value");
			throw FW;
		}
		
	}
	
	public static void Actions_Click(WebElement element) throws FrameWorkExceptions {
		
		if(element!=null)
		{
			actions = new Actions(getDriver());
			actions.click(element).build().perform();
		}
		else
		{
			FrameWorkExceptions FW = new FrameWorkExceptions("Element having Null Value");
			throw FW;
		}
	}
	
	public static void DoubleClick(WebElement element) throws FrameWorkExceptions {

		if(element!=null)
		{
			actions.doubleClick(element).build().perform();
		}
		else
		{
			FrameWorkExceptions FW = new FrameWorkExceptions("Element having Null Value");
			throw FW;
		}
	}
	
	public static void RightClick(WebElement element) throws FrameWorkExceptions {
		
		if(element!=null)
		{
			actions.contextClick(element).build().perform();
		}
		else
		{
			FrameWorkExceptions FW = new FrameWorkExceptions("Element having Null Value");
			throw FW;
		}
	}
	
	public static void MovetoElement(WebElement element) throws FrameWorkExceptions
	{
		if(element!=null) {
		if(element.isDisplayed()&element.isEnabled())
		{
			actions.moveToElement(element);
		}
		else
		{
			FrameWorkExceptions FW = new FrameWorkExceptions("Element is disabled");
			throw FW;
		}
		}
	}
	

}
