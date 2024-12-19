package za.co.flash.application.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import za.co.flash.application.pageObjectModel.CartPage;
import za.co.flash.application.pageObjectModel.ComputersPage;
import za.co.flash.application.pageObjectModel.DashboardPage;

public class TC02ComputerPurchase {
	
	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}



}
