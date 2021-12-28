package com.cloudran.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HomePageTest {

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
		// chromeOptions.addArguments("--headless");

		WebDriver webDriver = new ChromeDriver(chromeOptions);
		webDriver.get("http://localhost:8081/mcps-web/login");
		WebElement logo = webDriver.findElement(By.xpath("//img"));
		String expectedTag = logo.getTagName();
		String actualTag = "img";

		if (expectedTag.equals(actualTag)) {
			System.out.println("logo test passed");
		} else {
			System.out.println("logo test fail");
		}

		webDriver.findElement(By.xpath("//input[@name='username']")).sendKeys(properties.getProperty("login.UserName"));
		Thread.sleep(2000);

		webDriver.findElement(By.xpath("//input[@name='password']"))
				.sendKeys(properties.getProperty("login.UserPassword"));
		Thread.sleep(2000);

		webDriver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
		Thread.sleep(2000);

		String expectedTitle = webDriver.getTitle();
		String actualTitle = "CloudRAN";

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("sign in test passed");
		} else {
			System.out.println("sign in test fail");
		}
		Thread.sleep(3000);

		/*
		 * webDriver.findElement(By.linkText("Admin Dashboard")).click();
		 * webDriver.manage().window().maximize();
		 * 
		 * webDriver .findElement(By.xpath(
		 * "//div[@class='dhx_toolbar_btn dhxtoolbar_btn_def']/div/strong[contains(text(),'Validate')]"
		 * )) .click();
		 */

		webDriver
				.findElement(By.xpath(
						".//div[@class='dhx_cell_toolbar_no_borders']/div/div/div/div[contains(text(),'Add Project')]"))
				.click();
		webDriver.findElement(By.xpath("//div[@class='dhxform_item_label_left']/div[@class='dhxform_control'][../div[@title='Enter Project Name']]/input"))
				.sendKeys(properties.getProperty("AddProject.ProjectName"));
		
		webDriver.findElement(By.xpath("//div[@class='dhxform_item_label_left']/div[@class='dhxform_control'][../div[@title='Enter Project Description']]/input"))
				.sendKeys(properties.getProperty("AddProject.ProjectDescription"));
		
		
		Select systemTypeSelect = new Select(webDriver.findElement(By.xpath("//div[@class='dhxform_item_label_left']/div[@class='dhxform_control'][../div[@title='Select System Type']]/select")));
		systemTypeSelect.selectByVisibleText(properties.getProperty("AddProject.SystemType"));

		Select analysisTypeSelect = new Select(webDriver.findElement(By.xpath("//div[@class='dhxform_item_label_left']/div[@class='dhxform_control'][../div[@title='Select Analysis Type']]/select")));
		analysisTypeSelect.selectByVisibleText(properties.getProperty("AddProject.AnalysisType"));

		Select technologySelect = new Select(webDriver.findElement(By.xpath("//div[@class='dhxform_item_label_left']/div[@class='dhxform_control'][../div[@title='Select Technology']]/select")));
		technologySelect.selectByVisibleText(properties.getProperty("AddProject.Technology"));

		Select customerSelect = new Select(webDriver.findElement(By.xpath("//div[@class='dhxform_item_label_left']/div[@class='dhxform_control'][../div[@title='Select Customer Type']]/select")));
		customerSelect.selectByVisibleText(properties.getProperty("AddProject.Customer"));

		Select regionSelect = new Select(webDriver.findElement(By.xpath("//div[@class='dhxform_item_label_left']/div[@class='dhxform_control'][../div[@title='Select Region Type']]/select")));
		regionSelect.selectByVisibleText(properties.getProperty("AddProject.Region"));

		Select currencySelect = new Select(webDriver.findElement(By.xpath("//div[@class='dhxform_item_label_left']/div[@class='dhxform_control'][../div[@title='Select Currency Type']]/select")));
		currencySelect.selectByVisibleText(properties.getProperty("AddProject.Currency"));

		webDriver.findElement(By.xpath(
				"//div[@class='dhx_toolbar_btn dhxtoolbar_btn_over']/div[@class='dhxtoolbar_text'][contains(text(),'Next')]"))
				.click();

		
		
		System.out.println("completed");
		// webDriver.clo

	}

}
