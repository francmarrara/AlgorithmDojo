package it.unical.mat.kernel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class Esercitazione {

	DefaultDirectedGraph<Integer,DefaultEdge> grafo = new DefaultDirectedGraph<Integer,DefaultEdge>(DefaultEdge.class);


	public Esercitazione() {

		//prova input1 o due
		
		input1();
		//input2();
		if(resolve()) {
			System.out.print(true);
		}
		else {
			System.out.println(false);
		}

	}


	private boolean resolve() {

		Set<DefaultEdge> archiVicini;
		SortedSet<Integer> nodiVicini=new TreeSet<Integer>(); // creo un set ordinato per ordinare i nodi vicini mentre li inserisco
		int verifica=0;
		for(Integer i: grafo.vertexSet()) {
			if(grafo.edgesOf(i).size()<2)
				return false;
			archiVicini=grafo.outgoingEdgesOf(i);
			for(DefaultEdge edge:archiVicini) {
				//System.out.println(grafo.getEdgeSource(edge)+"----->"+grafo.getEdgeTarget(edge));
				nodiVicini.add(grafo.getEdgeTarget(edge));
			}
			if(checkConsecutivi(nodiVicini)) {
				verifica++;
			}
			nodiVicini.clear();
		}
		//se tutti i nodi hanno nodi hanno almeno 2 vicini consecutivi true
		if(verifica==grafo.vertexSet().size()) {
			return true;
		}
		return false;
	}


	private boolean checkConsecutivi(SortedSet<Integer> nodiVicini) {
		// TODO Auto-generated method stub
		List<Integer> supporList=new ArrayList<Integer>(nodiVicini);
		//System.out.print(supporList);
		int counter=0;
		for(int i=0;i<supporList.size()-1;i++) {
			if(supporList.get(i)+1==supporList.get(i+1)) {
				counter++;
			}
		}
		//System.out.println(counter);
		//se il contatore è uguale alla lista meno 1 significa che tutti i nodivicini sono consecutivi
		if(counter==supporList.size()-1) {
			return true;
		}
		return false;
	}


	private void input1() {

		grafo.addVertex(1);
		grafo.addVertex(2);
		grafo.addVertex(3);
		grafo.addVertex(4);
		grafo.addVertex(5);

		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);

		grafo.addEdge(2, 4);
		grafo.addEdge(2, 3);

		grafo.addEdge(3, 1);
		grafo.addEdge(3, 2);

		grafo.addEdge(4, 1);
		grafo.addEdge(4, 2);
		grafo.addEdge(4, 3);

		grafo.addEdge(5, 1);
		grafo.addEdge(5, 2);
	}

	private void input2() {


		grafo.addVertex(1);
		grafo.addVertex(2);
		grafo.addVertex(3);
		grafo.addVertex(4);
		grafo.addVertex(5);

		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);

		grafo.addEdge(2, 4);
		grafo.addEdge(2, 3);

		grafo.addEdge(3, 1);
		grafo.addEdge(3, 2);

		grafo.addEdge(4, 1);
		grafo.addEdge(4, 3);

		grafo.addEdge(5, 2);

	}
}
