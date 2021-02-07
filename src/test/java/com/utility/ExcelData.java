package com.utility;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelData {

	public ArrayList<String[]> getData() throws IOException {
		ArrayList<String[]> mydata = new ArrayList<String[]>();
		ExcelUtility file = new ExcelUtility("F:\\apache.xlsx", "Sheet1");
		for (int i = 0; i <= file.getRow(); i++) {
			String userName = file.getCellValue(i, 0);
			String password = file.getCellValue(i, 1);
			String firstName = file.getCellValue(i, 2);
			String lastName = file.getCellValue(i, 3);
			String address = file.getCellValue(i, 4);
			String cvv = file.getCellValue(i, 5);
			String num = file.getCellValue(i, 6);
			String obj[] = { userName, password, firstName, lastName, address, cvv, num };
			mydata.add(obj);
		}
		return mydata;
	}

}
