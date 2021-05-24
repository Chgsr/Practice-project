package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Guna.Base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProductPage extends BaseTest {
	
	@FindBy(id = "input-quantity")
	private static WebElement Quantity;
	
	@FindBy(xpath = "//button[@class='btn btn-default']/i[@class='fa fa-calendar']")
	private static WebElement Deliverydate;
	
	static
	{
		PageFactory.initElements(getDriver(), ProductPage.class);
	}
	
	public static void CheckDefaultQuantity() {

		String DQuan=Quantity.getAttribute("value");
		if(DQuan.equalsIgnoreCase("1"))
		{
		getExtenttest().log(LogStatus.PASS, "Default Quantity is: "+DQuan);
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, "Default Quantity is not 1 ");
		}
	}
	
	public static void EnterQuantity(String Enterquantity) {

		Quantity.clear();
		Quantity.sendKeys(Enterquantity);
		getExtenttest().log(LogStatus.PASS, "Quantity Entered as 3");
		
	}
	
	public static void Select_Deliverydate()
	{
		if(Deliverydate.isEnabled()&Deliverydate.isDisplayed())
		{
			Deliverydate.click();
		}
	}
	

}
