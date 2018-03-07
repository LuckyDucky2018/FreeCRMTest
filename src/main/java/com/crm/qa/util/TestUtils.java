package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtils extends TestBase{
	
	public static long IMPLICIT_WAIT = 40;
	public static long PAGE_LOAD_TIMEOUT = 40;
	
	public static String filePath = "C:\\WorkspaceAssignments\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	public FileInputStream file;
	
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	
	public Object[][] getData(String sheetName){
		
		try {
			file = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		  
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
		for(int i = 0 ; i  < sheet.getLastRowNum(); i++){
			for(int j = 0 ; j < sheet.getRow(0).getLastCellNum() ; j++){
				
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		return data;
		
	}
	
	
	
}
