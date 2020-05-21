// stackClass2.cpp

#include <cassert>
#include <cstdlib>
#include <iostream>
#include "StackClass2.h"
using namespace std;

char result[Stack::MAXCHARS];

Stack::Stack(void)   // constructor
{
	top = NULL;
}

void Stack::push(char *entry)
{
	int i;
	// Dynamically create a new record
	NameRec *newRecord = new NameRec;

	// If the record was not created 
	//    Print an error message
	if (newRecord == NULL)
		cout << "Item not added to stack" << endl;
	// Else
	//    Put the address contained in the top-of-stack pointer 
	//      into the address field of the new record
	//    Fill in the name field of the new record
	//    Put the address of the new record into the top-of-stack  
	//      pointer
	else
	{
		newRecord->priorAddr = top;
		// newRecord->name = *entry;
		for (i = 0; entry[i] != '\0' && i < MAXCHARS; i++)
			newRecord->name[i] = entry[i];
		newRecord->name[i] = '\0';
		top = newRecord;
	}
}

char * Stack::pop(void)
{
	int i;
	assert(!isEmpty());
	// Store the name field pointed to by the top-of-stack pointer 
	//    into a name array
	for (i = 0; top->name[i] != '\0'; i++)
		result[i] = top->name[i];
	result[i] = '\0';
	NameRec *discard = top;
	// Move the address in the work area address field into the 
	//    top-of-stack pointer.
	top = top->priorAddr;
	// Free the record pointed to by the top-of-stack pointer.
	delete discard;
	// Return the name array to the calling function
	return result;
}

int Stack::isEmpty(void)
{
	return (top == NULL);
}

void Stack::printStack(void)
{
	NameRec * content = top;
	cout << "The contents of the stack includes:\n";
	while (content != NULL)
	{
		cout << content->name << endl;
		content = content->priorAddr;
	}

}