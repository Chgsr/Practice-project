package com.Automation.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Automation.Guna.Base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class Laptop_Notebooks_Page extends BaseTest {
	
	@FindBy(xpath = "//div[@class='row']//h4/a")
	private static  List<WebElement>  AllLaptops;
	
	@FindBy(xpath = "//div[@class='row']//h4/a[text()='HP LP3065']")
	private static WebElement HPLaptop;
	
	static
	{
		PageFactory.initElements(getDriver(), Laptop_Notebooks_Page.class);
	}
	
	
	public static List<String> ShowallLaptops() {

		List<String> Alllaptops= new ArrayList<>();
		WebDriverWait wait= new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(AllLaptops));
		
		for(WebElement element:AllLaptops)
		{
			String LaptopName=element.getText();
			Alllaptops.add(LaptopName);
			getExtenttest().log(LogStatus.PASS, "Available Laptops are: "+LaptopName);
		}
		getExtenttest().log(LogStatus.PASS, "All Available Laptops are: "+Alllaptops);
		return Alllaptops;
	}
	
	public static void Select_HPLaptop() {

		if(HPLaptop.isEnabled()&HPLaptop.isDisplayed())
		{
			HPLaptop.click();
			getExtenttest().log(LogStatus.PASS, "Selected HP LP3065 Laptop ");
			
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL,"HP LP3065 is Disabled");
		}
	}

}
