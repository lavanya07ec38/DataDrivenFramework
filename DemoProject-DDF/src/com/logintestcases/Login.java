package com.logintestcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {
	
 String[][] data=null;
 WebDriver driver;
 
 	@DataProvider(name="logindata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data=getExcelData();
		return data;
		
	}
	
 	
 	public String[][] getExcelData() throws BiffException, IOException {
		
		FileInputStream excel=new FileInputStream("D:/Assigments/testdata-excel.xls");
		Workbook book=Workbook.getWorkbook(excel);
		Sheet sheet=book.getSheet(0);
		int rowCount=sheet.getRows();
		int colCount=sheet.getColumns();
		
		String testdata[][]=new String [rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++) {
			
			for(int j=0;j<colCount;j++) {
				
				testdata[i-1][j]=sheet.getCell(j,i).getContents();
			}
		}
		return testdata;
	}
	@Test(dataProvider="logindata")
	
	public void logintestcase(String Uname,String Pword) {
		
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(Uname);
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(Pword);
		WebElement loginBtn=driver.findElement(By.id("btnLogin"));
		loginBtn.click();
	}
	@BeforeTest
	
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}

}
