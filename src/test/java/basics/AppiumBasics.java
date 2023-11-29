package basics;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseClass {

	@Test
	public void appiumTest() throws MalformedURLException {

		// Actual automation
		// XPath, id, accessibilityId, className,androidUIAutomator

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String actTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Eunhyuk");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
}
