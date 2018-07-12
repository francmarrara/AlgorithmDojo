package it.unical.mat.kernel;

// problema di un ratto in un labirinto risolto tramite blacktracking

public class RatMaze {

	final int N=4; // dimensione matrice quadrata



	//metodo stampa matrice di soluzione
	public void printMazeSolution(int s[][]) {

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(" "+s[i][j]);
			}
			System.out.println();
		}
	}

	//metodo che controlla se la posizione è interna alla matrice e se essa è una posizione valida
	public boolean checkPosition(int maze[][],int x,int y) {

		if(x>=0 && x<N && y>=0 && y<N && maze[x][y] == 1)
			return true;
		return false;

	}


	//	utilizzo il backtraking per la soluzione del problema, se la 
	//	funzione ritorna falso non esiste soluzione altrimenti la stampa

	boolean solveMaze(int maze[][]) {

		int sol[][] = {{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0}};

		if (!solveMazeUntil(maze, 0, 0, sol)){
			System.out.print("soluzione non esistente");
			return false;
		}

		printMazeSolution(sol);
		return true;

	}

	//funzione ricorsiva per determinare la soluzione al problema
	boolean solveMazeUntil(int maze[][], int x, int y,int sol[][]) {

		if (x == N - 1 && y == N - 1){
			sol[x][y] = 1;
			return true;
		}
		if (checkPosition(maze, x, y)){
			sol[x][y] = 1;
			if (solveMazeUntil(maze, x + 1, y, sol))
				return true;
			if (solveMazeUntil(maze, x, y + 1, sol))
				return true;
			sol[x][y] = 0;
			return false;
		}
		return false;

	}



}
