package de.micon.TestWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestWorldApplication.class, args);
	}

}
