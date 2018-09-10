package it.unical.mat.kernel;

public interface Queue<E> {
	
	/** Restituisce il numero di elementi presenti nella coda**/
	int size();
	
	/** verifica se la coda è vuota**/
	boolean isEmpty();
	
	/**inserisce un elemento in fondo alla coda**/
	void enqueue(E e);
	
	/** Resituisce il primo elemento della coda, senza toglierlo (null se è vuoto)*/
	E first();
	
	/** elimina e restituisce il primo elemento della coda ( null se è vuoto) */
	E dequeue();
}
