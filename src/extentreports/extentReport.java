package extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class extentReport {
	protected static ExtentReports er1;
	protected static ExtentTest test,parent;
	protected static String folder;
	// for saving reports
	public extentReport(){
	folder="C:\\Users\\miracle\\workspace\\Hybrid-driven-framework\\Reports\\sample.html";
	er1= new ExtentReports(folder,true);
	}
	protected void information(){
		er1.addSystemInfo("Automation Tool","Selenium");
		er1.addSystemInfo("Framework","Hybrid Driven framework");
		er1.addSystemInfo("Created by","Praveen kumar reddy");
	}
	protected void endExtent(){
		// end test
        er1.endTest(test);
        
        // calling flush writes everything to the log file
        er1.flush();
	}

	protected void endParentExtent(){
		// end test
        er1.endTest(parent);
        
        // calling flush writes everything to the log file
        er1.flush();
	}

}
