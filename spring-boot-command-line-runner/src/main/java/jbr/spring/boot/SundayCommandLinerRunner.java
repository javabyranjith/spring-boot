package jbr.spring.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

@Order(value = 7)
@SpringBootApplication
public class SundayCommandLinerRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    System.out.println("SundayCommandLinerRunner run()");
  }

}
