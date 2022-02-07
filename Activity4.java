package appiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity4 {
	WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;
 
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "pixelEmulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.chrome");
      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 20);
      driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
      driver.get("https://www.training-support.net/selenium");
  }

  @Test
  public void toDoList() throws InterruptedException {
	  
	  String[] Data = {"Add tasks to list","Get number of tasks","Clear the list"};
	  //List aray = new ArrayList();
	  List<String> mylist = Arrays.asList(Data);
	  
	  
	  MobileElement locator=driver.findElementByXPath("//android.view.View[15]/android.view.View");
			 
	  for (int i = 0; i < 3; i++) {
		  driver.findElement(MobileBy.AndroidUIAutomator(
	              "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
		  
		} 
	 
	  locator.click();
	  
	  
	  for (String List : mylist){
		  driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys(List);
		  Thread.sleep(1000);
		  driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
		  
		  Thread.sleep(1000);
		  
	  }
	  
	  MobileElement locator1= driver.findElementByXPath("//android.view.View[@resource-id='tasksList']/android.view.View[2]/android.view.View");	  
	  MobileElement locator2= driver.findElementByXPath("//android.view.View[@resource-id='tasksList']/android.view.View[3]/android.view.View");
	  MobileElement locator3 =driver.findElementByXPath("//android.view.View[@resource-id='tasksList']/android.view.View[4]/android.view.View");
	  
	  
	  Assert.assertEquals(locator1.getText(), "Add tasks to list");
	  Assert.assertEquals(locator2.getText(), "Get number of tasks");
	  Assert.assertEquals(locator3.getText(), "Clear the list");
	
	  
	  locator1.click();
	  locator2.click();
	  locator3.click();
	  
	  driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']/android.view.View[3]").click();
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
