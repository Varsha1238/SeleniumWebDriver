package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File excelFile = new File("TestData.xlsx");	
		FileInputStream fis =new FileInputStream(excelFile);		
		XSSFWorkbook wb = new XSSFWorkbook(fis);		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int numberOfRows = sheet.getLastRowNum();
	     

	}

}
