package com.mycompany.app;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {

//Declare variables to access ExcelFile
public static XSSFWorkbook ExcelWorkbook;
public static XSSFSheet ExcelWSheet;
public XSSFCell ExcelCell;
public static XSSFRow ExcelRow;

  //Location of Excel File
public static String filename_path="Employee_Data.xlsx";

   //Testcase 1 to read data having first priority
  @Test(priority=0)
  public void Read_Data() throws IOException {
	  //Create an object of FileInputStream class to read excel file
	  FileInputStream ExcelFile = new FileInputStream(filename_path);
	  //create object of XSSFWorkbook class
	  ExcelWorkbook = new XSSFWorkbook(ExcelFile);
	  //Selecting Sheet1 from Workbook
	  ExcelWSheet = ExcelWorkbook.getSheet("Sheet1"); 
	  
  }

  //Testcase 1 to print data having first priority
  @Test(priority=1)
  public void Print_Data() {
	  //Find number of rows in excel sheet
	  int rowCount= ExcelWSheet.getLastRowNum() -ExcelWSheet.getFirstRowNum();
		  //Create a loop to read rows
		 for (int i = 0; i < rowCount+1; i++) {
			 //Read a row at i position
			 ExcelRow = ExcelWSheet.getRow(i);
			 
		        //Create a loop to print cell values in a row
		        for (int j = 0; j < ExcelRow.getLastCellNum(); j++) {
		            //Print Excel data in console
		            System.out.print(ExcelRow.getCell(j)+" | ");
	        }
	        System.out.println();
		 }  
  }
  
}
  
