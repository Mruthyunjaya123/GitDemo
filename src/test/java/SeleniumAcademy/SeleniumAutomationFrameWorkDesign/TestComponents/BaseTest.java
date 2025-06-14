package SeleniumAcademy.SeleniumAutomationFrameWorkDesign.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.LandingPage;

public class BaseTest {
      
	public WebDriver driver;
	public LandingPage landingPage;
 	public WebDriver initializaDriver() throws IOException
 	
 	{
 		Properties prop=new Properties();
 		FileInputStream fis=new FileInputStream("C:\\Users\\Dell\\Documents\\Seleniumcodeexecution\\SeleniumAutomationFrameWorkDesign\\src\\main\\java\\Resources\\GlobalData.properties");
 		prop.load(fis);
 		
 		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
 		
 		//String browerName=prop.getProperty("browser");
 		
 		if(browserName.contains("chrome"))
 		{
 			ChromeOptions options=new ChromeOptions();
 			if(browserName.contains("headless"))
 			{
 			options.addArguments("headless");
 			}
 			driver=new ChromeDriver(options);
 			
 			//driver=new ChromeDriver();
 		}
 		
 		else if(browserName.equalsIgnoreCase("firefox"))
 		{
 			driver=new FirefoxDriver();
 		}
 		
 		else if(browserName.equalsIgnoreCase("edge"))
 		{
 			driver=new EdgeDriver();
 		}
 		 
 		    driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 		  return driver;
 	
 	}

 	@BeforeMethod(alwaysRun = true)
 	public LandingPage launchAppilcation() throws IOException
 	{
 		 driver=initializaDriver();
 		 landingPage=new LandingPage(driver);
 	     landingPage.goToURL();
 	     return landingPage;
 	}	
 	
 	
 	@AfterMethod(alwaysRun = true)
 	public void teardown()
 	{
 		
 		 driver.close();
 		
 		
 	}
 	
 	public  List<HashMap<String, String>>  getJsonDataToMap(String filepath) throws IOException
	{
		//read json to String
	
		
		String jsonContent = FileUtils.readFileToString(
			    new File(filepath),
			    StandardCharsets.UTF_8);
		
		
	  // String to Hash Map
	  
	  ObjectMapper mapper=new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
		  
	  });
	  return data;
	}
 	
 	public String getScreenshot(String testcasename, WebDriver driver) throws IOException
 	{
 		TakesScreenshot ts=(TakesScreenshot)driver;
 		File srcfile=ts.getScreenshotAs(OutputType.FILE);
 		File file=new File(System.getProperty("user.dir")+"//repots//"+ testcasename + ".png");
 		FileUtils.copyFile(srcfile, file);
 		return System.getProperty("user.dir") + "//repots//"+ testcasename + ".png";
 		
 	}
 	
 	
}
