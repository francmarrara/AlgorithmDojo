package it.unical.mat.esame;

public class BoolWithId {
	
	private Boolean value;
	private Integer id;
	
	public BoolWithId(boolean v, Integer id) {
		this.value=v;
		this.id=id;
		
	}
	
	public Boolean getValue() {
		return value;
	}
	public void setValue(Boolean value) {
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
		
		return"("+this.id+")"+" "+value;
	}
	
}
