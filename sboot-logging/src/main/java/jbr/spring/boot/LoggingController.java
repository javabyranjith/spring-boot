package jbr.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

  private static final Logger log = LoggerFactory.getLogger(LoggingController.class);

  @RequestMapping("/hello")
  public String hello() {
    log.debug("HELLO DEBUG MSG");
    log.info("HELLO INFO MSG");
    return "hello";
  }

}
