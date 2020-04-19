package com.DataDriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		//get test data from excel
		
		
		Xls_Reader reader=new Xls_Reader("D:\\selenium\\selenium-java-3.4.0\\DemoProject-DDF\\src\\com\\testData\\testdata.xlsx");
		//String firstname=reader.getCellData("reg_testdata",0,1);
		String firstname=reader.getCellData("reg_testdata", "firstname", 2);
		System.out.println(firstname);
		
				
		String lastname=reader.getCellData("reg_testdata", "lastname", 2);
		System.out.println(lastname);
		
		String phone=reader.getCellData("reg_testdata", "phone", 2);
		System.out.println(phone);
		
		String address1=reader.getCellData("reg_testdata", "address1", 2);
		System.out.println(address1);
		
		String address2=reader.getCellData("reg_testdata", "address2", 2);
		System.out.println(address2);
		
		String city=reader.getCellData("reg_testdata", "city", 2);
		System.out.println(city);
		
		String state=reader.getCellData("reg_testdata", "state", 2);
		System.out.println(state);
		
		String zipcode=reader.getCellData("reg_testdata", "zipcode", 2);
		System.out.println(zipcode);
		
		String emailaddress=reader.getCellData("reg_testdata", "emailaddress", 2);
		System.out.println(emailaddress);
		
		String country=reader.getCellData("reg_testdata", "country", 2);
		System.out.println(country);
		
		
		//webdriver code:
		
		System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		//By id
		
		driver.findElement(By.id("userName")).sendKeys(emailaddress);
		driver.findElement(By.name("address1")).sendKeys(address1);
		driver.findElement(By.name("address2")).sendKeys(address2);
		
		//By xpath
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(zipcode);
		
		//to handle drop down
		
		Select select=new Select(driver.findElement(By.name("country")));
		select.selectByVisibleText(country);
		
		
		

	}

}
