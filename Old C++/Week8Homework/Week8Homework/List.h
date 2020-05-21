/**************************************************************************************
* file name: Wolf_6_1
* programmer name: Kyle Wolf
* date created: 3/29/2018
* date of last revision: 4/29/18
* details of the revision: Added sort function and converted the class to a template class
* short description: Declare the data members and functions of template class List
***************************************************************************************/

#ifndef LIST_H
#define LIST_H

template <class Item>
class List
{
public:
	struct Node
	{
		Item data;
		Node *link;
	};

	// MODIFICATION MEMBER FUNCTIONS
	void list_head_insert(Node*& head_ptr, const Item& entry);
	//  Precondition: head_ptr is the head pointer of a linked list.
	//  Postcondition: A new node containing the given entry 
	//  has been added at the head of the linked list;  head_ptr
	//  now points to the head of the new, longer linked list.

	void list_tail_insert(Node*& head_ptr, const Item& entry);
	//	Precondition:  previous_ptr points to a node in a linked list.
	//	Postcondition:  A new node containing the given entry has been added
	//	after the node that previous_ptr points to.

	void list_head_remove(Node*& head_ptr);
	//  Precondition: head_ptr is the head pointer of a linked list, with at
	//  least one node.
	//  Postcondition: The head node has been removed and returned to the
	//  heap;  head_ptr is now the head pointer of the new, shorter linked list.

	void list_remove(Node*& head_ptr, Node* target_ptr);
	//	Precondition:  head_ptr and target_ptr points to a node in a linked list
	//  Postcondition: The node pointed to by target_ptr has been removed from the list
	//	pointed to by head_ptr

	void list_clear(Node*& head_ptr);
	//	Precondition: head_ptr is the head pointer of a linked list.
	//	Postcondition: All nodes of the list have been returned to the heap,
	//	and the head_ptr is now NULL.

	void sort_list(Node*& head_ptr); 
	// Precondition: head_ptr is a head pointer of 
	// a linked list of items, and these items can be 
	// compared with a less-than operator.
	// Postcondition: head_ptr points to the head
	// of a linked list with exactly the same entries 
	// (including repetitions if any), but the entries 
	// in this list are sorted from smallest to
	// largest. The original linked list is no longer
	// available.

	// CONSTANT MEMBER FUNCTIONS
	size_t list_length(Node* head_ptr);
	// Precondition: head_ptr is the head pointer of a linked list.
	// Postcondition: The value returned is the number of nodes in
	//the linked list. The list itself is unaltered.

	void listDisplay(Node* head_ptr);
	//	Precondition: head_ptr is the head pointer of a linked list.
	//	Postcondition: The contents of the list have been printed to the screen
};


#include "List.template"
#endif
