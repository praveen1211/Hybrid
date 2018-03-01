package datapackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class gettingdata
{
	  Properties p = new Properties();	  
	  
	  public Properties getObjectRepository() throws IOException
		{
			//Read object repository file
		  File f= new File("C:\\Users\\miracle\\workspace\\Hybrid-driven-framework\\src\\object.properties.txt");
		  FileInputStream fis = new FileInputStream(f);
		  Properties p= new Properties();
			//load all objects
			p.load(fis);
			 return p;
		}
		
}

  

