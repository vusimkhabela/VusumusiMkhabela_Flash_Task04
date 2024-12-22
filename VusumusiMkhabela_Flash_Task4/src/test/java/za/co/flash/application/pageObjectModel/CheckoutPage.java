package za.co.flash.application.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage() {
	}

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement checkoutButton(WebDriver driver) {
		return driver.findElement(By.cssSelector("#checkout"));
	}

	public static WebElement checkoutHeading(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}

	public static WebElement cityName(WebDriver driver) {
		return driver.findElement(By.cssSelector("#BillingNewAddress_City"));
	}

	public static WebElement addressLine1(WebDriver driver) {
		return driver.findElement(By.cssSelector("#BillingNewAddress_Address1"));
	}

	public static WebElement addressLine2(WebDriver driver) {
		return driver.findElement(By.cssSelector("#BillingNewAddress_Address2"));
	}

	public static WebElement phoneNumber(WebDriver driver) {
		return driver.findElement(By.cssSelector("#BillingNewAddress_PhoneNumber"));
	}

	public static WebElement faxNumber(WebDriver driver) {
		return driver.findElement(By.cssSelector("#BillingNewAddress_FaxNumber"));
	}

	public static Select countryCombobox(WebDriver driver) {
		Select countryField = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
		return countryField;
	}
	
	public static Select billingAddressCombobox(WebDriver driver) {
		Select addressField = new Select(driver.findElement(By.xpath("//select[@id='billing-address-select']")));
		return addressField;
	}
	
	public static WebElement billingAddressHeading(WebDriver driver) {
		return driver.findElement(By.xpath("//h2[contains(text(),'Billing address')]"));
	}

	public static WebElement zipPostalCode(WebDriver driver) {
		return driver.findElement(By.cssSelector("#BillingNewAddress_ZipPostalCode"));
	}

	public static WebElement billingContinueBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@onclick='Billing.save()']"));
	}
	
	public static WebElement shippingContinueBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
	}
	
	public static WebElement shippingMethodContinueBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("input[class='button-1 shipping-method-next-step-button']"));
	}
	
	public static WebElement paymentMethodContinueBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector("input[class='button-1 payment-method-next-step-button']"));
	}
	
	public static WebElement paymentInfoContinueBtn(WebDriver driver) {
		return driver.findElement(By.xpath("(//input[@class='button-1 payment-info-next-step-button'])[1]"));
	}
	
	public static WebElement confirmOrderBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Confirm']"));
	}
	
	public static WebElement confirmOrderSuccessTitle(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[contains(text(),'Thank you')]"));
	}
	
	public static WebElement orderDetailsLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[normalize-space()='Click here for order details.']"));
	}
	
	public static WebElement logOutLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
	}
	
	public static WebElement pickUpInStore(WebDriver driver) {
		return driver.findElement(By.cssSelector("#PickUpInStore"));
	}
	
	public static WebElement orderNumber(WebDriver driver) {
		return driver.findElement(By.cssSelector("div[class='order-number'] strong"));
	}
	
	public static WebElement productsHeading(WebDriver driver) {
		return driver.findElement(By.xpath("//th[normalize-space()='Product(s)']"));
	}

	public void checkoutOrder(String country, String city, String addressLine1, String addressLine2,
			String zipCode, String phoneNumber, String faxNumber) {
		try {
			// Step1: Click the Checkout Link
			Actions a = new Actions(driver);
			a.moveToElement(checkoutButton(driver)).perform();
			checkoutButton(driver).click();
			System.out.println("3.5 The user clicks the CHECKOUT button.");

			Assert.assertEquals(checkoutHeading(driver).getText(), "Checkout");
			System.out.println("3.6 The heading is correct: Checkout.");

			// Step 3: Fill in Checkout Form
			countryCombobox(driver).selectByVisibleText(country);
			Assert.assertEquals(countryCombobox(driver).getFirstSelectedOption().getText(), country);
			System.out.println("3.7 The selects a country : " + country);

			cityName(driver).sendKeys(city);
			System.out.println("3.8 The user enters City into the City field: " + city);

			addressLine1(driver).sendKeys(addressLine1);
			System.out.println("3.9 The user enters Address Line 1 into the Address Line 1 field: " + addressLine1);

			addressLine2(driver).sendKeys(addressLine2);
			System.out.println("3.10 The user enters Address Line 2 into the Address Line 2 field: " + addressLine2);

			zipPostalCode(driver).sendKeys(zipCode);
			System.out.println("3.11 The user enters zip code into the zip code field: " + zipCode);

			phoneNumber(driver).sendKeys(phoneNumber);
			System.out.println("3.12 The user enters phone number into the phone number field: " + phoneNumber);
			
			faxNumber(driver).sendKeys(faxNumber);
			System.out.println("3.13 The user enters fax number into the fax number field: " + faxNumber);
			
			billingContinueBtn(driver).click();
			System.out.println("3.14 The user clicks the continue button.");
			
			Thread.sleep(3000);
			pickUpInStore(driver).click();
			System.out.println("*** The user clicks pickup in store.");
			Thread.sleep(2000);
			Thread.sleep(2000);
			
			shippingContinueBtn(driver).click();

			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(2000);
			paymentMethodContinueBtn(driver).click();
			Thread.sleep(3000);
			paymentInfoContinueBtn(driver).click();
			
			// Step 4: Confirm order
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(20000);
			confirmOrderBtn(driver).click();
			System.out.println("3.15 The order has been successfully placed.");
			

			System.out.println("3.16 The user is directed to the order confirmation page..");
			Thread.sleep(3000);
			Assert.assertEquals(confirmOrderSuccessTitle(driver).getText(), "Thank you");
			System.out.println("3.17 The heading is correct: Thank you.");
			Thread.sleep(2000);
			orderDetailsLink(driver).click();
			System.out.println("3.18 The user clicks order details link to see order details.");
			
			//3.24 log out
			a.moveToElement(logOutLink(driver)).perform();
			logOutLink(driver).click();
			System.out.println("3.19 The user logged out.");

		} catch (Error | InterruptedException e) {
			System.out.println("Test 3 Case failed...");
			System.out.println("ERROR: " + e.getMessage());
			System.out.println("Stopping Test...");
		}
		
	}
}
