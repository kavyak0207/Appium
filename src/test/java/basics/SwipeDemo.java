package basics;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseClass {

	@Test
	public void swipeGesture() throws MalformedURLException, InterruptedException {
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
	WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
	Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
	//Swipe
	swipeGesture(firstImage,"left");
	Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
	
}
}
