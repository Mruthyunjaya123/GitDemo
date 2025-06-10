package SeleniumAcademy.SeleniumAutomationFrameWorkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;


public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{   
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
    
    
    @FindBy(css=".mb-3")
    List<WebElement> Products;
    
    @FindBy(css=".ng-animating")
    WebElement spinner;
    
  
    
    
    
    
    By productBy=By.cssSelector(".mb-3");
    By addTocart=By.cssSelector(".card-body button:last-of-type");
    By toastMessage=By.cssSelector("#toast-container");
    public List<WebElement> getProductList()
    {
    	waitForElementToAppear(productBy);
    	return Products;
    	
    }
   
    public WebElement getProductByName(String productName)
    {
    	
    	WebElement prod= getProductList().stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    	return prod;
    }
    
    public void addProductToCart(String productName)
    {
    	WebElement prod=getProductByName(productName);
    	prod.findElement(addTocart).click();
    	waitForElementToAppear(toastMessage);
    	waitForElementToDisAppear(spinner);
    	
    	
    }
    
    
    
    
    
}




