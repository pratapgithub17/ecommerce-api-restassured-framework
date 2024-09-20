package com.ecom.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcel {
	
	private static XSSFWorkbook workbook;	
	private static XSSFSheet worksheet;
	private static String ExcelsheetPath;	
	private static FileInputStream	fis;
    static String CellValue;
		
		
			 public static String getData(String KeyValue, String sheetName) throws IOException
			 {
				
				
				 
				 ExcelsheetPath= "src/main/resources/TestData.xlsx";
					
				  File file= new File(ExcelsheetPath);
				  
							 fis=new FileInputStream(file);
							 workbook=new XSSFWorkbook(fis);
							
							int sheets=workbook.getNumberOfSheets();
							
							for(int i=0;i<sheets;i++)
							{
								if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
										{
								XSSFSheet worksheet=workbook.getSheetAt(i);
								
								//Identify Testcases coloum by scanning the entire 1st row
								
								 Iterator<Row>  rows= worksheet.iterator();// sheet is collection of rows
								Row firstrow= rows.next();
								Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
								int k=0;
								int KeyColoumnNum = 0;  // KeyColoumnNum is column number at key is present
								
			          while(ce.hasNext())
							   {
							      	Cell value=ce.next();
								
					if(value.getStringCellValue().equalsIgnoreCase(KeyValue))
						
								{
									KeyColoumnNum=k;
									
								}
								
								k++;
							}
																
							worksheet= workbook.getSheet(sheetName);
							
							int	rowcount =worksheet.getPhysicalNumberOfRows();
							
							for(int rowNumber=1; rowNumber<rowcount; rowNumber++) {     //Iterate row ++
								
								   CellValue=  worksheet.getRow(rowNumber).getCell(KeyColoumnNum).getStringCellValue();

								  
								//System.out.println(CellValue);

				}	
			}
	}
							return CellValue;
							
						
		
   }
			 	 
			 
			 
//				public static void getexceldata(String SheetName, int colNum) throws IOException {
//					
//			    	
//			    	
//					 
//					  ExcelsheetPath= "src/main/resources/TestData.xlsx";
//					
//					  File file= new File(ExcelsheetPath);
//				
//					   try {
//						   
//						       fis=new FileInputStream(file);
//						
//					} catch (FileNotFoundException e) {
//						
//						
//										e.printStackTrace();
//					}
//					  
//			
//					workbook =new XSSFWorkbook(fis);
//					
//					worksheet= workbook.getSheet(SheetName);
//					
//				int	rowcount =worksheet.getPhysicalNumberOfRows();
//				
//					for(int rowNumber=1; rowNumber<rowcount; rowNumber++) {
//						
//						String CellValue=  worksheet.getRow(rowNumber).getCell(colNum).getStringCellValue();
//
//						System.out.println(CellValue);
//
//					}
//					
//			}
			 
}
