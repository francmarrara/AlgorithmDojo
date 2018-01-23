// Iteratore.h: interface for the Iteratore class.
//
//////////////////////////////////////////////////////////////////////

#ifndef ITERATORE_H
#define ITERATORE_H

#include "Lista.h"
#include <assert.h>

template <class T>
class Iteratore{
public:
	Iteratore(Lista<T> & lista);
	T getCurrentValue() const;
	void setCurrentValue(T val);
	bool isNull();
	void MoveNext();
	void MoveBack();
	void VaiInTesta();
	void VaiInCoda();
	void InserisciQui(T val);
	void CancellaCorrente();

	bool operator== (const Iteratore<T> &i);
	bool operator!= (const Iteratore<T> &i);

private:
	Nodo<T> * corr;
	Nodo<T> * prec;
	Lista<T> * l;
};

#endif
