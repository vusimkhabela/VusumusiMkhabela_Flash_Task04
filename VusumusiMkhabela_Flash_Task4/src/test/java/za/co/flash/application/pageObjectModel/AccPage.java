package za.co.flash.application.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccPage {
	WebDriver driver;

	public AccPage() {
	}

	public AccPage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement accountLink(WebDriver driver) {
		return driver.findElement(By.cssSelector("div[class='header-links'] a[class='account']"));
	}

	public static WebElement accountHeading(WebDriver driver) {
		return driver.findElement(By.cssSelector("div[class='page-title'] h1"));
	}

	public static WebElement ordersMenuOption(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@class='inactive'][normalize-space()='Orders']"));
	}

	public static WebElement orderDetailsButton(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@value='Details'])[1]"));
	}

	public static WebElement orderNumber(WebDriver driver) {
		return driver.findElement(By.cssSelector("div[class='order-number'] strong"));
	}

	public void validateOrderCreated() {
		try {
			
			// Step1: Click the Account Link
			accountLink(driver).click();
			System.out.println("4.3 The user clicks the ACCOUNT button.");

			// Step2: Validate Account Page
			Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/customer/info");
			System.out.println("4.4 The user is directed to the Customer Info page form.");

			Assert.assertEquals(accountHeading(driver).getText(), "My account - Customer info");
			System.out.println("4.5 The heading is correct: My account - Customer info.");

			// Step 3: Confirm Order
			ordersMenuOption(driver).click();
			System.out.println("4.6 The user clicks on the orders menu option.");

			orderDetailsButton(driver).click();
			System.out.println("4.7 The user clicks on the order details link");
			System.out.println("4.8 " + orderNumber(driver).getText() + " has been successfully placed.");
		} catch (Error e) {
			System.out.println("Test 1 Case failed...");
			System.out.println("ERROR: " + e.getMessage());
			System.out.println("Stopping Test...");
			// driver.close();
			// driver.quit();
		}
	}

}
