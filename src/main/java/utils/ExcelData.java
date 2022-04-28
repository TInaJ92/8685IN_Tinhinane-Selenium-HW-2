package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelData {

    private final String filePath;
    private XSSFWorkbook workbook = null;
    private Sheet sheet = null;
    private Row row = null;
    private Cell cell = null;
    private FileOutputStream fos = null;
    private int numberOfRows, numberOfCol;

    public ExcelData(String filePath) {
        this.filePath = filePath;
    }

    // region Readers
    /**
     * Read all rows and columns (String values only) and return the results as a multi-dimensional String Array
     *
     * This function does not read the header row, and starts reading from row 2
     *
     * @param sheetName Sheet name to read from
     * @return All populated String cell values
     */
    public String[][] readStringArrays(String sheetName) {
        String[][] data;

        try {
            FileInputStream fis = new FileInputStream(this.filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to load file - Check file path, or if the file actually exists in file path directory");
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(1).getLastCellNum();

        data = new String[numberOfRows][numberOfCol];

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                cell = row.getCell(j);
                String cellData = getCellValue(cell);
                data[i-1][j] = cellData;
            }
        }
        return data;
    }


    /**
     * Read all rows and columns (integer values only) and return the results as a multi-dimensional integer Array
     *
     * This function does not read the header row, and starts reading from row 2
     *
     * @param sheetName Sheet name to read from
     * @return All populated integer cell values
     */
    public int[][] readIntegerArrays(String sheetName) {
        int[][] data;
        File file = new File(this.filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to load file - Check file path, or if the file actually exists in file path directory");
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(1).getLastCellNum();

        data = new int[numberOfRows][numberOfCol];

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                cell = row.getCell(j);
                int cellData = Integer.parseInt(getCellValue(cell));
                data[i-1][j] = cellData;
            }
        }
        return data;
    }

    /**
     * Read all cells in the last row (String values only) and return the results as a String Array. This method
     * is most likely to be used when there is only 1 row in the sheet
     *
     * @param sheetName Sheet name to read from
     * @return All populated String cells in the last row of the sheet
     */
    public String[] readStringArray(String sheetName) {
        String[] data;
        File file = new File(this.filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();

        data = new String[numberOfRows];

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            cell = row.getCell(0);
            String cellData = getCellValue(cell);
            data[i - 1] = cellData;
        }

        return data;
    }


    /**
     * Read all cells in the last row (integer values only) and return the results as an integer Array. This method
     * is most likely to be used when there is only 1 row in the sheet
     *
     * @param sheetName Sheet name to read from
     * @return All populated cells (integer values only) in the last row of the sheet
     */
    public int[] readIntegerArray(String sheetName) {
        int[] data;
        File file = new File(this.filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to load file - Check file path, or if the file actually exists in file path directory");
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();

        data = new int[numberOfRows];

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            cell = row.getCell(0);
            int cellData = Integer.parseInt(getCellValue(cell));
            data[i-1] = cellData;
        }
        return data;
    }

    /**
     * Read all cells in the last row (String values only) and return the results as a List<String>. This method
     * is most likely to be used when there is only 1 row in the sheet
     *
     * @param sheetName Sheet name to read from
     * @return All populated String cells in the last row of the sheet
     */
    public List<String> readStringList(String sheetName) {
        List<String> data;
        File file = new File(this.filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Unable to load file - Check file path, or if the file actually exists in file path directory");
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        numberOfRows = sheet.getLastRowNum();

        data = new ArrayList<>();

        for (int i = 1; i <= numberOfRows; i++) {
            row = sheet.getRow(i);
            cell = row.getCell(0);
            String cellData = getCellValue(cell);
            data.add(i-1, cellData);
        }
        return data;
    }

    // endregion

    // region Writers
    /**
     * Writes a multi-dimensional String array to a desired workbook/sheet
     *
     * @param sheetName Sheet name to write to
     */
    public void writeStringArrays(String[][] data, String sheetName) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < data.length; i++) {
            row = sheet.createRow(i + 1);

            for (int j = 0; j < data[i].length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        try {
            fos = new FileOutputStream(this.filePath);
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            System.out.println("Unable to close file resource");
            e.printStackTrace();
        }
    }

    /**
     * Writes a multi-dimensional integer array to a desired workbook/sheet
     *
     * @param sheetName Sheet name to write to
     */
    public void writeIntegerArrays(int[][] data, String sheetName) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < data.length; i++) {
            row = sheet.createRow(i + 1);

            for (int j = 0; j < data[i].length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        try {
            fos = new FileOutputStream(this.filePath);
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            System.out.println("Unable to close file resource");
            e.printStackTrace();
        }
    }

    // endregion

    // region Helper Methods
    private String getCellValue(Cell cell) {
        Object value;

        CellType dataType = cell.getCellType();
        switch (dataType) {
            case NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            default:
                value = cell.getRichStringCellValue();
        }
        return value.toString();
    }

    // endregion
}
