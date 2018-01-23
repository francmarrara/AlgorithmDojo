// Stack.h: interface for the Stack class.
//
//////////////////////////////////////////////////////////////////////

#ifndef STACK_H
#define STACK_H

template< class T >
class Stack
{
public:
	Stack(int = 10);
	~Stack() { delete [] stackPtr; }
	bool push( const T& );
	bool pop( T& );
	bool isEmpty() const { return top == -1; }
	bool isFull() const { return top == size - 1; }
private:
	int size;
	int top;
	T *stackPtr;
};

#endif
