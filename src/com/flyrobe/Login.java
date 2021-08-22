package com.flyrobe;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends Config {
	//public static WebDriver driver = Config.driver;
	
	public static void proceedToPayment() throws InterruptedException {
		Thread.sleep(3000);
		DataExtraction.top();
		driver.navigate().refresh();
		//driver.findElement(By.cssSelector("span.font-base-regular.logo.mdl-layout-title"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'btn') and text()='PROCEED TO PAYMENT']")));
		DataExtraction.top();
		driver.findElement(By.xpath("//button[contains(@class, 'btn') and text()='PROCEED TO PAYMENT']")).click();
		Thread.sleep(5000);
	}

	public static void googleLogin() throws InterruptedException {   //done
		// Click on google
		//driver.findElement(By.xpath("html/body/div[5]/div[1]/login-form/div/div[2]/div/div/div[2]/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		if (url.equals("url")) {
			driver.findElement(By.xpath("//a[contains(@title,'login') and text()='Login']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(@class, 'google-btn')]")));
		}
		driver.findElement(By.xpath(".//button[contains(@class, 'google-btn')]")).click();
		Thread.sleep(2000);
				
		// Login with google
		Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		String window2 = (String) AllWindowHandles.toArray()[1];

		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='email']")));
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("enter email here");
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[@id='next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("enter password here");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Switch to window1(parent window) and performing actions on it.
		driver.switchTo().window(window1);
		//Thread.sleep(5000);

	}
	
	public static void facebookLogin() throws InterruptedException {   //done
		//click on FB
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String url = driver.getCurrentUrl();
		//System.out.println(url);
		if (url.equals("url")) {
			driver.findElement(By.xpath("//a[contains(@title,'login') and text()='Login']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(@class, 'fb-btn')]")));
		}
		driver.findElement(By.xpath(".//button[contains(@class, 'fb-btn')]")).click();
		Thread.sleep(2000); 
		
		// Login with FB
				Set<String> AllWindowHandles = driver.getWindowHandles();
				String window1 = (String) AllWindowHandles.toArray()[0];
				String window2 = (String) AllWindowHandles.toArray()[1];

				// Switch to window2(child window) and performing actions on it.
				driver.switchTo().window(window2);
				driver.findElement(By.xpath("//*[@id='email']")).sendKeys("email");
				driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("poasswd");
				driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
				Thread.sleep(2000);

				// Switch to window1(parent window) and performing actions on it.
				driver.switchTo().window(window1);
		
		
	}

}
