package jbr.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCommandLineRunnerApplication implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(SpringBootCommandLineRunnerApplication.class);

  public static void main(String[] args) {
    log.info("Before application start");
    SpringApplication.run(SpringBootCommandLineRunnerApplication.class, args);
    log.info("After application start");
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("inside run method");
    for (int i = 0; i < args.length; i++) {
      log.info(args[i]);
    }
  }
}
