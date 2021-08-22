package com.flyrobe;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSelection extends Config {
	//public static WebDriver driver = Config.driver;
	static WebElement datePicker;
	static List<WebElement> noOfColumns;
	static List<String> monthList = Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11");
	static String DATE, MONTH, finalDate;
	static boolean okayGotIt=true;
	
	public static void MenBrands() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title,'men') and text()=normalize-space('Men')]")));
		WebElement menNavBar = driver.findElement(By.xpath("//a[@title='men' and text()=normalize-space('Men')]"));
		String brandSelection = "Hugo Boss";
		WebElement brand = driver.findElement(By.xpath("//a[@class='a-submenu-link' and text()=normalize-space('Suits and Tuxedos')]"));
		action.moveToElement(menNavBar).moveToElement(brand).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='footer-social-icons'][1]")));
		driver.navigate().refresh();
	}
	
	public static void WomenBrands() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='women' and text()=normalize-space('Women')]")));
		WebElement menNavBar = driver.findElement(By.xpath("//a[@title='women' and text()=normalize-space('Women')]"));
		String brandSelection = "Zari";
		WebElement brand = driver.findElement(By.xpath("//a[contains(@class, 'a-submenu-link') and contains(text(),normalize-space('"+brandSelection+"'))]"));
		action.moveToElement(menNavBar).moveToElement(brand).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='footer-social-icons'][1]")));
		driver.navigate().refresh();
	}
	
	public static void ItemSelection() throws InterruptedException {       //done
		//Reading of number of items (done)
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='footer-social-icons'][1]")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("datepicker")));
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.cssSelector("span.font-base-regular.logo.mdl-layout-title"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(3000);
		if(okayGotIt) {
		if(driver.findElements(By.xpath(".//button[contains(text(),normalize-space('Okay'))]")).size()>0) {
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//button[contains(text(),normalize-space('Okay'))]")).click();
			okayGotIt=false;
		}
		}
		Thread.sleep(3000);
		driver.findElement(By.className("product-card")).click();
		//product details data extraction (done)
		
	}
	
	public static void ItemSelection2() throws InterruptedException {       //done
		//Reading of number of items (done)
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if(driver.findElements(By.xpath(".//input[@name='gender']")).size()>0)
		driver.findElement(By.xpath(".//input[@name='gender'][4]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='footer-social-icons'][1]")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("datepicker")));
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.cssSelector("span.font-base-regular.logo.mdl-layout-title"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(5000);
		if(okayGotIt) {
		if(driver.findElements(By.xpath(".//button[contains(text(),normalize-space('Okay'))]")).size()>0) {
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//button[contains(text(),normalize-space('Okay'))]")).click();
			okayGotIt=false;
		}
		}
		//Thread.sleep(3000);
		driver.findElement(By.className("product-card")).click();
		//product details data extraction (done)
		
	}
	
	public static void SizeSelectionMen() throws InterruptedException, AWTException {  //Change to SizeSelectionMen
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("datetimepicker")));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("datetimepicker")));
		Thread.sleep(2000);
		
		/*JavascriptExecutor javascript = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(".//*[@id='demo-size']"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element);*/
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_HOME);
		
		/*WebElement element1 = driver.findElement(By.xpath(".//*[@id='demo-size']"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element1);*/
		
		//To click on sizes (Collar & Waist)
				List<WebElement> size = driver.findElements(By.id("demo-size"));
				
				List<WebElement> sizes = new ArrayList<>();
				
				//Sizes data
				sizes = driver.findElements(By.cssSelector("div.dropdown-content"));
				
				int noOfCollarSizes = sizes.get(0).findElements(By.tagName("li")).size();
				System.out.println("Number of collar sizes: "+noOfCollarSizes);
				
				int noOfWaistSizes = sizes.get(1).findElements(By.tagName("li")).size();
				System.out.println("Number of Waist sizes: "+noOfWaistSizes);
				
				//Thread.sleep(10000);
				
				//Click on collar size and print all the sizes
				size.get(0).click();
				System.out.println("Collar Sizes are as follows:");
				for(int i=0;i<noOfCollarSizes;i++)
				System.out.println(sizes.get(0).findElements(By.tagName("li")).get(i).getText());
				sizes.get(0).findElements(By.tagName("li")).get(0).click();
				
				//Click on waist size and print all the sizes
				size.get(1).click();
				System.out.println("Waist Sizes are as follows:");
				for(int i=0;i<noOfWaistSizes;i++)
				System.out.println(sizes.get(1).findElements(By.tagName("li")).get(i).getText());
				sizes.get(1).findElements(By.tagName("li")).get(0).click();
				
				Boolean isSizeGuidePresent = driver.findElements(By.cssSelector("p.capitalize.clickable")).size() > 0;
				if(isSizeGuidePresent)
					System.out.println("Size Guide Link Present");
				else
					System.out.println("Size Guide Link Not Present");
		
	}
	
	public static void DatePickerManual() throws FileNotFoundException,IOException, InterruptedException { //increment dates so that if the date is not present than the future dates are selected
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream("D:\\Selenium\\Flyrobe\\src\\com\\flyrobe\\objects.properties");
		obj.load(objfile);
		
		//Focus and page below
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='demo-size']"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element);
		
		driver.findElement(By.xpath("//input[@id='datetimepicker']")).click();
		
		Thread.sleep(1000);
		
		String expDate=obj.getProperty("date");
		int expMonth = Integer.parseInt(obj.getProperty("month"));
		int expYear = Integer.parseInt(obj.getProperty("year"));
		boolean dateNotFound = true;
		int z=0;
		String currDate = null;
		String currMonth = null;
		String currYear = null;
		
		while(dateNotFound)
		  { 
			if(z==0) {
			WebElement a = driver.findElement(By.xpath(".//td[contains(@class,' xdsoft_current ')]"));
			currDate = a.getAttribute("data-date");
			currMonth = a.getAttribute("data-month");
			currYear = a.getAttribute("data-year");
			z++;
			} else if (z>0) {
				WebElement a = driver.findElement(By.xpath(".//td[contains(@class,'xdsoft_current true') or contains(@class,'xdsoft_current xdsoft_weekend true')]"));
				currDate = a.getAttribute("data-date");
				currMonth = a.getAttribute("data-month");
				currYear = a.getAttribute("data-year");
				
			}
		   
		   //If current selected month and year are same as expected month and year then go Inside this condition.
		   if(monthList.indexOf(currMonth)+1 == expMonth && (expYear == Integer.parseInt(currYear)))
		   {
		    //Call selectDate function with date to select and set dateNotFound flag to false.
		    selectDate(expDate);
		    dateNotFound = false;
		   }
		   //If current selected month and year are less than expected month and year then go Inside this condition.
		   else if(monthList.indexOf(currMonth)+1 < expMonth && (expYear == Integer.parseInt(currYear)) || expYear > Integer.parseInt(currYear))
		   {
		    //Click on next button of date picker.
			   driver.findElement(By.cssSelector(".xdsoft_next")).click();
		   }
		   //If current selected month and year are greater than expected month and year then go Inside this condition.
		   else if(monthList.indexOf(currMonth)+1 > expMonth && (expYear == Integer.parseInt(currYear)) || expYear < Integer.parseInt(currYear))
		   {
		    //Click on previous button of date picker.
			   driver.findElement(By.cssSelector(".xdsoft_prev")).click();
		   }
		  }
		  Thread.sleep(5000);
		
	}
	
	public static void selectDate(String date)
	 {
	  datePicker = driver.findElement(By.className("xdsoft_calendar")); //3rd party code
	  noOfColumns=datePicker.findElements(By.tagName("td"));
	  Actions action = new Actions(driver);

	  //Loop will rotate till expected date not found.
	  for (WebElement cell: noOfColumns){ 
		  String className = cell.getAttribute("class");
	   //Select the date from date picker when condition match.
	   if (cell.getText().equals(date) && !(className.contains("xdsoft_other_month"))){   
		   action.click(cell).build().perform();
	    break;
	   }
	  }
	 }
	
	public static void DatePickerAuto() throws InterruptedException {
		//Focus and page below
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='demo-size']"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element);
		
		driver.findElement(By.xpath("//input[@id='datetimepicker']")).click();

		Thread.sleep(1000);

		Boolean datenotfound = true;
		int MONTH1;

		while (datenotfound) {
			List<WebElement> enabledDate = driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]"));
			if (enabledDate.size() > 0) {
				DATE = enabledDate.get(0).getAttribute("data-date");
				if(DATE.length() == 1)
				DATE = "0" + DATE;

				MONTH1 = Integer.parseInt(enabledDate.get(0).getAttribute("data-month")) + 1;
				MONTH = "" + MONTH1;
				if (MONTH.length() == 1)
					MONTH = "0" + MONTH;

				finalDate = enabledDate.get(0).getAttribute("data-year") + "-" + MONTH + "-" + DATE;
				System.out.println(finalDate);
				driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]")).click();
				 
				// This will enable this element if element is invisible      
				 
				//String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
				  
				// Execute the Java Script for the element which we find out
				//((JavascriptExecutor) driver).executeScript(js, elem);
				 
				// Click on element
				 
				//elem.click();
				//enabledDate.get(0).click();
				
				/*List<WebElement> enabledDate1 = driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]"));
				for (int i = 0; i < enabledDate1.size(); i++) {
					int x = enabledDate1.get(i).getLocation().getX();
					System.out.println(x);
					
						enabledDate1.get(i).click();
				}*/
				datenotfound = false;
			} else {
				driver.findElement(By.cssSelector(".xdsoft_next")).click();
				Thread.sleep(3000);
			}
		}

		System.out.println(finalDate);
		
	}
	
	
	public static void DatePickerAuto2() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//Focus and page below
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("datetimepicker")));
		driver.navigate().refresh();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(@class,'font-base-medium') and contains(text(),'ALTERABLE')]")));
		WebElement element = driver.findElement(By.xpath(".//span[contains(@class,'font-base-medium') and contains(text(),'ALTERABLE')]"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element);
		
		driver.findElement(By.xpath("//input[@id='datetimepicker']")).click();

		Thread.sleep(1000);

		Boolean datenotfound = true;
		int MONTH1;

		while (datenotfound) {
			List<WebElement> enabledDate = driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]"));
			if (enabledDate.size() > 0) {
				DATE = enabledDate.get(0).getAttribute("data-date");
				if(DATE.length() == 1)
				DATE = "0" + DATE;

				MONTH1 = Integer.parseInt(enabledDate.get(0).getAttribute("data-month")) + 1;
				MONTH = "" + MONTH1;
				if (MONTH.length() == 1)
					MONTH = "0" + MONTH;

				finalDate = enabledDate.get(0).getAttribute("data-year") + "-" + MONTH + "-" + DATE;
				System.out.println(finalDate);
				driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]")).click();
				datenotfound = false;
			} else {
				driver.findElement(By.cssSelector(".xdsoft_next")).click();
				Thread.sleep(3000);
			}
		}
	}
	
	
	
	public static void addToCart() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'btn') and contains(text(),normalize-space('ADD TO CART'))]")));
		driver.findElement(By.xpath("//button[contains(@class, 'btn') and contains(text(),normalize-space('ADD TO CART'))]")).click();
		
	}

}
