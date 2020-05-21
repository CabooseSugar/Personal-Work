/**************************************************************************************
* file name: stackClass.h
* programmer name: Kyle Wolf
* date created: 4/6/18
* date of last revision:
* details of the revision:
* short description: Declare the data members and functions of the stackClass class
***************************************************************************************/
#ifndef STACK_H
#define STACK_H
#include <cstdlib> // Provides size_t

template <class Item>
class Stack
{
public:
	// TYPEDEFS AND MEMBER CONSTANTS
	typedef std::size_t size_type;
	typedef Item value_type;
	static const size_type CAPACITY = 30;
	// CONSTRUCTOR + DESTRUCTOR
	Stack() { used = 0; }
	// Postcondition: used has been set to 0
	
	// MODIFICATION MEMBER FUNCTIONS
	void push(const Item& entry);
	// Precondition: entry is an item that works with the standard math operators
	// Postcondition: entry has been added to the top of the stack
	Item pop();
	// Postcondition: Item returned from the top of the stack
	
	// CONSTANT MEMBER FUNCTIONS
	bool is_empty() const { return (used == 0); }
	// Postcondition: Returned true if data array was empty, else returned false
	size_type size() const { return used; }
	// Postconditon: The size of the data array has been returned 
	Item peek() const;
	// Postcondition: Returns the top item of the stack
	
private:
	Item data[CAPACITY];	// Partially filled array
	size_type used;			// How much of array is being used

};

#include "stackClass.template"  // include implementation
#endif
