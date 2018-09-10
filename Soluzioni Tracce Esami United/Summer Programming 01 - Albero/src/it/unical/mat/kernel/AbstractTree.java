package it.unical.mat.kernel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public abstract class AbstractTree<E> implements Tree<E>{

	//---------classe annidata--------//
	private class ElementIterator implements Iterator<E>{

		Iterator<Position<E>> posIterator=positions().iterator();
		@Override
		public boolean hasNext() {
			return posIterator.hasNext();
		}

		@Override
		public E next() {
			return posIterator.next().getElement();
		}

		public void remove() {
			posIterator.remove();
		}
	}


	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}

	public boolean isExternal(Position<E> p) {
		return numChildren(p) == 0;
	}

	public boolean isRoot(Position<E> p) {
		return p == root();
	}

	public boolean isEmpty() {
		return size() == 0;
	}


	public int depth(Position<E> p) {

		if(isRoot(p))
			return 0;
		return 1 + depth(parent(p));
	}

	public int height(Position<E> p) {
		int h=0;
		for(Position<E> c:children(p))
			h=Math.max(h, 1+height(c));
		return h;
	}
	/*---restituisce un iteratore degli elementi memorizzati in un albero---*/
	public Iterator<E> iterator(){
		return new ElementIterator();
	}
	public Iterable<Position<E>> positions(){
		return preorder();
	}
	public Iterable<Position<E>> postPositions(){
		return postorder();
	}
	
	/**costruisce il cammino partendo da un nodo fino ad arrivare alle foglie (ricorsivo in preorder)**/
	
	public void preorderSubtree(Position<E> p,List<Position<E>> snapshot) {
		snapshot.add(p); //in preordine aggiungiamo p prima dei sottoalberi
		for(Position<E> c:children(p))
			preorderSubtree(c, snapshot);
	}
	/**restituisce una lista delle posizioni dell'albero in preordine patendo dalla radice**/
	public Iterable<Position<E>> preorder(){
		List<Position<E>> snapshot=new ArrayList<>();
		if(!isEmpty())
			preorderSubtree(root(), snapshot);//riempie ricorsivamente snapshot
		return snapshot;
	}

	/**costruisce il cammino partendo da un nodo fino ad arrivare alle foglie (ricorsivo in postorder)**/
	public void postorderSubtree(Position<E> p,List<Position<E>>snapshot) {
		for(Position<E> c:children(p))
			postorderSubtree(c,snapshot);
		snapshot.add(p);//post-ordine aggiungo p ai sottoalberi		
	}

	/**Restituisce una lista delle posizioni dell'albero, in post-ordine partendo dalla root**/
	public Iterable<Position<E>> postorder(){
		List<Position<E>> snapshot=new ArrayList<>();
		if(!isEmpty())
			postorderSubtree(root(), snapshot);
		return snapshot;
	}

	/** Restituisce una lista delle posizioni dell'albero con attraversamento in ampiezza**/
	public Iterable<Position<E>> breadthfirst(){
		List<Position<E>> snapshot =new ArrayList<>();
		if(!isEmpty()) {
			Queue<Position<E>> fringe= new LinkedQueue<>();
			fringe.enqueue(root()); //inizia con la radice
			while(!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue(); //estrae dall'inizio della coda
				snapshot.add(p); //aggiunge questa posizione
				for(Position<E> c:children(p))
					fringe.enqueue(c); //aggiunge i figli in fondo alla coda
			}
		}
		return snapshot;
	}
	/**metodo stampa senza etichette**/
	public static <E> void printPreorderIndent(Tree<E> T,Position<E> p, int d) {
		spaces(2*d);
		System.out.println(p.getElement());
		for(Position<E> c: T.children(p))
			printPreorderIndent(T, c, d+1);

	}

	/**metodo stampa con etichette**/
	public static <E> void printPreorderLabeled(Tree<E> T,Position<E>p,ArrayList<Integer>path) {
		int d=path.size();
		spaces(d*2);
		for(int j=0;j<d;j++)
			System.out.print(path.get(j)+(j==d-1 ? " " : "." ));
		System.out.println(p.getElement());
		path.add(1); //aggiunge al percorso il dato del primo figlio
		for(Position<E>c:T.children(p)) {
			printPreorderLabeled(T, c, path);
			path.set(d, 1+path.get(d));
		}
		path.remove(d);	
	}

	/** metodo stampa con parentesi**/
	public static <E> void parethesize(Tree<E> T,Position<E> p) {

		System.out.print(p.getElement());
		if(T.isInternal(p)) {
			boolean firstTime=true;
			for(Position<E> c:T.children(p)) {
				System.out.print((firstTime ? " (" : ", "));
				firstTime=false;
				parethesize(T, c);
			}
			System.out.print(")");
		}
	}

	//metodo per aggiungere n spazi in stampa
	private static void spaces(int f) {
		// TODO Auto-generated method stub
		for(int i=0;i<f;i++)
			System.out.print(" ");
	}
}
