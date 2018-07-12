package it.unical.mat.kernel;

import org.jgrapht.alg.cycle.CycleDetector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

/*							

	Dato un grafo orientato G(V, E), scrivere una funzione
	che restituisca true se esiste in G almeno un ciclo di lunghezza 3,
	false altrimenti. Per ciclo di lunghezza 3 si intende un ciclo
	costituito da 3 nodi: v1, v2, v3 collegati dagli archi: (v1, v2),(v2, v3),(v3, v1)


	@author=VioliHate

 */
public class Esercizio {

	private SimpleDirectedGraph<Integer, DefaultEdge> grafo = new SimpleDirectedGraph<Integer, DefaultEdge>(DefaultEdge.class);

	private CycleDetector<Integer, DefaultEdge> detector;



	public Esercizio() {

		takeInput();

		if(solve()) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}


	}



	private boolean solve() {

		detector = new CycleDetector<Integer, DefaultEdge>(grafo);

		if(!detector.detectCycles()) {
			return false;
		}
		for(Integer vertex: grafo.vertexSet()) {
			if(detector.findCyclesContainingVertex(vertex).size()>=3) {
				System.out.println(detector.findCyclesContainingVertex(vertex).toString());
				return true;
			}
		}
		return false;
	}



	private void takeInput() {
		// input con ciclo == a 3
		grafo.addVertex(1);
		grafo.addVertex(2);
		grafo.addVertex(3);
		grafo.addVertex(4);
		grafo.addVertex(5);

		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(1, 5);

		grafo.addEdge(2, 1);
		grafo.addEdge(3, 2);




	}

}
