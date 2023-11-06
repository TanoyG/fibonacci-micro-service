package tan.com.fibonacci.app.service.resource;

public class ExistValue {
	
	private Integer index;
	private Integer value;
	
	public ExistValue() {
		super();
	}
	public ExistValue(Integer index, Integer value) {
		super();
		this.index = index;
		this.value = value;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}

}
