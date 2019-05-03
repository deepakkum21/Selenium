package com.stpl.deepak.gtn.companymaster;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.stpl.deepak.gtn.utlity.FindAction;
import com.stpl.deepak.gtn.utlity.FindPropertyType;
import com.stpl.deepak.gtn.utlity.ReadExcelFile;

public class AddCFPTest {
	private WebDriver chromeDriver;
	private ReadExcelFile readFile;
	private int noOfrows;
	private FindAction findAction = new FindAction();
	private FindPropertyType findProType = new FindPropertyType();
	private static final int TESTCASESHEETNO = 3;
	private int cfpAddRows;

	@BeforeSuite
	@Parameters("excelPath")
	public void getExcelFile(String excelPath) {
		readFile = new ReadExcelFile(excelPath);
		System.out.println("File read from :" + excelPath);
		noOfrows = readFile.getRowCount(TESTCASESHEETNO);
		System.out.println(noOfrows);
	}
}
