package it.unical.mat.kernel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Esame {

	int n,k,p; //n= numero directory; k=direcory massime da prendere; p=numero minimo di persone che devono riceve il regalo

	String idDirectory[];

	LinkedHashMap<String, String> mappa=new LinkedHashMap<String,String>();

	ArrayList<Integer> personePrese=new ArrayList<Integer>();
	//qui inserisco l'id della persona se compare più volte la considero solo una volta
	ArrayList<String> directoryPrese=new ArrayList<String>();
	//qui inserisco l'id della directory per creare il sottoinsieme T

	int personeInserite[]; //indice per capire da dove inizio ad inserire persone
	int quantiInserimenti=0;

	public void solve() {
		readLine();

		if(!solveUntil(directoryPrese, personePrese)) {
			System.out.println("NO");
			printSolution();
		}
		else {
			printSolution();
		}

	}




	// metodo per leggere input e lo elaboro togliendo i ":"
	public void readLine() {

		Scanner scan=new Scanner(System.in);
		String input=scan.nextLine();
		String inputSplitted[]=input.split(" ");

		n=Integer.parseInt(inputSplitted[0]);
		k=Integer.parseInt(inputSplitted[1]);
		p=Integer.parseInt(inputSplitted[2]);

		idDirectory=new String[n];

		for(int i=0;i<n;i++) {
			input=scan.nextLine();
			int index = input.indexOf(":");
			idDirectory[i]=input.substring(0, index-1); //prendo il nome della directory senza spazio prima dei due punti

			mappa.put(idDirectory[i], input.substring(index+2,input.length()));
			//inserisco nella mappa la chiave e la stringa di persone dopo i due punti saltando lo spazio

		}
	}

	//controllo nel caso io abbia trovato una fine sia almeno uno e al più k && almeno p persone
	public boolean checkFinish(ArrayList<String> directory,ArrayList<Integer> persone) {

		if((directory.size()>0 && directory.size()<=k) && (persone.size()>=p))
			return true; 
		return false;

	}

	public boolean solveUntil(ArrayList<String> directory,ArrayList<Integer> persone) {

		if(checkFinish(directory, persone))
			return true; //trovata una soluzione valida

		for(int i=0;i<n;i++) {
			if(checkSafe(directory,persone,idDirectory[i])) {
				directory.add(idDirectory[i]);
				if(solveUntil(directory, persone))
					return true;
				directory.remove(idDirectory[i]);
				svuotaPersone(persone);
			}
		}
	return false;//non trovata soluzione
}

public void svuotaPersone(ArrayList<Integer> persone) {

	for(int i=0;i<personeInserite.length;i++) {
		persone.remove(new Integer(personeInserite[i]));
	}

}

//controllo se la directory e le persone prese sono una soluzione safe
public boolean checkSafe(ArrayList<String> directory, ArrayList<Integer> persone, String key) {


	if(directory.size()<k) {
		if(!directory.contains(key)) {

			String supporto;
			supporto=mappa.get(key);
			String arrayPersone[]=supporto.split(" ");

			for(int i=0;i<arrayPersone.length;i++) {
				if(!persone.contains(Integer.parseInt(arrayPersone[i]))) {
					persone.add(Integer.parseInt(arrayPersone[i]));
					quantiInserimenti++;
				}

			}

			personeInserite=new int[quantiInserimenti];

			for(int i=0;i<quantiInserimenti;i++) {
				personeInserite[i]=persone.get((persone.size()-i-1));

			}
			if(quantiInserimenti>0) {
				quantiInserimenti=0;
				return true;
			}
		}
	}
	return false;
}

		public void printSolution() {
			for(int i=0;i<directoryPrese.size();i++) {

				System.out.print(directoryPrese.get(i)+" ");

			}
		}


	}
