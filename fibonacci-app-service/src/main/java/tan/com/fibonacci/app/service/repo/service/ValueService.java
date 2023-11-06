package tan.com.fibonacci.app.service.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import tan.com.fibonacci.app.service.repo.ValueRepo;
import tan.com.fibonacci.app.service.resource.Value;

@Service
public class ValueService {

	@Autowired
	private ValueRepo valueRepo;

	public List<Value> getAllValues() {

		return valueRepo.findAll();

	}

	public List<Value> getValuesByIndex(Integer index) {
		Value value = new Value();
		value.setIndexValue(index);

		Example<Value> exampleOfValue = Example.of(value);
		return valueRepo.findAll(exampleOfValue);
	}

	public void addValue(Integer index, Integer fib) {

		Value value = new Value();
		value.setIndexValue(index);
		value.setFibValue(fib);

		valueRepo.save(value);

	}

}
