package com.selenium.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest
class SampleApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void login() throws MalformedURLException, InterruptedException {

		/*DesiredCapabilities cap=DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model
		options.setCapability("browserVersion", "98.0.4758.102");
		options.setCapability("platformName", "LINUX");
		URL url=new URL("http://localhost:5566/wd/hub"); //hub url
		*/
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		URL url=new URL("http://localhost:4444"); //hub url
		WebDriver driver=new RemoteWebDriver(url, chromeOptions);
		driver.manage().window().maximize();
		String baseURL = "http://localhost:8081";
		driver.get(baseURL); //Petclinic Url
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a")).click();
		String actualUrl= baseURL+"/owners/find";
		String expectedUrl= driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrl,actualUrl);
		WebElement find=driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
		find.sendKeys("Franklin");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button")).click();
		String actualUrl2= baseURL+"/owners/1";
		String expectedUrl2= driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrl,actualUrl);
		Thread.sleep(3000);
		driver.close();
	}
}
