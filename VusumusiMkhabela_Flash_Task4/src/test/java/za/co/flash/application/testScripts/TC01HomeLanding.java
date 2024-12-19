package za.co.flash.application.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
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
		System.out.println("Moving out of BeforeTest");
	}
	
	@Test
	public void run() {
		//execute test case 01
		//Register User
		System.out.println("Entering in Test");
		RegisterPage register = new RegisterPage(driver);
		register.registerUser("Vusumusi", "Mkhabela", "v@f.c", "1234567890");
	}
	
	@AfterTest
	public void terminate() {
		// close the driver
		driver.quit();
	}
	

}
