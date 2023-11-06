package tan.com.fibonacci.worker.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/")
public class WorkerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);

	@Cacheable(value = "values", key = "#index")
	@GetMapping("/fib/{index}")
	public Integer calculateFib(@PathVariable Integer index) {
		LOGGER.info("Calculate Fibonacci for [{}]", index);
		if (index < 2) {
			return 1;
		}

		return calculateFib(index - 1) + calculateFib(index - 2);

	}

}
