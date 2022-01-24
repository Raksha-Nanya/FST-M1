package Module1Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity4 {
	WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/");
  }

  @Test
  public void validatetext() {
	WebElement text =   driver.findElement(By.xpath("//div[starts-with(@class,'entry-content')]/h2"));
	Assert.assertEquals("Quia quis non", text.getText());
	
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
