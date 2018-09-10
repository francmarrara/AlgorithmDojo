package it.unical.mat.kernel;

public class SinglyLinkedList<E> {
	
	//-------------classe annidata Node -------
	private static class Node<E>{
		private E element; //riferimento all'elemento memorizzato in questo nodo
		private Node<E> next;//riferimento al nodo successivo nella lista
		public Node(E e,Node<E> n) {
			element=e;
			next=n;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setNext(Node<E>n) {
			next=n;
		}
	}//----fine della classe annidata-----
	
	//variabili
	private Node<E> head=null; //nodo iniziale della lista
	private Node<E> tail=null;//nodo finale della lista
	
	private int size=0;
	
	public SinglyLinkedList() {
		//costruisce una lista inizialmente vuoto
	}

	//metodi di accesso
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public E first() {
		if(isEmpty())
			return null;
		return head.getElement();
	}
	public E last() {
		if(isEmpty())
			return null;
		return tail.getElement();
	}
	//metodi aggiornamento

	public void addFirst(E e) {
		head= new Node<>(e,head); //aggiunge elemento inizio lista
		if(isEmpty())
			tail=head;
		size++;
	}
	public void addLast(E e) {
		Node<E> newest = new Node<>(e,null);
		if(isEmpty())
			head=newest; //caso speciale: lista inizialmente vuota
		else
			tail.setNext(newest);
		tail=newest;
		size++;
	}
	public E removeFirst() {
		if(isEmpty())
			return null;
		E answer=head.getElement();
		head=head.getNext();
		size--;
		if(isEmpty())
			tail=null;
		return answer;
	}
	
}
