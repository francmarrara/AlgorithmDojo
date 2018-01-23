 package esame;

import java.util.ArrayList;

import grafi_mio.Vertex;
import grafi_mio.lista.GraphListUndirected;

public class BacktrackingEsame {

	private int MIN_VAL;
	private int MAX_VAL;

	private int k;

	private GraphListUndirected graph;
	private int[] served;
	private ArrayList<Integer> solution = new ArrayList<>();

	public BacktrackingEsame(GraphListUndirected graph, int k) {
		this.graph = graph;
		served = new int[graph.getVerticesCount()];

		for (int i = 0; i < served.length; i++) {
			served[i] = 0;
		}

		MIN_VAL = 0;
		MAX_VAL = graph.getVerticesCount();
		this.k = k;
	}

	boolean solve() {

		int x = MIN_VAL;
		while (x < MAX_VAL) {
			if (canAdd(x)) {
				add(x);
				if (isComplete()) {
					return true;
				} else if (solve()) {
					return true;
				}
				remove(x);
				x = next(x);
			} else {
				x = next(x);
			}
		}
		return false;

	}

	private boolean canAdd(int x) {

		if (solution.contains(x))
			return false;

		if (solution.size() >= k)
			return false;

		/**
		 * Redundant
		if (!graph.hasNeighbor(x))
			return true;
		*/

		/**
		 * Redundant
		for (Vertex v : graph.getNeighbors(x))
			if (served[v.getIndex()] == 0)
				return true;
		*/

		return true;

	}

	private void add(int x) {
		solution.add(x);
		served[x] += 1;
		for (Vertex v : graph.getNeighbors(x))
			served[v.getIndex()] += 1;
	}

	private void remove(int x) {
		solution.remove(new Integer(x));
		served[x] -= 1;
		for (Vertex v : graph.getNeighbors(x))
			served[v.getIndex()] -= 1;
	}

	private boolean isComplete() {
		for (int i = 0; i < served.length; i++)
			if (served[i] == 0)
				return false;
		return true;
	}

	private int next(int x) {
		return x + 1;
	}

	public ArrayList<Integer> getSolution() {
		return solution;
	}

}
