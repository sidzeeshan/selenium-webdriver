package com.flyrobe;

import java.io.FileInputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Config {
	public static WebDriver driver=null;

	@BeforeTest
	@Parameters ({"browser"})
	public void setup(String browser) throws Exception {
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(
				"D:\\Selenium\\Flyrobe\\src\\com\\flyrobe\\objects.properties");
		obj.load(objfile);
		
		if (browser.equals("CRM")){//If value Is CRM then webdriver will open chrome Browser.
			   System.out.println("Test Starts Running In Google chrome.");
			   System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\Flyrobe\\lib\\chromedriver.exe");
			   driver = new ChromeDriver();
		}
		
		else if (browser.equals("FFX")) {//If value Is FFX then webdriver will open Firefox Browser.
			System.out.println("Test Starts Running In Firefox Browser.");
			System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\AA\\Desktop\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("url");// Ends
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//div[contains(@class, 'big-font') and text()='SELECT YOUR CITY']"),
				"SELECT YOUR CITY"));
		String defaultCity=obj.getProperty("defaultCity");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class, 'mdl-radio__label') and contains(text(),normalize-space('"+defaultCity+"'))]")));
		driver.findElement(
				By.xpath("//span[contains(@class, 'mdl-radio__label') and contains(text(),normalize-space('"+defaultCity+"'))]"))
				.click();

	}

	@AfterTest
	public void teardown() throws Exception {
	    driver.close();
	}
	
	@AfterSuite
	public void teardown1() throws Exception {
		
		/*final String username = "your email";
	    final String password = "your password";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("from.mail.id91@gmail.com"));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse("your email"));
	        message.setSubject("Testing Subject");
	        message.setText("PFA");

	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();

	        messageBodyPart = new MimeBodyPart();
	        String file = "D:\\Selenium\\Flyrobe\\test-output\\emailable-report.html";
	        String fileName = "report.html";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);

	        System.out.println("Sending");

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }*/
	}

}
