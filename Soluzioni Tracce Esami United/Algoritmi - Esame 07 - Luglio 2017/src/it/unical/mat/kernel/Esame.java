package it.unical.mat.kernel;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;




public class Esame {

	private char [][] mappaStelllare;
	private int [][] anniLuce; //per ogni punto non scoperto in posizione x,y calcolo gli anni luce
	private int x,y;
	ArrayList<Point> angoli= new ArrayList<>(); 
	ArrayList<Point> croce= new ArrayList<>();


	public Esame() {

		readInput();
		SettingAdiancenze();
		solve();
		takeResult();

	}


	private void takeResult() {
		// TODO Auto-generated method stub
		int max=Integer.MIN_VALUE;
		Point trovato=new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(max<anniLuce[i][j]) {
					trovato.setLocation(i, j);
					max=anniLuce[i][j];
				}
				else {
					if(max==anniLuce[i][j]) {
						if(trovato.x>i) {
							trovato.setLocation(i, j);
						}
						else {
							if(trovato.x==i) {
								if(trovato.y>j) {
									trovato.setLocation(i, j);
								}
							}
						}
					}
				}
			}
		}
		System.out.println("<"+trovato.x+","+trovato.y+">");
	}


	private void solve() {

		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(mappaStelllare[i][j]=='-') {
					anniLuce[i][j]=iteraDistanza(i,j,1);
				}
			}
		}

		//stampaMappa();
		//stammpaAnni();

	}




	private int iteraDistanza(int i, int j, int distance) {
		// TODO Auto-generated method stub
		Point bordo1= new Point();
		Point bordo2= new Point();
		if((i==0 && j==0)||(i==x-1 && j==0)||(i==0 && j==y-1)||(i==x-1 && j==y-1)) {
			for(int k=0;k<angoli.size();k++) {
				bordo1.x=angoli.get(k).x*distance;
				bordo1.y=angoli.get(k).y*distance;
				for(int l=0;l<croce.size();l++) {
					if(l!=k) {
						bordo2.x=croce.get(l).x*distance;
						bordo2.y=croce.get(l).y*distance;
						//System.out.println(bordo1+"|"+bordo2+"|"+i+"|"+j);
						if(!checkFraBordi(bordo1,bordo2,i,j)) {
							return distance;
						}
					}
				}
			}
			distance++;
			return iteraDistanza(i, j, distance);
		}else {
			for(int k=0;k<angoli.size();k++) {
				bordo1.x=angoli.get(k).x*distance;
				bordo1.y=angoli.get(k).y*distance;
				for(int l=0;l<angoli.size();l++) {
					if(l!=k) {
						bordo2.x=angoli.get(l).x*distance;
						bordo2.y=angoli.get(l).y*distance;
						//System.out.println(bordo1+"|"+bordo2+"|"+i+"|"+j);
						if(!checkFraBordi(bordo1,bordo2,i,j)) {
							return distance;
						}
					}
				}
			}
			distance++;
			return iteraDistanza(i, j, distance);
		}
	}


	private boolean checkFraBordi(Point bordo1, Point bordo2,int c,int f) {
		// TODO Auto-generated method stub

		if((c+bordo1.x>=0 && f+bordo1.y>=0) && (c+bordo2.x>=0 && f+bordo2.y>=0) && (c+bordo1.x<x && f+bordo1.y<y) &&((c+bordo2.x<x && f+bordo2.y<y))) {
			if(bordo2.x+bordo1.x!=0 || bordo2.y+bordo1.y!=0) {
				if(mappaStelllare[c+bordo2.x][f+bordo2.y]=='#' || mappaStelllare[c+bordo1.x][f+bordo1.y]=='#') {
					return false;
				}
				for(int i=bordo1.x+c;i<bordo2.x+c;i++) {
					if(mappaStelllare[i][bordo1.y+f]=='#')
						return false;
				}
				for(int i=bordo1.y+f;i<bordo2.y+f;i++) {
					if(mappaStelllare[bordo1.x+c][i]=='#')
						return false;
				}
			}
			return true;
		}

		return true;
	}

	private void readInput() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String row=scanner.nextLine();
		String splittedRow[]=row.split(" ");

		x=Integer.parseInt(splittedRow[0]);
		y=Integer.parseInt(splittedRow[1]);

		anniLuce=new int[x][y];
		mappaStelllare=new char[x][y];

		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				anniLuce[i][j]=0;
			}
		}

		for(int i=0;i<x;i++) {
			row=scanner.nextLine();
			for(int j=0;j<y;j++) {
				mappaStelllare[i][j]=row.charAt(j);
			}
		}


		scanner.close();
	}

	private void stammpaAnni() {
		// TODO Auto-generated method stub
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(anniLuce[i][j]);
			}
			System.out.println();
		}
	}


	private void stampaMappa() {
		// TODO Auto-generated method stub
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(mappaStelllare[i][j]);
			}
			System.out.println();
		}

	}		






	private void SettingAdiancenze() {
		//coordinate degli angoli
		angoli.add(new Point(-1,-1));
		angoli.add(new Point(1,-1));
		angoli.add(new Point(1,1));
		angoli.add(new Point(-1,1));

		croce.add(new Point(-1, 0));
		croce.add(new Point(1, 0));
		croce.add(new Point(0, -1));
		croce.add(new Point(0, 1));
	}


}