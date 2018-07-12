package it.unical.mat.kernel;

import java.util.Scanner;

import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class Esame {
	
	private SimpleGraph<String, DefaultEdge> grafo=new SimpleGraph<String,DefaultEdge>(DefaultEdge.class);
	private GreedyColoring<String,DefaultEdge> coloring;
	private int c,m;
	
	
	public Esame() {
		readFirstLine();
		
		if(solve()) {
			System.out.print(true);
		}
		else {
			System.out.print(false);
		}
			
	}
	
	
	
	private boolean solve() {

		coloring=new GreedyColoring<>(grafo);
		
		if(coloring.getColoring().getNumberColors()<=3)
			return true;
		return false;
	}



	public void readFirstLine() {

		Scanner scan= new Scanner(System.in); 		//inizializzo lo scanner per l'input
		String input=scan.nextLine(); //prendo la nuova linea

		//il formato input della prima riga è c spazio m
		String [] inputSplitted=input.split(" "); //splitto per prendere i due numeri

		c=Integer.parseInt(inputSplitted[0]); // quantita di corsi
		m=Integer.parseInt(inputSplitted[1]); //quantita di coppie (corso corso)

		for(int i=0;i<c;i++) {

			input=scan.nextLine();

			if(!grafo.containsVertex(input)) {

				grafo.addVertex(input);

			}
			//se il corso non è nella nel grafo lo inserisco

		}

		String supporto1=new String();
		String supporto2=new String();

		for(int i=0;i<m;i++) {
			input=scan.nextLine();
			inputSplitted=input.split(" ");

			int index = inputSplitted[0].indexOf("(");

			supporto1=inputSplitted[0].substring(index+1, inputSplitted[0].length());
			supporto2=inputSplitted[1].substring(index, inputSplitted[1].length()-1);

			grafo.addEdge(supporto1, supporto2);


		}

		//stampaInput();

	}

}
