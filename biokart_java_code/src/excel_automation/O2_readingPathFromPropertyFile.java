package excel_automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class O2_readingPathFromPropertyFile {

	public static void main(String[] args) {
		 // Load properties from config.properties file
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to load config.properties file.");
            return;
        }

        // Get the Excel sheet path from properties
        String excelSheetPath = prop.getProperty("excel.sheet.path");
        if (excelSheetPath == null) {
            System.out.println("Excel sheet path is not specified in config.properties file.");
            return;
        }

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
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Unable to fetch value from the Excel sheet.");
        }

	}

}
