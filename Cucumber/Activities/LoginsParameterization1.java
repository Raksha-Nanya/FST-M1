package stepDefintions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginsParameterization1 {
	
	WebDriver driver;
	
	@Given("^Load the login page$")
	public void loginPage() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
		
	}
	
	@When("^Enter the \"(.*)\" and \"(.*)\"$")
	public void enterCredential(String username,String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
	}
	
	@Then("^Read the page title and confirmation message1$")
	public void validateLogins() throws Throwable{
		String title = driver.getTitle();
		WebElement message = driver.findElement(By.id("action-confirmation"));
		System.out.println("Title of the page is : "+title);
		System.out.println("Message on the page is : "+message.getText());
	}
	
	@And("^Close the login browser$")
	public void closeLoginBrowser() throws Throwable {
		driver.close();
	}
	
	

}
