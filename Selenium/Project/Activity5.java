package Module1Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity5 {
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/");
  }

  @Test
  public void navigatetoPage() {
	  driver.findElement(By.linkText("Jobs")).click();
	  String title = driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals("Jobs – Alchemy Jobs", title);
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
