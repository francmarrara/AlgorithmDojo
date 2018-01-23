
public class Nodo {

	private char carattere;
	private Integer coordX;
	private Integer coordY;
	
	public Nodo(char c, Integer x, Integer y){
		
		this.setCarattere(c);
		this.setCoordX(x);
		this.setCoordY(y);
		
	}

	public char getCarattere() {
		return carattere;
	}

	public void setCarattere(char carattere) {
		this.carattere = carattere;
	}

	public Integer getCoordX() {
		return coordX;
	}

	public void setCoordX(Integer coordX) {
		this.coordX = coordX;
	}

	public Integer getCoordY() {
		return coordY;
	}

	public void setCoordY(Integer coordY) {
		this.coordY = coordY;
	}

	@Override
	public String toString() {
		String s = new String("Nodo"+" "+getCarattere() +" : "+ getCoordX() +" "+ getCoordY());// TODO Auto-generated method stub
		return s;
	}
	
	
	
}
