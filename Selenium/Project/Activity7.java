package Module1Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver= new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
 @BeforeClass
 public void beforeClass() {
	
	 driver.get("https://alchemy.hguy.co/jobs/");
	 
 }
	
 @Test(priority=0)
  public void postJob() {
		driver.findElement(By.linkText("Post a Job")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='submit_job']")));
		driver.findElement(By.xpath("//input[@name='submit_job']")).click();
		driver.findElement(By.id("create_account_email")).sendKeys("AStest13@gmail.com");
		driver.findElement(By.id("job_title")).sendKeys("LazyJob111");
		driver.findElement(By.id("job_location")).sendKeys("WFH");
		Select jobType = new Select(driver.findElement(By.id("job_type")));
		jobType.selectByVisibleText("Freelance");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("This is a Part time job, You can work from home. Easy jobs");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("application")).sendKeys("https://Test.com");
		driver.findElement(By.id("company_name")).sendKeys("LazyBean");
		driver.findElement(By.xpath("//input[@name='submit_job']")).click();
		
		//wait for submit button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job_preview_submit_button")));
		driver.findElement(By.id("job_preview_submit_button")).click();
		
	}
	//verifyin jobs Page
	@Test(priority=1)
	public void searchjob() {
		driver.findElement(By.linkText("Jobs")).click();
		 driver.findElement(By.id("search_keywords")).sendKeys("LazyJob1");
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'job_listing')]")));
		 
		WebElement text = driver.findElement(By.xpath("//div[@class='company']/strong"));
		Assert.assertEquals(text.getText(),"LazyBean");
		
  }
  @AfterClass
  public void afterClass() {
	  driver.close();
	  
  }

}
