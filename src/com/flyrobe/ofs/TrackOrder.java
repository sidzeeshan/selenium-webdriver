package com.flyrobe.ofs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackOrder {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\Flyrobe\\lib\\chromedriver.exe");
			   driver = new ChromeDriver();
			   driver.manage().window().maximize();
			   driver.get("url");
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			   //Login
			   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Username']")));
			   driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("email");
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
			   driver.findElement(By.xpath("//div[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[8]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select")));
			   String itemID = driver.findElement(By.xpath(".//b[text()='Item ID']//parent::div")).getText().substring(10, 27);
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[8]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[8]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select/option[2]")).click();   //Measurement Scheduled from placed
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //1 End
			   
			   
			   
			   //2 Start
			   Thread.sleep(3000);
			   Actions action = new Actions(driver);
			   //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title,'men') and text()=normalize-space('Men')]")));
			   WebElement navBar2 = driver.findElement(By.xpath(".//i[@class='fa fa-om']"));
			   WebElement orderMgmt = driver.findElement(By.xpath("//a[@href='#/om/om_confirm']"));  //Order Management
			   action.moveToElement(navBar2).moveToElement(orderMgmt).click().build().perform();
			   
			   //Measurement-->RESERVE MEASURING
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//a[contains(text(),normalize-space('MEASUREMENT'))]")).click();
			   driver.findElement(By.xpath(".//a[text()='RESERVE MEASURING']")).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   //create FE Trip
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@class='onoffswitch-switch']")));
			   driver.findElement(By.xpath(".//span[@class='onoffswitch-switch']")).click();  // on/off FE Trip
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div/div/div/span")).click();
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div/div/input[1]")).sendKeys("zeesh");
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div/div/input[1]")).sendKeys(Keys.ENTER);
			   driver.findElement(By.xpath(".//span[text()='Create FE Trip']")).click();
			   Thread.sleep(1000);
			   driver.findElement(By.xpath(".//*[@id='page-top']/div[4]/div[7]/button[2]")).click(); //OK
			   
			   //select FE Trip 
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div/div/span")).click();
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div/input[1]")).sendKeys(Keys.ENTER);
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and text()='Submit']")).click(); //submit
			   Thread.sleep(1000);
			   driver.findElement(By.xpath(".//*[@id='page-top']/div[4]/div[7]/button[2]")).click(); //OK
			   
			   //FE Assigned (Item Status Change)
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Fitting Expert Assigned'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //2 end
			   
			   
			   
			   //3 start
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.navigate().refresh();
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   //Out for Measurement (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Out For Measurement'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //3 end
			   
			   
			   
			   //4 start
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   Thread.sleep(3000);
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   //Measured (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Measured'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //4 end
			   
			   
			   
			   //5 start
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   Thread.sleep(3000);
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   //Confirm for Final Delivery (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm For Final Delivery'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //5 end
			   
			   
			   //6 start
			   WebElement navBar1 = driver.findElement(By.xpath(".//i[@class='fa fa-cc']"));
			   navBar1.click();
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'DataTables_Table')]/label/input")));
			   
			   //Measurement-->RESERVE MEASURED
			   driver.findElement(By.xpath(".//a[@class='dropdown-toggle' and contains(text(),normalize-space('MEASUREMENT'))]")).click();
			   driver.findElement(By.xpath(".//a[text()='RESERVE MEASURED']")).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   //Delivery Time
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[2]/div[2]/div/div/div/span")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[2]/div[2]/div/div/div/span")).click();
			   driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[2]/div[2]/div/div/input[1]")).sendKeys(Keys.ENTER);
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and text()='Submit']")).click(); //submit
			   Thread.sleep(1000);
			   driver.findElement(By.xpath(".//*[@id='page-top']/div[4]/div[7]/button[2]")).click();
			   //6 end
			   
			   
			   
			   //7 start
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[8]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivery Scheduled'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //7 end
			   
			   
			   
			   //8 start
			   action.moveToElement(navBar2).moveToElement(orderMgmt).click().build().perform();
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   
			   //Delivery-->RESERVE CONFIRM
			   driver.findElement(By.xpath(".//a[contains(text(),normalize-space('DELIVERY'))]")).click();
			   driver.findElement(By.xpath(".//a[text()='RESERVE CONFIRM']")).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   //create DB Trip
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@class='onoffswitch-switch']")));
			   driver.findElement(By.xpath(".//span[@class='onoffswitch-switch']")).click();  // on/off FE Trip
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div/div/div/span")).click();
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div/div/input[1]")).sendKeys("zeesh");
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div/div/input[1]")).sendKeys(Keys.ENTER);
			   driver.findElement(By.xpath(".//span[text()='Create Bike Trip']")).click();
			   Thread.sleep(1000);
			   driver.findElement(By.xpath(".//*[@id='page-top']/div[4]/div[7]/button[2]")).click(); //OK
			   
			   //select DB Trip 
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div/div/span")).click();
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div/input[1]")).sendKeys(Keys.DOWN);
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div/input[1]")).sendKeys(Keys.ENTER);
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and text()='Submit']")).click(); //submit
			   Thread.sleep(1000);
			   driver.findElement(By.xpath(".//*[@id='page-top']/div[4]/div[7]/button[2]")).click(); //OK
			   
			   //Altered Assigned (Item Status Change)
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Altered'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //8 end
			   
			   
			   
			   //9 start
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   //In QC Reserve (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('In Qc Reserve'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //9 end
			   
			   
			   
			   //10 start
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   //Packaged (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Packaged'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //10 end
			   
			   
			   
			   //11 start
			   WebElement logistics = driver.findElement(By.xpath("//a[@href='#/om/om-logistics']"));  //Order Management
			   action.moveToElement(navBar2).moveToElement(logistics).click().build().perform();
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='example_filter']/label/input")));
			   
			   //Delivery-->RESERVE CONFIRM
			   driver.findElement(By.xpath(".//a[contains(text(),normalize-space('DELIVERY'))]")).click();
			   driver.findElement(By.xpath(".//a[text()='RESERVE CONFIRM']")).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='example_filter']/label/input")));
			   driver.findElement(By.xpath(".//*[@id='example_filter']/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[@id='example']/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[@id='example']/tbody/tr/td[1]")).click();
			   
			   //Delivery Boy Assign (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivery Boy Assign'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //11 end
			   
			   
			   
			   //12 start
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='example_filter']/label/input")));
			   driver.findElement(By.xpath(".//*[@id='example_filter']/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[@id='example']/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[@id='example']/tbody/tr/td[1]")).click();
			   
			   //Out For Delivery (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Out For Delivery'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //12 end
			   
			   
			   
			   //13 start
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='example_filter']/label/input")));
			   driver.findElement(By.xpath(".//*[@id='example_filter']/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[@id='example']/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[@id='example']/tbody/tr/td[1]")).click();
			   
			   //Delivered (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivered'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //13 end
			   
			   
			   
			   //14 start
			   navBar1.click();
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   
			   //Pickup-->PICKUP RESERVE
			   driver.findElement(By.xpath(".//a[contains(text(),normalize-space('PICKUP'))]")).click();
			   driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[2]/a")).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			   
			   //pickup time
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Pickup Time']//parent::div/div/div/span")));
			   driver.findElement(By.xpath("//label[text()='Pickup Time']//parent::div/div/div/span")).click();
			   List<WebElement> pickUpTime = driver.findElements(By.xpath("//label[text()='Pickup Time']//parent::div/div/input[1]"));
			   pickUpTime.get(pickUpTime.size()-2).sendKeys(Keys.ENTER);
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and text()='Submit']")).click(); //submit
			   
			   //Pickup Scheduled (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//option[text()='Select Status']//parent::select[1]")));
			   driver.findElement(By.xpath(".//option[text()='Select Status']//parent::select[1]")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Pickup Scheduled'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //14 end
			   
			   
			   
			   //15 start
			   action.moveToElement(navBar2).moveToElement(logistics).click().build().perform();
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='example_filter']/label/input")));
			   
			   //Pickup-->PICKUP RESERVE
			   List<WebElement> logPickUp = driver.findElements(By.xpath(".//a[contains(text(),normalize-space('PICKUP'))]"));
			   logPickUp.get(0).click();
			   driver.findElement(By.xpath(".//a[contains(text(),normalize-space('RESERVE PICKUP'))]")).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='example_filter']/label/input")));
			   driver.findElement(By.xpath(".//*[@id='example_filter']/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[@id='example']/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[@id='example']/tbody/tr/td[1]")).click();
			   
			   //create Biker Trip
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@class='onoffswitch-switch']")));
			   driver.findElement(By.xpath(".//span[@class='onoffswitch-switch']")).click();  // on/off FE Trip
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div/div/div/span")).click();
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div/div/input[1]")).sendKeys("zeesh");
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div/div/input[1]")).sendKeys(Keys.ENTER);
			   driver.findElement(By.xpath(".//span[text()='Create Bike Trip']")).click();
			   Thread.sleep(1000);
			   driver.findElement(By.xpath(".//*[@id='page-top']/div[4]/div[7]/button[2]")).click(); //OK
			   
			   //select Biker Trip 
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div/div/span")).click();
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div/input[1]")).sendKeys(Keys.ENTER);
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and text()='Submit']")).click(); //submit
			   Thread.sleep(1000);
			   driver.findElement(By.xpath(".//*[@id='page-top']/div[4]/div[7]/button[2]")).click(); //OK
			   
			   //Out for PickUp (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Out For Pickup'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //15 end
			   
			   
			   
			   //16 start
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='example_filter']/label/input")));
			   driver.findElement(By.xpath(".//*[@id='example_filter']/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[@id='example']/tbody/tr/td[1]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[@id='example']/tbody/tr/td[1]")).click();
			   
			   //Picked Up (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[6]/div[2]/div/div/div[1]/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Picked Up'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('SUBMIT'))]")).click();   //submit
			   //16 end
			   
			   
			   
			   //17 start
			   WebElement navBar3 = driver.findElement(By.xpath(".//i[@class='fa fa-laundry']"));
			   WebElement pickedUp = driver.findElement(By.xpath(".//a[text()='Picked Up']"));  //Picked UP
			   action.moveToElement(navBar3).moveToElement(pickedUp).click().build().perform();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//a[contains(text(),normalize-space('Express'))]")).click();
			   driver.findElement(By.xpath(".//a[contains(text(),normalize-space('EXPRESS'))]")).click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[2]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]/div/label/i[1]")).click();
			   
			   //In Post Return Qc (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('In Post Return Qc'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('Update Status'))]")).click();   //Update status
			   //17 end
			   
			   
			   
			   //18 start
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys("FMR057908");
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[2]"), "FMR057908"));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]/div/label/i[1]")).click();
			   
			   //Qc Done(sd Initiated) (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Qc Done(sd Initiated)'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('Update Status'))]")).click();   //Update status
			   //18 end
			   
			   
			   
			   //19 start
			  /* WebElement navBar4 = driver.findElement(By.xpath(".//i[contains(@class,'fa fa-inr')]"));
			   WebElement refundCalling = driver.findElement(By.xpath(".//a[text()='Refund Calling']"));  //Refund Calling
			   action.moveToElement(navBar4).moveToElement(refundCalling).click().build().perform();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));*/
			   //19 end
			   
			   
			   
			   //20 start
			   WebElement laundryItems = driver.findElement(By.xpath(".//a[text()='Laundry Items']"));  //Laundry Items
			   action.moveToElement(navBar3).moveToElement(laundryItems).click().build().perform();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/label/input")).sendKeys(itemID);
			   wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[2]"), itemID));
			   driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]/div/label/i[1]")).click();
			   
			   //Qc Done(sd Initiated) (Item Status Change)
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select")));
			   driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/table[2]/tbody/tr/td[3]/select")).click();
			   driver.findElement(By.xpath(".//option[contains(text(),normalize-space('In Post Laundry Qc'))]")).click();
			   
			   driver.findElement(By.xpath(".//button[contains(@class,'btn btn-primary') and contains(text(),normalize-space('Update Status'))]")).click();   //Update status
			   //20 end
			   
			   //div[contains(@id,'DataTables_Table')]/label/input
			   //*[contains(@id,'DataTables_Table')]/tbody/tr[1]/td[1]
			   
			   //b[text()='Item ID']//parent::div/text()

	}

}
