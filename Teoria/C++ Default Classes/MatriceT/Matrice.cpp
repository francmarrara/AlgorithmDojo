// Matrice.cpp: implementation of the Matrice class.
//
//////////////////////////////////////////////////////////////////////

#include "Matrice.h"



template <class T>
void Matrice<T>::copia( const Matrice<T>& MC )
{	for ( int i = Vettore<VetT>::imin(); i <= Vettore<VetT>::imax(); i++ )
		for ( int j = jmin(); j <= jmax(); j++ )
			(*this)(i,j) = MC(i,j);
}

template <class T>
void Matrice<T>::init( int iMn, int iMx, int jMn, int jMx )
{
	assert ( nulla() );
	assert ( iMn <= iMx && jMn <= jMx );
	Vettore<VetT>::init(iMn,iMx); // crea il vettore di righe
	for ( int i = iMn; i <= iMx; i++ )
		(*this)[i].init(jMn,jMx); // crea ogni singola riga
	vjmin = jMn; vjmax = jMx;
}
