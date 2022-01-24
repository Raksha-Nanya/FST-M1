package Module1Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/");
  }
  
  
  @Test
  public void validateHeading() {
	  WebElement header = driver.findElement(By.xpath("//h1[@class='entry-title']"));
	  Assert.assertEquals("Welcome to Alchemy Jobs", header.getText());
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
