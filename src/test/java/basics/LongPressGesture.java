package basics;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPressGesture extends BaseClass {

	@Test
	public void longPress() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(ele);
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText, "Sample menu");
		// (or)
		// Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		Thread.sleep(3000);
	}
}
