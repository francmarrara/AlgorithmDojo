package it.unical.mat.esame;

import java.util.ArrayList;
import java.util.Scanner;

import it.unical.mat.kernel.LinkedBinaryTree;
import it.unical.mat.kernel.Position;

public class Esame {

	private LinkedBinaryTree<BoolWithId> alberello=new LinkedBinaryTree<>();


	public Esame() {

		readInput();
		if(solve())
			System.out.println("True");
		else
			System.out.println("False");
	}


	private boolean solve() {
		// TODO Auto-generated method stub
		//primo punto
		if(!alberello.root().getElement().getValue())
			return false;
		//secondo punto
		for(Position<BoolWithId> c: alberello.positions()) {
			if(!c.getElement().getValue()) {
				if(alberello.left(c)==null)
					return false;
				if(!alberello.left(c).getElement().getValue())
					return false;
				if(alberello.right(c)==null)
					return false;
				if(!alberello.right(c).getElement().getValue())
					return false;
			}
		}
		//terzo punto
		for(Position<BoolWithId> c: alberello.positions())
			if(!sameTrue(c))
				return false;
		return true;
	}





	private boolean sameTrue(Position<BoolWithId> c) {
		ArrayList<Position<BoolWithId>> foglie = new ArrayList<>();

		for (Position<BoolWithId> f : alberello.children(c)) {
			if (alberello.numChildren(f)== 0) {
				foglie.add(f);
			}
		}

		ArrayList<ArrayList<Position<BoolWithId>>> camminiPerFoglia = new ArrayList<>();

		for (Position<BoolWithId> foglia : foglie) {
			camminiPerFoglia.add(getCammino(c, foglia));

		}

		ArrayList<Integer> numeroTrue = new ArrayList<Integer>();

		for (ArrayList<Position<BoolWithId>> array : camminiPerFoglia) {
			numeroTrue.add(numberOfTrue(array));
		}

		Integer num = null;
		if (numeroTrue.size() > 0) {
			num = numeroTrue.get(0);
		}

		// non ne hanno nessuno quindi è ugualmente vera
		if (numeroTrue.size() == 0) {
			return true;
		}

		for (Integer I : numeroTrue) {
			if (I != num)
				return false;
		}

		return true;
	}


	private Integer numberOfTrue(ArrayList<Position<BoolWithId>> array) {
		int number = 0;

		for (Position<BoolWithId> n : array) {
			if (n.getElement().getValue())
				number++;
		}
		return number;
	}


	private ArrayList<Position<BoolWithId>> getCammino(Position<BoolWithId> inizio, Position<BoolWithId> fine) {
		// TODO Auto-generated method stub
		ArrayList<Position<BoolWithId>> camminoTotale = new ArrayList<Position<BoolWithId>>();// cammino totale di tutti i figli

		ArrayList<Position<BoolWithId>> cammino = new ArrayList<Position<BoolWithId>>();// cammino per arrivare alla foglia che mi interessa

		alberello.preorderSubtree(inizio, camminoTotale);

		for (Position<BoolWithId> n : camminoTotale) {
			for(Position<BoolWithId> l:alberello.children(n)) {
				if (n==fine || l==fine) {
					cammino.add(n);
				}
			}
		}

		return cammino;
	}


	private void readInput() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String linea=scanner.nextLine();
		String[] splittedLine=linea.split(" ");
		Integer posizione=Integer.parseInt(splittedLine[0].substring(1,splittedLine[0].length()-1)); //prendo il numero tra le parentesi tonde
		//System.out.println(posizione);
		Boolean val=Boolean.parseBoolean(splittedLine[1].toLowerCase());

		BoolWithId root=new BoolWithId(val, posizione);
		alberello.addRoot(root);
		Integer parent;

		while(scanner.hasNextLine()) {
			linea=scanner.nextLine();
			splittedLine=linea.split(" ");
			posizione=Integer.parseInt(splittedLine[0].substring(1,splittedLine[0].length()-1));
			//System.out.println(posizione);
			val=Boolean.parseBoolean(splittedLine[1].toLowerCase());
			parent=Integer.parseInt(splittedLine[3]);
			BoolWithId node=new BoolWithId(val,posizione);
			node.setId(posizione);
			node.setValue(val);
			for(Position<BoolWithId>c:alberello.positions()) {
				//System.out.println(c.getElement().toString());
				if(c.getElement().getId()==parent) {
					if(splittedLine[4].equals("<")) {
						//figlio sinistro
						alberello.addLeft(c, node);
						break;
					}
					else {
						//figlio destro
						alberello.addRight(c, node);
						break;
					}
				}

			}
		}
		scanner.close();
		//System.out.println(alberello.root().getElement().toString());
		//alberello.printPreorderLabeled(alberello, alberello.root(), new ArrayList<>());


	}
}
