package appiumAcivity;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	AndroidDriver<MobileElement> driver;
 
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "pixelEmulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.android.calculator2");
      caps.setCapability("appActivity", ".Calculator");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
  }
  
  
  @Test
  public void Calculate() throws IOException {
	  driver.findElementById("digit_5").click();
	  driver.findElementByAccessibilityId("multiply").click();
	  driver.findElementByXPath("//android.widget.Button[@text='9']").click();
	  
      // Perform Calculation
      driver.findElementById("eq").click();

      // Display Result
      String result = driver.findElement(MobileBy.id("result")).getText();
      System.out.println(result);
    
      // Assertion
      Assert.assertEquals(result, "45");
  }
  
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
