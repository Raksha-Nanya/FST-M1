package Selenium_Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println("The title of the page is "+ driver.getTitle());
		
		WebElement Checkbox = driver.findElement(By.xpath("//input[@class='willDisappear']"));
		
		System.out.println("Checkbox is Selected. - "+Checkbox.isSelected());
		
		Checkbox.click();
		
		System.out.println("Checkbox is selected. - "+Checkbox.isSelected());
		
		driver.close();
		
		

	}

}
