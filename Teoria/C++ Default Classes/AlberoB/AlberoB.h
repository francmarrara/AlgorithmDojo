// AlberoB.h: interface for the AlberoB class.
//
//////////////////////////////////////////////////////////////////////

#ifndef ALBEROB_H
#define ALBEROB_H

#include <assert.h>

enum Direzione { SIN=0, DES=1 };

template <class T>
struct SNodo{
	T vinfo; // parte informativa
	SNodo *ppadre, *pfiglio[2]; // puntatori al padre e ai due figli
	SNodo( const T& inf ): vinfo(inf)
	{	ppadre = pfiglio[SIN] = pfiglio[DES] = 0;
	}
	~SNodo( ) {delete pfiglio[SIN]; delete pfiglio[DES];}
};

template <class T>
class AlberoB
{
protected:
	SNodo<T>* pradice; // puntatore alla radice
public:

//	FUNZIONI NON COSTANTI
	AlberoB ();
	AlberoB ( const T&);

	//	inserisce l'albero AC come figlio d = SIN/DES di AC
	void insFiglio ( Direzione, AlberoB&);
	// 	estrae il figlio d = SIN/DES
	AlberoB<T> estraiFiglio ( Direzione);
	void modRadice ( const T& );
	// svuota l'albero cancellandone tutti i nodi
	void svuota();
	// svuota l'albero ma senza cancellare i nodi
	void annulla();

//	FUNZIONI COSTANTI
	bool nullo() const;
	// restituisce una copia dell'albero
	AlberoB<T> copia ( ) const;
	//	mostra l'info della radice
	const T& radice   ( ) const;
	// restituisce true se la radice è nodo foglia
	bool foglia () const;
	// restituisce il figlio d = SIN/DES
	AlberoB<T> figlio ( Direzione d ) const;
	//	restituisce il padre eventualmente nullo
	AlberoB<T> padre ( ) const;

};

#endif
