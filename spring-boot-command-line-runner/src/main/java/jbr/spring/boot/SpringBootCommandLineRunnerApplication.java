package jbr.spring.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCommandLineRunnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		System.out.println("Before application start");
		SpringApplication.run(SpringBootCommandLineRunnerApplication.class, args);
		System.out.println("After application start");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("inside run method");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}
