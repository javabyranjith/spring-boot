package jbr.sboot.service;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.sboot.util.ExcelGenerator;

@Service
public class FileDownloadService {

  @Autowired
  private ExcelGenerator excelGenerator;

  public void getExcelAsResponse(HttpServletResponse response) {
    excelGenerator.generateExcelAsResponse(response);
  }

  public File getExcelAsFile() {
   return excelGenerator.generateExcelAsFile();
  }

}
