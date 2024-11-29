package mini.chat.minichat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MinichatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinichatApplication.class, args);
	}

	// controller hello world
	@RestController
	public class HelloWorldController {
		@GetMapping("/hello")
		public String hello() {
			return "Hello World!";
		}
	}
}
