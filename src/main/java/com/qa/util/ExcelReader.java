package com.qa.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String ExcelData(String Label, String Header) throws Exception {
		FileInputStream file = new FileInputStream("./src/test/resources/Datasheet1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("DevopsUniv");
		//workbook.getSheetAt(0);//index value
		int noofRows = sheet.getPhysicalNumberOfRows();
		int noofCols = sheet.getRow(0).getLastCellNum();
		//system.out.println(noofRows);
		//system.out.println(noofCols);
		String[] LabelValue = new String[noofRows];
		String[] HeaderValue = new String[noofCols];
		String val = null;
		for(int i=0; i<noofRows;i++) {
			LabelValue[i] = sheet.getRow(i).getCell(0).getStringCellValue();
			if(LabelValue[i].equalsIgnoreCase(Label)) {

				for(int j=0; j<noofCols;j++) {
					HeaderValue[j] = sheet.getRow(0).getCell(j).getStringCellValue();
					if(HeaderValue[j].equalsIgnoreCase(Header)) {
						val = sheet.getRow(i).getCell(j).getStringCellValue();
						break;
					}
				}
				break;


			}
		}
		return val;

	}
}


