package com.deepak.stpl.selenium; 	

import com.deepak.stpl.selenium.utlity.ReadExcelFile;

public class DDTUsingExcel {
	public static void main(String... args) {
		
	ReadExcelFile config =new ReadExcelFile("C:\\Users\\deepak\\Desktop\\Git\\Selenium\\Selenium\\SeleniumDemoPro\\src\\main\\resources\\excel\\credentials.xlsx");
	
	int rows =config.getRowCount(0);
	String[][] credentials = new String[rows][2];
	for(int row =0; row<rows;row++) {
		/*for (int col=0;col<config.getColumnCount(row);col++) {
			credentials[row][col]= 	config.getData(0, row, col);
			System.out.println(credentials[row][col]);
		}*/
		credentials[row][0]= 	config.getData(0, row, 0);
		credentials[row][1]= 	config.getData(0, row, 1);
		System.out.println(credentials[row][0]+ credentials[row][1]);
	}
	}

}
