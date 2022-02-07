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

public class Activity2 {
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
  public void addNote() {
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"New text note\"]").click();
	  //driver.findElementById("com.google.android.keep:id/title_editor_fragment").click();
	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("My Note");
	  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("This is my Note. Thanks");
	  
	  driver.findElement(MobileBy.AccessibilityId("Open navigation drawer")).click();
	  
	  MobileElement title = driver.findElementByXPath("//androidx.cardview.widget.CardView[contains(@content-desc,\"My Note.\")]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]");
	  
	  Assert.assertEquals(title.getText(), "My Note");
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
