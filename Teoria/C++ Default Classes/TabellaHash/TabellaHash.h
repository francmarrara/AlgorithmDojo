#include "Vettore.h"
#include "Lista.h"
#include "Iteratore.h"

typedef unsigned long int card; // tipo cardinale

template <class T>
class ChiaveHash
{
	public:
		ChiaveHash ( ) {}
		virtual card hash ( const T& a )=0;
		virtual bool equivalenti ( const T& a1, const T& a2 )=0;
};

//NB è richiesto che sia definito correttamente l'operatore == per T
template <class T>
class TabellaHash
{
	protected:
		typedef Lista<T> lisEl;
		Vettore<lisEl> tab;
		card nEl;
		ChiaveHash<T>& ch;
	public:
		TabellaHash( card p, ChiaveHash<T>& vch);
		~TabellaHash();
		card nCelle() const;
		bool ins( T& a );
		bool canc( const T& a );
		void svuota();
		card n() const;
		bool cerca ( T& a );
};
