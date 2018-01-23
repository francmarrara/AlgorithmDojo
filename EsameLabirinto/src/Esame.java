import java.util.ArrayList;
import java.util.Scanner;

public class Esame {

	private Character[][] labirinto;
	private int n, m;

	private Character[][] labirintoTest;

	Scanner s = new Scanner(System.in);

	private ArrayList<PuntoMemorizzato> punti;

	public Esame() {
		setPunti(new ArrayList<PuntoMemorizzato>());
	};

	public void readInput() {
		String numeri = s.nextLine();
		String[] sub = numeri.split(" ");
		n = Integer.parseInt(sub[0]);
		m = Integer.parseInt(sub[1]);

		labirinto = new Character[n][m];
		labirintoTest = new Character[n][m];

		int indice = 0;
		while (indice < n) {

			char[] prova = s.nextLine().toCharArray();

			for (int j = 0; j < m; j++) {
				labirinto[indice][j] = prova[j];

			}

			indice += 1;
		}

	}

	public boolean isPuntoIntersezione(int x, int y) {

		Integer contaPuntiVicini = 0;
		// verfico che sia un punto
		if (labirinto[x][y].equals('.')) {
			// controllo le intersezioni

			// sopra

			if (x - 1 >= 0) {
				if (labirinto[x - 1][y].equals('.')) {
					contaPuntiVicini++;
				}

			}

			// sinistra
			if (y - 1 >= 0) {
				if (labirinto[x][y - 1].equals('.')) {
					contaPuntiVicini++;
				}

			}

			// sotto
			if (x + 1 < n) {
				if (labirinto[x + 1][y].equals('.')) {
					contaPuntiVicini++;
				}

			}

			// destra
			if (y + 1 < m) {
				if (labirinto[x][y + 1].equals('.')) {
					contaPuntiVicini++;
				}

			}

			if (contaPuntiVicini >= 3) {
				return true;
			}

		}

		return false;
	}

	public void StampaPuntiIntersezione() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (isPuntoIntersezione(i, j)) {
					punti.add(new PuntoMemorizzato(i, j));
				}
			}
		}
		System.out.println(punti.size());

	}

	public boolean solve(int x, int y, int x1, int y1) {
		copiaLabirinto();
		for (PuntoMemorizzato p : punti) {
			if (p.getX() == x && p.getY() == y) {
				for (PuntoMemorizzato p1 : p.getPuntiRaggiungibili()) {
					labirintoTest[p1.getX()][p1.getY()] = '#';

					// blocco la via agli altri punti
				}
			}
		}

		labirintoTest[x1][y1] = 'X';

		if (step(x, y)) {
			System.out.println(x + "" + y);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(labirintoTest[i][j]);

				}
				System.out.println();
			}

			return true;
		}

		return false;

	}

	// Backtracking method
	public boolean step(int x, int y) {

		if (x - 1 < 0)
			return false;

		if (y - 1 < 0)
			return false;

		if (x + 1 > n)
			return false;
		if (y + 1 > m)
			return false;

		if (isPuntoIntersezione(x, y + 1) && !nonContienepunti(x, y)) {
			return false;
		}

		if (isPuntoIntersezione(x - 1, y) && !nonContienepunti(x, y)) {
			return false;
		}

		if (isPuntoIntersezione(x, y - 1) && !nonContienepunti(x, y)) {
			return false;
		}

		if (isPuntoIntersezione(x + 1, y) && !nonContienepunti(x, y)) {
			return false;
		}

		/** Accept case - Trovo il Punto **/
		if (labirintoTest[x][y] == 'X') {
			return true;
		}

		/** Reject case - Colpisco un muro o ripasso sul mio cammino **/
		if (labirintoTest[x][y] == '#' || labirintoTest[x][y] == '*') {
			return false;
		}

		/** Backtracking Step **/

		// Seleziono la casella come via di passaggio
		labirintoTest[x][y] = '*';
		boolean result;

		// Provo ad andare a destra
		result = step(x, y + 1);
		if (result) {
			return true;
		}

		// Provo ad andare sopra
		result = step(x - 1, y);
		if (result) {
			return true;
		}

		// Provo ad andare a sx
		result = step(x, y - 1);
		if (result) {
			return true;
		}

		// Provo ad andare giù
		result = step(x + 1, y);
		if (result) {
			return true;
		}

		// Se non va bene la rendo di nuovo bianca
		labirintoTest[x][y] = ' ';

		// Torno Indietro
		return false;
	}

	public void assegnaPuntiRaggiungibili() {
		for (PuntoMemorizzato p : punti) {
			for (PuntoMemorizzato p1 : punti) {
				if (!p.equals(p1)) {
					if (solve(p.getX(), p.getY(), p1.getX(), p1.getY())) {
						p.getPuntiRaggiungibili().add(p1);
						p1.getPuntiRaggiungibili().add(p);

					}
				}
			}
		}

		for (PuntoMemorizzato p : punti) {
			System.out.print(p);
			System.out.print(" -> ");
			System.out.println(p.getPuntiRaggiungibili());
		}

	}

	public void copiaLabirinto() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				labirintoTest[i][j] = labirinto[i][j];
				if (labirintoTest[i][j].equals('.'))
					labirintoTest[i][j] = ' ';

			}
		}
	}

	public ArrayList<PuntoMemorizzato> getPunti() {
		return punti;
	}

	public void setPunti(ArrayList<PuntoMemorizzato> punti) {
		this.punti = punti;
	}

	public boolean nonContienepunti(int x, int y) {
		for (PuntoMemorizzato p : punti) {
			if (p.getX() == x && p.getY() == y) {
				if (p.getPuntiRaggiungibili().size() == 0)
					return true;
			}
		}

		return false;
	}

}
