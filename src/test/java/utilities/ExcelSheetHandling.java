package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetHandling {

    public static String getCellData(String sheetName, int rowNum, int colNum) {
        String value = "";
        try (FileInputStream fis = new FileInputStream(ConfigReader.getProperty("excelPath"));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            value = cell.getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
