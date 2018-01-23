package Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

	private Node<T> rootElement;

	private List<Node<T>> visitedNodes;
	private List<Node<T>> leafNodes;
	private List<Node<T>> allTreeNodes;

	/**
	 * Default ctor.
	 */
	public Tree() {
		super();

		setVisitedNodes(new ArrayList<>());
		setLeafNodes(new ArrayList<>());
		setAllTreeNodes(new ArrayList<>());

	}

	/**
	 * Return the root Node of the tree.
	 * 
	 * @return the root element.
	 */
	public Node<T> getRootElement() {
		return this.rootElement;
	}

	/**
	 * Set the root Element for the tree.
	 * 
	 * @param n
	 *            the root element to set.
	 */
	public void setRootElement(Node<T> n) {
		this.rootElement = (Node<T>) n;
	}

	/**
	 * Returns the Tree<T> as a List of Node<T> objects. The elements of the List
	 * are generated from a pre-order traversal of the tree.
	 * 
	 * @return a List<Node<T>>.
	 */
	public List<Node<T>> toList() {
		List<Node<T>> list = new ArrayList<Node<T>>();
		walk(rootElement, list);
		return list;
	}

	/**
	 * Returns a String representation of the Tree. The elements are generated from
	 * a pre-order traversal of the Tree.
	 * 
	 * @return the String representation of the Tree.
	 */
	public String toString() {
		return toList().toString();
	}

	/**
	 * Walks the Tree in pre-order style. This is a recursive method, and is called
	 * from the toList() method with the root element as the first argument. It
	 * appends to the second argument, which is passed by reference * as it recurses
	 * down the tree.
	 * 
	 * @param element
	 *            the starting element.
	 * @param list
	 *            the output of the walk.
	 */
	public void walk(Node<T> element, List<Node<T>> list) {
		list.add((Node<T>) element);
		for (Node<T> data : element.getChildren()) {
			walk(data, list);
		}
	}

	// Metodo che trova tutti i nodi foglia dell'albero
	public List<Node<T>> findAllLeafNodes() {

		// Prendo tutti i nodi del grafo
		walk(getRootElement(), allTreeNodes);

		// Per ogni nodo, se questo non ha figli lo inserisco nella lista dei nodi
		// foglia
		for (Node<T> node : getAllTreeNodes()) {

			if (node.getNumberOfChildren() == 0)
				leafNodes.add(node);

		}

		System.out.println("Nodi foglia");
		System.out.println(leafNodes.toString() + "\n");

		return leafNodes;

	}

	// Metodo che calcola, dato un nodo sorgente il cammino fino al nodo foglia
	// target
	public Boolean allWalks(Node<T> source, Node<T> target, List<Node<T>> list, Integer weightWalk,
			Integer inputWeight) {

		// Incremento il contatore del peso del cammino con la chiave del nodo corrente
		if (source instanceof Node<?>) {
			Integer sum = (Integer) source.getData();
			weightWalk += sum;

		}

		// Passo base
		if (visitedNodes.contains(source)) {

			return false;

		}

		// Passo base
		if (source.equals(target) && weightWalk.equals(inputWeight)) {

			visitedNodes.add(source);
			list.add(source);

			System.out.println("CAMMINO TROVATO");
			System.out.println("Cammino dal nodo source " + getRootElement() + " fino al nodo foglia " + target);
			System.out.println(list.toString() + "\n");

			System.out.println("Peso cammino: " + weightWalk + " - Peso inserito da input " + inputWeight + "\n\n");

			return true;

		}

		// Aggiungo il nodo alla lista del cammino
		list.add(source);

		// Per ogni figlio del nodo corrente richiamo la funzione ricorsivamente
		for (Node<T> n : source.getChildren()) {

			allWalks(n, target, list, weightWalk, inputWeight);

		}

		return false;

	}

	public List<Node<T>> getLeafNodes() {
		return leafNodes;
	}

	public void setLeafNodes(List<Node<T>> leafNodes) {
		this.leafNodes = leafNodes;
	}

	public List<Node<T>> getVisitedNodes() {
		return visitedNodes;
	}

	public void setVisitedNodes(List<Node<T>> visitedNodes) {
		this.visitedNodes = visitedNodes;
	}

	public List<Node<T>> getAllTreeNodes() {
		return allTreeNodes;
	}

	public void setAllTreeNodes(List<Node<T>> allTreeNodes) {
		this.allTreeNodes = allTreeNodes;
	}

	/**
	 * Represents a node of the Tree<T> class. The Node<T> is also a container, and
	 * can be thought of as instrumentation to determine the location of the type T
	 * in the Tree<T>.
	 */
}
