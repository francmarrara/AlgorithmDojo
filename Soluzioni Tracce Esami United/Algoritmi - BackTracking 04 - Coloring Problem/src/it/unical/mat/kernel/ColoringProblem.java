package it.unical.mat.kernel;

import java.util.Map;

import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class ColoringProblem {

	private SimpleGraph<Integer, DefaultEdge> grafo=new SimpleGraph<Integer,DefaultEdge>(DefaultEdge.class);
	GreedyColoring<Integer,DefaultEdge> coloring;
	private Integer nodi[];
	private int numeroColori;



	public ColoringProblem(int color) {
		numeroColori=color;

		readInput();

		if(solve()) {
			printSolution();
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
	}


	private void printSolution() {
		// TODO Auto-generated method stub
		for(Map.Entry<Integer,Integer>color: coloring.getColoring().getColors().entrySet()) {
			System.out.println(color.getKey()+" --->"+color.getValue());
		}
	}


	private boolean solve() {

		
		coloring=new GreedyColoring(grafo);
		//System.out.println(coloring.getColoring().getNumberColors());
		if(coloring.getColoring().getNumberColors()<=numeroColori) {
			return true;
		}
		return false;
	}

	

	private void readInput() {
		// TODO Auto-generated method stub
		nodi = new Integer[4];
		for(int i=0;i<4;i++) {

			nodi[i]=new Integer(i+1);
			grafo.addVertex(nodi[i]);
		}
		grafo.addEdge(nodi[0], nodi[1]);
		grafo.addEdge(nodi[0], nodi[2]);
		//grafo.addEdge(nodi[0], nodi[3]);

		grafo.addEdge(nodi[1], nodi[0]);
		grafo.addEdge(nodi[1], nodi[2]);
		grafo.addEdge(nodi[1], nodi[3]);

		grafo.addEdge(nodi[2], nodi[0]);
		grafo.addEdge(nodi[2], nodi[1]);
		grafo.addEdge(nodi[2], nodi[3]);

		//grafo.addEdge(nodi[3], nodi[0]);
		grafo.addEdge(nodi[3], nodi[1]);
		grafo.addEdge(nodi[3], nodi[2]);

		//

	}


}
