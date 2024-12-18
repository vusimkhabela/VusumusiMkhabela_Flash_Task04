package za.co.flash.application.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccPage {
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
	
	public AccPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void validateOrderCreated() {
		//click on Account/Email hyperlink
		//Click on orders side option
		//Validate date and number
	}
	
	

}
