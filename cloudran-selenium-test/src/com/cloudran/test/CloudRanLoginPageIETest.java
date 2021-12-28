package com.cloudran.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class CloudRanLoginPageIETest {
	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\kapadiya\\work\\software\\chrome drver\\old\\ie driver\\IEDriverServer.exe");

		InternetExplorerOptions capability=new InternetExplorerOptions();
				capability.setCapability("ignoreZoomSetting", true);
		WebDriver webDriver = new InternetExplorerDriver(capability);
		loginTest(webDriver);
		//webDriver.close();

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

		webDriver.findElement(By.xpath("//input[@name='username']")).sendKeys("administrator");

		webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		webDriver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();

		String expectedTitle = webDriver.getTitle();
		String actualTitle = "CloudRAN";

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("sign in test passed");
		} else {
			System.out.println("sign in test fail");
		}
		
	}
}
