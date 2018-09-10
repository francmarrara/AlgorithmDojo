package it.unical.mat.kernel;

/* Restituisce l'elemento memorizzato in questa posizione
 * 
 * @return l'elemento memorizzato
 * @throws IllegalStateException se la posizione non è più valida
 * 
 */


public interface Position<E> {

	E getElement() throws IllegalStateException;
	
}
