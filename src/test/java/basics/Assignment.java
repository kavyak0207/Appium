package basics;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Assignment extends BaseClass {
	
	@Test
	public void practice() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		driver.findElement(By.id("android:id/button1")).click();
		//String mess = driver.findElement(By.id("android:id/alertTitle")).getText();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
		/*
		 * driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		 * driver.findElement(By.xpath("(//android.widget.TextView)[2]")).click();
		 * String mess =driver.findElement(By.id("android:id/message")).getText();
		 * System.out.println(mess);
		 */
		
		//driver.findElement(By.id("android:id/list")).click();
		driver.findElement(AppiumBy.accessibilityId("Progress dialog")).click();
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[3]")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Eunhyuk");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("EunLee@44");
		driver.findElement(By.id("android:id/button1")).click();
	}

}
