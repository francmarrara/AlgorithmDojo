// Coda.cpp: implementation of the Coda class.
//
//////////////////////////////////////////////////////////////////////

#include "Coda.h"

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

template< class T >
Coda<T>::Coda()
{
}

template< class T >
void Coda< T >::inCoda( const T &value )
{
	addInCoda(value);
}

template< class T >
T Coda< T >::fuoriCoda()
{
	assert(!vuota());
	T temp=Lista< T >::valInTesta();
	Lista<T>::delInTesta();
	return temp;
}

template< class T >
bool Coda< T >::vuota()
{
	return (Lista< T >::testa == NULL);
}
