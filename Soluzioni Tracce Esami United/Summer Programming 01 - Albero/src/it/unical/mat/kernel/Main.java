package it.unical.mat.kernel;

import java.util.ArrayList;

//classe test alberi
public class Main {
	
	
	public static void main(String args[]) {
		
		LinkedBinaryTree<Integer> prova = new LinkedBinaryTree<>();
		Position<Integer> pos = prova.addRoot(20);
		prova.addLeft(pos, 0);
		prova.addRight(pos, 11);
		prova.addLeft(prova.right(pos), 23);
		prova.addLeft(prova.left(pos), 3);
		prova.addRight(prova.left(pos), 3);
		//prova.printPreorderIndent(prova, prova.root(), 0);
		prova.printPreorderLabeled(prova, prova.root(), new ArrayList<>());
		//prova.parethesize(prova, prova.root());
		
		System.out.println(pos);
	}

}
