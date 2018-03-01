package excelreader;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readexcel 
{
  @Test
	  public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException
  {
			//To open the xlsx file
			File file =	new File("C:\\Users\\miracle\\workspace\\Hybrid-driven-framework\\TestCase.xlsx");
			
			//To read the excel file
			FileInputStream inputStream = new FileInputStream(file);
			
			Workbook Excel1 = null;
			
			//Checking the File extension 
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			
			//Checking the .xlsx file extension or not
			if(fileExtensionName.equals(".xlsx"))
			{
			 Excel1 = new XSSFWorkbook(inputStream);
			}
			
			//Checking the .xls file extension or not
			else if(fileExtensionName.equals(".xls"))
			{
				Excel1 = new HSSFWorkbook(inputStream);
			}
			
			//Reading the Excel file based on the sheets
			Sheet  guru99Sheet = Excel1.getSheet(sheetName);
			
			 return guru99Sheet;	
			}
		}


  

