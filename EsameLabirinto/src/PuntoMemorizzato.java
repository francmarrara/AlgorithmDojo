import java.util.HashSet;
import java.util.Set;

public class PuntoMemorizzato {

	private int x;
	private int y;
	private boolean alreadyServed;

	private Set<PuntoMemorizzato> puntiRaggiungibili;

	public PuntoMemorizzato(int x, int y) {
		this.x = x;
		this.y = y;
		setAlreadyServed(false);
		puntiRaggiungibili = new HashSet<PuntoMemorizzato>();
	}

	public String toString() {

		return "( " + x + ", " + y + " )";

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Set<PuntoMemorizzato> getPuntiRaggiungibili() {
		return puntiRaggiungibili;
	}

	public void setPuntiRaggiungibili(Set<PuntoMemorizzato> puntiRaggiungibili) {
		this.puntiRaggiungibili = puntiRaggiungibili;
	}

	public boolean isAlreadyServed() {
		return alreadyServed;
	}

	public void setAlreadyServed(boolean alreadyServed) {
		this.alreadyServed = alreadyServed;
	}
}
