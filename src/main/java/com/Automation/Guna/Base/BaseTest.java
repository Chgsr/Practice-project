package com.Automation.Guna.Base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Automation.CustomisedExceptions.FrameWorkExceptions;
import com.Automation.Utilities.ScreenshotUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;

public class BaseTest {
	private static WebDriver driver;
	private static String CurrentDirectory;
	private static com.relevantcodes.extentreports.ExtentReports Extentreports;
	private static ExtentTest extenttest;
	private static String Name;

	

	public void Initialization() {

		CurrentDirectory = System.getProperty("user.dir");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Parameters("Browsername")
	@BeforeSuite
	public void OpenBrowser(@Optional("chrome") String Browsername) {

		CurrentDirectory = System.getProperty("user.dir");

		if (Browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Initialization();
		} else if (Browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Initialization();
		} else if (Browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			Initialization();
		} else if (Browsername.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			Initialization();
		}

	}

	@AfterSuite
	public void Closebrowser() throws FrameWorkExceptions {

		if (driver != null) {
			driver.quit();
		} else {
			FrameWorkExceptions FW = new FrameWorkExceptions("Driver is not closed");
			throw FW;
		}

	}

	@BeforeMethod
	public void Beforemethod(Method method) {
		String Mname = method.getName();
		System.out.println("Test case Execution is Started: " + Mname);
		extenttest = Extentreports.startTest(Mname);
		extenttest.log(LogStatus.PASS, "Test Case Execution Started: " + Mname);

	}

	@AfterMethod
	public void Aftermethod(ITestResult Result) throws IOException {
		Name = Result.getName();
		if (Result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Test case Is Passed: " + Name);
			extenttest.log(LogStatus.PASS, "Test Case Execution Passed: " + Name);
			ScreenshotUtility.Takescreenshot(Name);
			
		} else if (Result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test case is Failed and Taking Screenshot: " + Name);
			extenttest.log(LogStatus.FAIL, "Test Case Execution Failed: " + Name);
			ScreenshotUtility.Takescreenshot(Name);
			
		} else if (Result.getStatus() == ITestResult.SKIP) {
			System.out.println("Test case is Skipped and Taking Screenshot: " + Name);
			extenttest.log(LogStatus.SKIP, "Test Case Execution Skipped: " + Name);
			ScreenshotUtility.Takescreenshot(Name);
			
		}
		Extentreports.endTest(extenttest);
		Extentreports.flush();
	}

	@BeforeTest
	public void BeforeTest() {

		Extentreports = new ExtentReports(CurrentDirectory + "\\Reports\\reports.html");
		Map<String, String> map = new HashMap<>();
		map.put("user", "C H Gunashekar Reddy");
		map.put("Phone Num", "9392705090");
		Extentreports.addSystemInfo(map);
	}

	@AfterTest
	public void AfterTest() throws FrameWorkExceptions {

		if(Extentreports!=null)
		{
			Extentreports.close();
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getCurrentDirectory() {
		return CurrentDirectory;
	}
	public static ExtentTest getExtenttest() {
		return extenttest;
	}
	public static String getName() {
		return Name;
	}

}
