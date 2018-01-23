// TabellaHash.cpp: implementation of the TabellaHash<T> class.
//
//////////////////////////////////////////////////////////////////////

#include "TabellaHash.h"

template<class T>
TabellaHash<T>::TabellaHash( card p, ChiaveHash<T>& vch):  tab(1,p), ch(vch)
{
	nEl = 0;
}

template<class T>
TabellaHash<T>::~TabellaHash()
{
	for ( card i = 1; i <= nCelle(); i++ )
	tab[i].svuota();
}

template<class T>
card TabellaHash<T>::nCelle() const
{
	return tab.n();
}

template<class T>
bool TabellaHash<T>::ins( T& a )
{
	card i = (ch.hash(a) % nCelle())+1;

	if ( cerca(a)==false )
		{
		tab[i].addInCoda(a); nEl++;
		return true;
		}
	else
		return false;
}

template<class T>
bool TabellaHash<T>::canc( const T& a )
{
	card i = (ch.hash(a) % nCelle())+1;
	Iteratore<T> it(tab[i]);
	bool trovato=false;
	it.vaiInTesta();
	while (!it.isNull() && !trovato)
		if (ch.equivalenti(it.getCurrentValue(),a))
			trovato=true;
		else
			it.moveNext();
	if ( trovato )
	{
		it.cancellaCorrente(); nEl--;
		return true;
	}
	else
		return false;
}

template<class T>
void TabellaHash<T>::svuota()
{
	for ( card i = 1; i <= nCelle(); i++ )
	tab[i].svuota();  //funzione che cancella tutti i nodi nella lista
	nEl = 0;
}

template<class T>
card TabellaHash<T>::n() const
{
	return nEl;
}

template<class T>
bool TabellaHash<T>::cerca ( T& a )
{
	card i = (ch.hash(a) % nCelle())+1;
	Iteratore<T> it(tab[i]);
	bool trovato=false;
	it.VaiInTesta();
	while (!it.isNull() && !trovato)
		if (ch.equivalenti(it.getCurrentValue(),a))
		{
			a=it.getCurrentValue();
			trovato=true;
		}
		else
			it.MoveNext();
	return trovato;
}
