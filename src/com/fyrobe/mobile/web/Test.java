package com.fyrobe.mobile.web;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	static DesiredCapabilities  capabilities;
	 static String DeviceName;

	public static void main(String[] args) throws InterruptedException {
		DeviceName = "Apple iPhone 5";
		//  DeviceName = "Apple iPad 3 / 4";

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
		String orderno="MMR060525";
		
		driver.close();
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("url");
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.className("order-parent-id")));
		driver.findElement(By.className("order-parent-id")).clear();
		driver.findElement(By.className("order-parent-id")).sendKeys(orderno);
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
