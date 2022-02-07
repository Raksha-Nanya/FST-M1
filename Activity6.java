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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Activity6 {
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
      driver.get("https://www.training-support.net/selenium");
      
  }

  @Test(priority=0)
  public void validLogin() throws InterruptedException {
	 
	  
	  for (int i = 0; i < 4; i++) {
		  driver.findElement(MobileBy.AndroidUIAutomator(
	              "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()")); 
		} 
	  MobileElement locator=driver.findElementByXPath("//android.view.View[19]/android.view.View");
	  
	  locator.click();
	  driver.findElementByXPath("//android.widget.Button[@bounds='[363,1106][704,1249]']").click();	
	  //driver.findElement(MobileBy.id("android:id/username")).sendKeys("admin");
	  //driver.findElement(MobileBy.id("android:id/password")).sendKeys("password");
	 
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("admin");
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password");	  
	  driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
	  
	  MobileElement  message= driver.findElementByXPath("//android.view.View[contains(@text,'Welcome')]");
	  
	  Assert.assertEquals(message.getText(), "Welcome Back, admin");
	  
	 
	  }
  @Test(priority=1)
  
  public void invalidLogin() throws InterruptedException {
	  
	
	  driver.findElementByXPath("//android.view.View/android.view.View[5]/android.widget.Button").click();
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("adminn");
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("passworddd");	  
	  driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
	  
	  MobileElement  message= driver.findElementByXPath("//android.view.View[contains(@text,'Invalid')]");
	  
	  Assert.assertEquals(message.getText(), "Invalid Credentials");
	
	  
	  
	  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
