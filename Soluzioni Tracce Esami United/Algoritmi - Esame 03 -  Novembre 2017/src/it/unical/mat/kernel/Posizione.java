package it.unical.mat.kernel;

import java.awt.Point;

public class Posizione {
	
	
	private char casella; //# indica un muro || . indica un corridoio
	private Point coordinate; // coordinate della casella del labirinto
	private boolean puntoIntersezione; //flag true indica punto di intersezione flase invece no;
	// un punto è detto di intersezione se ha almeno 3 direzioni vicine che sono un corridoio
	
	public Posizione(char casella) {
		
		this.casella=casella;
		coordinate=new Point(0,0);
		puntoIntersezione=false;
		
	}
	
	
	public char getCasella() {
		return casella;
	}
	public void setCasella(char casella) {
		this.casella = casella;
	}
	public Point getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}
	public boolean isPuntoIntersezione() {
		return puntoIntersezione;
	}
	public void setPuntoIntersezione(boolean puntoIntersezione) {
		this.puntoIntersezione = puntoIntersezione;
	}
	
	
}
