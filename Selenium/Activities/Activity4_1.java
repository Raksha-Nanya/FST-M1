package Selenium_Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		
		System.out.println("The title of the page is "+ driver.getTitle());
		
		driver.findElement(By.xpath("//a[@id='about-link']")).click();
		System.out.println("The title of the page is "+ driver.getTitle());		
		driver.close();
		

	}
}

