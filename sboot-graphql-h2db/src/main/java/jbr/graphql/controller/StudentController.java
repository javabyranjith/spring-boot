package jbr.graphql.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

  @GetMapping("/greeting")
  public ResponseEntity<Object> greeting() {
    log.info("enter - greeting()");
    return new ResponseEntity<Object>("Welcome Student!!!", HttpStatus.OK);
  }
}
