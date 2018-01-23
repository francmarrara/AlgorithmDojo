// Nodo.cpp: implementation of the Nodo class.
//
//////////////////////////////////////////////////////////////////////

#include "Nodo.h"

template<class T>
ostream& operator<<(ostream& out, const Nodo<T>& n)
{
	out << n.getValore();
	return out;
}

template<class T>
Nodo<T>::Nodo<T>(T i): next(NULL), valore(i)
{

}

template<class T>
Nodo<T>::Nodo<T>(T i, Nodo<T>* n): next(n), valore(i)
{

}

template<class T>
T Nodo<T>::getValore() const
{
	return valore;
}

template<class T>
void Nodo<T>::setValore(T i)
{
	valore=i;
}

template<class T>
Nodo<T>* Nodo<T>::getNextNodo() const
{
	return next;
}

template<class T>
void Nodo<T>::setNextNodo(Nodo<T>* n)
{
	next=n;
}

