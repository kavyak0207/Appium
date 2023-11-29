package basics;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseClass {

	@Test
	public void ScrollDemoTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		// Where to scroll is known prior
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        //no prior idea
		scrollToEnd();
	}

}
