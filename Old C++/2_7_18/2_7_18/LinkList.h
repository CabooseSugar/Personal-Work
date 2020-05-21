#pragma once

struct Node
{
	typedef double Item;
	Item data;
	Node *link;
};

size_t list_length(Node* head_ptr);
// Precondition: head_ptr is the head pointer of a linked list.
// Postcondition: The value returned is the number of nodes in
//the linked list. The list itself is unaltered.

