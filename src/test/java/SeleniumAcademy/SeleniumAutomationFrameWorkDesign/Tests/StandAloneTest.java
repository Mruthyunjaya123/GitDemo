package SeleniumAcademy.SeleniumAutomationFrameWorkDesign.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
      
		String productName="ZARA COAT 3";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
	    driver.findElement(By.id("userEmail")).sendKeys("mruthyunjaya3t@gmail.com");
	    driver.findElement(By.id("userPassword")).sendKeys("Ashu@1994");
	    driver.findElement(By.id("login")).click();
	    
	    System.out.println("Git value 1 Updated");
	    System.out.println("Git value 2 Updated");
	    
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	    
	    List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	    
	  WebElement prod= products.stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	  System.out.println(prod);
	   //Thread.sleep(9000);
	    
	  
	   
	   
	
	   prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	   
	   //prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
	 
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	   wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	   
	   driver.findElement(By.cssSelector("button[routerlink*=cart]")).click();
	   
	   
	   List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	   Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	   Assert.assertTrue(match);
	   
	   driver.findElement(By.cssSelector(".totalRow button")).click();
	   //driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("India");
	   
	   Actions a=new Actions(driver);
	   a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build().perform();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	   driver.findElement(By.xpath("(//button[contains(@class, 'ta-item list')])[2]")).click();
	   
	   JavascriptExecutor js = (JavascriptExecutor) driver;

	   js.executeScript("window.scrollBy(0,100)");
	   
	   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
	 // driver.findElement(By.cssSelector(".actions a")).click();
	  driver.findElement(By.cssSelector(".action__submit")).click();

	   String ConfirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	   System.out.println("confirm mesage is" +ConfirmMessage);
	   Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	  
	   
	   

	}

}
