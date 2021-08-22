package com.flyrobe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test extends Config {
	public static Actions action = new Actions(driver);
	public static WebDriverWait wait = new WebDriverWait(driver, 20);
	
	public static void Testtest() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title,'men') and text()=normalize-space('Men')]")));
		Login.googleLogin();
		WebElement menNavBar = driver.findElement(By.xpath("//a[@title='men' and text()=normalize-space('Men')]"));
		String brandSelection = "Hugo Boss";
		WebElement brand = driver.findElement(By.xpath("//a[@class='a-submenu-link' and text()=normalize-space('Suits and Tuxedos')]"));
		action.moveToElement(menNavBar).moveToElement(brand).click().build().perform();
	}

}
