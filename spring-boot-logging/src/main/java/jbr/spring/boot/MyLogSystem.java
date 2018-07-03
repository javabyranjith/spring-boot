package jbr.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LoggingSystem;

public class MyLogSystem extends LoggingSystem {

  private static final Logger log = LoggerFactory.getLogger(MyLogSystem.class);
  @Override
  public void beforeInitialize() {
    log.info("inside MyLogSystem.beforeInitialize");
  }

}
