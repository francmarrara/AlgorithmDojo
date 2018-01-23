// Vettore.cpp: implementation of the Vettore class.
//
//////////////////////////////////////////////////////////////////////

#include "Vettore.h"

template <class T> 
bool operator== ( const Vettore<T>& V, const Vettore<T>& VC )
{	
	if ( &V == &VC ) return true;
	if ( V.imin() != VC.imin() || V.imax() != VC.imax() ) 
		return false; 
	for ( int i = V.imin(); i <= V.imax(); i++ ) 
		if ( !(V[i] == VC[i]) ) return false;
	return true;
}

template <class T> 
Vettore<T> operator+ ( const Vettore<T>& V1, const Vettore<T>& V2 )
{	
    assert ( V1.imin() == V2.imin() && V1.imax() == V2.imax());
	Vettore<T> V(V1.imin(),V1.imax());
	for ( int i = V.imin(); i <= V.imax(); i++ )
		V[i] = V1[i] + V2[i];
	return V;
}

template <class T> inline
const T& Vettore<T>::operator[] (int i) const 
{	
	assert ( !nullo() );
	assert ( i >= imin() && i <= imax() );
	return elementi[i-vimin];
}

template <class T> inline 
void Vettore<T>::init ( int iMn, int iMx ) 
{	
	assert (iMx>=iMn);
	elementi = new T[iMx-iMn+1]; 
	vimin = iMn; 
	vimax = iMx;
}

template <class T> inline 
T& Vettore<T>::operator[] ( int i ) 
{	
	assert ( !nullo() );
	assert ( i >= imin() && i <= imax() );
	return elementi[i-vimin];
}

template <class T> inline
Vettore<T>& Vettore<T>::operator= ( const Vettore<T>& VC ) 
{	
	if ( this == &VC ) return *this;
	assert ( imin() == VC.imin() && imax() == VC.imax() ); 
	for ( int i = imin(); i <= imax(); i++ ) 
		(*this)[i] = VC[i];
	return *this;
}

