package it.unical.mat.kernel;

//Java program for Knight Tour problem
class KnightTour {
	static int N = 8;


//	funzione per il controllo che i e j 
//	sono indici validi della scacchiera N*N
	
	static boolean isSafe(int x, int y, int sol[][]) {
		return (x >= 0 && x < N && y >= 0 &&
				y < N && sol[x][y] == -1);
	}
 
//	metodo per la stampa della soluzione
	static void printSolution(int sol[][]) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++)
				System.out.print(sol[x][y] + " ");
			System.out.println();
		}
	}
	
	
	
	
//	utilizzo il Backtracking per trovare la soluzione al problema del Knight Tour
//	se la funzione ritorna false non esiste soluzione altrimenti esiste e provvede alla stampa
	
 static boolean solveKT() {
     int sol[][] = new int[8][8];

     // inizializzo la scacchiera a -11 su tutte le posizioni 
     for (int x = 0; x < N; x++)
         for (int y = 0; y < N; y++)
             sol[x][y] = -1;

//     Move definisce esatttamente le prossime mosse del cavallo 
//     xMove usata per coordinata X
//     yMove per coordinata y
     int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
     int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

     // il cavallo inizia dalla posizione x=0 y=0 inserendo il valore iniziale 0
     sol[0][0] = 0;

//     inizio dal punto 0,0 giro per tutta la matrice cercando
//     una soluzione usando il metodo solveKTuntil()
     
     if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
         System.out.println("Solution does not exist");
         return false;
     } else
         printSolution(sol);

     return true;
 }

 // funzione ricorsiva utilizzata per trovare la soluzione
 static boolean solveKTUtil(int x, int y, int movei,
                            int sol[][], int xMove[],
                            int yMove[]) {
     int k, next_x, next_y;
     if (movei == N * N)
         return true;

     //provo tutte le prossime coordinate partendo dalla posizione in cui mi trovo
     for (k = 0; k < 8; k++) {
         next_x = x + xMove[k];
         next_y = y + yMove[k];
         if (isSafe(next_x, next_y, sol)) {
             sol[next_x][next_y] = movei;
             if (solveKTUtil(next_x, next_y, movei + 1,
                             sol, xMove, yMove))
                 return true;
             else
                 sol[next_x][next_y] = -1;// backtracking
         }
     }

     return false;
 }

}

