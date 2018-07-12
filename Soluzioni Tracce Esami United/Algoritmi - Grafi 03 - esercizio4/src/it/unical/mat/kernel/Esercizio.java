package it.unical.mat.kernel;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;






/*
	Definire una funzione che, dato in input un grafo orientato G(V, E), restituisca true se esiste almeno
	un nodo che sia adiacente a tutti gli altri nodi nel grafo, ovvero
	∃x ∈ V : ∀y ∈ V, y 6= x,(y, x) ∈ E,
	altrimenti restituisca false.

@author=VioliHate;
*/

public class Esercizio {
	
	private SimpleDirectedGraph<Integer, DefaultEdge> grafo = new SimpleDirectedGraph<Integer,DefaultEdge>(DefaultEdge.class);
	
	
	
	
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

		int counter=0;
		int nodi=grafo.vertexSet().size()-1;
		
		for(Integer vertex: grafo.vertexSet()) {
			
			for(DefaultEdge edge:grafo.edgeSet()) {
				
				if(grafo.getEdgeTarget(edge)==vertex)
					counter++;
			}
			if(counter==nodi) {
				return true;
			}
			counter=0;
		}
		
		
		
		return false;
	}




	private void takeInput() {
		//nodi
		grafo.addVertex(1);
		grafo.addVertex(2);
		grafo.addVertex(3);
		grafo.addVertex(4);
		grafo.addVertex(5);
		
		//archi
		
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(2, 3);
		grafo.addEdge(2, 5);
		grafo.addEdge(3, 4);
		grafo.addEdge(4, 3);
		grafo.addEdge(4, 5);
		grafo.addEdge(5, 3);
		
	}

}
