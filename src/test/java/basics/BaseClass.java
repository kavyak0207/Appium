package basics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		// to start appium server programmaticaly
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\2173346\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.104.144").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Demo1");
		options.setChromedriverExecutable("C:\\Users\\2173346\\eclipse\\eclipse workspace\\Appium\\drivers\\chromedriver.exe");
		options.setApp("C:\\Users\\2173346\\eclipse\\eclipse workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");

		driver = new AndroidDriver(new URL("http://192.168.104.144:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void scrollToEnd() throws InterruptedException {
		// no prior data
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (canScrollMore);
		Thread.sleep(2000);
	}

	public void swipeGesture(WebElement elem,String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)elem).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public void dragAndDrop(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", 594,
			    "endY", 527
			));
	}
	@AfterClass
	public void teardown() {
		driver.quit();
		// stop server
		service.stop();
	}
}
