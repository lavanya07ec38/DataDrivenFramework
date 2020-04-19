package Excel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.Xls_Reader;

public class Webtablehandle {

	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//dynamic wait
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		//*[@id="customers"]
		
		String before_Xpath_Company="//*[@id=\"customers\"]/tbody/tr[";
		String after_Xpath_Company="]/td[1]";
		
		String before_Xpath_Contact="//*[@id=\"customers\"]/tbody/tr[";
		String after_Xpath_Contact="]/td[2]";
		
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id=\"customers\"]//tr"));
		int rowCount=(rows.size()-1);
		
		Xls_Reader reader=new Xls_Reader("D:\\selenium\\selenium-java-3.4.0\\DemoProject-DDF\\src\\com\\testData\\testdata.xlsx");
		reader.addColumn("reg_testdata2", "Company");
		reader.addColumn("reg_testdata2", "Contact");
		for(int rowNum=2;rowNum<=rowCount;rowNum++) {
			
			String actual_Xpath_Company=before_Xpath_Company+rowNum+after_Xpath_Company;
			String company_name=driver.findElement(By.xpath(actual_Xpath_Company)).getText();
			System.out.println(company_name);
			reader.setCellData("reg_testdata2", "Company", rowNum, company_name);
			
			String actual_Xpath_Contact=before_Xpath_Contact+rowNum+after_Xpath_Contact;
			String contact_name=driver.findElement(By.xpath(actual_Xpath_Contact)).getText();
			System.out.println(contact_name);
			reader.setCellData("reg_testdata2", "Contact", rowNum, contact_name);
		}
		
		

	}

}
