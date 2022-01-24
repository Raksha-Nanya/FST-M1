package TestNG_Activity;

import org.testng.annotations.Test;
import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net");
  }
  @Test
  public void activity1() {
	  String title = driver.getTitle();
	  System.out.println("The title of the page is: "+title);
	  Assert.assertEquals("Training Support",title);
	  driver.findElement(By.id("about-link")).click();
	  System.out.println("New page title is: " + driver.getTitle());
	  Assert.assertEquals("About Training Support", driver.getTitle());
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
