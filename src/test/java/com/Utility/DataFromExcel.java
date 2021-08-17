package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFromExcel {
	public static File src;																																							//THIS WILL CREATE A FILE
	public static String inputFilePath = "C:\\Users\\pawan\\eclipse-workspace\\AxisBankProject\\src\\test\\java\\com\\ExcelUtils\\AxisBank.xls";		//THIS WILL STORE THE PATH OF THE INPUT EXCEL FILE INTO A STRING
	public static String inputSheetName = "Sheet1";																																	//THIS WILL STORE THE NAME OF THE EXCEL SHEET INTO A STRING
	
	//public static String outputFilePath = "G:\\Projects\\Main_Project_CognizantCheers_891172\\MainProject_CognizantCheers\\src\\test\\java\\com\\ExcelInputOutput\\OutputFile.xlsx";	//THIS WILL STORE THE PATH OF THE OUTPUT EXCEL FILE INTO A STRING
	
	public static FileInputStream fin;																//THIS WILL CREATE AN OBJECT OF THE CLASS FILEINPUTSTREAM	
	//public static FileOutputStream fout;
	public static XSSFWorkbook workbook;															//THIS WILL CREATE AN OBJECT OF THE CLASS XSSFWORKBOOK
	public static XSSFSheet sheet;																	//THIS WILL CREATE AN OBJECT OF THE CLASS XSSFSHEET
	public static XSSFRow row;																		//THIS WILL CREATE AN OBJECT OF THE CLASS XSSFROW
	public static XSSFCell cell;																	//THIS WILL CREATE AN OBJECT OF THE CLASS XSSFCELL
	
	
	public static String readCellData(int rowNum, int column) throws Exception {
		
		fin = new FileInputStream(inputFilePath);													//THIS WILL CREATE A NEW FILE INPUT STREAM TO FETCH DATA FROM THE FILEPATH
		workbook = new XSSFWorkbook(fin);															//THIS WILL CREATE A BLANK WORKBOOK CONNECTED TO THE INPUT STREAM
		sheet = workbook.getSheet(inputSheetName);													//THIS WILL NAVIGATE THE WORKBOOK TO THE REQUIRED SHEET OF THE EXCEL FILE
		row = sheet.getRow(rowNum);																	//THIS WILL SELECT THE FIRST ROW
		cell = row.getCell(column);																	//THIS WILL SELECT THE FIRST COLUMN
		
		String s1 = null;
		if(cell.getCellType() == CellType.STRING) {													//THIS WILL CHECK IF THE CELL CONTAINS A STRING
			s1 = cell.getStringCellValue();															//THIS WILL FETCH THE CELL VALUE INTO THE STRING S1
			workbook.close();																		//THIS WILL CLOSE THE WORKBOOK
			fin.close();																			//THIS WILL CLOSE THE INPUT STREAM
			
		}
		else if(cell.getCellType() == CellType.NUMERIC) {											//THIS WILL CHECK IF THE CELL CONTAINS A NUMERIC VALUE
			int v = (int)cell.getNumericCellValue();												//THIS WILL FETCH THE CELL VALUE AND TYPECAST IT
			s1 = String.valueOf(v);																	//THIS WILL CONVERT THE NUMERIC VALUE TO A STRING 
			workbook.close();																		//THIS WILL CLOSE THE WORKBOOK
			fin.close();																			//THIS WILL CLOSE THE INPUT STREAM
			
		}
		
		return s1;																					//THIS WILL RETURN THE STRING S1 CONTAINING THE CELL VALUE
		
	}
	

}
