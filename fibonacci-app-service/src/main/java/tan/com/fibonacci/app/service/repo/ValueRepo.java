package tan.com.fibonacci.app.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tan.com.fibonacci.app.service.resource.Value;

public interface ValueRepo extends JpaRepository<Value, Long>{

}
