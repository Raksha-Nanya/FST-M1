package SeleniumActivity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) throws InterruptedException {
		// control + Shift + O
		WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        driver.quit();

	}

}
