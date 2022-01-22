package stepDefintions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity5 {
	
	WebDriver driver;
	
	@Given("^Load the LOGIN page$")
	public void loginPage() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
		
	}
	
	@When("^enter the \"(.*)\" and \"(.*)\"$")
	public void enterCredential(String Username,String Password) {
		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
	}
	
	@Then("^read the page title and confirmation message1$")
	public void validateLogins() throws Throwable{
		String title = driver.getTitle();
		WebElement message = driver.findElement(By.id("action-confirmation"));
		System.out.println("Title of the page is : "+title);
		System.out.println("Message on the page is : "+message.getText());
	}
	
	@And("^close the login browser$")
	public void closeLoginBrowser() throws Throwable {
		driver.close();
	}
	
	


}
