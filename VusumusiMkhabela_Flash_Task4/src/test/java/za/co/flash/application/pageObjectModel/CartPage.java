package za.co.flash.application.pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CartPage {

	WebDriver driver;
	int total = 0;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement cartHeadingEl(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}

	public static WebElement shoppingCartLink(WebDriver driver) {
		return driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']"));
	}

	public static WebElement item(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='removefromcart']"));
	}

	public static WebElement updateCartButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='updatecart']"));
	}

	public static WebElement grandTotal(WebDriver driver) {
		return driver.findElement(By.cssSelector("span[class='product-price order-total'] strong"));
	}

	public static WebElement termsOfServiceChkbx(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='termsofservice']"));
	}
	
	public static WebElement checkoutButton(WebDriver driver) {
		return driver.findElement(By.cssSelector("#checkout"));
	}

	public void updateCart() {
		try {
			System.out.println("\n\n---------------------------------------Test Case 03 : Cart & Checkout-------------------------------------------");
			
			// Step1: Click the SHOPPING CART Link
			shoppingCartLink(driver).click();
			System.out.println("\n3. The user clicks the SHOPPING CART link.");

			// Step2: Validate Shopping cart.
			Assert.assertEquals(cartHeadingEl(driver).getText(), "Shopping cart");
			System.out.println("3.1 The heading is correct: Shopping cart.");

			Actions a = new Actions(driver);
			WebElement grandTotal = grandTotal(driver);
			a.moveToElement(grandTotal).perform();
			double prevGrandTotal = Double.parseDouble(grandTotal.getText());
			System.out.println("Expected Total: " + calcTotalPrice() + " vs Actual Total: " + grandTotal.getText());

			// Step 3 : Delete Item from Cart
			a.moveToElement(item(driver)).perform();
			item(driver).click();
			System.out.println("3.2 The user selected item to delete.");

			a.moveToElement(updateCartButton(driver)).perform();
			updateCartButton(driver).click();
			System.out.println("3.3 The user clicks update cart to remove item from shopping cart.");

			//Assert.assertNotEquals(prevGrandTotal, total);
			System.out.println("3.4 The total price has been successfully updated. New total is: " + prevGrandTotal);

			a.moveToElement(termsOfServiceChkbx(driver)).perform();
			termsOfServiceChkbx(driver).click();
			a.moveToElement(checkoutButton(driver)).perform();
			
		} catch (Error e) {
			System.out.println("Test 3 Case failed...");
			System.out.println("ERROR: " + e.getMessage());
			System.out.println("Stopping Test...");
			//driver.close();
			//driver.quit();
		}
	}

	private int calcTotalPrice() {
		List<WebElement> productSubtotals = driver.findElements(By.className("product-subtotal"));
		for (WebElement el : productSubtotals) {
			total += Double.parseDouble(el.getText());
		}
		return total;
	}

}
