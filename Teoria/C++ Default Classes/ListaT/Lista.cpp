// Lista.cpp: implementation of the Lista<T> class.
//
//////////////////////////////////////////////////////////////////////

#include "Lista.h"

template<class T>
ostream& operator<<(ostream& out, const Lista<T>& l)
{
	Nodo<T> * tmp = l.getTesta();
	while(tmp != NULL)
	{
		out << *tmp <<endl;
		tmp = tmp->getNextNodo();
	}
	return out;
}

template<class T>
Lista<T>::Lista():testa(NULL),coda(NULL)
{

}

template<class T>
Lista<T>::~Lista()
{
	if(testa == NULL) return;
	while(testa != coda)
	{
		Nodo<T> * tmp = testa;
		testa = testa->getNextNodo();
		delete tmp;
	}
	delete testa;
}

template< class T >
Nodo<T>* Lista<T>::getTesta() const
{
	return testa;
}

template< class T >
Nodo<T>* Lista<T>::getCoda() const
{
	return coda;
}

template<class T>
void Lista<T>::addInTesta(T i)
{
	Nodo<T> * tmp = testa;
	testa = new Nodo<T>(i, tmp);
	if (coda == NULL)
		coda = testa;
}

template<class T>
void Lista<T>::addInCoda(T i)
{
    Nodo<T>* tmp = coda;
    coda = new Nodo<T>(i,NULL);
    if (testa == NULL)
		testa = coda;
    else
		tmp->setNextNodo(coda);
}

template<class T>
Nodo<T>* Lista<T>::cerca(T i) const
{
    Nodo<T>* tmp = testa;

    while(tmp != NULL)
    {
        if(tmp->getValore() == i) break;
        tmp = tmp->getNextNodo();
    }

    return tmp;
}

template<class T>
T Lista<T>::valInTesta() const
{	assert(testa != NULL);
	return testa->getValore();
}

template<class T>
T Lista<T>::valInCoda() const
{	assert(coda != NULL);
	return coda->getValore();
}

template<class T>
void Lista<T>::delInTesta()
{
    if(testa == NULL)
		return;
    Nodo<T>* tmp = testa;
    testa = tmp->getNextNodo();
    delete tmp;
}

template<class T>
void Lista<T>::delInCoda()
{
    if(testa == coda)
	{
		delInTesta();
		return;
	}
    Nodo<T> * corr = testa;
	Nodo<T> * prec = NULL;
	while (corr != coda)
    {
		prec = corr;
		corr = corr->getNextNodo();
    }
	prec->setNextNodo(NULL);
    delete coda;
	coda = prec;
}

template<class T>
void Lista<T>::cancellaTutti(T i)
{
	if (testa == NULL) return;
	Nodo<T> * corr = testa;
	Nodo<T> * prec = NULL;
	while (corr != NULL)
		if (corr->getValore() == i)
		{
			Nodo<T> * tmpCorr = corr;
			corr = corr->getNextNodo();
			cancellaNodo(tmpCorr, prec);
		}
		else
		{
			prec = corr;
			corr = corr->getNextNodo();
		}
}

template<class T>
void Lista<T>::cancellaNodo(Nodo<T> * daElim, Nodo<T> * prec)
{
	if (daElim == testa)
	{
		testa = daElim->getNextNodo();
		if (daElim == coda)
			coda = NULL;
	}
	else
	{
		if (daElim == coda)
			coda = prec;
		prec->setNextNodo(daElim->getNextNodo());
	}
	delete daElim;
}

template<class T>
void Lista<T>::svuota()
{
    while (testa != NULL)
	    delInTesta();
}

