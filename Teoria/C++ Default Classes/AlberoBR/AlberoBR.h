// AlberoBR.h: interface for the AlberoBR class.
//
//////////////////////////////////////////////////////////////////////

#ifndef ALBEROBR_H
#define ALBEROBR_H

#include "AlberoB.h"
#include "Lista.h"

template <class T>
class AlberoBR: protected AlberoB<T>
{
protected:
public:
	AlberoBR();
	AlberoBR( const T& a ): AlberoB<T>(a) {}
	AlberoBR( const AlberoBR<T>&);
//	FUNZIONI EREDITATE DA AlberoB<T>
// 	vengono rese visibili le funzioni costanti e quelle
//	non costanti che non alterano l'ordinamento
	AlberoB<T>::svuota; // svuota l'albero
	AlberoB<T>::foglia; // true se la radice è nodo foglia
	AlberoB<T>::nullo; // true se albero nullo
	AlberoB<T>::radice; // mostra l'info della radice
	AlberoB<T>::pradice;


//	inserisce 'a' nella posizione opportuna
//	nel caso di duplicato inserisce il nuovo nodo a destra di esso
//	sempre mantenendo l'ordinamento
	void  ins( const T&);

// 	Funzioni per ottenere sottoalberi di tipo AlberoBR
//	restituisce il figlio d = SIN/DES
	AlberoBR figlio ( Direzione ) const;
//	restituisce il padre eventualmente nullo
	AlberoBR padre ( ) const;
//
	bool cerca (const T&);

//	Restituisce tutti i valori i T.C. a1 <= i <= a2
	Lista<T> compresiTra (const T&, const T&);

protected:
	void visitaInfissaIntelligente( const AlberoBR<T>&, Lista<T>&, const T&, const T& );

};

#endif
