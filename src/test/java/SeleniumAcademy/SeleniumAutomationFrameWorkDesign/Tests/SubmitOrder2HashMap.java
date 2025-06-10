package SeleniumAcademy.SeleniumAutomationFrameWorkDesign.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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

public class SubmitOrder2HashMap extends BaseTest {
	
	
	
	
	@Test(dataProvider="getdata", groups={"Purchase"})
	    public void submitOrdermeth(HashMap<String,String> input) throws IOException, InterruptedException
	    {
		//String productName="ZARA COAT 3";
		
		//LandingPage landingPage=launchAppilcation();
	    
		landingPage.loginApplication(input.get("email"), input.get("password"));
	    //landingPage.loginApplication("mruthyunjaya3t@gmail.com", "Ashu@1994");
	    ProductCatalogue productCatalogue=new ProductCatalogue(driver);
	    List<WebElement> products=productCatalogue.getProductList();
	    productCatalogue.addProductToCart(input.get("productName"));
	    productCatalogue.goToCartPage(); 
	    CartPage cartPage=new CartPage(driver);
	    Boolean match=cartPage.VerifyProductsDisplay(input.get("productName"));
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
		 HashMap<String,String> map= new HashMap<String,String>();
		 map.put("email", "mruthyunjaya3t@gmail.com");
		 map.put("password", "Ashu@1994");
		 map.put("productName", "ZARA COAT 3");
		 
		 
		 HashMap<String,String> map1= new HashMap<String,String>();
		 map1.put("email", "mruthyunjaya812@gmail.com");
		 map1.put("password", "Punya@2023");
		 map1.put("productName", "ADIDAS ORIGINAL");
		 
		 
		 //email, password
		 
		 	return new Object[][] {{map},{map1}};
		 	
	 }
	  
	   
	   
	 
	   
	   
	   
	   
	  
	   
	 
	   

	}



