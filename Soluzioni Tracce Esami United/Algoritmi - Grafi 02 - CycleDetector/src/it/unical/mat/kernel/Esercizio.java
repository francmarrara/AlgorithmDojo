package it.unical.mat.kernel;

import org.jgrapht.alg.cycle.CycleDetector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;


/*
	Dato un grafo orientato G(V, E), scrivere una funzione che restituisca true se G `e ciclico, false
	altrimenti. Si ricorda che un grafo `e ciclico se contiene almeno un ciclo di lunghezza maggiore di 1.
	Suggerimento: se tra una qualsiasi coppia di nodi i e j in G esiste sia un cammino da i a j che un
	cammino da j a i allora G `e ciclico. Per determinare se esiste un cammino da i a j si pu`o utilizzare
	un algoritmo di visita che parte da i e poi controllare se j `e stato visitato.


@author=Violihate;
 */



public class Esercizio {

	private SimpleDirectedGraph<Integer,DefaultEdge> grafo= new SimpleDirectedGraph<Integer,DefaultEdge> (DefaultEdge.class);




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

		CycleDetector<Integer, DefaultEdge> detector=new CycleDetector<Integer, DefaultEdge>(grafo);

		return detector.detectCycles();
	}


	private void takeInput() {
		// Nodi
		grafo.addVertex(1);
		grafo.addVertex(2);
		grafo.addVertex(3);
		grafo.addVertex(4);
		grafo.addVertex(5);


		// archi

		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(1, 5);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);
		grafo.addEdge(4, 1);
		grafo.addEdge(5, 2);
	}

}
