package com.flyrobe;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout extends Config {
	//public static WebDriver driver = Config.driver;
	//static List<WebElement> allinks= driver.findElements(By.xpath("//button[contains(@class, 'accordion')]"));
	
	public static void couponSelection() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cpnSelector")));
		driver.findElement(By.className("cpnSelector")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//input[@placeholder='Coupon Code']")));
		driver.findElement(By.xpath(".//input[@placeholder='Coupon Code']")).sendKeys("asadssa");
		driver.findElement(By.cssSelector(".btn.dark-blue-btn.lg-width")).click();
		/* javascript.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();*/
		Thread.sleep(1000);
		List<WebElement> removeCoupon = driver.findElements(By.cssSelector(".text-red.underline.small-font.clickable"));
		removeCoupon.get(removeCoupon.size()-2).click();
		  
	}
	
	public static void deliveryAddress() throws InterruptedException { //done
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//h6[contains(@class, 'ng-scope') and text()='Secure Checkout']"),
				"Secure Checkout"));
		/*driver.navigate().refresh();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//h6[contains(@class, 'ng-scope') and text()='Secure Checkout']"),
				"Secure Checkout"));*/
		driver.findElement(By.id("hereButton")).click();
		Thread.sleep(3000);
	}
	
	public static void measurements() throws InterruptedException {  //done
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		//Measurement
		List<WebElement> measurementSchedule = driver.findElements(By.xpath(".//div[contains(@class,'datePick')]"));
		System.out.println("No. of available Measurement Dates: "+measurementSchedule.size());
		driver.findElement(By.xpath(".//div[contains(@class,'datePick')][1]/child::div[2]")).click();
		
		List<WebElement> measurementTimeSlots = driver.findElements(By.xpath(".//div[contains(@class,'slotSelect')]/descendant::div"));
		System.out.println("No. of available Measurement Dates: "+measurementTimeSlots.size());
		driver.findElement(By.xpath(".//div[contains(@class,'slotSelect')]/descendant::div[1]")).click();
		
		WebElement element1 = driver.findElement(By.xpath(".//div[contains(@class,'datePick')][1]/child::div[2]"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element1);
		
		driver.findElement(By.id("continueButton")).click();
		
		Thread.sleep(3000);
		
	}
	
	public static void payment() throws InterruptedException { // done
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.cssSelector(".accordion.active"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element);
		
		driver.findElement(
				By.xpath("//span[contains(@class, 'payType') and contains(text(),normalize-space('CASH/CARD ON DELIVERY'))]"))
				.click();
		Thread.sleep(2000);
	}
	
	public static void placeOrder() throws InterruptedException {   //done
		WebDriverWait wait = new WebDriverWait(driver, 40);
		List<WebElement> placeOrder = driver.findElements(
				By.xpath("//button[contains(@class, 'mdl-button') and text()=normalize-space('RENT NOW')]"));
		placeOrder.get(placeOrder.size()-1).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.text-light-grey.font-base-medium.big-font")));
		String orderNo = driver.findElement(By.cssSelector("div.text-light-grey.font-base-medium.big-font")).getText().trim();
		System.out.println(orderNo.substring(10));
		Thread.sleep(3000);
		driver.navigate().to("https://node.flyrobeapp.com:8002/escalationDashboardNewDB");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("order-parent-id")));
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit_get_report")));
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
		
		
	}

}
