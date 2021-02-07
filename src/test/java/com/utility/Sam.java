package com.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sam {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\java\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/HotelAppBuild2/");
		driver.manage().window().maximize();
		
	}

	@DataProvider(name = "loginData")
	public Iterator<String[]> getData() throws IOException {
		ExcelData a = new ExcelData();
		ArrayList<String[]> data = a.getData();
		return data.iterator();
	}

	@Test(dataProvider = "loginData")
	public void test(String userName, String password,String firstName,String lastName,String address,
			String cvv,String num) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		WebElement location = driver.findElement(By.id("location"));
		Select select = new Select(location);
		select.selectByVisibleText("Melbourne");
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_2")).click();
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("first_name")).sendKeys(firstName);
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		driver.findElement(By.id("address")).sendKeys(address);
		driver.findElement(By.id("cc_num")).sendKeys(cvv);
		WebElement cardType = driver.findElement(By.id("cc_type"));
		Select card=new Select(cardType);
		card.selectByVisibleText("Master Card");
		WebElement month = driver.findElement(By.id("cc_exp_month"));
		Select monthType =  new Select(month);
		monthType.selectByVisibleText("May");
		WebElement year = driver.findElement(By.id("cc_exp_year"));
		Select yearType= new Select(year);
		yearType.selectByVisibleText("2022");
		driver.findElement(By.id("cc_cvv")).sendKeys(num);
		driver.findElement(By.id("book_now")).click();
		Thread.sleep(7000);
		driver.findElement(By.id("logout")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click here to login again')]")).click();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
