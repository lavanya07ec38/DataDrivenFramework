package com.DataDriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.Util;

public class DataProviderTest {
	
	WebDriver driver;
	@BeforeTest
	public void DriversetUp() {
		
		
		System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
	}
	
	@AfterTest
	
	public void tearDown() {
		
		driver.quit();
	}
	
	@DataProvider
	public Iterator<Object[]> getData() {
		
		ArrayList<Object[]> testData=Util.getExcelData();
		//System.out.println(testData);
		return testData.iterator();
	}
	
	@Test(dataProvider="getData")
	public void enterData(String firstname,String lastname,String phone,String address1,String address2,String city,String state,String zipcode,String emailaddress,String country)
	
	{
		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys(phone);
		//By id
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys(emailaddress);
		driver.findElement(By.name("address1")).clear();
		driver.findElement(By.name("address1")).sendKeys(address1);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(address2);
		driver.findElement(By.xpath("//input[@name='city']")).clear();
		
		//By xpath
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='state']")).clear();
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@name='postalCode']")).clear();
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(zipcode);
		
		//to handle drop down
		
		Select select=new Select(driver.findElement(By.name("country")));
		select.selectByVisibleText(country);
		
	}
	
	

}
