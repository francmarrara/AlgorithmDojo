import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Esame {

	private Scanner s;
	private ArrayList<Directory> directories;
	private Integer numDirectory;
	private Integer max_val;
	private Integer numPersoneDaServire;
	private Integer MIN_VAL;
	private Integer MAX_VAL;
	private ArrayList<Directory> soluzioni;

	public Esame() {
		s = new Scanner(System.in);
		directories = new ArrayList<Directory>();
		soluzioni = new ArrayList<Directory>();

		MIN_VAL = 0;
	}

	public void readInput() {

		String numeri = s.nextLine();

		String[] numeriSub = numeri.split(" ");

		numDirectory = Integer.parseInt(numeriSub[0]);
		max_val = Integer.parseInt(numeriSub[1]);
		numPersoneDaServire = Integer.parseInt(numeriSub[2]);

		MAX_VAL = numDirectory;

		for (int i = 0; i < numDirectory; i++) {

			String linea = s.nextLine();
			String[] sub = linea.split(" ");
			Directory d = new Directory();
			d.setNomeDirectory(sub[0]);

			for (int j = 2; j < sub.length; j++) {

				d.getIdentificativi().add(Integer.parseInt(sub[j]));

			}

			directories.add(d);

		}

	}


	public boolean solve() {
		int x = MIN_VAL;
		while (x < MAX_VAL) {
			if (canAdd(directories.get(x))) {
				soluzioni.add(directories.get(x));
				if (isComplete()) {
					return true;
				} else if (solve()) {
					return true;
				}
				soluzioni.remove(directories.get(x));
				x++;
			} else {
				x++;
			}
		}
		return false;


	}
	public boolean isComplete() {

		HashSet<Integer> destinatari = new HashSet<Integer>();

		for (Directory d : soluzioni) {

			destinatari.addAll(d.getIdentificativi());

		}

		if (destinatari.size() >= numPersoneDaServire) {
			return true;
		}

		return false;
	}

	private boolean canAdd(Directory d) {

		if (soluzioni.contains(d))
			return false;

		if (soluzioni.size() >= max_val)
			return false;

		return true;

	}

	public void stampaDirectories() {
		for (Directory d : directories) {
			d.stampaDirectory();
		}
	}

	public void stampaSoluzioni() {
		for(Directory d : soluzioni) {
			System.out.println(d.getNomeDirectory());
		}
	}
	
	public Integer getNumDirectory() {
		return numDirectory;
	}

	public void setNumDirectory(Integer numDirectory) {
		this.numDirectory = numDirectory;
	}

	public Integer getMin_val() {
		return max_val;
	}

	public void setMin_val(Integer min_val) {
		this.max_val = min_val;
	}

	public ArrayList<Directory> getDirectories() {
		return directories;
	}

	public void setDirectories(ArrayList<Directory> directories) {
		this.directories = directories;
	}

	public Scanner getS() {
		return s;
	}

	public void setS(Scanner s) {
		this.s = s;
	}

	public Integer getNumPersoneDaServire() {
		return numPersoneDaServire;
	}

	public void setNumPersoneDaServire(Integer numPersoneDaServire) {
		this.numPersoneDaServire = numPersoneDaServire;
	}

}
