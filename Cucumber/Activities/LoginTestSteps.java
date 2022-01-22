package stepDefintions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginTestSteps {
	WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver,1000);
	
	@Given("^User is on Login page$")
	public void userIsOnLoginPage() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
		
	}
	
	@When("^User Enters Username and Password$")
	public void userEntersCredential() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
	}
	
	@Then("^Read the page title and confirmation message$")
	public void validateLogins() {
		String title = driver.getTitle();
		WebElement message = driver.findElement(By.id("action-confirmation"));
		System.out.println("Title of the page is : "+title);
		System.out.println("Message on the page is : "+message.getText());

	}
	
	@And("^close the browser$")
	public void closebrowser() {
		driver.close();
	}
}
