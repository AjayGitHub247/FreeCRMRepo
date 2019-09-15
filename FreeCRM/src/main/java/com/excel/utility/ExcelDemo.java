package com.excel.utility;

import java.util.regex.Pattern;

public class ExcelDemo {

	public static void main(String[] args) {
		
		String projectpath = System.getProperty("user.dir");	
		projectpath = projectpath.replaceAll(Pattern.quote("\\"), "/");		
		String finalPath = projectpath + "/Excel/LoginData.xlsx";
		
		System.out.println(finalPath);
		
		ExcelUtility excel = new ExcelUtility(finalPath, "Sheet1");	
		
		excel.getrowcount();
		excel.getcelldatastring(1, 0);
		excel.getcelldatanumber(1, 1);

	}

}
