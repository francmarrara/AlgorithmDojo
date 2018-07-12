package it.unical.mat.kernel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.jgrapht.alg.cycle.HawickJamesSimpleCycles;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class Esame {


	private Scanner scanner;
	private int n;
	private int k;
	private DefaultDirectedGraph<Integer, DefaultEdge> directedGraph= new DefaultDirectedGraph <Integer,DefaultEdge> (DefaultEdge.class);
	private DefaultDirectedGraph<Integer, DefaultEdge> newGraph= new DefaultDirectedGraph <Integer,DefaultEdge> (DefaultEdge.class);
	private HawickJamesSimpleCycles<Integer, DefaultEdge> ciclo;
	
	private int archiRimossi = 0;
	
	public Esame() {
		readInput();
		solve();
	}

	private void solve() {
		// TODO Auto-generated method stub
		newGraph=directedGraph;
		ciclo = new HawickJamesSimpleCycles<>(newGraph);
		if(removeUntil(ciclo)) {
			System.out.println("SI");
		}
		else {
			System.out.println("NO");
		}
	}

	private boolean removeUntil(HawickJamesSimpleCycles<Integer, DefaultEdge> ciclo2) {
		// TODO Auto-generated method stub
		
		if(ciclo2.findSimpleCycles().isEmpty()) {
			return true;
		}
		if(ciclo2.findSimpleCycles().size()>k) {
			return false;
		}
		List<List<Integer>> listaCicli = new ArrayList<>();//lista dei cicli
		List<Integer>cicloSingolo = new ArrayList<>();//lista singolo ciclo
		
		listaCicli = ciclo2.findSimpleCycles();

			
		for(List<Integer> tac:listaCicli) {
			
			cicloSingolo = tac;
			
			//System.out.println("Ciclo singolo: " + cicloSingolo);
			
			//size-1 e size-2 perchè gli archi li salva al contrario = 2-3-4 sarebbe il percorso 4-3-2
			newGraph.removeAllEdges(cicloSingolo.get(cicloSingolo.size()-1), cicloSingolo.get(cicloSingolo.size()-2));
			archiRimossi++;
			
		}
		
		if(archiRimossi<=k) {
			return true;
		}
		
		return false;
	}

	public void readInput() {
		scanner=new Scanner(System.in);
		String input=scanner.nextLine();
		String [] splittedInput=input.split(" ");
		n=Integer.parseInt(splittedInput[0]);
		k=Integer.parseInt(splittedInput[1]);
		while(scanner.hasNext()) {
			input=scanner.nextLine();
			splittedInput=input.split(" ");
			//se i vertici sono presenti non li aggiungo
			if(!directedGraph.containsVertex(Integer.parseInt(splittedInput[0]))){
				directedGraph.addVertex(Integer.parseInt(splittedInput[0]));
			}
			if(!directedGraph.containsVertex(Integer.parseInt(splittedInput[1]))){
				directedGraph.addVertex(Integer.parseInt(splittedInput[1]));
			}
			directedGraph.addEdge(Integer.parseInt(splittedInput[0]), Integer.parseInt(splittedInput[1]));
			//creo un arco orientato da nodo a nodo
		}
		//stampaGrapho(directedGraph);
		scanner.close();

	}

	private void stampaGrapho(DefaultDirectedGraph<Integer, DefaultEdge> graph) {
		// TODO Auto-generated method stub
		for(DefaultEdge i: graph.edgeSet()) {

			System.out.print("("+graph.getEdgeSource(i)+")");
			System.out.print("------>");
			System.out.println("("+graph.getEdgeTarget(i)+")");

		}
	}
}
