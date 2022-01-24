package Module1Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity3 {
	WebDriver driver;
	
	 @BeforeMethod
	  public void beforeMethod() {
		  driver = new FirefoxDriver();
		  driver.get("https://alchemy.hguy.co/jobs/");
		  
	  }
	 
  @Test
  public void validateURL() throws InterruptedException {
	  WebElement url = driver.findElement(By.xpath("//div[contains(@class,'-img-content')]/img"));
	  System.out.println("Url of the image is : "+url.getAttribute("src"));
  }
 

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
