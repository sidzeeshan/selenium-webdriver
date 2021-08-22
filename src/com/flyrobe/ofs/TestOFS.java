package com.flyrobe.ofs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestOFS {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\Flyrobe\\lib\\chromedriver.exe");
			   driver = new ChromeDriver();
			   driver.manage().window().maximize();
			   driver.get("url");
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			   //Login
			   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Username']")));
			   driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Username");
			   driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("passwd");
			   driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
			   
			   //search box wait
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'DataTables_Table')]/label/input")));
			   driver.navigate().refresh();
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'DataTables_Table')]/label/input")));
			   //Placed Order--->Reserve
			   driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[1]/a")).click();
			   driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[1]/ul/li[2]/a")).click();
			   
		       //1 start
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'DataTables_Table')]/label/input")));   //search box wait
			   driver.findElement(By.xpath("//div[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR054128");
			   wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR054128"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   /*JavascriptExecutor javascript = (JavascriptExecutor) driver;
			   
			   WebElement element = driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[5]/div[2]/button"));
			   javascript.executeScript("arguments[0].scrollIntoView(true);",element);*/
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[8]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select")));
			   System.out.println(driver.findElement(By.xpath(".//b[text()='Item ID']//parent::div")).getText().substring(10, 27));

	}

}
