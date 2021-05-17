package com.Automation.Supporters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Automation.CustomisedExceptions.FrameWorkExceptions;

public class ExcelReader {
	
	private String filepath;
	private FileInputStream FIP;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	private String CellValue;
	
	public ExcelReader(String filepath) throws EncryptedDocumentException, IOException {
		this.filepath=filepath;
		FIP= new FileInputStream(filepath);
		workbook= WorkbookFactory.create(FIP);
	}
	
	public Sheet GetsheetObj(String How, String Value) throws FrameWorkExceptions {
		
		if(workbook!=null)
		{
			if(How.equalsIgnoreCase("Sheetname"))
			{
				sheet= workbook.getSheet(Value);
			}
			else if(How.equalsIgnoreCase("Index"))
			{
				int sheetindex=Integer.parseInt(Value);
				sheet=workbook.getSheetAt(sheetindex);
			}
		}
		else
		{
			FrameWorkExceptions FE= new FrameWorkExceptions("Excel file is Null");
			throw FE;
		}
		return sheet;
	}
	
	public String GetCellValue(String How, String Value, int RowNum, int CellNum) throws FrameWorkExceptions {

		sheet=GetsheetObj(How, Value);
		if(sheet!=null)
		{
			row= sheet.getRow(RowNum);
			if(row!=null)
			{
			 cell= row.getCell(CellNum);
			 if(cell!=null)
			 {
				 if(cell.getCellType()==CellType.STRING)
				 {
					CellValue= cell.getStringCellValue();
				 }
				 else if(cell.getCellType()==CellType.NUMERIC)
				 {
					 CellValue=cell.getNumericCellValue()+"";
				 }
				 else if(cell.getCellType()==CellType.BOOLEAN)
				 {
					CellValue= cell.getBooleanCellValue()+"";
				 }
			 }
			}
		}
		return CellValue;
	}
	
	public List<String> GetrowData(String How, String Value, int RowNum) throws FrameWorkExceptions {

		List<String> Rowdata= new ArrayList<>();
		sheet=GetsheetObj(How, Value);
		if(sheet!=null)
		{
			row=sheet.getRow(RowNum);
			if(row!=null)
			{
				for(int i=0;i<=row.getLastCellNum(); i++)
				{
					cell=row.getCell(i);
					if(cell!=null)
					{
					if(cell.getCellType()==CellType.STRING)
					 {
						CellValue= cell.getStringCellValue();
						Rowdata.add(CellValue);
					 }
					 else if(cell.getCellType()==CellType.NUMERIC)
					 {
						 CellValue=cell.getNumericCellValue()+"";
						 Rowdata.add(CellValue);
					 }
					 else if(cell.getCellType()==CellType.BOOLEAN)
					 {
						CellValue= cell.getBooleanCellValue()+"";
						Rowdata.add(CellValue);
					 }
					}
				}
			}
		}
		return Rowdata;
	}
	
	public List<String> GetSheetData(String How, String Value) throws FrameWorkExceptions {

		sheet=GetsheetObj(How, Value);
		List<String> Sheetdata= new ArrayList<String>();
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			row=sheet.getRow(i);
			if(row!=null)
			{
				for(int j=0; j<=row.getLastCellNum(); j++)
				{
					cell=row.getCell(j);
					if(cell!=null)
					{
						if(cell.getCellType()==CellType.STRING)
						 {
							CellValue= cell.getStringCellValue();
							Sheetdata.add(CellValue);
						 }
						 else if(cell.getCellType()==CellType.NUMERIC)
						 {
							 CellValue=cell.getNumericCellValue()+"";
							 Sheetdata.add(CellValue);
						 }
						 else if(cell.getCellType()==CellType.BOOLEAN)
						 {
							CellValue= cell.getBooleanCellValue()+"";
							Sheetdata.add(CellValue);
						 }
					}
				}
			}
		}
		return Sheetdata;
		
	}
	

}
