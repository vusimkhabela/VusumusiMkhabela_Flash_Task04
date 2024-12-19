package za.co.flash.application.pageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public static WebElement loginLink(WebDriver driver) {
		return driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
	}

	public static WebElement emailEl(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='Email']"));
	}

	public static WebElement passEl(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='Password']"));
	}

	public static WebElement loginButton(WebDriver driver) {
		return driver.findElement(By.cssSelector("input[value='Log in']"));
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginUser(String emailAdd, String pass) {

		try {
			System.out.println("\n\n---------------------------------------Test Case 04 : Login & Account-------------------------------------------");

			// Step1: Click the Log In Link
			loginLink(driver).click();
			System.out.println("\n4. The user clicks the LOG IN link.");

			// Step 2: Enter credentials
			emailEl(driver).sendKeys(emailAdd);
			passEl(driver).sendKeys(pass);
			System.out.println("4.1. The user has entered details.");

			// Step 3: Log in
			loginButton(driver).click();
			System.out.println("4.2. The user logged in successfully.");
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} catch (Error e) {
			System.out.println("Test 4 Case failed...");
			System.out.println("ERROR: " + e.getMessage());
			//driver.close();
			//driver.quit();
		}

	}

}
