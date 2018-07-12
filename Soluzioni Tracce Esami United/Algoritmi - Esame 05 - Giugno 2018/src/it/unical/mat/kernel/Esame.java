package it.unical.mat.kernel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.Scanner;


public class Esame {

	int c,m; //prima rigga dell'input
	LinkedHashMap<String, Integer> mappa=new LinkedHashMap<String,Integer>();
	//nome corso e intero valori possibili:
	//- 0 se bisogna effettuare un assegnamento
	//- 1 prima fascia oraria (10-12)
	//- 2 seconda fascia oraria(14-16)
	//- 3 terza fascia oraria(17-19)

	ArrayList<Coppia> corsiAccoppiati=new ArrayList<Coppia>();
	//lista degli accoppiamenti dati da input
	ArrayList<Coppia> appareComePrimoCorso=new ArrayList<Coppia>();
	//lista dove il corso appare nella posizione 1;
	ArrayList<Coppia> appareComeSecondoCorso=new ArrayList<Coppia>();
	//lista dove il corso appare nella posizione 2;

	int initValue=0;
	//valore di init di qualsiasi chiave dell'hashmap

	public boolean solve() {
		readFirstLine();
		if(!solveUntil(mappa)) {
			System.out.println("NO");
			return false;
		}

		System.out.println("SI");
		return true;
	}



	//leggo la prima riga
	public void readFirstLine() {

		Scanner scan= new Scanner(System.in); 		//inizializzo lo scanner per l'input
		String input=scan.nextLine(); //prendo la nuova linea

		//il formato input della prima riga è c spazio m
		String [] inputSplitted=input.split(" "); //splitto per prendere i due numeri

		c=Integer.parseInt(inputSplitted[0]); // quantita di corsi
		m=Integer.parseInt(inputSplitted[1]); //quantita di coppie (corso corso)

		for(int i=0;i<c;i++) {

			input=scan.nextLine();

			if(!mappa.containsKey((input))) {

				mappa.put(input, initValue); 

			}
			//se il corso non è nella hashtable la inserisco e inserisco valore 0

		}

		String supporto1=new String();
		String supporto2=new String();

		for(int i=0;i<m;i++) {
			input=scan.nextLine();
			inputSplitted=input.split(" ");

			int index = inputSplitted[0].indexOf("(");

			supporto1=inputSplitted[0].substring(index+1, inputSplitted[0].length());
			supporto2=inputSplitted[1].substring(index, inputSplitted[1].length()-1);

			corsiAccoppiati.add(new Coppia(supporto1,supporto2));


		}

		//stampaInput();

	}

	public boolean solveUntil(HashMap<String, Integer> mappa) {

	
		
		String chiaveDoveAggiungere=searchEmptyLocation();
		
		if(chiaveDoveAggiungere.equals(""))
			return true;
	
		for (int val = 1; val <= 3; val++) {
			
			if(checkSafe(chiaveDoveAggiungere, val)) {
				
				mappa.replace(chiaveDoveAggiungere, val);
				//se il valore va bene vado avanti
				
				if(solveUntil(mappa))
					return true;
				
				mappa.replace(chiaveDoveAggiungere, 0);
				//altrimenti resetto
			}
			
		}
		
		return false;
	}


	public boolean checkSafe(String  key,int val) {
		// TODO Auto-generated method stub
		
		trovaAlPrimoPosto(key, corsiAccoppiati);
		trovaAlSecondoPosto(key, corsiAccoppiati);
		
		
		if(checkPrimoPosto(val, appareComePrimoCorso) && checkSecondoPosto(val, appareComeSecondoCorso)) {
			appareComePrimoCorso.clear();
			appareComeSecondoCorso.clear();
			return true;
		}
		
		
		appareComePrimoCorso.clear();
		appareComeSecondoCorso.clear();
		return false;
	}



	//prova per controllare prendesse bene input
	public void stampaInput() {


		System.out.println(c+" "+m);

		Iterator it = mappa.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());

		}

		for(int j=0;j<m;j++) {
			System.out.println("("+corsiAccoppiati.get(j).getPrimoCorso()+" "+corsiAccoppiati.get(j).getSecondoCorso()+")");
		}



	}

	//creo una lista dove la chiave appare al primo posto
	public void trovaAlPrimoPosto(String key,ArrayList<Coppia> corsiAccoppiati) {

		for(int i=0;i<corsiAccoppiati.size();i++) {

			if(corsiAccoppiati.get(i).getPrimoCorso().equals(key))
				appareComePrimoCorso.add(corsiAccoppiati.get(i));
		}


	}
	//creo una lista dove la chiave appare al secondo posto
	public void trovaAlSecondoPosto(String key,ArrayList<Coppia> corsiAccoppiati) {

		for(int i=0;i<corsiAccoppiati.size();i++) {

			if(corsiAccoppiati.get(i).getSecondoCorso().equals(key))
				appareComeSecondoCorso.add(corsiAccoppiati.get(i));
		}


	}

	//controllo tutti i valori del primo posto con il secondo posto attraverso hashmap
	public boolean checkPrimoPosto(int val,ArrayList<Coppia> primoPosto) {

		for(Coppia i : primoPosto) {
			
			if(val==(mappa.get(i.getSecondoCorso())))
			return false;
		}
		
		
		return true;
	}
	
	//controllo tutti i valori del secondo posto con il primo posto attraverso hashmap
	public boolean checkSecondoPosto(int val,ArrayList<Coppia> secondoPosto) {

		for(Coppia i : secondoPosto) {
			
			if(val==(mappa.get(i.getPrimoCorso())))
			return false;
		}
		
		
		return true;
	}
	
	public String searchEmptyLocation() {
		
		String chiaveConValoreVuoto=new String("");
		
		for(String i:mappa.keySet()) {
			if(mappa.get(i)==initValue) {
				chiaveConValoreVuoto=i;
				break;
			}
		}
		
		return chiaveConValoreVuoto;
	}




}