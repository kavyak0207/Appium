package E_Commerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce_tc2 extends BaseClass2 {

	@Test
	public void fillForm() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hyukjae Lee");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Autria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		/*
		 * //or 
		 * driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		 * driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		 */	
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		List<WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		int productCount = productPrice.size();
		double sum =0;
		
		for(int i=0;i<productCount;i++) {
			String amount = productPrice.get(i).getText();
			Double price = getFormattedValue(amount);
			sum = sum+price;
		}

		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayedAmount =getFormattedValue(displaySum);
		Assert.assertEquals(sum,displayedAmount);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.xpath("//android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);
	}

}
