package it.unical.mat.esame;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

import org.jgrapht.alg.isomorphism.VF2GraphIsomorphismInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;

public class Esame {
	
	private SimpleGraph<Integer,DefaultEdge> grafo1= new SimpleGraph<>(DefaultEdge.class);
	private SimpleGraph<Integer,DefaultEdge> grafo2= new SimpleGraph<>(DefaultEdge.class);
	private int n1,n2,e1,e2;
	private ArrayList<Point> archiGrafo1= new ArrayList<>();
	private ArrayList<Point> archiGrafo2= new ArrayList<>();
	public Esame() {
		readInput();
		solve();
	}


	private void solve() {
		// TODO Auto-generated method stub
		VF2GraphIsomorphismInspector<Integer, DefaultEdge> verifica= new VF2GraphIsomorphismInspector<>(grafo1, grafo2);
		if(verifica.isomorphismExists())
			System.out.println("SI");
		else
			System.out.println("NO");
	}


	private void readInput() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String line= scanner.nextLine();
		String splittedLine[]=line.split(" ");
		
		n1=Integer.parseInt(splittedLine[0]); //numero nodi primo grafo
		n2=Integer.parseInt(splittedLine[1]);// numero nodi secondo grafo
		e1=Integer.parseInt(splittedLine[2]); // numero di archi del primo grafo
		e2=Integer.parseInt(splittedLine[3]); // numero di archi del secondo grafo
		
		//costruisco il primo grafo
		for(int i=0;i<e1;i++) {
			line= scanner.nextLine();
			splittedLine=line.split(" ");
			if(!grafo1.containsVertex(Integer.parseInt(splittedLine[0])))
				grafo1.addVertex(Integer.parseInt(splittedLine[0]));
			if(!grafo1.containsVertex(Integer.parseInt(splittedLine[2])))
				grafo1.addVertex(Integer.parseInt(splittedLine[2]));
//			grafo1.addEdge(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[0]));
			archiGrafo1.add(new Point(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[2])));
		}
		// aggiungo gli archi al grafo
		for(int i=0;i<e1;i++) {
			grafo1.addEdge(archiGrafo1.get(i).x, archiGrafo1.get(i).y);
			grafo1.addEdge(archiGrafo1.get(i).y, archiGrafo1.get(i).x);
		}
		
		//costruisco il secondo grafo
		for(int i=0;i<e2;i++) {
			line= scanner.nextLine();
			splittedLine=line.split(" ");
			if(!grafo2.containsVertex(Integer.parseInt(splittedLine[0])))
				grafo2.addVertex(Integer.parseInt(splittedLine[0]));
			if(!grafo2.containsVertex(Integer.parseInt(splittedLine[2])))
				grafo2.addVertex(Integer.parseInt(splittedLine[2]));
//			grafo1.addEdge(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[0]));
			archiGrafo2.add(new Point(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[2])));
		}
		// aggiungo gli archi al grafo
		for(int i=0;i<e2;i++) {
			grafo2.addEdge(archiGrafo2.get(i).x, archiGrafo2.get(i).y);
			grafo2.addEdge(archiGrafo2.get(i).y, archiGrafo2.get(i).x);
		}
		scanner.close();
		//prova se costruisco bene il grafo
		//print(grafo1);
		//print(grafo2);
	}
	
	/**stampo input per verificare sia giusto**/
	private void print(SimpleGraph<Integer, DefaultEdge> grafo) {
		// TODO Auto-generated method stub
		for(DefaultEdge edge:grafo.edgeSet()) {
			System.out.print("("+grafo.getEdgeSource(edge)+")<----->");
			System.out.println("("+grafo.getEdgeTarget(edge)+")");
		}
		
	}

}
