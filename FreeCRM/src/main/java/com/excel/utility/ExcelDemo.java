package com.excel.utility;

public class ExcelDemo {

	public static void main(String[] args) {
		
		String projectpath = System.getProperty("user.dir");
		String finalPath = projectpath + "/Excel/LoginData.xlsx";
		
		ExcelUtility excel = new ExcelUtility(finalPath, "Sheet1");	
		
		excel.getrowcount();
		excel.getcelldatastring(1, 0);
		excel.getcelldatanumber(1, 1);

	}

}
