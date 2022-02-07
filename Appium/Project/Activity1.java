package appiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
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

public class Activity1 {
	WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;
 
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "pixelEmulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 20);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
  }

  @Test
  public void addTask() throws InterruptedException {
	  String[] strArray = {"Complete Activity with Google Tasks", "Complete Activity with Google Keep", "Complete the second Activity Google Keep"};
	  List<String> mylist = Arrays.asList(strArray);
	  
	  for(String val : mylist){
		 
		  MobileElement Createtask = driver.findElement(MobileBy.AccessibilityId("Create new task"));
		  wait.until(ExpectedConditions.visibilityOf(Createtask));
		  Createtask.click();
		  
		  
		  String newTask1 = "text(\"New task\")";
		  MobileElement Createnewtask = driver.findElement(MobileBy.AndroidUIAutomator(newTask1));
		  wait.until(ExpectedConditions.visibilityOf(Createnewtask));
		  Createnewtask.sendKeys(val);
		  
		  String Save1 = "text(\"Save\")"; 
		  MobileElement saveNewtask = driver.findElement(MobileBy.AndroidUIAutomator(Save1));
		  saveNewtask.click();
         
       }
	  
	  /*
      MobileElement task1= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Google Tasks\"]/android.view.ViewGroup/android.widget.TextView");
      MobileElement task2= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Google Keep\"]/android.view.ViewGroup/android.widget.TextView");
      MobileElement task3= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"second Activity\"]/android.view.ViewGroup/android.widget.TextView");
      */
	  
	  MobileElement task1= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView");
	  MobileElement task2= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView");
      MobileElement task3= driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView");
      
      Assert.assertEquals(task1.getText(), "Complete the second Activity Google Keep");
      Assert.assertEquals(task2.getText(), "Complete Activity with Google Keep");
      Assert.assertEquals(task3.getText(), "Complete Activity with Google Tasks");
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
