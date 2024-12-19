package za.co.flash.application.pageObjectModel;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ComputersPage {

	WebDriver driver;

	public ComputersPage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement desktopsHeadingEl(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}

	public static Select sortCombobox(WebDriver driver) {
		Select sortField = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
		return sortField;
	}

	public static WebElement item1(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]"));
	}

	public static WebElement item1Processor(WebDriver driver) {
		return driver.findElement(By.cssSelector("#product_attribute_75_5_31_96"));
	}

	public static WebElement item1AddToCart(WebDriver driver) {
		return driver.findElement(By.cssSelector("#add-to-cart-button-75"));
	}

	public static WebElement desktopLink(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),'Desktops')]"));
	}
	
	public static WebElement closeSuccessPopup(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@title='Close']"));
	}
	
	public static WebElement item2(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]"));
	}

	public static WebElement item2AddToCart(WebDriver driver) {
		return driver.findElement(By.cssSelector("#add-to-cart-button-72"));
	}

	public static WebElement item3(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@value='Add to cart'])[2]"));
	}

	public static WebElement item3AddToCart(WebDriver driver) {
		return driver.findElement(By.cssSelector("#add-to-cart-button-16"));
	}

	public static WebElement item3AddToCartError(WebDriver driver) {
		return driver.findElement(By.xpath("//p[@class='content']"));
	}

	public static WebElement item3HDD(WebDriver driver) {
		return driver.findElement(By.cssSelector("#product_attribute_16_3_6_18"));
	}
	
	public static WebElement item4(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@value='Add to cart'])[3]"));
	}

	public static WebElement item4AddToCart(WebDriver driver) {
		return driver.findElement(By.cssSelector("#add-to-cart-button-74"));
	}
	

	public void createOrder() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try
		{ 
			// Step 1: Validate Desktops page appears
			Assert.assertEquals(desktopsHeadingEl(driver).getText(), "Desktops");
			System.out.println("2.5 The heading is correct: Desktops.");

			// Step 2: Sort Desktops
			sortCombobox(driver).selectByVisibleText("Name: A to Z");
			Assert.assertEquals(sortCombobox(driver).getFirstSelectedOption().getText(), "Name: A to Z");
			System.out.println("2.6 The desktops are sorted by Name: A to Z");

			sortCombobox(driver).selectByVisibleText("Name: Z to A");
			Assert.assertEquals(sortCombobox(driver).getFirstSelectedOption().getText(), "Name: Z to A");
			System.out.println("2.7 The desktops are sorted by Name: Z to A");

			sortCombobox(driver).selectByVisibleText("Price: Low to High");
			Assert.assertEquals(sortCombobox(driver).getFirstSelectedOption().getText(), "Price: Low to High");
			System.out.println("2.8 The desktops are sorted by Price: Low to High");

			sortCombobox(driver).selectByVisibleText("Price: High to Low");
			Assert.assertEquals(sortCombobox(driver).getFirstSelectedOption().getText(), "Price: High to Low");
			System.out.println("2.3 The desktops are sorted by Price: High to Low");

			sortCombobox(driver).selectByVisibleText("Created on");
			Assert.assertEquals(sortCombobox(driver).getFirstSelectedOption().getText(), "Created on");
			System.out.println("2.3 The desktops are sorted by : Created on");

			// Step 3: Add items to cart
			Actions a = new Actions(driver);

			a.moveToElement(item1(driver)).perform();
			item1(driver).click();
			System.out.println("2.9.1 User selects a desktop");
			item1Processor(driver).click();
			a.moveToElement(item1AddToCart(driver)).perform();
			item1AddToCart(driver).click();
			System.out.println("**First item successfully added to cart");
			returnToDesktopList(wait, a);

			a.moveToElement(item2(driver)).perform();
			item2(driver).click();
			System.out.println("2.9.2 User selects a desktop");
			a.moveToElement(item2AddToCart(driver)).perform();
			item2AddToCart(driver).click();
			System.out.println("**second item successfully added to cart");
			returnToDesktopList(wait, a);

			a.moveToElement(item3(driver)).perform();
			item3(driver).click();
			System.out.println("2.9.3 User selects a desktop");
			a.moveToElement(item3AddToCart(driver)).perform();
			item3AddToCart(driver).click();
			// Validate error
			Assert.assertTrue(item3AddToCartError(driver).isDisplayed());
			System.out.println("Error: User tried adding item without necessary info.");
			item3HDD(driver).click();
			a.moveToElement(item3AddToCart(driver)).perform();
			item3AddToCart(driver).click();
			System.out.println("**third item successfully added to cart");
			returnToDesktopList(wait, a);

			a.moveToElement(item4(driver)).perform();
			item4(driver).click();
			System.out.println("2.9.4 User selects a desktop");
			a.moveToElement(item4AddToCart(driver)).perform();
			item4AddToCart(driver).click();
			System.out.println("**Forth item successfully added to cart");
			returnToDesktopList(wait, a);
		} 
		catch(Error e)
		{
			System.out.println("Test 2 Case failed...");
			System.out.println("ERROR: " + e.getMessage());
			System.out.println("Stopping Test...");
			//driver.close();
			//driver.quit();
		}
		
	}

	private void returnToDesktopList(WebDriverWait wait, Actions a) {
		WebElement closeSuccessPopupIcon = closeSuccessPopup(driver);
		while(!closeSuccessPopupIcon.isDisplayed()) {
			a.moveToElement(desktopLink(driver)).perform();
			wait.until(ExpectedConditions.elementToBeClickable(desktopLink(driver)));
		}
		if(closeSuccessPopupIcon.isDisplayed()) {
			closeSuccessPopupIcon.click();
		}
		desktopLink(driver).click();
	}
}
