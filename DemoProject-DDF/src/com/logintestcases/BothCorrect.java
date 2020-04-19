package com.logintestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothCorrect {
	
	@Test
	@Parameters({"username","password"})
	public void CorrectUsernamendPwd(String Uname,String Pword) {
		
		System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(Uname);
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(Pword);
		WebElement loginBtn=driver.findElement(By.id("btnLogin"));
		loginBtn.click();
	}


}
