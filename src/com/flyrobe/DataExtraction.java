package com.flyrobe;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataExtraction extends Config {
	
	//public static WebDriver driver = Config.driver;
	public static String detailsPageDate, detailsPageRent, detailsPageSD,
			detailsPageWaist, detailsPageCollar, detailsPageRentalPeriod,
			cartDate1, cartRentalPeriod1, cartSD1, cartCollar1, cartWaist1,
			cartRental1, cartTotalRental1, cartRental2, cartSD2, cartDiscount, 
			cartTotalRental2, cartQuantity;
	public static String checkoutRental2, checkoutSD2, checkoutDiscount, checkoutRental, 
			checkoutDeliveryDate;
	public static int cartDelivery, checkoutDelivery;
	public static boolean customFit = false;

	public static void citySelection() throws FileNotFoundException,IOException {
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream("D:\\Selenium\\Flyrobe\\src\\com\\flyrobe\\objects.properties");
		obj.load(objfile);
		String city=obj.getProperty("city");
		driver.findElement(By.className("dropdwnHeadIcon")).click();
		driver.findElement(
				By.xpath("//span[contains(@class, 'mdl-radio__label') and text()='"+city+"']"))
				.click();
		
	}
	
	public static void listPageProductCount() {
		String noOfProducts = driver.findElement(By.cssSelector("span.small-font.mob-block")).getText().substring(8);
		System.out.println("Number of Products on List Page: "+noOfProducts);
		
	}
	
	public static void productsData() throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		Robot robot = new Robot();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='footer-social-icons'][1]")));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.small-font.mob-block")));
		System.out.println(driver.findElement(By.cssSelector("span.small-font.mob-block")).getText().length());
		String noOfProducts = driver.findElement(By.cssSelector("span.small-font.mob-block")).getText().substring(8);
		int numberOfProducts = Integer.parseInt(noOfProducts);
		System.out.println("Number of Products on List Page: "+noOfProducts);
		
		for (int i=1;i<=numberOfProducts;i++) {
			List<WebElement> products = new ArrayList<>();
			products = driver.findElements(By.xpath(".//*[@id='focusDiv']/div["+i+"]"));
			System.out.println("Product "+i+" Data");
			
			for (int j = 0; j < products.size(); j++) {
				System.out.println(products.get(j).getText());
			}
			System.out.println("\n---------------------------------------------");
			
			if(i%18==0) {
				WebElement element = driver.findElement(By.className("artboard-1"));
				javascript.executeScript("arguments[0].scrollIntoView(true);",element);
				robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				javascript.executeScript("window.scrollBy(0,1000)", "");
				Thread.sleep(10000);
				robot.keyPress(KeyEvent.VK_HOME);
			}
		}
	}
	
	public static void DetailsPageData() {
		detailsPageDate = ProductSelection.finalDate;
		
		detailsPageRent = driver.findElement(By.cssSelector(".large-font.font-base-medium")).getText();
		detailsPageSD = driver.findElement(By.cssSelector(".big-font2.ph-5.font-base-medium")).getText();
		
		if(driver.findElements(By.className("customFit")).size()>0)
			customFit = true;
		
		List<WebElement> size = driver.findElements(By.id("demo-size"));
		
		detailsPageWaist = size.get(0).getAttribute("value");
		detailsPageCollar = size.get(1).getAttribute("value");
		
		detailsPageRentalPeriod = driver.findElement(By.cssSelector("label.is-checked")).findElement(By.xpath(".//span[text()]")).getText();
		
	}
	
	public static void CartPageData() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cart-product")));
		List<WebElement> cart = driver.findElement(By.cssSelector(".cart-product")).findElements(By.xpath(".//div/div/div/child::div[2]"));
		
		System.out.println(cart.size());
		
		
		cartDate1 = cart.get(0).getText();
		System.out.println("1:  "+cartDate1);
		System.out.println();
		cartRentalPeriod1 = cart.get(1).getText();
		System.out.println("2:  "+cartRentalPeriod1);
		System.out.println();
		cartSD1 = cart.get(2).getText();
		System.out.println("3:  "+cartSD1);
		System.out.println();
		cartCollar1 = cart.get(3).getText();
		String[] lines = cartCollar1.split("\\r?\\n"); // catches Windows newlines (\r) as well)
	    for (int i = 0; i < lines.length-1; i++)   // lines.length - 1 to discard the last 1 line
	        cartCollar1 = lines[i];
		System.out.println("4:  "+cartCollar1);
		System.out.println();
		cartWaist1 = cart.get(4).getText();
		System.out.println("5:  "+cartWaist1);
		System.out.println();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[@class='ng-binding']")));
		cartTotalRental1 = driver.findElement(By.xpath(".//span[@class='ng-binding']")).getText();
		
		cartTotalRental2 = driver.findElement(By.xpath(".//*[@class='totalDetails']/strong[normalize-space(text())]")).getText();
		
		cartRental1 = driver.findElement(By.cssSelector(".font-base-medium.big-font2.ng-binding")).getText();
		
		System.out.println(cartDate1+" "+cartRentalPeriod1+" "+cartSD1+" "+cartCollar1+" "+cartWaist1+" "+cartRental1+" "+cartTotalRental1+" "+cartTotalRental2);
		
		List<WebElement> cart2 = driver.findElements(By.xpath(".//*[@class='itemDetails right']/strong[normalize-space(text())]"));
		cartRental2 = cart2.get(0).getText();
		cartSD2 = cart2.get(1).getText();
		cartDiscount = cart2.get(2).getText();
		String delivery = cart2.get(3).getText();
		
		if(delivery.equals("FREE"))
		cartDelivery = 0;
		else {
			delivery = cart2.get(3).getText().trim().substring(1);
			cartDelivery = Integer.parseInt(delivery);
		}
		
		cartQuantity = driver.findElement(By.xpath(".//div[contains(@class,'text-center')]/span[contains(text(),'CART')]/following-sibling::span")).getText().substring(1, 2);
		
	}
	
	public static void CheckoutPageData() throws InterruptedException {
		List<WebElement> checkout = driver.findElements(By.xpath(".//*[@class='itemDetails right']/strong[normalize-space(text())]"));
		checkoutRental2 = checkout.get(0).getText();
		checkoutSD2 = checkout.get(1).getText();
		checkoutDiscount = checkout.get(2).getText();
		String delivery = checkout.get(3).getText();
		
		if(delivery.equals("FREE"))
		checkoutDelivery = 0;
		else {
			delivery = checkout.get(3).getText().trim().substring(1);
			checkoutDelivery = Integer.parseInt(delivery);
		}
		
		checkoutRental = driver.findElement(By.xpath(".//*[@class='totalDetails']/strong[text()]")).getText();
		
		checkoutDeliveryDate = driver.findElement(By.xpath(".//h6[@class='ng-binding']/following-sibling::p")).getText();
		
	}
	
	public static void Homepage() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> homepage = driver.findElements(By.cssSelector("span.font-base-regular.logo.mdl-layout-title"));
		homepage.get(homepage.size()-2).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
	public static void top() {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.cssSelector("span.font-base-regular.logo.mdl-layout-title"));
		javascript.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

            

    }
	
}
