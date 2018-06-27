package jbr.spring.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

@Order(value = 2)
@SpringBootApplication
public class TuesdayCommandLineRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    System.out.println("TuesdayCommandLinerRunner run()");
  }

}
