package it.unical.mat.kernel;

public class NQueen {

	final int N=8; //problema per 4 regine e matrice 4x4


	//metodo stampa soluzione
	void printSolution(int board[][]){
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++) {
				System.out.print(" "+board[i][j]+" ");
			}
			System.out.println();
		}
	}

	boolean checkPosition(int board[][], int x, int y){
		

		for (int i = 0; i < y; i++) {
			if (board[x][i] == 1)
				return false;
		}

		for (int i=x, j=y; i>=0 && j>=0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}

		for (int i=x, j=y; j>=0 && i<N; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}

//	metodo ricorsivo per la soluzione del problema delle N regine
	
	boolean solveNQUtil(int board[][], int col){

		if (col >= N)
			return true;

		for (int i = 0; i < N; i++){

			if (checkPosition(board, i, col)){
				board[i][col] = 1;

				if (solveNQUtil(board, col + 1))
					return true;
				board[i][col] = 0; // BACKTRACK
			}
		}
		return false;
	}

	//metodo che utilizza il backtraking per trovare la soluzione 
	boolean solveNQ()
    {
        int board[][] = new int [N][N];
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		board[i][j]=0;
        	}
        }
 
        if (!solveNQUtil(board, 0))
        {
            System.out.print("la soluzione non esiste");
            return false;
        }
 
        printSolution(board);
        return true;
    }
}
