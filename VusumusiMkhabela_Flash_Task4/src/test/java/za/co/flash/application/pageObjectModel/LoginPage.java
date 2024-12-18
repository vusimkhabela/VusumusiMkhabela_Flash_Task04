package za.co.flash.application.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	WebElement sendk = driver.findElement(By.tagName("h1"));
	/*WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));
	WebElement sendk = driver.findElement(By.tagName("h1"));*/
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginUser(String emailAdd, String pass) {
		//Click log out
		//Click log in
		//fill in details
		//click on login
		//Validate user logged in
	}

}
