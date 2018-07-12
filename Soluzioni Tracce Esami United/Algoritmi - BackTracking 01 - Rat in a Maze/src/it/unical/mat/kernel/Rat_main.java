package it.unical.mat.kernel;

public class Rat_main {

	public static void main(String args[]) {
		RatMaze rat= new RatMaze();

		//labirinto il valore uno indica caselle accessibili dal ratto
		int maze[][]={{1, 0, 0, 0},{1, 1, 0, 1},{0, 1, 0, 0},{1, 1, 1, 1}};

		rat.solveMaze(maze);
	}
}
