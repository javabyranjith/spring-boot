package jbr.sboot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jbr.sboot.model.Product;
import jbr.sboot.service.FileDownloadService;
import jbr.sboot.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileDownloadController {

  @Autowired
  private FileDownloadService downloadService;

  @Autowired
  private ProductService productService;

  @GetMapping("/")
  public String home(Model model) {
    List<Product> products = productService.getProducts();
    log.info("product size: " + products.size());
    model.addAttribute("products", products);

    return "home";
  }

  @GetMapping("/downloadExcelAsReponse")
  public ModelAndView downloadExcelAsReponse(HttpServletRequest request, HttpServletResponse response) {
    log.info("inside downloadExcelAsReponse");
    String filename = "product-data-as-response.xlsx";

    // Set Header details
    response.setHeader("Pragma", "public");
    response.setHeader("Cache-Control", "max-age=0");
    response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
    response.setContentType("application/md-excel");

    downloadService.getExcelAsResponse(response);
    return null;
  }

  @GetMapping("/downloadExcelAsFile")
  public @ResponseBody Resource downloadExcelAsFile(HttpServletRequest request, HttpServletResponse response) {
    log.info("inside downloadExcelAsFile");

    File file = downloadService.getExcelAsFile();
    response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
    response.setContentType("application/md-excel");

    return new FileSystemResource(file);
  }

  @GetMapping("/downloadExcelAsFile1")
  public @ResponseBody void downloadExcelAsFile1(HttpServletRequest request, HttpServletResponse response)
      throws FileNotFoundException, IOException {
    log.info("inside downloadExcelAsFile1");

    File file = downloadService.getExcelAsFile();
    response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
    response.setContentType("application/md-excel");
    // FileCopyUtils.copy(new FileInputStream(file),
    // response.getOutputStream());
    IOUtils.copy(new FileInputStream(file), response.getOutputStream());
  }

  @GetMapping("/download1")
  public @ResponseBody HttpEntity<byte[]> download1(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    File file = downloadService.getExcelAsFile();
    byte[] document = FileCopyUtils.copyToByteArray(file);

    HttpHeaders header = new HttpHeaders();
    header.setContentType(new MediaType("application", "md-excel"));
    header.set("Content-Disposition", "attachment; filename=" + file.getName());
    header.setContentLength(document.length);
    return new HttpEntity<>(document, header);
  }

  @GetMapping("/download2")
  public Response download2(HttpServletRequest request, HttpServletResponse response) {
    File file = downloadService.getExcelAsFile();

    return Response.ok().entity(new StreamingOutput() {

      @Override
      public void write(final OutputStream output) throws IOException {
        try {
          Files.copy(file.toPath(), output);
        } finally {
          Files.delete(file.toPath());
        }
      }
    }).header("Content-Disposition", "attachment; filename=" + file.getName()).build();
  }

}
