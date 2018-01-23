import java.util.Scanner;

public class Esame {

	Scanner scanner;
	Integer righe;
	Integer colonne;
	char[][] matriceCaratteri;
	Integer[][] distanze;

	public Esame() {

		scanner = new Scanner(System.in);
		righe = 0;
		colonne = 0;

	}

	// Calcola quanti intorni ha un punto in cui il carattere è '-'
	public Integer calcolaIntorno(Integer riga, Integer colonna, Integer intorno, Boolean trovato) {

		if (trovato == true)
			return intorno;

		// Controllo superiore
		if ((riga - intorno >= 0 && colonna - intorno >= 0) && (colonna + intorno < getColonne())) {

			for (int x = colonna - intorno; x <= colonna + intorno; x++) {

				if (matriceCaratteri[riga - intorno][x] == '#') {
					trovato = true;
					break;
				}

			}

		}

		// Controllo inferiore
		if ((riga + intorno < getRighe() && colonna - intorno >= 0) && (colonna + intorno < getColonne())) {

			for (int x = colonna - intorno; x <= colonna + intorno; x++) {

				if (matriceCaratteri[riga + intorno][x] == '#') {
					trovato = true;
					break;
				}

			}

		}

		// Controllo sinistro
		if ((riga - intorno >= 0 && colonna - intorno >= 0) && (riga + intorno < getRighe())) {

			for (int x = riga - intorno; x <= riga + intorno; x++) {

				if (matriceCaratteri[x][colonna - intorno] == '#') {
					trovato = true;
					break;
				}

			}

		}

		// Controllo destro
		if ((riga - intorno >= 0 && colonna + intorno < getColonne()) && (riga + intorno < getRighe())) {

			for (int x = riga - intorno; x <= riga + intorno; x++) {

				if (matriceCaratteri[x][colonna + intorno] == '#') {
					trovato = true;
					break;
				}

			}

		}

		if (trovato)
			return calcolaIntorno(riga, colonna, intorno, trovato);
		else
			return calcolaIntorno(riga, colonna, intorno + 1, trovato);

	}

	// Per ogni carattere - calcola quanti intorni - ha e li salva nella matrice
	// della distanze
	public void solve() {

		for (int x = 0; x < getRighe(); x++) {

			for (int y = 0; y < getColonne(); y++) {

				if (matriceCaratteri[x][y] == '-') {

					distanze[x][y] = calcolaIntorno(x, y, 1, false);

				}

			}

		}

	}

	public void stampaPuntoPiuIsolato() {

		Integer max = Integer.MIN_VALUE, x = 0, y = 0;
		
		for(int j = 0; j < getRighe(); j++){
			for(int i = 0; i < getColonne(); i++){
				
				if(distanze[j][i] > max){
					
					max = distanze[j][i];
					x = j;
					y = i;
					
				}
				
			}
		}
		
		System.out.println("<" + x + "," + y + ">");

	}

	public void readInput() {

		righe = scanner.nextInt();
		colonne = scanner.nextInt();

		matriceCaratteri = new char[righe][colonne];
		distanze = new Integer[righe][colonne];

		// Inizializzo la matrice della distanze a 0
		for (int x = 0; x < righe; x++)
			for (int y = 0; y < colonne; y++)
				distanze[x][y] = 0;

		String riga = new String();
		Integer r = 0;

		// Prendo l'input e la salvo nella matrice dei caratteri
		while (scanner.hasNext()) {

			riga = scanner.next();

			for (int x = 0; x < riga.length(); x++) {

				matriceCaratteri[r][x] = riga.charAt(x);

			}

			r++;

		}

	}

	// Stampa la matrice di caratteri
	public void stampaCaratteri() {

		for (int x = 0; x < getRighe(); x++) {
			for (int y = 0; y < getColonne(); y++) {

				System.out.print(matriceCaratteri[x][y]);

			}

			System.out.println();
		}

	}

	// Stampa la matrice di distanze
	public void stampaDistanze() {

		for (int x = 0; x < getRighe(); x++) {
			for (int y = 0; y < getColonne(); y++) {

				System.out.print(distanze[x][y]);

			}

			System.out.println();
		}

	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public Integer getRighe() {
		return righe;
	}

	public void setRighe(Integer righe) {
		this.righe = righe;
	}

	public Integer getColonne() {
		return colonne;
	}

	public void setColonne(Integer colonne) {
		this.colonne = colonne;
	}

	public char[][] getMatriceCaratteri() {
		return matriceCaratteri;
	}

	public void setMatriceCaratteri(char[][] matriceCaratteri) {
		this.matriceCaratteri = matriceCaratteri;
	}

	public Integer[][] getDistanze() {
		return distanze;
	}

	public void setDistanze(Integer[][] distanze) {
		this.distanze = distanze;
	}

}
