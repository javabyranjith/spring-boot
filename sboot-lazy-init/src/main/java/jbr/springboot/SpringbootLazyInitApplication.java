package jbr.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLazyInitApplication {

	public static void main(String[] args) {
		System.setProperty("spring.main.lazy-initialization", "false");
		SpringApplication.run(SpringbootLazyInitApplication.class, args);
	}

}
