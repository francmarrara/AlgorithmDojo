package it.unical.mat.kernel;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Esame {

	private int n,m;
	private int mappa[][];
	private ArrayList<Point> adiacenze=new ArrayList<>();
	private int max=Integer.MIN_VALUE;
	private ArrayList<Point> listaPicchi=new ArrayList<>();
	private LinkedHashMap<Point,Integer> valori= new LinkedHashMap<Point,Integer>();



	public Esame() {
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
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int conta=0;

		for(Point a:listaPicchi) {
			for(Point b:listaPicchi) {
				//				System.out.print("<"+a.x+","+a.y+">");		
				//				System.out.println("<"+b.x+","+b.y+">");		
				if(mappa[a.x][a.y]!=mappa[b.x][b.y]) {
					if(checkPunti(a.x,a.y,b.x,b.y))
						if(mappa[a.x][a.y]>mappa[b.x][b.y]) 
							conta++;
				}
			}
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
		Point trovato=new Point();
		// TODO Auto-generated method stub
		for(Point p:valori.keySet()) {
			//			System.out.println(p.x+","+p.y+":"+valori.get(p));
			if(max<valori.get(p)) {

				max=valori.get(p);
				trovato=p;
			}


		}
		System.out.println("<"+trovato.x+","+trovato.y+">");		

	}






	private boolean checkPunti(int x, int y, int x2, int y2) {
		// TODO Auto-generated method stub
		if(x==x2) // stessa riga
			return true;
		if(y==y2)// stessa colonna
			return true;
		if(x-y==x2-y2) //diagonale1
			return true;
		if(x+y==x2+y2) //diagonale2
			return true;
		return false;
	}

	private void iteraPoint(int x, int y) {
		// TODO Auto-generated method stub
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

		if((x+vicino.x>=0 && y+vicino.y>=0)&&(x+vicino.x<n && y+vicino.y<m))
			return true;
		return false;
	}



	private void readInput() {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String row=scan.nextLine();

		String [] splittedRow=row.split(" ");
		n=Integer.parseInt(splittedRow[0]);
		m=Integer.parseInt(splittedRow[1]);
		mappa=new int [n][m];

		for(int i=0;i<n;i++) {
			row=scan.nextLine();
			for(int j=0;j<m;j++) {
				splittedRow=row.split(" ");
				mappa[i][j]=Integer.parseInt(splittedRow[j]);
			}
		}

		scan.close();
	}

	private void stampaInput() {
		// TODO Auto-generated method stub
		System.out.print(n+" "+m);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(mappa[i][j]+" ");
			}
			System.out.println();
		}
	}
	private void settingAdiacenze() {
		// TODO Auto-generated method stub
		//adianceze per controllare intorno picco

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
