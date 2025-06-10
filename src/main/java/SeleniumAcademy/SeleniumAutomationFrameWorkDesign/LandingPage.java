package SeleniumAcademy.SeleniumAutomationFrameWorkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;


public class LandingPage extends AbstractComponents {
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{   super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
    
    
    @FindBy(id="userEmail")
    WebElement UserMailId;
    
    @FindBy(id="userPassword")
    WebElement Password;
    
    @FindBy(id="login")
    WebElement Submit;
    
    @FindBy(css="[class*='flyInOut']") //Need to update this one 
    WebElement errorMessage;
    
	
   
    
    public void loginApplication(String email, String password)
    {
    	UserMailId.sendKeys(email);
    	Password.sendKeys(password);
    	Submit.click();
    	
    }
    
    
    
    
    
    
    public void goToURL()
    {
    	driver.get("https://rahulshettyacademy.com/client");
    }
    
    public String GetErrorMessage()
    
    {
    return errorMessage.getText();
    	
    	
    }

    
}




