package tan.com.fibonacci.app.service.resource;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "value")
public class Value {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "value_id")
	private Long valueId;
	
	@Column(name = "index_value")
	private Integer indexValue;
	
	@Column(name = "fib_value")
	private Integer fibValue;

	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}

	public Long getValueId() {
		return valueId;
	}

	public Integer getIndexValue() {
		return indexValue;
	}

	public void setIndexValue(Integer indexValue) {
		this.indexValue = indexValue;
	}
	

	public Integer getFibValue() {
		return fibValue;
	}

	public void setFibValue(Integer fibValue) {
		this.fibValue = fibValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fibValue, indexValue, valueId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Value other = (Value) obj;
		return Objects.equals(fibValue, other.fibValue) && Objects.equals(indexValue, other.indexValue)
				&& Objects.equals(valueId, other.valueId);
	}

	@Override
	public String toString() {
		return "Value [valueId=" + valueId + ", indexValue=" + indexValue + ", fibValue=" + fibValue + "]";
	}
	
	
}
