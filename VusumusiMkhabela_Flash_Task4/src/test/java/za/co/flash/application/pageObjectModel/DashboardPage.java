package za.co.flash.application.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement computersTab(WebDriver driver) {
		return driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Computers']"));
	}

	public static WebElement computersHeadingEl(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}

	public static WebElement desktopCategory(WebDriver driver) {
		return driver.findElement(By.cssSelector("div[class='picture'] a[title='Show products in category Desktops']"));
	}

	public void validateUserDashboard() {

		try {
			System.out.println("\n\n---------------------------------------Test Case 02 : Dashboard & Computers-------------------------------------------");

			// Step1: Click the COMPUTERS tab Link
			computersTab(driver).click();
			System.out.println("\n2. The user clicks the COMPUTERS tab in the heading bar.");

			// Step2: Validate Computers page appears
			Assert.assertEquals(computersHeadingEl(driver).getText(), "Computers");
			System.out.println("2.1 The heading is correct: Register.");

			Assert.assertTrue(desktopCategory(driver).isDisplayed());
			System.out.println("2.2 The 'Desktop' Category is displaying.");

			// Step 3: Click Desktops option
			desktopCategory(driver).click();
			System.out.println("2.3. The user clicked the 'Desktop' category.");
		} catch (Error e) {
			System.out.println("Test 2 Case failed...");
			System.out.println("ERROR: " + e.getMessage());
			System.out.println("Stopping Test...");
			//driver.close();
			//driver.quit();
		}

	}

}
