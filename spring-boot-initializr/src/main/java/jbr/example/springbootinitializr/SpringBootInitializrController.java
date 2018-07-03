package jbr.example.springbootinitializr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootInitializrController {

	@RequestMapping("/hello")
	public String hello() {
		return "Welcome to Spring Boot Initializr!!!";
	}
}
