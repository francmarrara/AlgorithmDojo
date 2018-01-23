import java.util.ArrayList;
import java.util.Scanner;

import grafi_mio.lista.GraphListUndirected;

public class MainEsame {

	public int n = 0;
	public int k = 0;

	public GraphListUndirected glu = null;

	public ArrayList<String> citiesName = new ArrayList<>();

	public static void main(String[] args) {
		MainEsame me = new MainEsame();
		me.readInput();
		BacktrackingEsame be = new BacktrackingEsame(me.glu, me.k);
		be.solve();
		me.printSolution(be.getSolution());
	}

	public void printSolution(ArrayList<Integer> solutions) {

		if (solutions.isEmpty()) {
			System.out.println("-1");
		} else {
			System.out.println(solutions.size());

			String toPrint = "";

			for (int i : solutions)
				toPrint += citiesName.get(i) + ", ";

			System.out.println(toPrint.substring(0, toPrint.length() - 2));

		}

	}

	public void readInput() {

		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		n = Integer.valueOf(input.split(" ")[0]);
		k = Integer.valueOf(input.split(" ")[1]);

		glu = new GraphListUndirected(n);

		for (int i = 0; i < n; i++) {
			String newCity = scanner.nextLine();
			citiesName.add(newCity);
		}

		String edge = scanner.nextLine();

		while (scanner.hasNext()) {
			String[] sub = edge.split(" ");
			String city1 = sub[0];
			String city2 = sub[2];
			int v1 = citiesName.indexOf(city1);
			int v2 = citiesName.indexOf(city2);
			glu.addEdge(v1, v2);
			edge = scanner.nextLine();
		}

		scanner.close();

	}

}
