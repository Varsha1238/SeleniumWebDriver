package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderSupplier {
	@DataProvider
	public String[][] getData() {
		String[][] data = { { "UserName1", "Password1", "Address" }, { "UserName2", "Password2" },
				{ "UserName3", "Password3" } };
		return data;

	}
	
	@DataProvider(indices = {1,0,2})
	public Iterator<String[]> getData1() {
		List<String[]> data= new ArrayList<String[]>();
		data.add(new String[] {"UserName1","Password1"});
		data.add(new String[] {"UserName2","Password2"});
		return data.iterator();

	}
	
	@DataProvider
	public String[][] getData2() throws IOException
	{
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
			}
			
		}	
		fis.close();
		return data;
		
	}

}
