package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPageTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kapadiya\\work\\software\\chrome drver\\chromedriver.exe");

		WebDriver webDriver = new ChromeDriver();
		
		webDriver.get("https://www.facebook.com/reg/");
		webDriver.manage().window().maximize();

		WebElement day = webDriver.findElement(By.id("day"));
		Select select = new Select(day);
		Thread.sleep(3000);
		select.selectByVisibleText("9");

		WebElement month = webDriver.findElement(By.id("month"));
		Select month_s = new Select(month);
		Thread.sleep(3000);
		month_s.selectByVisibleText("Jul");

		WebElement years = webDriver.findElement(By.id("year"));
		Select years_s = new Select(years);
		Thread.sleep(3000);
		years_s.selectByVisibleText("1994");

		System.out.println("test successful");

	}

}
