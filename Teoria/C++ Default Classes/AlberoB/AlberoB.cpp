// AlberoB.cpp: implementation of the AlberoB class.
//
//////////////////////////////////////////////////////////////////////

#include "AlberoB.h"

template <class T>
AlberoB<T>::AlberoB () {
	pradice = 0;
}
template <class T>
AlberoB<T>::AlberoB ( const T& a) {
	pradice = new SNodo<T>(a);
}

template <class T>
bool AlberoB<T>::nullo() const
{
	return pradice == 0;
}

//	inserisce l'albero AC come figlio d = SIN/DES di AC
template <class T>
void AlberoB<T>::insFiglio ( Direzione d, AlberoB& AC )
{
	assert( !nullo() );
	assert( figlio(d).nullo() );
	if ( !AC.nullo() ) {
		pradice->pfiglio[d]=AC.pradice;
		AC.pradice->ppadre=pradice;
	}
}

// 	estrae il figlio d = SIN/DES
template <class T>
AlberoB<T> AlberoB<T>::estraiFiglio ( Direzione d ) {
	assert( !nullo() );
	AlberoB<T> A = figlio(d);
	A.pradice->ppadre=0;
	pradice->pfiglio[d] = 0;
	return A;
}

template <class T>
void AlberoB<T>::modRadice ( const T& a ) {
	assert( !nullo() );
	pradice->vinfo = a;
}

// svuota l'albero cancellandone tutti i nodi
template <class T>
void AlberoB<T>::svuota() {
	delete pradice; pradice = 0;
}

// svuota l'albero ma senza cancellare i nodi
template <class T>
void AlberoB<T>::annulla() {
	pradice = 0;
}

//	FUNZIONI COSTANTI
// restituisce una copia dell'albero
template <class T>
AlberoB<T> AlberoB<T>::copia ( ) const	{
	if ( nullo() ) return AlberoB<T>();
	AlberoB<T> AC(radice());
	AlberoB<T> fs = figlio(SIN).copia();
	AlberoB<T> fd = figlio(DES).copia();
	AC.insFiglio(SIN,fs);
	AC.insFiglio(DES,fd);
	return AC;
}

//	mostra l'info della radice
template <class T>
const T& AlberoB<T>::radice ( ) const {
	assert( !nullo() );
	return pradice->vinfo;
}

// restituisce true se la radice è nodo foglia
template <class T>
bool AlberoB<T>::foglia () const {
	return !nullo()&&figlio(SIN).nullo()&& figlio(DES).nullo();
}

// restituisce il figlio d = SIN/DES
template <class T>
AlberoB<T> AlberoB<T>::figlio ( Direzione d ) const {
	assert( !nullo() );
	AlberoB<T> AC;
	AC.pradice = pradice->pfiglio[d];
	return AC;
}

//	restituisce il padre eventualmente nullo
template <class T>
AlberoB<T> AlberoB<T>::padre ( ) const {
	assert( !nullo() );
	AlberoB<T> AC;
	AC.pradice = pradice->ppadre;
	return AC;
}

