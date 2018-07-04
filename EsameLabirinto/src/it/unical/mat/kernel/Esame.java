package it.unical.mat.kernel;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class Esame {


	private ArrayList<Point> adiacenze = new ArrayList<Point>();
	//possibili movimenti nel labirinto spostamenti diagonali non accettati
	private int intersezioni=0;
	private int n;
	private int m;
	private Scanner s;
	private List<Posizione> puntiIntersezione=new LinkedList<>();
	private Graph<Posizione,DefaultEdge> graph= new SimpleGraph<>(DefaultEdge.class);
    private DijkstraShortestPath<Posizione,DefaultEdge> prova;

	public Esame() {
		readInput();
		solve();
	}


	private void solve() {
		// TODO Auto-generated method stub

		searchPuntiIntersezione();
		//printIntersezione(); fino qui funziona benissimo
		if(takeIntersezioni()==null) {
			System.out.println("nessuna intersezione");
		}
		else {
			puntiIntersezione=takeIntersezioni();
			System.out.println(intersezioni);
			for(int i=0;i<puntiIntersezione.size();i++) {
				System.out.print("("+(int)puntiIntersezione.get(i).getCoordinate().getX()+","+(int)puntiIntersezione.get(i).getCoordinate().getY()+")");
				System.out.print(" -> {");
				for(int j=0;j<puntiIntersezione.size();j++) {
					if(i!=j)
					getDistance(puntiIntersezione.get(i), puntiIntersezione.get(j));
				}
				System.out.println("}");
			}
		}
	}

	private void getDistance(Posizione start, Posizione target) {
		
			prova=new DijkstraShortestPath<Posizione,DefaultEdge>(graph);
		   if(prova.getPath(start, target)!=null) {
			   List<Posizione> shortestPath = prova.getPath(start, target).getVertexList();
			   	if(checkList(shortestPath)) {
			   		System.out.print("("+(int)shortestPath.get(shortestPath.size()-1).getCoordinate().getX()+","+(int)shortestPath.get(shortestPath.size()-1).getCoordinate().getY()+") ");
			   }
		   }
		   else {
			   System.out.print("");
		   }
		    
		}





		private boolean checkList(List<Posizione> shortestPath) {
		// TODO Auto-generated method stub
			int counter=0;
			for(Posizione i: shortestPath) {
				if(i.isPuntoIntersezione())
					counter++;
			}
			if(counter==2)
				return true;
		return false;
	}


		private void stampaList(List<Posizione> shortestPath) {
		// TODO Auto-generated method stub
		for(Posizione i: shortestPath) {
			System.out.println(i.getCoordinate().getX()+" "+i.getCoordinate().getY());
		}
	}


		private List<Posizione> takeIntersezioni() {
			
			List<Posizione> support = new LinkedList<Posizione>();
			
			for(Posizione i : graph.vertexSet()) {
				if(i.isPuntoIntersezione())
					support.add(i);
			}
			return support;
		}


		private void printIntersezione() {
			// TODO Auto-generated method stub
			System.out.println(intersezioni);
			for(Posizione i : graph.vertexSet()) {
				if(i.isPuntoIntersezione())
					System.out.println("("+(int)i.getCoordinate().getX()+", "+(int)i.getCoordinate().getY()+")");
			}
		}


		private void searchPuntiIntersezione() {
			// TODO Auto-generated method stub
			int c=0;
			Posizione controllo;
			for(Posizione i: graph.vertexSet()) {

				for(DefaultEdge e: graph.edgeSet()) {

					if(checkPosition(i, graph.getEdgeTarget(e))||checkPosition(i, graph.getEdgeSource(e))) {
						c++;
					}
				}
				if(c>=3) {
					i.setPuntoIntersezione(true);
					intersezioni++;
				}
				c=0;
			}

		}


		public void readInput() {

			s=new Scanner(System.in); //configuro scanner
			String input=s.nextLine();// prendo prima linea

			String[] inputSplitted= input.split(" ");// splitto per spazio la prima riga è in formato n spazio m
			n=Integer.parseInt(inputSplitted[0]);
			m=Integer.parseInt(inputSplitted[1]);


			for(int i=0;i<n;i++) {
				input=s.nextLine();
				inputSplitted= input.split("");

				for(int j=0;j<m;j++) {
					if(inputSplitted[j].charAt(0)=='.') {
						Posizione inputPosition=new Posizione(inputSplitted[j].charAt(0));
						inputPosition.setCoordinate(new Point(i,j));
						graph.addVertex(inputPosition);
					}
				}
			}

			creaArchi();
			//stampaGraph();
			//System.out.println(n+" "+m);
		}


		private void stampaGraph() {
			// TODO Auto-generated method stub
			//vertexset ritorna tutti i vertici presenti nel graph!
			System.out.println("lista vertici /vertice --> coordinate/");
			for(Posizione i : graph.vertexSet()) {
				System.out.println(i.getCasella()+" -->("+(int)i.getCoordinate().getX()+","+(int)i.getCoordinate().getY()+")");
			}

			System.out.println("lista archi /vertice ---> vertice/");
			for(DefaultEdge i : graph.edgeSet()) {
				System.out.println(graph.getEdgeSource(i).getCasella()+"("+graph.getEdgeSource(i).getCoordinate().getX()+","+
						graph.getEdgeSource(i).getCoordinate().getY()+")"+"-->"+
						graph.getEdgeTarget(i).getCasella()+"("+graph.getEdgeTarget(i).getCoordinate().getX()+","+
						graph.getEdgeTarget(i).getCoordinate().getY()+")");
			}
		}


		public void SettingAdiancenze() {

			adiacenze.add(new Point(-1,0));
			adiacenze.add(new Point(0,1));
			adiacenze.add(new Point(1,0));
			adiacenze.add(new Point(0,-1));
		}

		public Point getAdianceza(int i) {

			return adiacenze.get(i);
		}

		public void creaArchi() {
			SettingAdiancenze();

			for(Posizione p : graph.vertexSet()) {
				for(Posizione z: graph.vertexSet()) {

					if(!checkPosition(p,z)) {
						for(int i=0;i<adiacenze.size();i++) {
							Point control=new Point();
							control.setLocation(p.getCoordinate().getX()+adiacenze.get(i).getX(),p.getCoordinate().getY()+adiacenze.get(i).getY());
							if(control.getX()==z.getCoordinate().getX() && control.getY()==z.getCoordinate().getY()) {
								graph.addEdge(p, z);
							}
						}

					}
				}

			}
		}


		private boolean checkPosition(Posizione p, Posizione z) {
			// TODO Auto-generated method stub

			if(p.getCoordinate()==z.getCoordinate() && p.getCasella()==z.getCasella() && p.isPuntoIntersezione()==z.isPuntoIntersezione())
				return true;
			return false;
		}
	}

