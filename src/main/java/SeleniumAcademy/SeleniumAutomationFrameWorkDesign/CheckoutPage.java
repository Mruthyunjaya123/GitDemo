package SeleniumAcademy.SeleniumAutomationFrameWorkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css=".action__submit")
    WebElement submit;
	@FindBy(css="input[placeholder='Select Country']")
    WebElement country;
	@FindBy(xpath="(//button[contains(@class, 'ta-item list')])[2]")
    WebElement selectcountry;
	
	By results=By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selectcountry.click();
	}
	
	 public ConfirmationPage submitOrder()
	 {
		 submit.click();
		 return new ConfirmationPage(driver);
	 }

	 public void scrollto()
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,100)");
	 }
}
