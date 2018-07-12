package mat.unical.it.kernel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Esame {

	int n,m,p; //n e m dimensione griglia p il numero di persone

	private static int[][] adiacenze = new int[][]{{-1,-1}, {-1,0}, {-1,1},  {0,1}, {1,1},  {1,0},  {1,-1},  {0, -1}};

	int kayPerson[];


	int grid[][];

	LinkedHashMap<Integer, String> conoscenze = new LinkedHashMap<Integer, String>();
	//creo un hashmap di conoscenze la chiave sara la persona le conoscenze saranno una stringa
	//linkedhashmap per tenere traccia dll'ordine di inserimento della chiave (persona)
	public void readLine() {

		Scanner s=new Scanner(System.in);

		String input = s.nextLine();


		String splittedInput[]=input.split(" ");

		n=Integer.parseInt(splittedInput[0]);
		m=Integer.parseInt(splittedInput[1]);
		p=Integer.parseInt(splittedInput[2]);
		
//		System.out.println(n+"-"+m+"-"+p);
		kayPerson=new int[p];

		if(p<=n*m) {
			
			int takePerson=0;
			for(int i=0;i<p;i++) {
				input = s.nextLine();
				int index = input.indexOf("->");
//								System.out.println(input.substring(0, index));
//								System.out.println(input.substring(index+2, input.length()));
				takePerson=Integer.parseInt(input.substring(0, index-1));
				kayPerson[i]=takePerson;
				conoscenze.put(takePerson, input.substring(index+3,input.length())); //+2 prende spazio mentre con +3 prende dal numero

			}

//			printLinkedMap(conoscenze);
			grid=new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++){
					grid[i][j]=0;
				}
			}

		}
		else {
			System.out.println("error - più persone che posti - quit program");
		}
	}

	public void solve() {
		readLine();
//		printgriglia(grid);
		if(!solveUntil(grid,0,0,0))
			System.out.println("NO");
		else {
			System.out.println("SI");
			printSolution(grid);
		}
	}



	public void printSolution(int[][] grid) {

		Map.Entry mentrySupport;
		Set set = conoscenze.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==(int)mentry.getKey())
					System.out.println(grid[i][j]+" = ("+i+","+j+")");
				}
			}
		}

	}

	public boolean solveUntil(int grid[][],int x,int y,int key) {

	
		if(checkFinish(grid))
			return true; //trovata soluzione valida
//		Map.Entry mentrySupport;
//		Set set = conoscenze.entrySet();
//		Iterator iterator = set.iterator();
//		while(iterator.hasNext()) {
//			Map.Entry mentry = (Map.Entry)iterator.next();
	
		if(key<p) {
		
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
//					mentrySupport=mentry;
					if(checkPositionSafe(grid,kayPerson[key],i,j)) {

						grid[i][j]=kayPerson[key];
						key++;
						if(solveUntil(grid,i,j,key)) {
							return true;
						}
						grid[i][j]=0;
						key--;
					}


				}
			}
		}
		return false;
	}



	public boolean checkPositionSafe(int[][] grid2, int key,int x,int y) {


		if(grid2[x][y]!=0)
			return false;
		
		if(grid[x][y]==key)
			return false;
		
		String prova;
		prova=conoscenze.get(key);
		String conosce[]=prova.split(" ");
		int personaConoscente;
		for(int i=0;i<conosce.length;i++) {
			personaConoscente=Integer.parseInt(conosce[i]);
			for (int[] direction : adiacenze) {
				int cx = x + direction[0];
				int cy = y + direction[1];
				if(cy >=0 && cy < m)
					if(cx >= 0 && cx < n)
							if(grid[cx][cy]==personaConoscente)
								return false;
			}

		}


		return true;
	}


	//test di stampa della LinkedHashMap
	public void printLinkedMap(LinkedHashMap mappina) {

		Set set = mappina.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());
		}
	}

	//condizione di fine
	public boolean checkFinish(int grid[][]){

		int positioning=0;

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++){
				if(grid[i][j]!=0)
					positioning++;
			}
		}
		if(positioning==p)
			return true;
		return false;
	}

	public void printgriglia(int grid[][]) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(" "+grid[i][j]);
			}
			System.out.println();
		}
	}


}
