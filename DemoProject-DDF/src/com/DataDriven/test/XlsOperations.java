package com.DataDriven.test;

import com.utility.Xls_Reader;

public class XlsOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Xls_Reader reader=new Xls_Reader("D:\\selenium\\selenium-java-3.4.0\\DemoProject-DDF\\src\\com\\testData\\testdata.xlsx\\");

		//reader.addSheet("reg_testdata2");
		if(!reader.isSheetExist("reg_testdata2")) {
			
			reader.addSheet("reg_testdata2");
			
		}
		int colCount=reader.getColumnCount("reg_testdata");
		System.out.println(colCount);
	}

}
