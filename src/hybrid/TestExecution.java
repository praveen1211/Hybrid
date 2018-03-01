package hybrid;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import datapackage.gettingdata;
import excelreader.readexcel;
import extentreports.extentReport;
import operations.UIoperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class TestExecution extends extentReport
{
	WebDriver webdriver = null;
	
	@BeforeTest
	public void browser() 
	{
		
	webdriver=new FirefoxDriver();	
	webdriver.manage().window().maximize();
	}
	
	//report opening 
	@AfterTest
	public void result() throws InterruptedException
	{
		 
	      
		webdriver.navigate().to("file:///C:/Users/miracle/workspace/Hybrid-driven-framework/Reports/sample.html");
		Thread.sleep(6000);
		webdriver.close();
	}
	
    @Test(dataProvider="hybridData")
    
    @Parameters("browser")
    
  public void testLogin(String testcaseName,String keyword,String objectName,String objectType,String value) throws Exception 
    {
    	gettingdata object = new gettingdata();
       Properties allObjects =  object.getObjectRepository();
       
       if(objectName.equals("Y"))
    	    
       {
        	readexcel file = new readexcel();
        	Sheet firstSheet = file.readExcel(System.getProperty("C:\\Users\\miracle\\workspace\\Hybrid-driven-framework"), "TestCase.xlsx", testcaseName);
        	UIoperations operation = new UIoperations(webdriver);
        	
        	//getting the name of the test case
        	test=er1.startTest(testcaseName);
        	System.out.println(testcaseName);
        	
           String[][] obj=null;
    	   int rowCount = firstSheet.getLastRowNum();
    	   
        	obj = new String[rowCount][5];
        	
        for (int i=0;i<rowCount;i++) 
        	
     	{
    		//Loop over all the rows
    		Row row = firstSheet.getRow(i+1);
    		
    		//Create a loop to print cell values in a row
    		for(int j=0;j<row.getLastCellNum();j++)
    		{
    			//Print excel data in console
    			obj[i][j]=row.getCell(j).toString();
    			
    		}
    		operation.perform(allObjects, obj[i][1], obj[i][2],
					obj[i][3], obj[i][4]);
     	}
        
  }
       endExtent();
    }
    @DataProvider(name="hybridData")
   	public Object[][] getDataFromDataprovider() throws IOException
    {
       	Object[][] object = null;   
       	readexcel file = new readexcel();
       	Sheet firstSheet1 = file.readExcel(System.getProperty("C:\\Users\\miracle\\workspace\\Hybrid-driven-framework"), "TestCase.xlsx", "SCENARIOS");
       
      	int rowCount = firstSheet1.getLastRowNum();
       	
     	object = new Object[rowCount][5];
     	for (int i=0;i<rowCount;i++) 
     	{
     		
    		//Loop over all the rows
    		Row row = firstSheet1.getRow(i+1);
    		//Create a loop to print cell values in a row
    		for (int j=0;j<row.getLastCellNum();j++)
    		{
    			//Print excel data in console
    			object[i][j]=row.getCell(j).toString();
    				
    			
    		}
    	
     	}  
     	
     	System.out.print("");
    	
	return object;

    }
  
  }

