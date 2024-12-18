package za.co.flash.application.testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import za.co.flash.application.pageObjectModel.HomeLandingPage;
import za.co.flash.application.pageObjectModel.RegisterPage;

public class TC01HomeLanding {
	
	WebDriver driver;
	HomeLandingPage home = new HomeLandingPage(driver);
	RegisterPage register = new RegisterPage(driver);
	
	@BeforeTest
	public void start() {
		//refresh & initiate the driver
		home.landingPage();
		register.registerUser(null, null, null, null, null);
	}
	
	@Test
	public void run() {
		//execute test case 01
		//Validate landing page
		
		
	}
	
	@AfterTest
	public void terminate() {
		// close the driver
		driver.quit();
	}
	

}
