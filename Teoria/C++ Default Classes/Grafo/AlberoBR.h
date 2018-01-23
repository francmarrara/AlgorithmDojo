// AlberoBR.h: the AlberoBR template class.
//
//////////////////////////////////////////////////////////////////////

#ifndef ALBEROBR_H
#define ALBEROBR_H

#include "AlberoB.h"
#include "Lista.h"

template <class T>
class AlberoBR: protected AlberoB<T>
{
public:
    AlberoBR() {};
	AlberoBR( const T& a ): AlberoB<T>(a) {}
	AlberoBR( const AlberoBR<T>& AC ) {
		AlberoB<T> *Atemp = &AC.copia();
		pradice = static_cast<AlberoBR*>(Atemp)->pradice;
	};
//	FUNZIONI EREDITATE DA AlberoB<T>
// 	vengono rese visibili le funzioni costanti e quelle
//	non costanti che non alterano l'ordinamento
	AlberoB<T>::svuota; // svuota l'albero
	AlberoB<T>::foglia; // true se la radice è nodo foglia
	AlberoB<T>::nullo; // true se albero nullo
	AlberoB<T>::radice; // mostra l'info della radice
	AlberoB<T>::pradice;


//	Inserisce 'a' nella posizione opportuna
//	nel caso di duplicato inserisce il nuovo nodo a destra di esso
//	sempre mantenendo l'ordinamento
    void  ins( const T& a ) {
        if ( nullo() )
            AlberoB<T>::pradice = new SNodo<T>(a);
        else {
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
    };


// 	Funzioni per ottenere sottoalberi di tipo AlberoBR
//	restituisce il figlio d = SIN/DES
    AlberoBR figlio ( Direzione d ) const {
        assert( !nullo() );
        AlberoBR<T> AC;
        AC.pradice = AlberoB<T>::pradice->pfiglio[d];
        return AC;
    };

//  Restituisce il padre eventualmente nullo
	AlberoBR padre ( ) const {
        assert( !nullo() );
        AlberoBR<T> AC;
        AC.pradice = AlberoB<T>::pradice->ppadre;
        return AC;
    };

//  Restituisce l'esito della ricerca di un elemento nell'albero
    bool cerca (const T& a) {
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
    };

//	Restituisce tutti i valori i T.C. a1 <= i <= a2
    Lista<T> compresiTra (const T& a1, const T& a2) {
        assert (a1<=a2);
        Lista<T> L;
        visitaInfissaIntelligente(*this, L, a1, a2);
        return L;
    };

protected:
    void visitaInfissaIntelligente (AlberoBR<T>& A, Lista<T>& L, const T& a1, const T& a2 ) const {
        if ( !A.nullo() && (a1 <= A.radice()) ) {
            visitaInfissaIntelligente(A.figlio(SIN),L, a1, a2);
            if (A.radice() <= a2) {
                L.appendi(A.radice());
                visitaInfissaIntelligente(A.figlio(DES),L, a1, a2);
            }
        }
    };

};

#endif
