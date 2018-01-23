
public class boolWithId {
	private boolean value;
	private Integer id;

	public boolWithId(boolean v, Integer _id) {
		this.setValue(v);
		this.setId(_id);
		
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	@Override
	public String toString() {
		
		return"("+this.id+")"+"  "+value;
	}
	
	
	
}
