package mobileBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTest extends MobileBaseClass{
	
	@Test
	public void mobileBrowser() {
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.xpath("//a[@routerlink='/products']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)","");
		
		String text = driver.findElement(By.xpath("//a[normalize-space()='Devops']")).getText();
		Assert.assertEquals(text, "Devops");
	}

}
