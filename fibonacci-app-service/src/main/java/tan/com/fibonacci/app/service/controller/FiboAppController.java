package tan.com.fibonacci.app.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tan.com.fibonacci.app.service.repo.service.ValueService;
import tan.com.fibonacci.app.service.resource.ExistValue;
import tan.com.fibonacci.app.service.resource.IndexValue;
import tan.com.fibonacci.app.service.resource.Value;

@CrossOrigin
@RestController
@RequestMapping("/fibo-app")
public class FiboAppController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FiboAppController.class);

	@Autowired
	private RestTemplate template;

	@Autowired
	private ValueService valueService;

	@PostMapping("/calculateFibo")
	public ResponseEntity<Integer> calculateFibo(@RequestBody IndexValue indexValue) throws Exception {

		LOGGER.info("Input [{}]", indexValue);

		Integer inputIndex = indexValue.getIndexValue();

		LOGGER.info("Calculate Fibinacci number for [{}]", inputIndex);

		// get the movie by id
		Integer fiboValue = template.getForObject("http://fibonacci-worker-service/fib/" + inputIndex, Integer.class);

		LOGGER.info("Calculated Fibinacci number is [{}]", fiboValue);

		List<Value> existingValues = valueService.getValuesByIndex(inputIndex);
		if (existingValues.isEmpty()) {
			LOGGER.info("[{}] is a new input index. Add it in DB", inputIndex);
			valueService.addValue(inputIndex, fiboValue);
		} else {
			LOGGER.info("[{}] is an existing input index. No need to add it in DB", inputIndex);
		}

		return ResponseEntity.ok(fiboValue);

	}

	@GetMapping("/values")
	public ResponseEntity<List<ExistValue>> getAllValues() throws Exception {

		LOGGER.info("Get all existing values");

		List<ExistValue> allValues = new ArrayList<ExistValue>();
		List<Value> existingValues = valueService.getAllValues();
		if (!existingValues.isEmpty()) {
			LOGGER.info("[{}] existing values", existingValues.size());
			allValues = existingValues.stream()
					.map(existingValue -> new ExistValue(existingValue.getIndexValue(), existingValue.getFibValue()))
					.collect(Collectors.toList());
		} else {
			LOGGER.info("No value present");
		}

		return ResponseEntity.ok(allValues);

	}

}
