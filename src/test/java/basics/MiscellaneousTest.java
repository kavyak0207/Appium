package basics;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousTest extends BaseClass {

	@Test
	public void appiumTest() throws MalformedURLException {
		// adb shell dumpsys window | find "mCurrentFocus"
		// Actuall automation
		// xpath,id, accessibilityId,classname,androidUIAutomator
		//Activity activity = new Activity("io.appium.android.apis",
				//"io.appium.android.apis.preference.PreferenceDependencies");
		//driver.startActivity(activity);
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String actTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actTitle, "WiFi settings");

		driver.setClipboardText("Eunhyuk");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}
