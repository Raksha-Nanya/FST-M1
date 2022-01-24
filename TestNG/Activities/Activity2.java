package TestNG_Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
	
	WebDriver driver;
	 @BeforeClass
	  public void beforeClass() {
		  
		  driver = new FirefoxDriver();
		  driver.get("https://www.training-support.net/selenium/target-practice");
	  }
	 
  @Test
  public void testcase1() {
	  String title = driver.getTitle();
      System.out.println("Title is: " + title);
      Assert.assertEquals(title, "Target Practice");
	  
  }
  @Test
  public void testcase2() {
	  WebElement blackButton = driver.findElement(By.xpath("//button[contains(@class,'black')]"));
      Assert.assertTrue(!blackButton.isDisplayed());
      Assert.assertEquals(blackButton.getText(), "black");
	  
  }
  @Test(enabled=false)
  public void testcase3() {
	  String subHeading = driver.findElement(By.className("sub")).getText();
      Assert.assertTrue(subHeading.contains("Practice"));
  }
  @Test
  public void testcase4() {
	  throw new SkipException("Skipping test case");      
  }
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
