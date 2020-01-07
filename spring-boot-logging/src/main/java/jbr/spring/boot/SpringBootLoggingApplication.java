package jbr.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLoggingApplication {

  private static final Logger _log = LoggerFactory.getLogger(SpringBootLoggingApplication.class);

  @Autowired
  WelcomeController welcomeController;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootLoggingApplication.class, args);
    log.info("MESSAGE..............");
    _log.debug("Debug message");
  }
}
