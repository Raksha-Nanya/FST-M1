package Selenium_Activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12_1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  
		driver.get("https://www.training-support.net/selenium/iframes");
		System.out.println(driver.getTitle());
		
		driver.switchTo().frame(0);
		
		System.out.println(driver.findElement(By.xpath("//div[@class = 'content']")).getText());
		
		WebElement button1 = driver.findElement(By.cssSelector("button"));
        System.out.println(button1.getText());
        System.out.println(button1.getCssValue("background-color"));
        
        button1.click();
        
        System.out.println(button1.getText());
        System.out.println(button1.getCssValue("background-color"));
        
        driver.switchTo().defaultContent();
        
        driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.xpath("//div[@class = 'content']")).getText());
		
		WebElement button2 = driver.findElement(By.id("actionButton"));
		
		 System.out.println(button2.getText());
	     System.out.println(button2.getCssValue("background-color"));
	     wait.until(ExpectedConditions.elementToBeClickable(button2));
         Thread.sleep(2000);
	     button2.click();
	      
        System.out.println(button2.getText());
        System.out.println(button2.getCssValue("background-color"));
        driver.switchTo().defaultContent();
        
        driver.close();
        
		
	}

}
