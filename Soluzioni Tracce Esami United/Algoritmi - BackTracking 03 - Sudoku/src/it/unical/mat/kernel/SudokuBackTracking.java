package it.unical.mat.kernel;


/* risolutore sudoku di dimensione N tramite backtraking ricorsivo.
 * Dove N è un numero intero che ammette una radice quadrata intera.
 *
*/
import java.awt.Point;
import java.util.Scanner;

public class SudokuBackTracking {

	// grandezza matrice del sudoku
	private final int N=9;
	// grandezza dei box della matrice
	private int sqrtN=(int) Math.sqrt(N);




	public boolean solveSudoku() {

		int grid[][]=new int[N][N];
		//			 = {{9, 8, 0, 0, 5, 0, 0, 3, 7},
		//				{4, 0, 0, 0, 0, 0, 0, 0, 6},
		//				{0, 0, 3, 4, 0, 2, 9, 0, 0},
		//				{0, 0, 4, 3, 0, 6, 8, 0, 0},
		//				{5, 0, 0, 0, 0, 0, 0, 0, 4},
		//				{0, 0, 8, 1, 0, 5, 2, 0, 0},
		//				{0, 0, 6, 2, 0, 7, 5, 0, 0},
		//				{2, 0, 0, 0, 0, 0, 0, 0, 9},
		//				{3, 4, 0, 0, 1, 0, 0, 6, 2}};


		//		    9 8 0 0 5 0 0 3 7
		//			4 0 0 0 0 0 0 0 6
		//			0 0 3 4 0 2 9 0 0
		//			0 0 4 3 0 6 8 0 0
		//			5 0 0 0 0 0 0 0 4
		//			0 0 8 1 0 5 2 0 0
		//			0 0 6 2 0 7 5 0 0
		//			2 0 0 0 0 0 0 0 9
		//			3 4 0 0 1 0 0 6 2



		//		
		readLineSudoku(grid);

		if(!solveSudokuUntil(grid)) {
			System.out.println("non esiste una soluzione");
			return false;
		}
		stampa(grid);
		return true;
	}



	// risolve con backtracking
	public boolean solveSudokuUntil(int grid[][]) {

		int x=0;
		int y=0;
		y=(int) CheckEmptyLocation(grid,x,y).getY();
		x=(int) CheckEmptyLocation(grid,x,y).getX();
		if((x==-1) && (y==-1))
			return true;//non ci sono celle a 0 ergo sudoku completato

		for (int number = 1; number <= 9; number++){

			if (CheckSafe(grid, x, y, number)){

				grid[x][y] = number;

				if (solveSudokuUntil(grid)) //ricorsività per capire se la prossima mossa ammette soluzione
					return true;
				grid[x][y] = 0; //backtracking
			}

		}
		return false;
	}



	//stampa la griglia
	public void stampa(int grid[][]) {

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(" "+grid[i][j]);
			}
			System.out.println();
		}
	}

	//controllo la griglia cercando le celle in cui è presente 0 restituendo le coordinate x,y come punto;
	Point CheckEmptyLocation(int grid[][],int x,int y){

		Point cord=new Point(-1,-1);

		for(x=0;x<N;x++) {
			for(y=0;y<N;y++) {
				if (grid[x][y] == 0) {
					cord.x=x;
					cord.y=y;
					break;
				}
			}
		}
		return cord;
	}

	//controllo se il numero è già presente nella riga di tutta la griglia	
	boolean CheckRow(int grid[][], int x, int number){
		for (int j = 0; j < N; j++){
			if (grid[x][j] == number)
				return true;
		}
		return false;
	}
	//controllo se il numero è già presente nella colonna di tutta la griglia	
	boolean CheckCol(int grid[][], int y, int number){
		for (int i = 0; i < N; i++){
			if (grid[i][y] == number)
				return true;
		}
		return false;
	}
	//controllo se il numero è già presente nel box della griglia	
	boolean CheckBox(int grid[][], int boxX, int boxY,int number){


		for (int i = 0; i < sqrtN; i++){
			for(int j=0;j<sqrtN;j++) {
				if (grid[boxX+i][boxY+j] == number)
					return true;
			}
		}
		return false;
	}

	//controllo che il numero scelto sia consentito attraverso tutti i check
	boolean CheckSafe(int grid[][],int x,int y,int number) {

		return !CheckRow(grid, x, number) && !CheckCol(grid, y, number) && !CheckBox(grid, x-(x%sqrtN), y-(y%sqrtN), number);

	}

	//metodo che legge la riga del sudoku numeri interi compresi da 0 e 9 separati da spazio
	// lo 0 rappresenza la cella vuota
	void readLineSudoku(int grid[][]) {

		Scanner s1 = new Scanner(System.in);
		Scanner s2  = new Scanner(System.in);
		String[] intStringSplit;
		String a;
		int nu;
		for (int i=0;i<N;i++) {
			a = s1.nextLine();
			intStringSplit = a.split(" ");
			for(int j=0;j<N;) {
				if(checkInputNumber(Integer.parseInt(intStringSplit[j]))) {
					grid[i][j]=Integer.parseInt(intStringSplit[j]);
					j++;
				}
				else {
					do {
					System.out.println("ops! - numeri permessi [0-9] - reinserisci numero in pos:"+(j+1));
					nu=s2.nextInt();
					intStringSplit[j]=String.valueOf(nu);
					}while(!checkInputNumber(nu));
				}
			}
		}
		s1.close();
		s2.close();
	}



	boolean checkInputNumber(int number) {
		return ((number>=0) && (number<=N));
	}

}
