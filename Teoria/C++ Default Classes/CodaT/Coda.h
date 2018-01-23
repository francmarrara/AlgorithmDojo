// Coda.h: interface for the Coda class.
//
//////////////////////////////////////////////////////////////////////

#ifndef CODA_H
#define CODA_H

#include "Lista.h"
#include <assert.h>

template< class T >
class Coda : private Lista<T>
{
public:
	Coda();
	void inCoda( const T& );
	T fuoriCoda();
	bool vuota();
};

#endif
