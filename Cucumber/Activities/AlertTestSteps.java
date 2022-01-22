package stepDefintions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertTestSteps {
	WebDriver driver;
	WebDriverWait wait;
	Alert alert;

	@Given("^User is on the page$")
	public void OpenPage() throws Throwable  {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.training-support.net/selenium/javascript-alerts");

	}
	
	@When("^User clicks the Simple Alert button$")
	public void clickSimpleAlert() throws Throwable {
		driver.findElement(By.id("simple")).click();
		
	}
	
	@When("^User clicks the Confirm Alert button$")
	public void clickConfirmAlert()throws Throwable  {
		driver.findElement(By.id("confirm")).click();
		
	}
	
	@When("^User clicks the Prompt Alert button$")
	public void clickPromptAlert()throws Throwable  {
		driver.findElement(By.id("prompt")).click();
		
	}
	
	@Then("^Alert opens$")
	public void AlertOpen() throws Throwable  {
		 alert = driver.switchTo().alert();
		
		
	}
	
	@And("^Read the text from it and print it$")
	public void readAlert() throws Throwable  {
		System.out.println("Text on the alert is : "+alert.getText());
		
	}
	
	@And("^Write a custom message$")
	public void writeToAlert()throws Throwable  {
		alert.sendKeys("ABC");
		
		
	}
	
	@And("^Close the alert$")
	public void closeAlert()throws Throwable  {
		alert.accept();
		
	}
	
	@And("^Close the alert with Cancel$")
	public void dismissAlert()throws Throwable  {
		alert.dismiss();
		
	}
	
	
	@And("^Close the Alert browser$")
	public void closeBrowser() throws Throwable {
		driver.close();
		
	}
	
}
