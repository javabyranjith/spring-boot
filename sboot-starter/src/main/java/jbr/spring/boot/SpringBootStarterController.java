package jbr.spring.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootStarterController {

	@RequestMapping("/hello")
	public String hello() {
		return "Welcome to Spring Boot Starter!!!";
	}
}
