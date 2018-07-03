package jbr.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggingApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootLoggingApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingApplication.class, args);
		log.debug("Debug message");
	}
}
