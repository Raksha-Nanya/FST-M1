package Selenium_Activity;

import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/tables");
		List<WebElement> rows=driver.findElements(By.xpath("//table[contains(@class,'ui celled')]/tbody/tr"));
		System.out.println("The Number of Rows and Column in Static table is: "+rows.size());
		
		List<WebElement> column=driver.findElements(By.xpath("//table[contains(@class,'ui celled')]/tbody/tr[1]/td"));
		System.out.println("The Number of colomn in Static table is: "+column.size());
		
		List<WebElement> ThirdRow=driver.findElements(By.xpath("//table[contains(@class,'ui celled')]/tbody/tr[3]/td"));
		
		for (WebElement i: ThirdRow) {
			System.out.println("The value of third row is : "+i.getText());
		}
		
		WebElement Value=driver.findElement(By.xpath("//table[contains(@class,'ui celled')]/tbody/tr[2]/td[2]"));
		System.out.println("The cell value of second row and second column is : "+Value.getText());
		
		
		
		driver.close();
		
		

	}

}
