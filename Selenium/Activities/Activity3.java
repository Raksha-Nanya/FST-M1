package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.println("The title of the webpage is "+ driver.getTitle()+".");

		WebElement FirstName = driver.findElement(By.id("firstName"));
		
		WebElement LastName = driver.findElement(By.id("lastName"));
		
		FirstName.sendKeys("Raksha");
		LastName.sendKeys("Nanya");
		
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("test@gmail.com");
		
		WebElement phNo = driver.findElement(By.xpath("//input[@id='number']"));
		phNo.sendKeys("1234345678");
		
		Thread.sleep(3000);
		
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();

		driver.quit();
		
		

	}

}
