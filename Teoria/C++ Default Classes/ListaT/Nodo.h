// Nodo.h: interface for the NodoInt class.
//
//////////////////////////////////////////////////////////////////////

#ifndef NODO_H
#define NODO_H

#include <iostream>
using namespace std;

template <class T>
class Nodo
{
public:
    Nodo(T);
    Nodo(T, Nodo<T>*);

    T getValore() const;
    void setValore(T);

    Nodo* getNextNodo() const;
    void setNextNodo(Nodo<T>*);

private:
	Nodo<T>* next;
	T valore;
};

#endif
