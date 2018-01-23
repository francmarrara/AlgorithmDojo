import java.util.HashSet;
import java.util.Set;

public class Directory {
	private String nomeDirectory;
	private Set<Integer> identificativi;

	
	public Directory() {
		identificativi = new HashSet<Integer>();
	}
	
	
	
	public String getNomeDirectory() {
		return nomeDirectory;
	}

	public void setNomeDirectory(String nomeDirectory) {
		this.nomeDirectory = nomeDirectory;
	}

	public Set<Integer> getIdentificativi() {
		return identificativi;
	}

	public void setIdentificativi(Set<Integer> identificativi) {
		this.identificativi = identificativi;
	}

	
    public void stampaDirectory() {
    	System.out.print(nomeDirectory+" : ");
    	System.out.println(identificativi);
    	
    }
	
}
