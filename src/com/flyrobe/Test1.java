package com.flyrobe;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void flow1() throws FileNotFoundException, IOException, InterruptedException, AWTException {
		DataExtraction.citySelection();
		ProductSelection.MenBrands(); //Men with SD
		//DataExtraction.productsData();
		ProductSelection.ItemSelection();
		ProductSelection.SizeSelectionMen();
		ProductSelection.DatePickerAuto();
		//DataExtraction.DetailsPageData();
		ProductSelection.addToCart();
		Thread.sleep(3000);
		//DataExtraction.CartPageData();
		Login.proceedToPayment();
		Login.googleLogin();
		Thread.sleep(3000);
		//DataExtraction.CheckoutPageData();
		Checkout.deliveryAddress();
		Checkout.measurements();
		Checkout.payment();
		Checkout.placeOrder();
		Thread.sleep(10000);
		//test change in git
		//com.flyrobe.Test.Testtest();
	}

}
