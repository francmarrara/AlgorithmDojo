// AlberoBR.cpp: implementation of the AlberoBR class.

//////////////////////////////////////////////////////////////////////

#include "AlberoBR.h"


template <class T>
AlberoBR<T>::AlberoBR() {}

template <class T>
AlberoBR<T>::AlberoBR( const AlberoBR<T>& AC )
{
	AlberoB<T> *Atemp = &AC.copia();
	pradice = static_cast<AlberoBR*>(Atemp)->pradice;
}

template <class T>
void  AlberoBR<T>::ins( const T& a )
{
	if ( nullo() )
		AlberoB<T>::pradice = new SNodo<T>(a);
	else
	{
		// sottoalbero attraverso cui ricercare la posizione corretta di inserimento
		AlberoB<T> SA = *((AlberoB<T>*)this);
		while ((a<SA.radice())&&(!SA.figlio(SIN).nullo()) ||
				(a>=SA.radice())&&(!SA.figlio(DES).nullo()))
			if (a<SA.radice())
				SA=SA.figlio(SIN);
			else
				SA=SA.figlio(DES);
		if (a<SA.radice())
			SA.insFiglio(SIN, *(new AlberoB<T>(a)));
		else
			SA.insFiglio(DES, *(new AlberoB<T>(a)));
	}
}

template <class T>
AlberoBR<T> AlberoBR<T>::figlio ( Direzione d ) const
{
	assert( !nullo() );
	AlberoBR<T> AC;
	AC.pradice = AlberoB<T>::pradice->pfiglio[d];
	return AC;
}

template <class T>
AlberoBR<T> AlberoBR<T>::padre ( ) const
{
	assert( !nullo() );
	AlberoBR<T> AC;
	AC.pradice = AlberoB<T>::pradice->ppadre;
	return AC;
}

template <class T>
bool AlberoBR<T>::cerca (const T& a)
{
	if (nullo())
		return false;
	else
		if (a==radice())
			return true;
		else
			if (a<radice())
				return figlio(SIN).cerca(a);
			else
				return figlio(DES).cerca(a);
}

template <class T>
Lista<T> AlberoBR<T>::compresiTra (const T& a1, const T& a2)
{
	assert (a1<=a2);
	Lista<T> L;
	visitaInfissaIntelligente(*this, L, a1, a2);
	return L;
}

template <class T>
void AlberoBR<T>::visitaInfissaIntelligente( const AlberoBR<T>& A, Lista<T>& L, const T& a1, const T& a2 )
{
	if ( !A.nullo() && (a1 <= A.radice()) )
	{
		visitaInfissaIntelligente(A.figlio(SIN),L, a1, a2);
		if (A.radice() <= a2)
		{
			L.appendi(A.radice());
			visitaInfissaIntelligente(A.figlio(DES),L, a1, a2);
		}
	}
}
