package com.flyrobe;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

public class Test2 extends Config {
	@Test
	public void flow2() throws InterruptedException, AWTException, FileNotFoundException, IOException {
		//DataExtraction.citySelection();
		ProductSelection.WomenBrands();
		ProductSelection.ItemSelection2();
		ProductSelection.DatePickerAuto2();
		ProductSelection.addToCart();
		Thread.sleep(3000);
		DataExtraction.Homepage();
		ProductSelection.MenBrands();
		ProductSelection.ItemSelection();
		ProductSelection.SizeSelectionMen();
		ProductSelection.DatePickerAuto();
		ProductSelection.addToCart();
		Thread.sleep(3000);
		Login.proceedToPayment();
		Login.facebookLogin();
		Thread.sleep(3000);
		Checkout.deliveryAddress();
		Checkout.measurements();
		Checkout.payment();
		Checkout.placeOrder();
		Thread.sleep(10000);
	}

}
