package za.co.flash.application.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	
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
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void registerUser(String fName, String lName, String gender, String emailAdd, String pass) {
		//Validate Registration page
		//Fill In Details
		//Validate Register button
		//Click Register button
	}
	
	

}
