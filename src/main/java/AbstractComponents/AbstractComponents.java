package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
    
	WebDriver driver;
    public AbstractComponents(WebDriver driver) 
    
    {
		this.driver=driver;
		PageFactory.initElements(driver, this);
    	
	}
    
    @FindBy(css="button[routerlink*=cart]")
    WebElement cartHeader;
    
    
	public void waitForElementToAppear(By findBy)
    {
    	
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    
	public void waitForElementToAppear(WebElement findBy)
    {
    	
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }
	
	
	public void waitForElementToDisAppear(WebElement ele)
    {
    	
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }
	
	
	public void goToCartPage()
	{
		cartHeader.click();
	}

}
