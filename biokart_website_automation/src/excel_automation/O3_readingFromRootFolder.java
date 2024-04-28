package excel_automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class O3_readingFromRootFolder {

	public static void main(String[] args) {
		 // Get the root directory of the project
        String rootDirectory = System.getProperty("user.dir");
        
        System.out.println(rootDirectory);
        //D:\ecoders_testing_projects\biokart_testing_project\Biokart\biokart_website_automation  - is the root folder of the project. 

        // Specify the Excel sheet name
        String excelSheetName = "biokart_data.xlsx";

        // Concatenate the root directory path and Excel sheet name
        String excelSheetPath = rootDirectory + File.separator + excelSheetName;
        
        
//         Windows:
//
//			String rootDirectory = "C:\\Users\\username\\project";
//			String excelSheetName = "biokart_data.xlsx";
//			String excelSheetPath = rootDirectory + File.separator + excelSheetName;
//			The resulting excelSheetPath would be:
//			
//			C:\Users\\username\project\biokart_data.xlsx 
//			
//			
//			Linux:
//			
//			String rootDirectory = "/home/username/project";
//			String excelSheetName = "biokart_data.xlsx";
//			String excelSheetPath = rootDirectory + File.separator + excelSheetName;
//			The resulting excelSheetPath would be:
//			
//			/home/username/project/biokart_data.xlsx
//			 
//			macOS:
//			
//			String rootDirectory = "/Users/username/project";
//			String excelSheetName = "biokart_data.xlsx";
//			String excelSheetPath = rootDirectory + File.separator + excelSheetName;
//			The resulting excelSheetPath would be:
//			
//			/Users/username/project/biokart_data.xlsx
//         
    
        
        // mention the row number and cell number(column)
        int rowNumber = 0;
        int cellNumber = 0;

        try (FileInputStream fis = new FileInputStream(excelSheetPath);
                Workbook workbook = new XSSFWorkbook(fis)) {

            // Create a sheet in the workbook.
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Sheet1");

            // From that sheet, go to the row number you want to fetch the value from.
            Row row = sheet.getRow(rowNumber);
            // From that row, go to the cell number from which you want to fetch the data.
            Cell cell = row.getCell(cellNumber);

            // From that cell, extract the String value.
            String value = cell.getStringCellValue();

            // Print the value read from the Excel sheet.
            System.out.println("Value from Excel sheet: " + value);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Unable to fetch value from the Excel sheet.");
        }

	}

}
