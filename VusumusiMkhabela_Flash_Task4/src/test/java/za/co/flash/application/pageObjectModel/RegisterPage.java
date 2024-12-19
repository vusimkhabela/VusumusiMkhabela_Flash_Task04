package za.co.flash.application.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage() {
	}

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement registerOption(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
	}

	public static WebElement registerHeadingEl(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}

	public static WebElement registerFormEl(WebDriver driver) {
		return driver.findElement(By.cssSelector("form[action='/register']"));
	}

	public static WebElement genderEl(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='gender-male']"));
	}

	public static WebElement fNameEl(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='FirstName']"));
	}

	public static WebElement lNameEl(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='LastName']"));
	}

	public static WebElement emailAddEl(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='Email']"));
	}

	public static WebElement passEl(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='Password']"));
	}

	public static WebElement confirmPassEl(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
	}

	public static WebElement registerBtnEl(WebDriver driver) {
		return driver.findElement(By.cssSelector("#register-button"));
	}

	public static WebElement continueBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Continue']"));
	}

	public void registerUser(String fName, String lName, String emailAdd, String pass) {

		try {
			System.out.println("\n\n---------------------------------------Test Case 01 : Registration-------------------------------------------");


			// Step1: Click the Contact Link
			registerOption(driver).click();
			System.out.println("\n1. The user clicks the REGISTER link in the Navigation Bar.");

			// Step2: Validate Registration Form
			Assert.assertTrue(registerFormEl(driver).isDisplayed());
			System.out.println("1.1 The user is directed to the registration form.");

			Assert.assertEquals(registerHeadingEl(driver).getText(), "Register");
			System.out.println("1.2 The heading is correct: Register.");

			// Step 3: Fill in Registration Form
			genderEl(driver).click();
			System.out.println("1.3. The user selects MALE from the gender radio buttons.");

			fNameEl(driver).sendKeys(fName);
			System.out.println("1.4. The user enters first name into the first name field: " + fName);

			lNameEl(driver).sendKeys(lName);
			System.out.println("1.5. The user enters last name into the last name field: " + lName);

			emailAddEl(driver).sendKeys(emailAdd);
			System.out.println("1.6. The user enters email into the email field: " + emailAdd);

			passEl(driver).sendKeys(pass);
			System.out.println("1.8. The user enters password Test into the password field.");

			confirmPassEl(driver).sendKeys(pass);
			System.out.println("1.9. The user confirms the password into the confirm password field.");

			registerBtnEl(driver).click();
			continueBtn(driver).click();
			System.out.println("1.10 Registration was successfull for user: " + emailAdd);
		} catch (Error e) {
			System.out.println("Test 1 Case failed...");
			System.out.println("ERROR: " + e.getMessage());
			System.out.println("Stopping Test...");
			//driver.close();
			//driver.quit();
		}

	}
}
