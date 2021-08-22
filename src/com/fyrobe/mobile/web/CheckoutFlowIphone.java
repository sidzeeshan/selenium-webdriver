package com.fyrobe.mobile.web;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flyrobe.DataExtraction;

public class CheckoutFlowIphone {
	static DesiredCapabilities  capabilities;
	 static String DeviceName;

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		//some Sample Devices. Complete list can be found here: https://code.google.com/p/chromium/codesearch#chromium/src/chrome/test/chromedriver/chrome/mobile_device_list.cc
		  //pick any of the device
		  
		//  DeviceName = "Google Nexus 5";
		//  DeviceName = "Samsung Galaxy S4";
		//  DeviceName = "Samsung Galaxy Note 3";
		//  DeviceName = "Samsung Galaxy Note II";
		//  DeviceName = "Apple iPhone 4";
		    DeviceName = "Apple iPhone 5";
		//  DeviceName = "Apple iPad 3 / 4";
		//	DeviceName = "Apple iPhone 6 Plus";

		  System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium\\Flyrobe\\lib\\chromedriver.exe");
		  
		  Map<String, String> mobileEmulation = new HashMap<String, String>();
		  mobileEmulation.put("deviceName", DeviceName);
		  
		  Map<String, Object> chromeOptions = new HashMap<String, Object>();
		  chromeOptions.put("mobileEmulation", mobileEmulation);

		  capabilities = DesiredCapabilities.chrome();
		  capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		  WebDriver driver = new ChromeDriver(capabilities);
		  
		  driver.manage().window().maximize();
			driver.get("url");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//div[contains(@class, 'big-font') and text()='SELECT YOUR CITY']"),
				"SELECT YOUR CITY"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class, 'mdl-radio__label') and contains(text(),normalize-space('Mumbai'))]")));
		driver.findElement(
				By.xpath("//span[contains(@class, 'mdl-radio__label') and contains(text(),normalize-space('Delhi / NCR'))]"))
				.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("material-icons")));
		
		driver.findElement(By.xpath(".//*[@id='mdl-js-layout']/div[2]")).click();
		
		driver.findElement(By.xpath(".//a[text()=normalize-space('WOMEN')]")).click();
		
		driver.findElements(By.xpath(".//*[@id='drawer-western']//a[text()='Lehengas']")).get(0).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='gender' and @value='M - L']")));
		
		driver.findElement(By.xpath("//input[@name='gender' and @value='M - L']")).click();
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='product-card']/div[2]/div[1]/div[1]/div")));
		
		/*driver.navigate().refresh();
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='product-card']/div[2]/div[1]/div[1]/div")));*/
		
		driver.findElements(By.className("product-img")).get(0).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("datetimepicker")));
		
		driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("datetimepicker")));
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//*[@id='product-details']/div[2]/div[4]/div/div/div[2]/div[2]/span"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='datetimepicker'][1]")).click();
		
		Thread.sleep(1000);

		Boolean datenotfound = true;

		while (datenotfound) {
			List<WebElement> enabledDate = driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]"));
			if (enabledDate.size() > 0) {
				driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]")).click();
				datenotfound = false;
			} else {
				driver.findElement(By.cssSelector(".xdsoft_next")).click();
				Thread.sleep(3000);
			}
		}
		
		driver.findElement(By.xpath("//button[contains(@class, 'button') and contains(text(),normalize-space('ADD TO CART'))]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'btn') and text()='PROCEED TO PAYMENT']")));
		driver.findElement(By.xpath("//button[contains(@class, 'btn') and text()='PROCEED TO PAYMENT']")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(@class, 'fb-btn')]")));
		
		driver.findElement(By.xpath(".//button[contains(@class, 'fb-btn')]")).click();
		Thread.sleep(2000); 
	
		// Login with FB
		Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		String window2 = (String) AllWindowHandles.toArray()[1];

		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='email']")));
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("email");
		driver.findElement(By.xpath("//*[@name='pass']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@value='Log In']")).click();
		Thread.sleep(2000);

		// Switch to window1(parent window) and performing actions on it.
		driver.switchTo().window(window1);
	 	
	 	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hereButton")));
		driver.findElement(By.id("hereButton")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class,'datePick')][1]/child::div[2]")));
		driver.findElement(By.xpath(".//div[contains(@class,'datePick')][1]/child::div[2]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class,'slotSelect')]/descendant::div[1]")));
		driver.findElement(By.xpath(".//div[contains(@class,'slotSelect')]/descendant::div[1]")).click();
		
		driver.findElement(By.id("continueButton")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class, 'payType') and contains(text(),normalize-space('CASH ON DELIVERY'))]")));
		driver.findElement(By.xpath("//span[contains(@class, 'payType') and contains(text(),normalize-space('CASH ON DELIVERY'))]")).click();
		
		List<WebElement> placeOrder = driver.findElements(
				By.xpath("//button[contains(@class, 'mdl-button') and contains(text(),normalize-space('RENT NOW'))]"));
		placeOrder.get(placeOrder.size()-2).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.text-light-grey.font-base-medium.big-font")));
		String orderNo = driver.findElement(By.cssSelector("div.text-light-grey.font-base-medium.big-font")).getText().trim();
		System.out.println(orderNo.substring(10));
		
		driver.quit();
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("url");
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.className("order-parent-id")));
		driver.findElement(By.className("order-parent-id")).clear();
		driver.findElement(By.className("order-parent-id")).sendKeys(orderNo.substring(10));
		driver.findElement(By.id("submit_get_report")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='order_status_update']")).click();
		Alert A1 = driver.switchTo().alert();
		A1.accept();
		Thread.sleep(2000);
		Alert A2 = driver.switchTo().alert();
		A2.accept();
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("submit_get_report")));
		driver.findElement(By.id("submit_get_report")).click();
		Thread.sleep(5000);
		String test = driver.findElement(By.xpath("//*[@id='example']/tbody/tr/td[4]")).getText();
		System.out.println(test);
		if(test.equals("TEST")) {
			System.out.println("Order Test Marked Successfully");
		}
		else {
			System.out.println("Order Test Marked not Successful");
		}
		
		Thread.sleep(10000);
		  
		  driver.quit();
		

	}

}
