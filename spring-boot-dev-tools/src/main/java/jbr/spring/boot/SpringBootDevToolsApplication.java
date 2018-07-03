package jbr.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDevToolsApplication {
  private static final Logger log = LoggerFactory.getLogger(SpringBootDevToolsApplication.class);
	public static void main(String[] args) {
	  //System.setProperty("spring.devtools.restart.enabled", "false"); // overrides application.properties
		SpringApplication.run(SpringBootDevToolsApplication.class, args);
		//log.debug("debug1111");
	}
}
