package blog.geek1vision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Geek1visionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Geek1visionApplication.class, args);
	}

}
