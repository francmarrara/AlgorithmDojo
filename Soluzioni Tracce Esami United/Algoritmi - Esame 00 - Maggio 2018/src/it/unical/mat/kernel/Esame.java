package it.unical.mat.kernel;

import java.awt.Point;
import java.util.Scanner;

public class Esame {

	int n,s,m,k;

	int inputGrid[][];
	int outGrid[][];




	public boolean solve() {

		readFirstLine();

		if(!solveUntil(inputGrid)) {
			System.out.println("IMPOSSIBILE");
			return false;
		}
		stampa(outGrid);
		return true;
	}




	// risolve con backtracking
	public boolean solveUntil(int grid[][]) {

		int sector;

		if(checkFinish(outGrid))
			return true; //finiti i piazzamenti transistor
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sector=grid[i][j];
				if(CheckSafe(outGrid, i, j, k,sector)) {
					outGrid[i][j]=-1;
					if (solveUntil(grid)) //ricorsività per capire se la prossima mossa ammette soluzione
						return true;
					outGrid[i][j]=0; //backtracking
				}
			}
		}
		return false;
	}





	//leggo la prima riga
	public void readFirstLine() {

		Scanner scan= new Scanner(System.in);
		String input=scan.nextLine();

		String [] inputSplitted=input.split(" ");

		n=Integer.parseInt(inputSplitted[0]);
		s=Integer.parseInt(inputSplitted[1]);
		m=Integer.parseInt(inputSplitted[2]);
		k=Integer.parseInt(inputSplitted[3]);


		inputGrid= new int [n][n];
		for(int i=0;i<n;i++) {
			input=scan.nextLine();
			inputSplitted=input.split(" ");
			for(int j=0;j<n;j++) {

				inputGrid[i][j]=Integer.parseInt(inputSplitted[j]);

			}
		}

		scan.close();




		outGrid=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				outGrid[i][j]=0;
			}
		}
	}

	//leggo la matrice pannello
	//	public void readGrid() {
	//
	//		grid=new int[n][n];
	//
	//		Scanner scan2= new Scanner(System.in);
	//
	//		for(int i=0;i<n;i++) {
	//			String input=scan2.nextLine();
	//			String [] inputSplitted=input.split(" ");
	//			for(int j=0;j<n;j++) {
	//
	//				grid[i][j]=Integer.parseInt(inputSplitted[j]);
	//
	//			}
	//		}
	//		scan2.close();
	//
	//	}

	//stampo pannello di risultato
	public void stampa(int grid[][]) {

		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid.length;j++) {

				if(grid[i][j]==-1)
					System.out.print(" #");
				else {
					System.out.print(" "+inputGrid[i][j]);
				}
			}
			System.out.println();
		}

	}

	//controllo se ho raggiunto i k transistor in riga
	public boolean checkRow(int grid[][],int x,int k) {
		int checkK=0;
		for (int j = 0; j < n; j++){
			if (grid[x][j] == -1)
				checkK++;
		}
		if(checkK<k)
			return true;
		return false;

	}

	//controllo se ho raggiunto i k transistor in colonna
	public boolean checkCol(int grid[][],int y,int k) {
		int checkK=0;
		for (int i = 0; i < n; i++){
			if (grid[i][y] == -1)
				checkK++;
		}
		if(checkK<k)
			return true;
		return false;

	}
	//date le coordinate del settore e il numero di transistor
	//controllo se nel settore sono a k transistor
	public boolean checkBox(int grid[][],int s,int k) {

		int checkK=0;

		for (int i = 0; i < n; i++){
			for(int j=0;j<n;j++) {

				if ((inputGrid[i][j]==s) && (grid[i][j] == -1))
					checkK++;
			}
		}
		if(checkK<k)
			return true;
		return false;

	}

	//controllo che la posizione scelta sia consentito attraverso tutti i check
	public boolean CheckSafe(int grid[][],int x,int y,int k,int s) {

		return checkRow(grid,x, k) && checkCol(grid,y, k) && checkBox(grid, s, k) && checkPosition(grid, x, y);

	}


	public boolean checkPosition(int grid[][],int x,int y) {

		return grid[x][y]!=-1;

	}




	public boolean checkFinish(int grid[][]) {
		int checkK=0;

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]==-1)
					checkK++;
			}
		}

		if(checkK==k*s)
			return true;
		return false;
	}

}
