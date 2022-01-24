package Module1Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;
	WebDriverWait wait;
	 Alert alert;
	 Actions action ;
	 
 
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  action = new Actions(driver);
	  wait = new WebDriverWait(driver,20);
	 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	  //driver.get("https://alchemy.hguy.co/jobs/wp-admin/index.php");
  }
  
  @Test(priority=0)
  public void login() throws InterruptedException {
	  
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("wp-submit")).click();
  }
  
  @Test(priority=1)
  public void Job_Listing() throws InterruptedException {
	 
	  driver.findElement(By.xpath("//div[text()='Job Listings']")).click();
	  driver.findElement(By.linkText("Add New")).click();
	  //driver.switchTo().alert();
	  driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
	  driver.findElement(By.id("post-title-0")).sendKeys("LazyChartz");
	  driver.findElement(By.xpath("//button[text()='Publish…']")).click();
	  driver.findElement(By.xpath("//button[text()='Publish']")).click();
	  driver.navigate().back();
	 
	  WebElement key = driver.findElement(By.id("post-search-input"));
	  wait.until(ExpectedConditions.elementToBeClickable(key));
	  key.sendKeys("LazyChartz");
	 //key.sendKeys(Keys.ENTER);
	  driver.findElement(By.id("search-submit")).click();
	  
	  WebElement  position = driver.findElement(By.xpath("//div[@class='job_position']/a"));  
	  Assert.assertEquals("LazyChartz", position.getText());
	  	 
  }
  
  
  @AfterClass
  public void afterClass() {
	
	  driver.close();
	  
  }

}
