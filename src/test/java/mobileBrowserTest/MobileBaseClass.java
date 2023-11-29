package mobileBrowserTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBaseClass {

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
		options.setCapability("browserName", "chrome");

		driver = new AndroidDriver(new URL("http://192.168.104.144:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public Double getFormattedValue(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	@AfterClass
	public void teardown() {
		driver.quit();
		// stop server
		service.stop();
	}
}
