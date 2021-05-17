package com.Automation.Utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.Automation.Guna.Base.BaseTest;
import com.Automation.Supporters.ExcelReader;
import com.Automation.Supporters.PropertyReader;

public class POJO_Utility {
	
	private static String ConfPath= BaseTest.getCurrentDirectory()+"\\Config_Practice.properties";
	private static String Excelpath= BaseTest.getCurrentDirectory()+"\\src\\main\\java\\com\\Automation\\TestData\\Testdata.xlsx";
	
	public static PropertyReader GetConf() throws IOException {
		
		PropertyReader ORConf= new PropertyReader(ConfPath);
		return ORConf;

	}
	
	public static ExcelReader GetExcel() throws  IOException
	{
		ExcelReader Excel= new ExcelReader(Excelpath);
		return Excel;
	}

}
