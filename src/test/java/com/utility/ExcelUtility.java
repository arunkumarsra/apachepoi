package com.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	FileInputStream file;
	FileOutputStream output;
	XSSFWorkbook workBook;
	XSSFSheet sheetName;
	XSSFRow row;
	XSSFCell cell;
	String path;
	String sheet;

	public ExcelUtility(String path, String sheet) {
		this.path = path;
		this.sheet = sheet;
	}

	public int getRow() throws IOException {
		file = new FileInputStream(path);
		workBook = new XSSFWorkbook(file);
		sheetName = workBook.getSheet(sheet);
		return sheetName.getLastRowNum();

	}

	public int getCell() throws IOException {
		file = new FileInputStream(path);
		workBook = new XSSFWorkbook(file);
		sheetName = workBook.getSheet(sheet);
		row = sheetName.getRow(0);
		return row.getLastCellNum();
	}

	public String getCellValue(int rows, int cells) throws IOException {
		file = new FileInputStream(path);
		workBook = new XSSFWorkbook(file);
		sheetName = workBook.getSheet(sheet);
		row = sheetName.getRow(rows);
		cell = row.getCell(cells);
		DataFormatter x = new DataFormatter();
		return x.formatCellValue(cell);

	}

	public void writeData(int rows, int cells, String value) throws IOException {
		file = new FileInputStream(path);
		workBook = new XSSFWorkbook(file);
		sheetName = workBook.getSheet(sheet);
		row = sheetName.getRow(rows);
		cell = row.getCell(cells);
		cell.setCellValue(value);
		output = new FileOutputStream(path);
		workBook.write(output);

	}

}
