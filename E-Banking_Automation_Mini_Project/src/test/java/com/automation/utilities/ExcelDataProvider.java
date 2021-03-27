package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider() throws Exception {
	
		File src=new File(".\\TestData\\TestData.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		try {
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			System.out.println("Enable to read Excel File"+e.getMessage());
		}
	}
		public String getStringData(int sheetIndex, int row, int column) {
		
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	
	
	public String getStringData(String sheetName, int row, int column) {
		
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	public double getNumericData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	// to be continued 17:00 sec 
	
}
