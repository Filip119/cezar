package sk.fzdp.ciphers.cezar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="sk.fzdp.ciphers.cezar")
public class CezarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CezarApplication.class, args);
	}

}
