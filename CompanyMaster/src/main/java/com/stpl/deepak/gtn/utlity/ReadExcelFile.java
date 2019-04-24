package com.stpl.deepak.gtn.utlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	private XSSFWorkbook workBook;
	private XSSFSheet sheet;
	
	public ReadExcelFile(String excelPath) {
		File src=new File(excelPath);
		try {
			FileInputStream fileInputStr = new FileInputStream(src);
			try {
				this.workBook = new XSSFWorkbook(fileInputStr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getData( int sheetNo, int row, int column) {
		sheet = workBook.getSheetAt(sheetNo);
		
		// LAst cell no of a particular row
		// sheet.getRow(row).getLastCellNum();
		return sheet.getRow(row).getCell(column).getStringCellValue();
	}
	
	public int getRowCount(int sheetIndex) {
		return (workBook.getSheetAt(sheetIndex).getLastRowNum() + 1);
	}
	
	/*public int getColumnCount(int row) {
		System.out.println(sheet.getRow(row));
		// return sheet.getRow(row).getLastCellNum()+1;
		return 1;
	}*/
	
	public int noOfWorkSheet() {
		return workBook.getNumberOfSheets();
	}

}
