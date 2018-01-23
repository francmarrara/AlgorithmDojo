// MatriceS.cpp: implementation of the MatriceS class.
//
//////////////////////////////////////////////////////////////////////

#include "MatriceS.h"

template <class T>
void MatriceS<T>::init( int iMn, int iMx )
{
	assert ( Matrice<T>::nulla() );
	Vettore<VetT>::init(iMn,iMx); // crea il vettore di righe
	for ( int i = iMn; i <= iMx; i++ )
		(*this)[i].init(iMn,i); // ogni riga ha una dimensione diversa
	Matrice<T>::vjmin = iMn; Matrice<T>::vjmax = iMx;
}

template <class T>
const T& MatriceS<T>::operator() ( int i, int j ) const
{
	assert( !Matrice<T>::nulla() );
	if ( i < j )
		return (*this)[j][i];
	else
		return (*this)[i][j];
}

template <class T>
T& MatriceS<T>::operator() ( int i, int j )
{
	assert( !Matrice<T>::nulla() );
	if ( i < j )
		return (*this)[j][i];
	else
		return (*this)[i][j];
}
