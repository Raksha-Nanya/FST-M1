package Selenium_Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		System.out.println("The title of the page is "+ driver.getTitle());
		
		WebElement Third = driver.findElement(By.xpath("//h3[@id='third-header']"));
		System.out.println("The text of third header is "+ Third.getText());
		
		WebElement fifth= driver.findElement(By.xpath("//h3[@id='third-header']"));
		System.out.println("The Color of Fifth header is "+ fifth.getCssValue("color")); 
		
		WebElement Violet= driver.findElement(By.xpath("//button[text()='Violet']"));
		System.out.println("The Class attribute of Violet button is "+ Violet.getAttribute("class"));
		
		WebElement Grey= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
		System.out.println("The text of Grey button is "+ Grey.getText());
		
		driver.close();

	}

}
