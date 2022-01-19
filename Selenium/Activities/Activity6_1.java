package Selenium_Activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println("The title of the page is "+ driver.getTitle());
		
		WebElement ToggleCheck = driver.findElement(By.id("toggleCheckbox"));
		
		WebElement Checkbox = driver.findElement(By.xpath("//input[@class='willDisappear']"));
		ToggleCheck.click();
		
		wait.until(ExpectedConditions.invisibilityOf(Checkbox));
		ToggleCheck.click();
		wait.until(ExpectedConditions.visibilityOf(Checkbox));
		
		driver.close();

	}

}
