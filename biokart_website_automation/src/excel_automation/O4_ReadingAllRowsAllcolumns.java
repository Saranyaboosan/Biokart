package excel_automation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class O4_ReadingAllRowsAllcolumns {

    public static void main(String[] args) {
        String rootDirectory = System.getProperty("user.dir");
        
        System.out.println(rootDirectory);
        //D:\ecoders_testing_projects\biokart_testing_project\Biokart\biokart_website_automation  - is the root folder of the project. 

        // Specify the Excel sheet name
        String excelSheetName = "biokart_data.xlsx";

        // Concatenate the root directory path and Excel sheet name
        String excelSheetPath = rootDirectory + File.separator + excelSheetName;

        try (FileInputStream fis = new FileInputStream(excelSheetPath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            // Get the first sheet
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(1);

            // Iterate over all rows
            for (Row row : sheet) {
                // Iterate over all cells in the row
                for (Cell cell : row) {
                    // Check the cell type and print the value accordingly
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue() + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case FORMULA:
                            System.out.print(cell.getCellFormula() + "\t");
                            break;
                        case BLANK:
                            System.out.print("<BLANK>\t");
                            break;
                        default:
                            System.out.print("<UNKNOWN TYPE>\t");
                    }
                }
                System.out.println(); // Move to the next line after printing all cells in the row
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
