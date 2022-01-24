package Module1Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
	WebDriver driver;
	WebDriver wait;
 
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
  }
  
  @Test
  public void login() throws InterruptedException {
	  
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("wp-submit")).click();
	  Thread.sleep(1000);
	  WebElement home = driver.findElement(By.linkText("Home"));
	  Assert.assertEquals(home.getText(), "Home");
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
