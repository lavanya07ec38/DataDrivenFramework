package com.logintestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenUsingPOI {
	
	
	static WebDriver driver;
	static List<String> userNameList=new ArrayList<String>();
	static List<String> pwdList=new ArrayList<String>();
    @Test(dataProvider="logindata")
	
	public static void login(String Uname,String Pword) {
	System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver_win32/chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(Uname);
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(Pword);
		WebElement loginBtn=driver.findElement(By.id("btnLogin"));
		loginBtn.click();		driver.quit();
	}
	
	
	public void readExcel() throws IOException {
	
		
		FileInputStream excel=new FileInputStream("D:/Assigments/testdata1-excel.xlsx");
		Workbook workbook=new XSSFWorkbook(excel);
		Sheet sheet=workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator=sheet.iterator();
		while(rowIterator.hasNext()) {
			
			Row rowValue=rowIterator.next();
			
			Iterator<Cell> colIterator=rowValue.iterator();
			int i=2;
			
			while(colIterator.hasNext()) {
				if(i%2==0) {
					userNameList.add(colIterator.next().getStringCellValue());
				}else {
					pwdList.add(colIterator.next().getStringCellValue());
				}
				i++;
				
				}
		}
		
	
	}
	public static void executeTest() {
		
		for(int i=0;i<userNameList.size();i++) {
			
			login(userNameList.get(i),pwdList.get(i));
			
			
		}
	}


	public static void main(String[] args) throws IOException {
		
		
		DataDrivenUsingPOI data=new DataDrivenUsingPOI();
		data.readExcel();
		System.out.println("Username List"+userNameList);
		System.out.println("Password List"+pwdList);
		executeTest();
	}
}

