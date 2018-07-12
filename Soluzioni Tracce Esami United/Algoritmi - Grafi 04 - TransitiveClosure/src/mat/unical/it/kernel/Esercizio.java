package mat.unical.it.kernel;

import org.jgrapht.alg.TransitiveClosure;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

public class Esercizio {

	private SimpleDirectedGraph<Integer, DefaultEdge> grafo = new SimpleDirectedGraph<Integer, DefaultEdge>(DefaultEdge.class);
	private final TransitiveClosure grafoTransitivo=TransitiveClosure.INSTANCE;
	
	
	
	public Esercizio() {
		input();
		System.out.println("------input------");
		print(grafo);
		solve();
		System.out.println("------risultato------");
		print(grafo);
	}
	
	private void print(SimpleDirectedGraph<Integer, DefaultEdge> grafo2) {
		// TODO Auto-generated method stub
		for(DefaultEdge edge:grafo.edgeSet()) {
			System.out.print("("+grafo.getEdgeSource(edge)+")----->");
			System.out.println("("+grafo.getEdgeTarget(edge)+")");
		}
		
	}

	private void solve() {
		// TODO Auto-generated method stub
		grafoTransitivo.closeSimpleDirectedGraph(grafo);
	}

	private void input() {
		
		
		grafo.addVertex(1);
		grafo.addVertex(2);
		grafo.addVertex(3);
		grafo.addVertex(4);
		grafo.addVertex(5);

		grafo.addEdge(1, 2);


		grafo.addEdge(2, 5);
		grafo.addEdge(2, 3);

		grafo.addEdge(3, 4);
;
		
		
	}
}
