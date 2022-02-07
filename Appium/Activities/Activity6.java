package appiumAcivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Activity6 {
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
	      driver.get("https://www.training-support.net/selenium/lazy-loading");
	  }

  @Test
  public void ScrollTest() {
	  MobileElement pageTitle = driver.findElementByXPath("//android.view.View[@text='Lazy Loading']");
      wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));

      // Count the number of images shown on the screen
      List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
      System.out.println("Number of image shown currently: " + numberOfImages.size());

      // Assertion before scrolling
      Assert.assertEquals(numberOfImages.size(), 2);
      
      // Scroll to Helen's post
      AndroidElement element =  (AndroidElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).index(0)).scrollIntoView(new UiSelector().text(\"helen\"))"));
      //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));

      // Find the number of images shown after scrolling
      numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
      System.out.println("Number of image shown currently: " + numberOfImages.size());

      // Assertion after scrolling
      Assert.assertEquals(numberOfImages.size(), 15);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
