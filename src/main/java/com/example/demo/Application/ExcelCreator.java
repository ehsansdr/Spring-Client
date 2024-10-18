package com.example.demo.Application;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelCreator {

    /** this class create Excel file
     * https://medium.com/@metehankozan/creating-excel-files-in-java-with-apache-poi-0378be215b44
     * */

    public static void main(String[] args) {
        ExcelXSSF();

    }

    private static void ExcelXSSF() {
        String excelFileName = "excelXSSF";

        // Create a list of employees with their data
        List<Object[]> employeeData = new ArrayList<>();
        employeeData.add(new Object[]{"John Doe", 101, "2023-01-15", 55000.0});
        employeeData.add(new Object[]{"Jane Smith", 102, "2022-08-20", 65000.0});
        employeeData.add(new Object[]{"Bob Johnson", 103, "2023-03-10", 60000.0});

        // Create a new Excel workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a new sheet
        Sheet sheet = workbook.createSheet("Employee Data");

        // Create the header row and adding column
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Employee ID");
        headerRow.createCell(2).setCellValue("Hire Date");
        headerRow.createCell(3).setCellValue("Salary");

        // Populate the rows with employee data
        for (int i = 0; i < employeeData.size(); i++) {
            Row row = sheet.createRow(i + 1); // Start from the second row
            // Employee Name
            row.createCell(0).setCellValue((String) employeeData.get(i)[0]);
            // Employee ID
            row.createCell(1).setCellValue((int) employeeData.get(i)[1]);
            // Hire Date
            row.createCell(2).setCellValue((String) employeeData.get(i)[2]);
            // Salary
            row.createCell(3).setCellValue((double) employeeData.get(i)[3]);
        }

        // Save the Excel file to a local directory
        try (FileOutputStream fileOut =
                     new FileOutputStream("src/main/resources/ExcelFiles/" + excelFileName + ".xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void simpleExcel() {
        // create work book
        XSSFWorkbook workbook = new XSSFWorkbook();

        String excelFileName = "excelXSSF";

        //create a sheet in the workbook(you can give it a name)
        Sheet sheet = workbook.createSheet("excel-sheet");

        //create a row in the sheet
        Row row = sheet.createRow(0);

        //add cells in the sheet
        Cell cell0 = row.createCell(0);

        //set a value to the cell
        cell0.setCellValue("something");

        //save the Excel file
        try {
            FileOutputStream out = new FileOutputStream(
                    new File("src/main/resources/ExcelFiles/" + excelFileName + ".xlsx"));// C:\Java projects\spring-client\excel.xlsx
            // src/main/resources/ExcelFiles
            workbook.write(out);
            out.close();
            System.out.println("created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
