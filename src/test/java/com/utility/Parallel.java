package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parallel {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\java\\Driver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("http://google.com");
	}

	@Test
	public void test1() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "google");
	}

	@Test
	public void test2() {
		driver.getCurrentUrl();
	}
}