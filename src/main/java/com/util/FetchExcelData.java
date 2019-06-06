package com.util;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchExcelData
{
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileInputStream fileInputStream;
	public static Properties properties;
	public static Object[][] getData(String sheetName)
	{
		try
		{
			
			fileInputStream = new FileInputStream("src/test/resources/CRMData.xlsx");
			workbook = new XSSFWorkbook(fileInputStream);
			
			sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			System.out.println("Properties File Not Found");
		}

		int total_Row = sheet.getLastRowNum();
		int total_columns = sheet.getRow(0).getLastCellNum();
		
		
		
		Object[][] data = new Object[total_Row][total_columns];
		
		for(int i=0;i<total_Row;i++)
		{
			
			
			for(int j=0;j<total_columns;j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
			
		}
		return data;
	}
	
}




