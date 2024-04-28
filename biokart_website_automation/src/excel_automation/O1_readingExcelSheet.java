package excel_automation;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class O1_readingExcelSheet {

	public static void main(String[] args) 
	{
		String excelsheetpath = "D:\\ecoders_testing_projects\\biokart_testing_project\\Biokart\\biokart_website_automation\\excel_data\\biokart_data.xlsx";
		int rownumber = 0;
		int cellnumber = 0;
		
		try {
			File f = new File(excelsheetpath);
			FileInputStream fis = new FileInputStream(f);
			
			// create a workbook. using WorkBook interface.
			Workbook workbook = new XSSFWorkbook(fis);
			// create a sheet in the workbook. 
			org.apache.poi.ss.usermodel.Sheet sh = workbook.getSheet("Sheet1");
			
			// from that sheet go to the row number you want to fetch the value from. 
			Row row = sh.getRow(rownumber);
			// from that row go to the cell number. from which you want to fetch the data. 
			Cell columnnumber = row.getCell(cellnumber);
			
			// from that cell extract the String value. 
			String value = columnnumber.getStringCellValue();
			
			// print the value read from the excel sheet. 
			System.out.println(value);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		    System.out.println("Unable to fetch value from the excel sheet.");	
		}
	}
}
