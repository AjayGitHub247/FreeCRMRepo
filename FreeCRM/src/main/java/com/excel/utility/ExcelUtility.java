package com.excel.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtility(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			}catch(Exception exp) {
				System.out.println(exp.getMessage());
				System.out.println(exp.getCause());
				System.out.println(exp.getStackTrace());
			}	
		
	}
	
	public void getrowcount() {	
		try {
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of Rows :" + rowCount);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());
		}	
	}
	
	public void getcelldatastring(int rowNum, int colNum) {	
		try {
		String cellstringvalue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(cellstringvalue);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());
		}	
	}
	
	public void getcelldatanumber(int rowNum, int colNum) {	
		try {
		double cellNumericValue = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(cellNumericValue);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());
		}	
	}

}
