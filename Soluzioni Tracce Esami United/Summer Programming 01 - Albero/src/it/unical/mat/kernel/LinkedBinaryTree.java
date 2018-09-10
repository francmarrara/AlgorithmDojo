package it.unical.mat.kernel;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>{

	//---------classe nodo annidata----------//
	protected static class Node<E> implements Position<E>{
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;

		//costruisce un nodo dato un elemento e i nodi adiacenti//
		public Node(E e,Node<E> above,Node<E> leftChild,Node<E> rightChild) {

			element=e;
			parent=above;
			left=leftChild;
			right=rightChild;

		}

		//metodi get
		public E getElement() throws IllegalStateException {
			return element;
		}
		public Node<E> getParent() {
			return parent;
		}
		public Node<E> getLeft() {
			return left;
		}
		public Node<E> getRight() {
			return right;
		}

		//metodi set
		public void setElement(E element) {
			this.element=element;
		}
		public void setParent(Node<E> parent) {
			this.parent = parent;
		}
		public void setLeft(Node<E> left) {
			this.left = left;
		}
		public void setRight(Node<E> right) {
			this.right = right;
		}
	}
	//fine classe annidata

	//factory method per creare un nodo memorizzando l'elemento e
	protected Node<E> createNode(E e,Node<E> parent,Node<E> left,Node<E> right){
		return new Node<E>(e,parent,left,right);
	}

	//variabili della classe linkedBinaryTree
	protected Node<E> root=null; //radice albero
	private int size=0; //numero nodi albero

	//costruttore albero binario vuoto
	public LinkedBinaryTree() {}

	//metodi ausiliari non pubblici

	//verifica la validità della posizione e la sestituisce sotto forma di nodo
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node))
			throw new IllegalArgumentException("tipo posizione non valido");
		Node<E> node=(Node<E>) p; //casting
		if(node.getParent()==node) //convensione per indicare un ex nodo
			throw new IllegalArgumentException("p non è più nell'albero");
		return node;
	}

	//metodi get
	//restituisce il numero nodi dell'albero
	public int size() {
		return size;
	}

	//resistuisce la Position radice dell'albero/ null se l'albero è vuoto
	public Position<E> root(){
		return root;
	}

	//resistuisce Position del genitore di p null in caso p è radice
	public Position<E> parent(Position<E> p) throws IllegalArgumentException{
		Node<E> node=validate(p);
		return node.getParent();
	}

	//resistuisce Position del figlio sinistro di p null in caso non esiste
	public Position<E> left(Position<E> p) throws IllegalArgumentException{
		Node<E> node=validate(p);
		return node.getLeft();
	}

	//resistuisce Position del figlio destro di p null in caso non esiste
	public Position<E> right(Position<E> p) throws IllegalArgumentException{
		Node<E> node=validate(p);
		return node.getRight();
	}

	//metodi set

	//Pone e nella radice di un albero vuoto e restituisce la sua nuova Position
	public Position<E> addRoot(E e) throws IllegalStateException{
		if(!isEmpty()) throw new IllegalStateException("albero non vuoto");
		root=createNode(e, null, null, null);
		size=1;
		return root;
	}
	
	//crea il figlio sinistro di p con l'elemento e restituendo la posizione
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
		
		Node<E> parent =validate (p);
		if(parent.getLeft() != null)
			throw new IllegalArgumentException("p ha già un figlio sinistro");
		Node<E> child=createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}
	
	//crea il figlio destro di p con l'elemento e restituendo la posizione
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
		
		Node<E> parent =validate (p);
		if(parent.getRight() != null)
			throw new IllegalArgumentException("p ha già un figlio destro");
		Node<E> child=createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}	
	
	//sostituiscecon e l'elemento in p e restituisce l'elemento sostituito
	public E set(Position<E>p,E e) throws IllegalArgumentException{
		Node<E> node=validate(p);
		E temp=node.getElement();
		node.setElement(e);
		return temp;
	}
	
	//metodi albero
	
	//collega gli alberi t1 e t2 come sottoalberi sinistro e destro di p,foglia
	public void attach(Position<E> p,LinkedBinaryTree<E> t1,LinkedBinaryTree<E> t2) throws IllegalArgumentException{
		Node<E> node=validate(p);
		if(isInternal(p))
			throw new IllegalArgumentException("p deve essere una foglia");
		size+=t1.size()+t2.size();
		if(!t1.isEmpty()) {
			//collego t1 come sottoalbero sinistro di node
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root=null;
			t1.size=0;
		}
		if(!t2.isEmpty()) {
			//collego t2 come sottoalbero nestro di node
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root=null;
			t2.size=0;
		}
	}
	
	//elimina il nodo in posizione p e lo sostituisce con il figlio se esiste
	
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> node=validate(p);
		if(numChildren(p)==2)
			throw new IllegalArgumentException("p ha due figli");
		Node<E> child=(node.getLeft() !=null ? node.getLeft():node.getRight());
		if(child!=null)
			child.setParent(node.getParent());//nonno di child diventa genitore
		if(node==root)
			root=child; //child diventa radice
		else {
			Node<E> parent =node.getParent();
			if(node == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
		}
		size--;
		E temp= node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		return temp;
		
	}
	//--------fine classe LInkedBinaryTree--------	

}
