package appiumAcivity;

import java.net.MalformedURLException;
import java.net.URL;
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

public class Activity4 {
	WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;
 
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "pixelEmulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.contacts");
      caps.setCapability("appActivity", ".activities.PeopleActivity");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 20);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void addContact() {
      // Wait for app to load
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new contact")));

      // Click on add new contact floating button
      driver.findElementByAccessibilityId("Create new contact").click();

      // Wait for fields to load
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='First name']")));

      // Find the first name, last name, and phone number fields
      MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
      MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
      MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");

      // Enter the text in the fields
      firstName.sendKeys("REETU");
      lastName.sendKeys("NI");
      phoneNumber.sendKeys("1234567898");

      // Save the contact
      driver.findElementById("editor_menu_save_button").click();

      // Wait for contact card to appear
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));

      // Assertion
      MobileElement mobileCard = driver.findElementById("toolbar_parent");
      Assert.assertTrue(mobileCard.isDisplayed());

      String contactName = driver.findElementById("large_title").getText();
      Assert.assertEquals(contactName, "REETU NI");
  }

  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
