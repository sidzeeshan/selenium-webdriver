package com.fyrobe.mobile.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\Flyrobe\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("url");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		int i=1;
		
		while(i==1) {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='content']/div/div[4]/pre/span[1]/b[1]")));
			System.out.println(driver.findElement(By.xpath(".//*[@id='content']/div/div[4]/pre/span[1]/b[1]")).getText());
		}

	}

}
