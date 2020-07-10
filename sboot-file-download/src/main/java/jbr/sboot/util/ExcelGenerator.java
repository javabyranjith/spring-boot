package jbr.sboot.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import jbr.sboot.model.Product;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ExcelGenerator {

  public File generateExcelAsFile() {
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Product Data");
    generateHeader(workbook, sheet);
    int rownum = 1;

    // Generate Data
    List<Product> products = ProductUtil.getProducts();
    log.info("Downloading " + products.size() + " products.");
    for (Product product : products) {
      Row row = sheet.createRow(rownum++);
      generateData(row, product);
    }
    File file = new File("product-data-as-file.xlsx");
    try {
      FileOutputStream fos = new FileOutputStream(file);
      workbook.write(fos);
    } catch (IOException e) {
      log.error(e.getMessage());
    }

    return file;
  }

  public void generateExcelAsResponse(HttpServletResponse response) {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Product Data");
    generateHeader(workbook, sheet);
    int rownum = 1;

    // Generate Data
    List<Product> products = ProductUtil.getProducts();
    log.info("Downloading " + products.size() + " products.");
    for (Product product : products) {
      Row row = sheet.createRow(rownum++);
      generateData(row, product);
    }

    try {
      workbook.write(response.getOutputStream());
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }

  private void generateData(Row row, Product product) {
    row.createCell(0).setCellValue(product.getId());
    row.createCell(1).setCellValue(product.getName());
    row.createCell(2).setCellValue(product.getCategory());
    row.createCell(3).setCellValue(product.getPrice());
    row.createCell(4).setCellValue(product.getDescription());
  }

  private void generateHeader(XSSFWorkbook workbook, XSSFSheet sheet) {
    XSSFRichTextString richTxt = new XSSFRichTextString();
    XSSFFont font = workbook.createFont();
    font.setBold(true);

    Row row1 = sheet.createRow(0);

    richTxt.append("IDDDDD", font);
    row1.createCell(0).setCellValue(richTxt);

    richTxt.append("NAME", font);
    row1.createCell(0).setCellValue(richTxt);

    richTxt.append("CATEGORY", font);
    row1.createCell(0).setCellValue(richTxt);

    richTxt.append("PRICE", font);
    row1.createCell(0).setCellValue(richTxt);

    richTxt.append("DESCRIPTION", font);
    row1.createCell(0).setCellValue(richTxt);
  }
}
