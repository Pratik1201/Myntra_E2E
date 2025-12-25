package com.myntra;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyntraE2E {
WebDriver driver;
	
	@BeforeTest
	public void setup() {
	driver = new ChromeDriver();
	driver.get("https://www.myntra.com");
	driver.manage().window().maximize();
	}
	@Test
	public void myntra() {
		driver.findElement(By.className("desktop-searchBar")).sendKeys("Shirts");
		driver.findElement(By.className("desktop-submit")).click();
		driver.findElement(By.xpath("//img[@title='The Roadster Lifestyle Co. Tartan Checked Regular Fit Shirt']")).click();
		Set<String> allwindowIDS= driver.getWindowHandles();
		System.out.println(allwindowIDS);
		Iterator<String> it = allwindowIDS.iterator();
		String win1 = it.next();
		String win2= it.next();
		driver.switchTo().window(win2);
		driver.findElement(By.xpath("//div[@class='size-buttons-tipAndBtnContainer'][3]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'ADD TO BAG')]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();
		driver.findElement(By.xpath("//button[@class='inlinebuttonV2-base-actionButton bulkActionStrip-desktopBulkRemove']")).click();
		driver.findElement(By.xpath("//button[@class='inlinebuttonV2-base-actionButton ']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='emptyCart-base-emptyText']")).getText());
	}
		@AfterTest
		public void tearDown() {
		driver.quit();

	}
}

