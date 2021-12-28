package com.cloudran.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CloudRanLoginPageTest {

	static Properties properties = new Properties();
	static {
		try {
			FileReader reader = new FileReader("C:\\Users\\kapadiya\\work\\login.properties");
			properties.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kapadiya\\work\\software\\chrome drver\\old\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");

		WebDriver webDriver = new ChromeDriver(chromeOptions);
		loginTest(webDriver);
		webDriver.close();

	}

	public static void loginTest(WebDriver webDriver) throws InterruptedException {
		webDriver.get("http://localhost:8081/mcps-web/login");
		WebElement logo = webDriver.findElement(By.xpath("//img"));
		String expectedTag = logo.getTagName();
		String actualTag = "img";

		if (expectedTag.equals(actualTag)) {
			System.out.println("logo test passed");
		} else {
			System.out.println("logo test fail");
		}

		webDriver.findElement(By.xpath("//input[@name='username']")).sendKeys(properties.getProperty("loginUserName"));
		// Thread.sleep(2000);

		webDriver.findElement(By.xpath("//input[@name='password']"))
				.sendKeys(properties.getProperty("loginUserPassword"));
		// Thread.sleep(2000);

		webDriver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
		// Thread.sleep(2000);

		String expectedTitle = webDriver.getTitle();
		String actualTitle = "CloudRAN";

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("sign in test passed");
		} else {
			System.out.println("sign in test fail");
		}
		// Thread.sleep(3000);
	}

}
