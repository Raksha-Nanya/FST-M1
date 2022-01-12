package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		System.out.println("The title of the webpage is "+ driver.getTitle()+".");
		
		WebElement id = driver.findElement(By.id("about-link"));
		System.out.println("Text in element: " + id.getText());
		
		WebElement ClassName  = driver.findElement(By.className("inverted"));
		System.out.println("Text in element: " + ClassName.getText());
		
		WebElement LinkText  = driver.findElement(By.linkText("About Us"));
		System.out.println("Text in element: " + LinkText.getText());
		
		WebElement cssSelect = driver.findElement(By.cssSelector("a.inverted"));
		System.out.println("Text in element: " + cssSelect.getText());
		driver.quit();
		
		

	}

}
