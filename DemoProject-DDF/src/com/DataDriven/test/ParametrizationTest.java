package com.DataDriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.utility.Xls_Reader;

public class ParametrizationTest {

	public static void main(String[] args) {
				
		System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		
		
		Xls_Reader reader=new Xls_Reader("D:\\selenium\\selenium-java-3.4.0\\DemoProject-DDF\\src\\com\\testData\\testdata.xlsx");
		int rowCount=reader.getRowCount("reg_testdata");
		System.out.println(rowCount);
		
		reader.addColumn("reg_testdata", "status");
		
		
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++) {
			
			System.out.println("####################");
			String firstname=reader.getCellData("reg_testdata", "firstname", rowNum);
			System.out.println(firstname);
			
					
			String lastname=reader.getCellData("reg_testdata", "lastname", rowNum);
			System.out.println(lastname);
			
			String phone=reader.getCellData("reg_testdata", "phone", rowNum);
			System.out.println(phone);
			
			String address1=reader.getCellData("reg_testdata", "address1", rowNum);
			System.out.println(address1);
			
			String address2=reader.getCellData("reg_testdata", "address2", rowNum);
			System.out.println(address2);
			
			String city=reader.getCellData("reg_testdata", "city", rowNum);
			System.out.println(city);
			
			String state=reader.getCellData("reg_testdata", "state", rowNum);
			System.out.println(state);
			
			String zipcode=reader.getCellData("reg_testdata", "zipcode", rowNum);
			System.out.println(zipcode);
			
			String emailaddress=reader.getCellData("reg_testdata", "emailaddress", rowNum);
			System.out.println(emailaddress);
			
			String country=reader.getCellData("reg_testdata", "country", rowNum);
			System.out.println(country);
			
			//enter data		
		
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
		
		reader.setCellData("reg_testdata", "status", rowNum, "Pass");
		
		}

	}

}
