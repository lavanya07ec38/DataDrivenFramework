package com.utility;

import java.util.ArrayList;

public class Util {
	
	public static  ArrayList<Object[]> getExcelData() {
		
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		
		Xls_Reader reader=new Xls_Reader("D:\\selenium\\selenium-java-3.4.0\\DemoProject-DDF\\src\\com\\testData\\testdata.xlsx");
		int rowCount=reader.getRowCount("reg_testdata");
		System.out.println(rowCount);
		for(int rowNum=2;rowNum<=rowCount;rowNum++) {
			
			String firstname=reader.getCellData("reg_testdata", "firstname", rowNum);			
			String lastname=reader.getCellData("reg_testdata", "lastname", rowNum);			
			String phone=reader.getCellData("reg_testdata", "phone", rowNum);			
			String address1=reader.getCellData("reg_testdata", "address1", rowNum);			
			String address2=reader.getCellData("reg_testdata", "address2", rowNum);			
			String city=reader.getCellData("reg_testdata", "city", rowNum);			
			String state=reader.getCellData("reg_testdata", "state", rowNum);		
			String zipcode=reader.getCellData("reg_testdata", "zipcode", rowNum);			
			String emailaddress=reader.getCellData("reg_testdata", "emailaddress", rowNum);			
			String country=reader.getCellData("reg_testdata", "country", rowNum);
				
		
		
		
		Object ob[]= {firstname,lastname,phone,address1,address2,city,state,zipcode,emailaddress,country};
		mydata.add(ob);
				
		}
		return mydata;
	}

}
