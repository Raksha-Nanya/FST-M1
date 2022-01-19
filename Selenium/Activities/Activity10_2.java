package Selenium_Activity;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.apache.commons.math3.ode.events.EventHandler.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

	public static void main(String[] args) throws HeadlessException,UnsupportedFlavorException,IOException {
		 	WebDriver driver = new FirefoxDriver();
	        Actions actions = new Actions(driver);
	        String pressedKeyText;
	 
	        //Open browser
	        driver.get("https://www.training-support.net/selenium/input-events");
	        WebElement pressedKey = driver.findElement(By.id("keyPressed"));
	        
	        //Create action sequence for initials
	        actions.sendKeys("R").build().perform();
	        pressedKeyText = pressedKey.getText();
	        System.out.println("Pressed key is: " + pressedKeyText);
	                
	        //Create action sequence for Spacebar
	        org.openqa.selenium.interactions.Action actionSequence2 = actions
	                .keyDown(Keys.CONTROL)
	                .sendKeys("a")
	                .sendKeys("c")
	                .keyUp(Keys.CONTROL)
	                .build();
	        actionSequence2.perform();
	        pressedKeyText = pressedKey.getText();
	        String data =  (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
	        System.out.println(data);
	 
	        //Close browser
	        driver.close();

	}

}
