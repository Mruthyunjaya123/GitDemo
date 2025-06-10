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
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Authenticator.Retry;

import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.CartPage;
import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.CheckoutPage;
import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.ConfirmationPage;
import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.LandingPage;
import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.ProductCatalogue;
import SeleniumAcademy.SeleniumAutomationFrameWorkDesign.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {
	
	
	
	@Test
	public void LoginErrorvalidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";

		// LandingPage landingPage=launchAppilcation();

		landingPage.loginApplication("mruthyunjaya3t@gmail.com", "As1111@1994");
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		landingPage.GetErrorMessage();
		Assert.assertEquals("Incorrect email or123 password.", landingPage.GetErrorMessage());
		

	}

	@Test(retryAnalyzer = SeleniumAcademy.SeleniumAutomationFrameWorkDesign.TestComponents.Retry.class)
	public void ProductErrorvalidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";

		// LandingPage landingPage=launchAppilcation();

		landingPage.loginApplication("mruthyunjaya3t@gmail.com", "Ashu@1994");
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		productCatalogue.goToCartPage();
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VerifyProductsDisplay(productName);
		Assert.assertTrue(match);

		
	}

	
}
