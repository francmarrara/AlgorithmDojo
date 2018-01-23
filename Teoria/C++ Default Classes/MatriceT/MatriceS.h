// MatriceS.h: interface for the MatriceS class.
//
//////////////////////////////////////////////////////////////////////

#ifndef MATRICES_H
#define MATRICES_H

#include "Matrice.h"

template <class T>
class MatriceS: public Matrice<T>
{
typedef Vettore<T> VetT;
public:
	//	costruttore di matrice nulla
	MatriceS( ) {}
	//	dimensionamento a partire da una matrice nulla
	void init( int iMn, int iMx ) ;
	//	costruttore di matrice non nulla
	MatriceS( int iMn, int iMx ) { init(iMn,iMx); }
	//	restituisce il valore elemento (i,j)
	const T& operator() ( int i, int j ) const;
	//	restituisce il valore elemento (i,j)
	T& operator() ( int i, int j );
};
#endif
