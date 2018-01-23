package Esercizio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Tree.Node;
import Tree.Tree;

public class Handler {

	// Albero
	private Tree<Integer> tree;

	// Lista di nodi dell'albero
	private List<Node<Integer>> nodeList;

	// Scanner per leggere da fileInput
	private Scanner s;

	public Handler() {

		s = new Scanner(System.in);
		setTree(new Tree<Node<Integer>>());
		setNodeList(new ArrayList<>());

	}

	// Metodo che legge da input
	public void readInput() {

		String line;
		String nodeID = "";
		String[] firstSubString;
		String[] secondSubString;

		// Leggo e memorizzo la radice dell'albero
		line = s.nextLine();
		firstSubString = line.split("");

		Node<Integer> n = new Node<Integer>(Integer.parseInt(firstSubString[1]));
		tree.setRootElement(n);
		nodeList.add(n);

		// Leggo gli altri nodi e li inserisco nell'albero
		while (s.hasNextLine()) {

			// Leggo una linea e la splitto in base allo " "
			line = s.nextLine();
			firstSubString = line.split(" ");
			secondSubString = firstSubString[0].split("");

			// Prendo l'id del nodo figlio
			for (int x = 1; x < secondSubString.length - 1; x++) {
				nodeID += secondSubString[x];
			}

			// Se il nodo è già inserito nella lista non faccio nulla, altrimenti lo creo e
			// lo inserisco base all'id letto da input
			Node<Integer> node = new Node<Integer>(Integer.parseInt(nodeID));
			nodeID = "";

			if (!(nodeList.contains(node)))
				nodeList.add(node);

			// Prendo l'id del nodo padre
			Integer fatherID = Integer.parseInt(firstSubString[1]);

			// Imposto i figli al nodo padre
			for (Node<Integer> nod : nodeList) {

				if (nod.getData() == fatherID) {

					if (firstSubString[2].equals("<"))
						nod.insertChildAt(0, node);

					else if (firstSubString[2].equals(">"))
						if (nod.getNumberOfChildren() == 0) {
							nod.insertChildAt(0, node);
						} else
							nod.insertChildAt(1, node);

				}
			}

		}

		System.out.println("Lista nodi");
		for (Node<Integer> node : nodeList) {

			System.out.println(node.toString());

		}

		System.out.println("\nNodi Albero\n" + tree.toString() + "\n");

	}

	public void searchWalk() {

		// Prendo dall'albero tutti i nodi foglia
		List<Node<Integer>> leafNodes = tree.findAllLeafNodes();

		// Cammino ricercato
		List<Node<Integer>> searchedWalk = new ArrayList<>();

		// Memorizzo il peso del cammino qui
		Integer weightWalk = 0, inputWeight = 0;

		inputWeight = Integer.parseInt(JOptionPane.showInputDialog("Inserire peso del cammino"));

		// Per ogni nodo foglia calcolo il cammino dalla radice a questo nodo
		// Se il peso è uguale al valore dato in input stampo
		for (Node<Integer> node : leafNodes) {

			weightWalk = 0;
			searchedWalk.clear();

			getTree().allWalks(getTree().getRootElement(), node, searchedWalk, weightWalk, inputWeight);

		}

	}

	// GET E SET

	public List<Node<Integer>> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<Node<Integer>> nodeList) {
		this.nodeList = nodeList;
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

}
