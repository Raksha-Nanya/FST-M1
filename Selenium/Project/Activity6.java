package Module1Project;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver= new FirefoxDriver();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
 
  @BeforeMethod
  public void beforeMethod() {
	
	  driver.get("https://alchemy.hguy.co/jobs/");
  }
  

  @Test
  public void searchjob() {
	  driver.findElement(By.linkText("Jobs")).click();
	  driver.findElement(By.id("search_keywords")).sendKeys("Banking");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'job_listing')]")));
	  driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type='button']")));
	  
	  driver.findElement(By.xpath("//input[@type='button']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='job_application_email']")));
	  WebElement email = driver.findElement(By.xpath("//a[@class='job_application_email']"));
	  System.out.println("Email is : "+ email.getText());
	  
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
