// Lista.h: interface for the Lista class.
//
//////////////////////////////////////////////////////////////////////

#ifndef LISTA_H
#define LISTA_H

#include "Nodo.h"
#include <assert.h>

template <class T>
class Lista
{
public :
	Lista();
	~Lista();
	Nodo<T>* getTesta() const;
	Nodo<T>* getCoda() const;
	void addInTesta(T);
	void addInCoda(T);
	Nodo<T>* cerca(T) const;
	T valInTesta() const;
	T valInCoda() const;
	void delInTesta();
	void delInCoda();
	void cancellaTutti(T);
	void cancellaNodo(Nodo<T> *, Nodo<T> *);
	void svuota();

protected:
	Nodo<T> * testa;
	Nodo<T> * coda;
};

#endif
