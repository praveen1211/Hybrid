package operations;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import extentreports.extentReport;

public class UIoperations extends extentReport {

	WebDriver driver;
	public UIoperations(WebDriver driver){
		this.driver = driver;
	}
	public void perform(Properties p,String operation,String objectName,String objectType,String value) throws Exception{
		System.out.println("");try{
		switch (operation.toUpperCase()) {
		case "CLICK":
			//Perform click
			driver.findElement(this.getObject(p,objectName,objectType)).click();
			Thread.sleep(500);
			test.log(LogStatus.PASS, "Clicking operation is working fine");
			break;
		case "SETTEXT":
			//Set text on control
			driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
			Thread.sleep(500);
			test.log(LogStatus.PASS, "SETTEXT operation is working fine");
			break;
			
		case "GOTOURL":
			//Get url of application
			driver.get(p.getProperty(value));
			Thread.sleep(500);
			test.log(LogStatus.PASS, "GOTOURL operation is working fine");
			break;
		case "GETTEXT":
			//Get text of an element
			driver.findElement(this.getObject(p,objectName,objectType)).getText();
			Thread.sleep(500);
			test.log(LogStatus.PASS, "GETTEXT operation is working fine");
			break;
		case "SLEEP" :
			float changeToFloat=Float.parseFloat(value);
			int changeToInt=(int) changeToFloat;
			Thread.sleep(changeToInt);
			test.log(LogStatus.PASS, "SLEEP operation is working fine");
		default:
			break;
		}
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Failed");
			e.printStackTrace();
		}
	}
	
	/**
	 * Find element BY using object type and value
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	private By getObject(Properties p,String objectName,String objectType) throws Exception{
		//Find by xpath
		if(objectType.equalsIgnoreCase("XPATH")){
			
			return By.xpath(p.getProperty(objectName));
		}
		//find by class
		else if(objectType.equalsIgnoreCase("CLASSNAME")){
			
			return By.className(p.getProperty(objectName));
			
		}
		//find by name
		else if(objectType.equalsIgnoreCase("NAME")){
			
			return By.name(p.getProperty(objectName));
			
		}
		//Find by css
		else if(objectType.equalsIgnoreCase("CSS")){
			
			return By.cssSelector(p.getProperty(objectName));
			
		}
		//find by link
		else if(objectType.equalsIgnoreCase("LINK")){
			
			return By.linkText(p.getProperty(objectName));
			
		}
		//find by partial link
		else if(objectType.equalsIgnoreCase("PARTIALLINK")){
			
			return By.partialLinkText(p.getProperty(objectName));
			
		}else
		{
			throw new Exception("Wrong object type");
		}
	}
	public void demand(WebElement element,String step,String any,String result) throws Exception{			// report and screenshot purpose
		ScreenshotPage sc=new ScreenshotPage(driver, new Timing().timeform());
		String img = test.addScreenCapture(sc.imagepath);
		AShot a=new AShot();
		Screenshot screen=a.takeScreenshot(driver, element);
		String sub="D:\\screen\\element "+new Timing().timeform()+".png";
		ImageIO.write(screen.getImage(), "PNG", new File(sub));
		String subimg = test.addScreenCapture(sub);
		switch(result.toUpperCase()){
		case "PASS":
			test.log(LogStatus.PASS, step, any+" The page screenshot: \n"+img +"\n"+subimg);
		break;
		case "FAIL":
			test.log(LogStatus.FAIL, step, any+" The page screenshot: \n"+img +"\n"+subimg);
		break;
		case "WARNING":
			test.log(LogStatus.WARNING, step, any+" The page screenshot: \n"+img +"\n"+subimg);
		break;
		case "INFO":
			test.log(LogStatus.INFO, step, any+" The page screenshot: \n"+img +"\n"+subimg);
		break;
		}
}

}
