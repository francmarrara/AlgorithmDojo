import java.util.Scanner;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		Integer righe = s.nextInt();
		Integer colonne = s.nextInt();
		String in;
		Nodo[][] matrice = new Nodo[righe][colonne];

		// inizializzo la matrice di nodi
		for (int i = 0; i < righe; i++) {
			in = s.next();

			for (int j = 0; j < colonne; j++) {
				matrice[i][j] = new Nodo(in.charAt(j), i, j);
			}

		}

		DefaultDirectedWeightedGraph<Nodo, DefaultWeightedEdge> grafo = new DefaultDirectedWeightedGraph<>(
				DefaultWeightedEdge.class);

		
		for (int i = 0; i < righe; i++)
			for (int j = 0; j < colonne; j++) {
				grafo.addVertex(matrice[i][j]);
			}

		for (int i = 0; i < righe; i++)
			for (int j = 0; j < colonne; j++) {

				if (i - 1 >= 0 && j - 1 >= 0) {
					// alto a sx
					grafo.addEdge(matrice[i][j], matrice[i - 1][j - 1]);
					grafo.addEdge(matrice[i - 1][j - 1], matrice[i][j]);

				}

				if (i - 1 >= 0) {
					// alto sopra
					grafo.addEdge(matrice[i][j], matrice[i - 1][j]);
					grafo.addEdge(matrice[i - 1][j], matrice[i][j]);

				}

				if (i - 1 >= 0 && j + 1 < colonne) {
					// alto a dx
					grafo.addEdge(matrice[i][j], matrice[i - 1][j + 1]);
					grafo.addEdge(matrice[i - 1][j + 1], matrice[i][j]);

				}

				if (j - 1 >= 0) {
					// sx
					grafo.addEdge(matrice[i][j], matrice[i][j - 1]);
					grafo.addEdge(matrice[i][j - 1], matrice[i][j]);

				}

				if (j + 1 < colonne) {
					// dx
					grafo.addEdge(matrice[i][j], matrice[i][j + 1]);
					grafo.addEdge(matrice[i][j + 1], matrice[i][j]);

				}

				if (i + 1 < righe && j - 1 >= 0) {
					// basso a sx
					grafo.addEdge(matrice[i][j], matrice[i + 1][j - 1]);
					grafo.addEdge(matrice[i + 1][j - 1], matrice[i][j]);

				}

				if (i + 1 < righe && j + 1 < colonne) {
					// basso a dx
					grafo.addEdge(matrice[i][j], matrice[i + 1][j + 1]);
					grafo.addEdge(matrice[i + 1][j + 1], matrice[i][j]);

				}

				if (i + 1 < righe) {
					// basso
					grafo.addEdge(matrice[i][j], matrice[i + 1][j]);
					grafo.addEdge(matrice[i + 1][j], matrice[i][j]);

				}

			}
		System.out.println(Graphs.predecessorListOf(grafo,matrice[2][0]).toString());
		System.out.println(Graphs.successorListOf(grafo, matrice[2][0]).toString());
		
	

	
	}
	
		

}