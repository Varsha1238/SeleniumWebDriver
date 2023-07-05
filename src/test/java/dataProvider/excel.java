package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	
			File excelFile = new File("TestData.xlsx");	
			FileInputStream fis =new FileInputStream(excelFile);		
			XSSFWorkbook wb = new XSSFWorkbook(fis);		
			XSSFSheet sheet = wb.getSheet("Sheet1");
			int numberOfRows = sheet.getLastRowNum();
			int numberOfCols = sheet.getRow(0).getLastCellNum();
			
			String[][] data = new String[numberOfRows+1][numberOfCols];
			System.out.println(numberOfRows);
			System.out.println(numberOfCols);
			
			for (int i = 1; i <= numberOfRows; i++) {
				for (int j = 0; j < numberOfCols; j++) {
					DataFormatter df =new DataFormatter();
					
					data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
					System.out.println(data[i][j] );
				}
				
			}		
			fis.close();
			
	}

}
