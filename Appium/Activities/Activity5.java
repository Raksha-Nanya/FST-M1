package appiumAcivity;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity5 {
	AndroidDriver driver = null;
	WebDriverWait wait ;
 
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "pixelEmulator");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("automationName", "UiAutomator2");
	  caps.setCapability("appPackage", "com.google.android.apps.messaging");
	  caps.setCapability("appActivity", ".ui.ConversationListActivity");
	  caps.setCapability("noReset", true);

	  // Instantiate Appium Driver
	  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	  driver = new AndroidDriver<MobileElement>(appServer, caps);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  wait = new WebDriverWait(driver,10);

  }
  
  @Test
  public void messageMe() throws InterruptedException {
	  driver.findElement(MobileBy.AccessibilityId("Start new conversation")).click();
	  
	  
	  String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(contactBoxLocator)));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("1234567890");
	  
	  //select the number
	  
	  //driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/contact_picker_create_group\")")).click();
	  
	  ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	  
	  String composeMessage = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
	  
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(composeMessage)));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator(composeMessage)).sendKeys("ABC");
	  
	  
	  String sendMessage ="resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")";
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(sendMessage)));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator(sendMessage)).click();
	  
	  String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageLocator)));
      
      String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
      Assert.assertEquals(sentMessageText, "Hello from Appium");
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
