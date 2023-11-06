package tan.com.fibonacci.worker.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FibonacciWorkerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FibonacciWorkerServiceApplication.class, args);
	}

}
