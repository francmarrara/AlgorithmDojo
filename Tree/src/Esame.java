import java.util.ArrayList;
import java.util.Scanner;

public class Esame {
	private Scanner s;
	private Tree<boolWithId> tree;
	private ArrayList<Node<boolWithId>> nodes;

	public Esame() {
		setS(new Scanner(System.in));
		setTree(new Tree<>());
		setNodes(new ArrayList<Node<boolWithId>>());

	}

	public void readInput() {
		// Leggo la linea
		String line = s.nextLine();
		// splitto la prima volta per il valore
		String[] sub = line.split(" ");

		// splitto la seconda volta per prendere L'intero
		String[] sub1 = sub[0].split("");

		boolean value;

		String number = "";

		for (int i = 1; i < sub[0].length() - 1; i++) {
			number += sub1[i];
		}

		Integer id = Integer.parseInt(number);

		if (sub[1].equals("True"))
			value = true;
		else
			value = false;

		// inizializzo la radice
		boolWithId root = new boolWithId(value, id);

		Node<boolWithId> N1 = new Node<boolWithId>(root);
		tree.setRootElement(N1);
		nodes.add(N1);

		// fin quando ha nodi in input leggo.
		while (s.hasNextLine()) {

			line = s.nextLine();

			// splitto la prima volta per le singole sottostringhe
			sub = line.split(" ");

			// splitto la seconda volta per prendere L'intero
			sub1 = sub[0].split("");

			String number1 = "";

			for (int i = 1; i < sub[0].length() - 1; i++) {
				number1 += sub1[i];
			}

			id = Integer.parseInt(number1);

			if (sub[1].equals("True"))
				value = true;
			else
				value = false;

			boolWithId n = new boolWithId(value, id);
			Node<boolWithId> N = new Node<boolWithId>(n);

			Integer idToAssign = Integer.parseInt(sub[3]);
			nodes.add(N);

			for (Node<boolWithId> b : nodes) {
				if (b.getData().getId() == idToAssign) {

				

					if (sub[4].equals("<"))
						b.insertChildAt(0, N);
					else if (sub[4].equals(">")) {
						if (b.getNumberOfChildren() == 0) {
							b.insertChildAt(0, N);

						} else
							b.insertChildAt(1, N);

					}

				}

			}

		}

	}

	public boolean testIsLegalInput() {

		if (!tree.getRootElement().getData().isValue()) // controllo se la radice è false
			return false;

		for (Node<boolWithId> b : nodes) {// controllo se ogni foglia è true
			if (b.getNumberOfChildren() == 0) {
				if (!b.getData().isValue())
					return false;
			}
		}

		for (Node<boolWithId> b : nodes) {
			if (b.getNumberOfChildren() > 0) {// verifico che sia un nodo, ossia che abbia figli
				if (!b.getData().isValue()) { // controllo se ha valore false
					if (b.getNumberOfChildren() < 2) {// controllo che abbia tutti i figli
						return false;
					} else { // se si, controllo che siano tutti "veri"
						for (Node<boolWithId> n : b.getChildren()) {
							if (!n.getData().isValue())
								return false;
						}

					}
				}
			}
		}

		for (Node<boolWithId> b : nodes) {
			if (!haStessoNumerodiTrue(b)) {
				return false;
			}
		}

		return true;
	}

	public Integer numBerofTrue(ArrayList<Node<boolWithId>> list) {
		int number = 0;

		for (Node<boolWithId> n : list) {
			if (n.getData().isValue())
				number++;
		}
		return number;
	}

	public ArrayList<Node<boolWithId>> getCammino(Node<boolWithId> start, Node<boolWithId> finish) {
		ArrayList<Node<boolWithId>> camminoTotale = new ArrayList<Node<boolWithId>>();// cammino totale di tutti i figli
		ArrayList<Node<boolWithId>> cammino = new ArrayList<Node<boolWithId>>();// cammino per arrivare alla foglia che
																				// mi interessa

		tree.walk(start, camminoTotale);

		for (Node<boolWithId> n : camminoTotale) {
			if (n.getChildren().contains(finish) || n == finish) {
				cammino.add(n);

			}
		}

		return cammino;
	}

	public boolean haStessoNumerodiTrue(Node<boolWithId> n) {

		ArrayList<Node<boolWithId>> foglie = new ArrayList<Node<boolWithId>>();

		for (Node<boolWithId> node : n.getChildren()) {
			if (node.getNumberOfChildren() == 0) {
				foglie.add(node);
			}
		}
		ArrayList<ArrayList<Node<boolWithId>>> camminiPerFoglia = new ArrayList<ArrayList<Node<boolWithId>>>();

		for (Node<boolWithId> foglia : foglie) {
			camminiPerFoglia.add(getCammino(n, foglia));

		}

		ArrayList<Integer> numeroTrue = new ArrayList<Integer>();

		for (ArrayList<Node<boolWithId>> array : camminiPerFoglia) {
			numeroTrue.add(numBerofTrue(array));
		}

		Integer valoreSentinella = null;
		if (numeroTrue.size() > 0) {
			valoreSentinella = numeroTrue.get(0);
		}

		// non ne hanno nessuno quindi è ugualmente vera
		if (numeroTrue.size() == 0) {
			return true;
		}

		for (Integer I : numeroTrue) {
			if (I != valoreSentinella)
				return false;
		}

		return true;
	}

	public Tree<boolWithId> getTree() {
		return tree;
	}

	public void setTree(Tree<boolWithId> tree) {
		this.tree = tree;
	}

	public Scanner getS() {
		return s;
	}

	public void setS(Scanner s) {
		this.s = s;
	}

	public ArrayList<Node<boolWithId>> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node<boolWithId>> nodes) {
		this.nodes = nodes;
	}

}
