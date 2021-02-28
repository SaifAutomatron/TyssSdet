package com.crm.vtiger.genericutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Saif
 *
 */
public class ExcelUtility {
	
	String filepath=PathConst.EXCELPATH;
	
	/**
	 * returns string data from excel file
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return String excel data
	 * @throws Throwable
	 */
	public String getStringExcelData(String sheetName,int rowNum,int colNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		wb.close();
		
		return row.getCell(colNum).getStringCellValue();
		
	}
	/**
	 * returns numeric data from excel file
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return Numeric excel data
	 * @throws Throwable
	 */
	public double getNumericExcelData(String sheetName,int rowNum,int colNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		wb.close();
		
		
		return row.getCell(colNum).getNumericCellValue();
		
	}
	/**
	 * returns date excel data from excel file
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return Date excel data
	 * @throws Throwable
	 */
	public Date getDateExcelData(String sheetName,int rowNum,int colNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		wb.close();
		
		return row.getCell(colNum).getDateCellValue();
	}
	/**
	 * write data into excel file
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @param data to write in excel file
	 * @throws Throwable
	 */
	public void setExcelData(String sheetName,int rowNum,int colNum,String data) throws Throwable
	{
		File file=new File(filepath);
		FileInputStream fis=new FileInputStream(file);
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cl=row.createCell(colNum);
		
		cl.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		
		
		wb.close();
		
	
		
	}
/**
 * returns number of rows occupied in excel sheet
 * @param sheetName
 * @return Numeric Excel data
 * @throws Throwable
 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		
		return sh.getLastRowNum();
		
	}
}
