package com.jira.utils;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qmetry.qaf.automation.util.Reporter;

public class Commons {
	
	/*public Map<String, String> getAsSeperateLogs() {
		Map<String,String> data=new TreeMap<String,String>();
		
		return data;
	}*/

	public static Map<String, Map<String,String>> getExcelLogData(String fileName,String sheetName) {
		Map<String, Map<String,String>> data=new TreeMap<String,Map<String,String>>();
		try{
			XSSFWorkbook workbook=new XSSFWorkbook(new File(fileName));
			XSSFSheet sh=workbook.getSheet(sheetName);
			for(int i=1;i<sh.getPhysicalNumberOfRows();i++) {				
				Row row=sh.getRow(i);
				Map<String, String> logs=new TreeMap<String, String>();
				for(int j=0;j<row.getPhysicalNumberOfCells();j++) {					
					if(!row.getCell(j).getStringCellValue().isEmpty()){
						String rowHeader=sh.getRow(0).getCell(j).getStringCellValue();
						String logCellValue=row.getCell(j).getStringCellValue();					
						logs.put(rowHeader, logCellValue);
					}
					/*if(j==0) {
						logs.put("timeSpent", row.getCell(j).getStringCellValue());
					}
					if(j==1) {
						logs.put("dateAndTime", row.getCell(j).getStringCellValue());
					}
					if(j==2) {
						logs.put("workDescription", row.getCell(j).getStringCellValue());
					}*/
				}
				data.put("row"+i, logs);
			}
		}catch(Exception e) {
			Reporter.log(e.getMessage());
		}
		
		return data;
	}
	
}
