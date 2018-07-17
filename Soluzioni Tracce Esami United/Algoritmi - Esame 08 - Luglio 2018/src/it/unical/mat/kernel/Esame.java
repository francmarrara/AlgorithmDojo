package it.unical.mat.kernel;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Esame {

	private int n,m;//grandezza matrice
	private int mappa[][];//matrice di punti
	private ArrayList<Point> adiacenze=new ArrayList<>();//arraylist che contiene i punti per il calcolo dell'intorno
	private int max=Integer.MIN_VALUE; // il valore massimo di coperture
	private ArrayList<Point> listaPicchi=new ArrayList<>(); // lista dei picchi trovati
	private LinkedHashMap<Point,Integer> valori= new LinkedHashMap<Point,Integer>(); //hashmap dove il punto è la chiave e il valore sono le coperture picchi



	public Esame() {
		//costruttore come inizializzo trovo direttamente la soluzione
		readInput();
		//stampaInput();
		settingAdiacenze();
		solve();
	}



	private void solve() {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				iteraPoint(i,j);
			}
		}

		solution();
	}

	private void solution() {
		//funzione dove calcolo la soluzione seguendo le regole della traccia
		//prendo un picco lo controllo con gli altri picchi e controllo se esso è sulla stessa riga colonna o diagonale
		//se lo è controllo se sia maggiore e incremento il contatore
		int conta=0;
		for(Point a:listaPicchi) {
			//System.out.print("<"+a.x+","+a.y+">");		
			conta=checkPunti(a.x,a.y);
			//			System.out.println(conta);
			if(!valori.containsKey(a)) {
				if(conta!=0)
					valori.put(a, conta);
			}
			else {
				valori.replace(a, conta);
			}
			conta=0;
		}
		stampaSoluzione();
	}

	private void stampaSoluzione() {
		//funzione dove trovo il punto con più copertura di picchi
		//la chiave è il punto il valore sono le coperture
		Point trovato=new Point();
		// TODO Auto-generated method stub
		for(Point p:valori.keySet()) {
			System.out.println(p.x+","+p.y+":"+valori.get(p));
			if(max<valori.get(p)) {
				max=valori.get(p);
				trovato=p;
			}
		}
		System.out.println("<"+trovato.x+","+trovato.y+">");		
	}

	private int checkPunti(int x, int y) {
		int valore=0;
		Set<Point> vicini=new LinkedHashSet<Point>();//trovo i picchi vicini sulla riga colonna e le diagonali
		//basso
		for(int i=x+1;i<n;i++) {
			if(listaPicchi.contains(new Point(i,y))){
				vicini.add(new Point(i,y));
				break;
			}
		}
		//alto
		for(int i=x-1;i>=0;i--) {
			if(listaPicchi.contains(new Point(i,y))){
				vicini.add(new Point(i,y));
				break;

			}
		}
		//destra
		for(int i=y+1;i<n;i++) {
			if(listaPicchi.contains(new Point(x,i))){
				vicini.add(new Point(x,i));
				break;
			}
		}
		//sinistra
		for(int i=y-1;i>=0;i--) {
			if(listaPicchi.contains(new Point(x,i))){
				vicini.add(new Point(x,i));
				break;
			}
		}

		//diagonale in basso a destra
		for(int i=x+1,j=y+1;i<n && j<m;i++,j++) {
			if(listaPicchi.contains(new Point(i,j))){
				vicini.add(new Point(i,j));
				break;
			}
		}
		//diagonale in alto a sinistra
		for(int i=x-1,j=y-1;i>=0 && j>=0;i--,j--) {
			if(listaPicchi.contains(new Point(i,j))){
				vicini.add(new Point(i,j));
				break;
			}
		}

		//diagonale basso a sinistra
		for(int i=x-1,j=y+1;i>=0 && j<m;i--,j++) {
			if(listaPicchi.contains(new Point(i,j))){
				vicini.add(new Point(i,j));
				break;
			}
		}
		//diagonale in alto a destra
		for(int i=x+1,j=y-1;i<n && j>=0;i++,j--) {
			if(listaPicchi.contains(new Point(i,j))){
				vicini.add(new Point(i,j));
				break;
			}
		}
		
		for(Point a:vicini) {
//			System.out.println("<"+x+","+y+">");
//			System.out.println("<"+a.x+","+a.y+">");
			if(mappa[x][y]>mappa[a.x][a.y])
				valore++;
//			System.out.println(valore);
		}
		return valore;
	}

	private void iteraPoint(int x, int y) {
		//funzione che controlla se il punto è un picco lo inserisco in una arraylist di picchi
		int valore=0;
		for(Point vicino:adiacenze) {
			if(controlla(x,y,vicino)) {
				valore+=mappa[x+vicino.x][y+vicino.y];
			}
		}
		if(valore<mappa[x][y]) {
			listaPicchi.add(new Point(x, y));			
		}

	}

	private boolean controlla(int x, int y, Point vicino) {
		//funzione per controllare che si sfori dalla matrice
		if((x+vicino.x>=0 && y+vicino.y>=0)&&(x+vicino.x<n && y+vicino.y<m))
			return true;
		return false;
	}

	private void readInput() {
		//funzione prelevare input
		Scanner scan=new Scanner(System.in); // scanner per poter prelevare l'input
		String row=scan.nextLine(); // prima riga dell'input
		String [] splittedRow=row.split(" "); //splitto la riga siccome è del formato n spazio m
		n=Integer.parseInt(splittedRow[0]);
		m=Integer.parseInt(splittedRow[1]);
		mappa=new int [n][m]; // inizializzo matrice con le grandezze 
		for(int i=0;i<n;i++) {
			row=scan.nextLine(); //prendo la riga
			for(int j=0;j<m;j++) {
				splittedRow=row.split(" "); //splitto per spazio per prendere i numeri senza spazi
				mappa[i][j]=Integer.parseInt(splittedRow[j]);//prendo il numero j della riga
			}
		}
		scan.close(); //chiudo lo scanner
	}

	private void stampaInput() {
		// funzione per controllare se l'input lo prendevo bene
		System.out.print(n+" "+m);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(mappa[i][j]+" ");
			}
			System.out.println();
		}
	}

	private void settingAdiacenze() {

		// funzione per inizializzare le adianceze per controllare intorno picco
		// l'intorno è stato calcolato guardando la traccia esame
		adiacenze.add(new Point(0,-2)); //1
		adiacenze.add(new Point(0,-1)); //2
		adiacenze.add(new Point(1,-1)); //3
		adiacenze.add(new Point(-1,-1)); //4
		adiacenze.add(new Point(-2,0));//5
		adiacenze.add(new Point(-1,0));//6
		adiacenze.add(new Point(1,0));//7
		adiacenze.add(new Point(2,0));//8
		adiacenze.add(new Point(-1,1));//9
		adiacenze.add(new Point(0,1));//10
		adiacenze.add(new Point(1,1));//11
		adiacenze.add(new Point(0,2));//12

	}

}
