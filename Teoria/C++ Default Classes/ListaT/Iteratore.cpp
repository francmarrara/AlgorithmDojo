// Iteratore.cpp: implementation of the Iteratore class.
//
//////////////////////////////////////////////////////////////////////

#include "Iteratore.h"

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

template <class T>
Iteratore<T>::Iteratore(Lista<T> & lista)
{
	l = &lista;
	corr = l->getTesta();
	prec = NULL;
}

template <class T>
T Iteratore<T>::getCurrentValue() const
{
	assert(corr != NULL);
	return corr->getValore();
}

template <class T>
void Iteratore<T>::setCurrentValue(T val)
{
	assert(corr != NULL);
	corr->setValore(val);
}

template <class T>
bool Iteratore<T>::isNull()
{
	return (corr == NULL);
}

template <class T>
void Iteratore<T>::MoveNext()
{
	assert(corr != NULL);
	prec = corr;
	corr = corr->getNextNodo();
}

template <class T>
void Iteratore<T>::MoveBack()
{
	assert(corr != NULL);
	if (corr == l->getTesta())
	{	corr = NULL;
		prec = NULL;
	}
	else
	{
		Nodo<T> * tmp = corr;
		corr = l->getTesta();
		prec = NULL;
		while (corr->getNextNodo() != tmp)
		{
			prec = corr;
			corr = corr->getNextNodo();
		}
	}
}

template <class T>
void Iteratore<T>::VaiInTesta()
{
	corr = l->getTesta();
	prec = NULL;
}

template <class T>
void Iteratore<T>::VaiInCoda()
{
	corr = l->getTesta();
	prec = NULL;
	while (corr != l->getCoda())
	{
		prec = corr;
		corr = corr->getNextNodo();
	}
}

template <class T>
void Iteratore<T>::InserisciQui(T val)
{
	if (corr == l->getTesta())
	{
		l->addInTesta(val);
		corr = l->getTesta();
		prec = NULL;
	}
	else if (prec == l->getCoda())
	{
		l->addInCoda(val);
		corr = l->getCoda();
	}
	else
	{
		Nodo<T> * newNodo = new Nodo<T>(val);
		newNodo->setNextNodo(corr);
		prec->setNextNodo(newNodo);
		corr = newNodo;
	}
}

template <class T>
void Iteratore<T>::CancellaCorrente()
{
	assert(corr != NULL);
	if (corr == l->getTesta())
	{
		l->delInTesta();
		corr = l->getTesta();
		prec = NULL;
	}
	else if (corr == l->getCoda())
	{
		l->delInCoda();
		prec = l->getCoda();
		corr = NULL;
	}
	else
	{
		prec->setNextNodo(corr->getNextNodo());
		delete corr;
		corr = prec->getNextNodo();
	}
}

template <class T>
bool Iteratore<T>::operator== (const Iteratore<T> &i)
{
	return ((l == i.l) && (prec == i.prec) && (corr == i.corr));
}

template <class T>
bool Iteratore<T>::operator!= (const Iteratore<T> &i){
	return ((l != i.l) || (prec != i.prec) || (corr != i.corr));
}
