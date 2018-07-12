package it.unical.mat.kernel;

public class Coppia {
	
	String primoCorso;
	String secondoCorso;
	
	
	public Coppia() {
		
		primoCorso=new String();
		secondoCorso=new String();
		
	}
	
	public Coppia(String primoCorso,String secondoCorso) {
		
		this.primoCorso=primoCorso;
		this.secondoCorso=secondoCorso;
		
	}
	
	public String getPrimoCorso() {
		return primoCorso;
	}
	public void setPrimoCorso(String primoCorso) {
		this.primoCorso = primoCorso;
	}
	public String getSecondoCorso() {
		return secondoCorso;
	}
	public void setSecondoCorso(String secondoCorso) {
		this.secondoCorso = secondoCorso;
	}

}
