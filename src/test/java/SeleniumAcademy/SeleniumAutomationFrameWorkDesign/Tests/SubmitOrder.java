package SeleniumAcademy.SeleniumAutomationFrameWorkDesign.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.CartPage;
import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.CheckoutPage;
import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.ConfirmationPage;
import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.LandingPage;
import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.ProductCatalogue;
import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.TestComponents.BaseTest;

public class SubmitOrder extends BaseTest {
	
	
	
	
	@Test(dataProvider="getdata", groups={"Purchase"})
	    public void submitOrdermeth(String email, String password, String productName) throws IOException, InterruptedException
	    {
		//String productName="ZARA COAT 3";
		
		//LandingPage landingPage=launchAppilcation();
		
       System.out.println(" US guy changes");
       System.out.println("New develop branch added to the git class SubmitOrder1");
       System.out.println("New develop branch added to the git class SubmitOrder2");
	    
		landingPage.loginApplication(email, password);
	    //landingPage.loginApplication("mruthyunjaya3t@gmail.com", "Ashu@1994");
	    ProductCatalogue productCatalogue=new ProductCatalogue(driver);
	    List<WebElement> products=productCatalogue.getProductList();
	    productCatalogue.addProductToCart(productName);
	    productCatalogue.goToCartPage();
	    CartPage cartPage=new CartPage(driver);
	    Boolean match=cartPage.VerifyProductsDisplay(productName);
	    Assert.assertTrue(match);
	    CheckoutPage checkoutPage=cartPage.goTocheckout();
	    checkoutPage.selectCountry("India");
	    checkoutPage.scrollto();
	    
	    Thread.sleep(2000);
	    ConfirmationPage confirmationPage=checkoutPage.submitOrder();
	    
	    String confirmationMessage=confirmationPage.getConfimationMessage();
	    Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.")); 
	   
	    
	    }
	  
	 @DataProvider
	 public Object[][] getdata()
	 {
		 
		 	return new Object[][] {{"mruthyunjaya3t@gmail.com", "Ashu@1994","ZARA COAT 3"},{"mruthyunjaya812@gmail.com", "Punya@2023", "ADIDAS ORIGINAL"}};
		 	
	 }
	  
	   
	   
	 
	   
	   
	   
	   
	  
	   
	 
	   

	}



