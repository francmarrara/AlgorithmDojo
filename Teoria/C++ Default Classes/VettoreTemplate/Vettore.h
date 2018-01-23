// Vettore.h: interface for the Vettore class.
//
//////////////////////////////////////////////////////////////////////

#ifndef VETTORE_H
#define VETTORE_H

#include <assert.h>
#include <iostream>
using namespace std;

template <class T>
class Vettore
{
	template<T> friend bool operator== ( const Vettore<T>& V, const Vettore<T>& VC );
	template<T> friend Vettore<T> operator+ ( const Vettore<T>& V1, const Vettore<T>& V2 );

protected:
	T* elementi; // array degli elementi
	int vimin, vimax; // indice minimo e massimo

public:
//	FUNZIONI COSTANTI
	// true se vettore nullo
	bool nullo() const { return elementi==0; }
	// indice minimo del vettore
	int imin() const { return vimin;}
	// indice massimo del vettore
	int imax() const { return vimax;}
	// restituisce il numero di elementi
	int n() const { return imax()-imin()+1;}
	// valore dell'elemento i-mo del vettore
	const T& operator[] ( int i ) const ;

//	FUNZIONI NON COSTANTI
	Vettore() { elementi = 0; vimin=1; vimax=0;}
	void init( int iMn, int iMx);
	Vettore( int iMn, int iMx )
	{	init(iMn,iMx);
	}
	// costruttore per copia profonda
	Vettore( const Vettore& VC )
	{	assert ( VC.n() > 0 );
		vimin = VC.imin();
		vimax = VC.imax();
		elementi = new T[vimax-vimin+1];
		for ( int i = imin(); i <= imax(); i++ )
			(*this)[i] = VC[i];
	}
	T& operator[] (int i);
	Vettore& operator= ( const Vettore& VC ) ;
	// distruttore profondo
	virtual ~Vettore() { delete [] elementi;}
};
#endif
