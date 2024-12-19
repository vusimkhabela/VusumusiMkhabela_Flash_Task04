package za.co.flash.application.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import za.co.flash.application.pageObjectModel.CartPage;
import za.co.flash.application.pageObjectModel.ComputersPage;
import za.co.flash.application.pageObjectModel.DashboardPage;
import za.co.flash.application.pageObjectModel.LoginPage;
import za.co.flash.application.pageObjectModel.RegisterPage;

public class TC01HomeLanding {
	
	WebDriver driver;
	
	@BeforeTest
	public void start() {
		//refresh & initiate the driver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=4)
	public void runT1() {
		//Register User
		RegisterPage register = new RegisterPage(driver);
		register.registerUser("Vusumusi", "Mkhabela", "v1mkhajki2@f.c", "1234567890");
	}
	
	
	@Test(priority=2)
	public void runT2() {
		DashboardPage dashboardPage = new DashboardPage(driver);
		ComputersPage computersPage = new ComputersPage(driver);
		dashboardPage.validateUserDashboard();
		computersPage.createOrder();
	}
	
	@Test(priority=3)
	public void runT3() {
		CartPage cartPage = new CartPage(driver);
		cartPage.updateCart();
	}
	
	@Test(priority=1)
	public void runT4() {
		LoginPage login = new LoginPage(driver);
		login.loginUser("v1mgj2@f.c", "1234567890");
	}
	
	@AfterTest
	public void tearDown() {
		// close the driver
		driver.close();
		driver.quit();
	}
	

}
