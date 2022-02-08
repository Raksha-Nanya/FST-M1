package appiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Activity5 {
	WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;
 
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
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
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
  }

  @Test(priority=0)
  public void validLogin() throws InterruptedException {
	  driver.get("https://www.training-support.net/selenium");
	  driver.findElementByXPath("//android.widget.Button[@text='Login']").click();
	  Thread.sleep(1000);
	  driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys("admin");
	  driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("password");
	  driver.findElementByXPath("//android.widget.Button[@text='Log In']").click();
	  
	  MobileElement message = driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View[2]");
	  
	  Assert.assertEquals(message.getText(), "Something went wrong.");
	  
	  
	  }
  @Test((priority=1)
  public void inalidLogin() throws InterruptedException {
	  driver.get("https://www.training-support.net/selenium");
	  driver.findElementByXPath("//android.widget.Button[@text='Login']").click();
	  Thread.sleep(1000);
	  driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys("admin");
	  driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("password");
	  driver.findElementByXPath("//android.widget.Button[@text='Log In']").click();
	  
	  MobileElement message = driver.findElementByXPath("//android.view.View/android.view.View[2]/android.view.View[2]");
	  
	  Assert.assertEquals(message.getText(), "Something went wrong.");
	  
	  
	  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
