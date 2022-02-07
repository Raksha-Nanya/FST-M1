package appiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity3 {
	WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "pixelEmulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.google.android.keep");
      caps.setCapability("appActivity", ".activities.BrowseActivity");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 20);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void addReminder() {
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"New text note\"]").click();
	  //driver.findElementById("com.google.android.keep:id/title_editor_fragment").click();
	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("My Note");
	  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("This is my Note. Thanks");
	  
	 //Add reminder
	  driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Reminder\"]").click();
	  driver.findElementByXPath("//android.widget.TextView[@text=\"Later today\"]").click();
	  
	  //Go back
	  driver.findElement(MobileBy.AccessibilityId("Open navigation drawer")).click();
	  
	  //Assert for Title
	  
	  MobileElement title = driver.findElementByXPath("//android.widget.TextView[@text='My Note']"); 
	  Assert.assertEquals(title.getText(), "My Note");
	  
	  //Assert for Reminder
	  
	  MobileElement reminder = driver.findElementByXPath("//android.widget.TextView[@text=\"Today, 6:00 PM\"]"); 
	  Assert.assertEquals(reminder.getText(), "Today, 6:00 PM");
	  
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
