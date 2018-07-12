package it.unical.mat.kernel;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.util.NeighborCache;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Esercizio {

	private SimpleWeightedGraph<Integer,DefaultWeightedEdge> livello=new SimpleWeightedGraph<Integer,DefaultWeightedEdge>(DefaultWeightedEdge.class);



	public Esercizio() {

		takeLevel();

		solve();
	}



	private void solve() {
		// TODO Auto-generated method stub
		DijkstraShortestPath<Integer,DefaultWeightedEdge> soluzione=new DijkstraShortestPath<>(livello);
		System.out.println(soluzione.getPath(1, 9));
		
	}







	private void takeLevel() {
		// TODO Auto-generated method stub

		//creao i nodi importanti
		livello.addVertex(1); // inizio
		livello.addVertex(9); // fine
		livello.addVertex(3); // nemico
		livello.addVertex(13);//nemico
		//nodi insignificanti
		livello.addVertex(2);
		livello.addVertex(4);
		livello.addVertex(5);
		livello.addVertex(6);
		livello.addVertex(7);
		livello.addVertex(8);
		livello.addVertex(10);
		livello.addVertex(11);
		livello.addVertex(12);

		//creo i passaggi

		livello.addEdge(3, 2);
		livello.addEdge(3, 4);
		livello.addEdge(3, 8);
		livello.addEdge(13, 12);
		livello.addEdge(13, 10);
		
		livello.addEdge(1, 2);
		livello.addEdge(1, 4);
		livello.addEdge(1, 5);

		livello.addEdge(9, 10);
		livello.addEdge(9, 7);
		livello.addEdge(9, 8);

		livello.addEdge(2, 4);

		livello.addEdge(4, 6);
		livello.addEdge(4, 7);

		livello.addEdge(5, 6);

		livello.addEdge(6, 11);
		livello.addEdge(6, 12);

		livello.addEdge(7, 11);
		livello.addEdge(7, 8);
		livello.addEdge(7, 9);

		livello.addEdge(8, 9);

		livello.addEdge(10, 11);

		livello.addEdge(11, 10);
		livello.addEdge(11, 12);

		for(DefaultWeightedEdge edge:livello.edgeSet()) {
			livello.setEdgeWeight(edge, 1.0);
		}
		NeighborCache<Integer,DefaultWeightedEdge> vicini= new NeighborCache<Integer,DefaultWeightedEdge>(livello);
		
		for(Integer vertex:livello.vertexSet()) {
			
			for(Integer sorvegliati:vicini.neighborListOf(vertex)) {
				
				if(vertex==3 || vertex ==13) {
					for(DefaultWeightedEdge edge:livello.edgeSet()) {
						if(livello.getEdgeSource(edge)==sorvegliati ||livello.getEdgeTarget(edge)==sorvegliati) {
							livello.setEdgeWeight(edge, 99.0);	
						}
						System.out.println(edge+"    "+livello.getEdgeWeight(edge));
					}
				}
					
			}
		}
	}

}
