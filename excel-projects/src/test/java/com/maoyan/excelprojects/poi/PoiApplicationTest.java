package com.maoyan.excelprojects.poi;

import com.maoyan.excelprojects.InsertExcelApplicationTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author chenhua11
 * @date 2021/6/24  3:55 下午
 */
public class PoiApplicationTest extends InsertExcelApplicationTest {
    
    private static final String poiPath = "/Users/user/ideaproject/study-project/excel-projects/src/main/resources/poi/" + System.currentTimeMillis() + ".xlsx";
    
    @Test
    public void test4() {
    
    }
    
    @Test
    public void test3() throws IOException {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");
        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(1);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(1);
        cell.setCellValue(4);
        // Style the cell with borders all around.
        CellStyle style = wb.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
        style.setBorderTop(BorderStyle.MEDIUM_DASHED);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cell.setCellStyle(style);
        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream(poiPath)) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        wb.close();
    }
    
    
    @Test
    public void test2() throws IOException {
        Workbook wb = new XSSFWorkbook(); //or new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow(2);
        row.setHeightInPoints(30);
        createCell(wb, row, 0, HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM);
        createCell(wb, row, 1, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.BOTTOM);
        createCell(wb, row, 2, HorizontalAlignment.FILL, VerticalAlignment.CENTER);
        createCell(wb, row, 3, HorizontalAlignment.GENERAL, VerticalAlignment.CENTER);
        createCell(wb, row, 4, HorizontalAlignment.JUSTIFY, VerticalAlignment.JUSTIFY);
        createCell(wb, row, 5, HorizontalAlignment.LEFT, VerticalAlignment.TOP);
        createCell(wb, row, 6, HorizontalAlignment.RIGHT, VerticalAlignment.TOP);
        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream("xssf-align.xlsx")) {
            wb.write(fileOut);
        }
        wb.close();
    }
    
    
    private static void createCell(Workbook wb, Row row, int column, HorizontalAlignment halign, VerticalAlignment valign) {
        Cell cell = row.createCell(column);
        cell.setCellValue("Align It");
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
    }
    
    @Test
    public void test1() throws IOException, InvalidFormatException {
        // Use a file
        Workbook wb = WorkbookFactory.create(new File("/Users/user/ideaproject/study-project/excel-projects/src/main/resources/poi/1624527444837.xlsx"));
    }
    
    @Test
    public void difftype() throws IOException {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");
        Row row = sheet.createRow(2);
        row.createCell(0).setCellValue(1.1);
        row.createCell(1).setCellValue(new Date());
        row.createCell(2).setCellValue(Calendar.getInstance());
        row.createCell(3).setCellValue("a string");
        row.createCell(4).setCellValue(true);
        row.createCell(5).setCellType(CellType.ERROR);
        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream(poiPath)) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        wb.close();
    }
    
    @Test
    public void createWorkBook() throws Exception {
        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        OutputStream fileOut = new FileOutputStream(poiPath);
        String safeName = WorkbookUtil.createSafeSheetName("new sheet");
        Sheet sheet = wb.createSheet(safeName);
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(1);
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(
                createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);
    
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        Cell cell1 = row.createCell(4);
        cell1.setCellValue(new Date());
        cell1.setCellStyle(cellStyle);
        wb.write(fileOut);
        wb.close();
        fileOut.close();
    }
    
    @Test
    public void testWrite07Excel() throws Exception {
        //1、创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //2、创建工作表
        XSSFSheet sheet = workbook.createSheet("Hello");//指定工作表名
        //3、创建行：创建第3行
        XSSFRow row = sheet.createRow(2);
        //4、创建单元格：创建第3行第3列
        XSSFCell cell = row.createCell(2);
        cell.setCellValue("Hello World"); //输出到硬盘
        FileOutputStream outputStream = new FileOutputStream(poiPath + "测试.xlsx");
        //把Excel输出到具体的地址
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    
    
    @Test
    public void testRead07Excel() throws Exception{
        FileInputStream inputStream = new FileInputStream(poiPath + "测试.xlsx");
        //1、读取工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        //2、读取第一个工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //3、读取行：读取第3行
        XSSFRow row = sheet.getRow(2);
        //4、读取单元格：读取第3行第3列
        XSSFCell cell = row.getCell(2);
        System.out.println("第3行第3列单元格的内容为：" + cell.getStringCellValue());
        workbook.close();
        inputStream.close();
    }
    
    
    
    
}