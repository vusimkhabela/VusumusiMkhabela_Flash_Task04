package za.co.flash.application.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import za.co.flash.application.pageObjectModel.AccPage;
import za.co.flash.application.pageObjectModel.CartPage;
import za.co.flash.application.pageObjectModel.CheckoutPage;
import za.co.flash.application.pageObjectModel.ComputersPage;
import za.co.flash.application.pageObjectModel.DashboardPage;
import za.co.flash.application.pageObjectModel.LoginPage;
import za.co.flash.application.pageObjectModel.RegisterPage;
import za.co.flash.application.testData.TestData;

public class TC01HomeLanding {

	WebDriver driver;

	@BeforeTest
	public void start() {
		// refresh & initiate the driver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void run1() {
		// Register User
		RegisterPage register = new RegisterPage(driver);
		register.registerUser(TestData.fName, TestData.lName, TestData.emailAdd, TestData.passWord);
	}

	@Test(priority = 2)
	public void runT2() {
		DashboardPage dashboardPage = new DashboardPage(driver);
		ComputersPage computersPage = new ComputersPage(driver);
		dashboardPage.validateUserDashboard();
		computersPage.createOrder();
	}

	@Test(priority = 3)
	public void runT3() {
		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		cartPage.updateCart();
		checkoutPage.checkoutOrder(TestData.country, TestData.city, TestData.addressLine1,
				TestData.addressLine2, TestData.zipCode, TestData.phoneNumber, TestData.faxNumber);
	}

	@Test(priority = 4)
	public void runT4() {
		LoginPage login = new LoginPage(driver);
		AccPage accPage = new AccPage(driver);
		login.loginUser(TestData.emailAdd, TestData.passWord);
		accPage.validateOrderCreated();
	}

	@AfterTest
	public void tearDown() {
		// close the driver
		driver.close();
		driver.quit();
	}

}
