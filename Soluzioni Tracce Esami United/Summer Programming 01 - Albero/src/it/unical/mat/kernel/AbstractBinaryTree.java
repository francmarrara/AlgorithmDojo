package it.unical.mat.kernel;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E>{

	@Override
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		Position<E> parent = parent(p);
		if(parent==null)
			return null;
		if(p==left(parent))
			return right(parent);
		return left(parent);
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {

		int c=0;
		if(left(p)!=null)
			c++;
		if(right(p)!=null)
			c++;
		return c;
	}
	public Iterable<Position<E>> children(Position<E> p){

		List<Position<E>> snap =new ArrayList<>();
		if(left(p)!=null)
			snap.add(left(p));
		if(right(p)!=null)
			snap.add(right(p));
		return snap;
	}
	/** aggiunge a snapshot le posizioni del sottoalbero avente radice p.*/
	private void inorderSubtree(Position<E> p,List<Position<E>> snapshot) {
		if(left(p)!=null)
			inorderSubtree(left(p), snapshot);
		snapshot.add(p);
		if(right(p)!=null)
			inorderSubtree(right(p), snapshot);

	}
	/** restituisce una lista dell posizioni dell'albero in ordine simmetrico*/	
	public  Iterable<Position<E>> inorder(){
		List<Position<E>> snapshot =new ArrayList<>();
		if(!isEmpty())
			inorderSubtree(root(), snapshot);
		return snapshot;
	}
	
	/** sovrascrive positions per rendere predefinito l'ordine simmetrico*/
	public Iterable<Position<E>> positions(){
		return inorder();
	}

}
