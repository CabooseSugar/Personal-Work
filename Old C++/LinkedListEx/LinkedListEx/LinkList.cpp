#include <cstdlib>
#include <cassert>
#include <iostream>
#include "LinkList.h"

using namespace std; 

size_t list_length(Node* head_ptr) {
	size_t answer = 0;

	Node* cursor = head_ptr;

	for (cursor = head_ptr; cursor != NULL; cursor = cursor->link)
		answer++;

	return answer;
}

void list_head_insert(Node*& head_ptr, const Node::Item& entry) 
{
	Node* newHead = new Node;
	newHead->data = entry;
	newHead->link = head_ptr;
	head_ptr = newHead;
}

void list_insert(Node* previous_ptr, const Node::Item& entry)
{
	Node* newNode = new Node;
	newNode->data = entry;
	newNode->link = previous_ptr->link;
	previous_ptr->link = newNode;
}

Node* list_search(Node* head_ptr, const Node::Item& target)
{
	Node* cursor;
	for (cursor = head_ptr; cursor != NULL; cursor = cursor->link)
		if (target == cursor->data)
			return cursor;
	
	return NULL;
}

Node* list_locate(Node* head_ptr, size_t position)
{
	Node* cursor;
	size_t i;

	assert(0 < position);

	cursor = head_ptr;
	for (i = 1; (i < position) && (cursor != NULL); i++)
		cursor = cursor->link;
	return cursor;
}

void list_copy(Node* source_ptr, Node*& head_ptr, Node*& tail_ptr)
{
	Node *newHead = new Node;

	head_ptr = NULL;
	tail_ptr = NULL;

	if (source_ptr == NULL)
		return;

	head_ptr = newHead;
	tail_ptr = newHead;

	newHead->data = source_ptr->data;	//copy over contents of first node "manually", then loop kicks in for rest
	newHead->link = source_ptr->link; // this line might be wrong, sets newHead to point to old list directly

	for (source_ptr = source_ptr->link; source_ptr != NULL; source_ptr = source_ptr->link)
	{
		list_insert(tail_ptr, source_ptr->data);
		tail_ptr = tail_ptr->link;
	}
}

void list_piece(Node* start_ptr, Node* end_ptr, Node*& head_ptr, Node*& tail_ptr)
{
	Node *newHead = new Node;

	head_ptr = NULL;
	tail_ptr = NULL;

	if (start_ptr == NULL)
		return;

	head_ptr = newHead;
	tail_ptr = newHead;

	newHead->data = start_ptr->data;
	newHead->link = start_ptr->link;

	for (start_ptr = start_ptr->link; start_ptr != end_ptr; start_ptr = start_ptr->link)
	{
		list_insert(tail_ptr, start_ptr->data);
		tail_ptr = tail_ptr->link;
	}
}

void list_head_remove(Node*& head_ptr)
{
	Node *remove_ptr;
	remove_ptr = head_ptr;    
	head_ptr = head_ptr->link;    
	delete remove_ptr;
}

void list_remove(Node* previous_ptr)
{
	Node *remove_ptr;   
	remove_ptr = previous_ptr->link;
	previous_ptr->link = remove_ptr->link; 
	delete remove_ptr; 
}

void list_clear(Node*& head_ptr)
{
	while (head_ptr != NULL)       
		list_head_remove(head_ptr);
}

// REVISED, PERSONAL VERSIONS BELOW































// rewrite practice (no peeking!)

size_t list_length(Node* head_ptr)
{
	size_t count = 0;

	while (head_ptr->link != NULL)
	{
		head_ptr->link = head_ptr->link->link;
		count++;
	}

	return count;
}

void list_head_insert(Node*& head_ptr, const Node::Item& entry)
{
	Node* newHead = new Node;

	newHead->data = entry;
	newHead->link = head_ptr;

	head_ptr = newHead;
}

void list_insert(Node* previous_ptr, const Node::Item& entry)
{
	Node* newInsert = new Node;

	newInsert->data = entry;
	newInsert->link = previous_ptr->link;
	previous_ptr->link = newInsert;
}

Node* list_search(Node* head_ptr, const Node::Item& target)
{
	Node* index = head_ptr;
	while (index != NULL && index->data != target)
	{
		index = index->link;
	}

	if (index == NULL)
	{
		cout << "\nData not found" << endl;
		return NULL;
	}

	cout << "\nData found" << endl;
	return index;
}

Node* list_locate(Node* head_ptr, size_t position)
{
	size_t count = 1;
	Node* index = head_ptr;

	while (count != position)
	{
		if (index->link == NULL)
			return NULL;
		index = index->link;
		count++;
	}

	return index;
}


void list_copy(Node* source_ptr, Node*& head_ptr, Node*& tail_ptr)
{
	Node* newHead = new Node;
	bool headConnectsTails = false;

	head_ptr = NULL;
	tail_ptr = NULL;

	if (source_ptr == NULL)
		return;

	head_ptr = newHead;
	tail_ptr = newHead;
	
	newHead->data = source_ptr->data;

	for (source_ptr->link; source_ptr != NULL; source_ptr->link)
	{
		// first run: inserts node below newHead and points tail_ptr to it
		list_insert(tail_ptr, source_ptr->data);
		tail_ptr = tail_ptr->link;
		// first run: connects newHead to this node below, from now on, for loop will do the connecting
		while (headConnectsTails == false)
		{
			newHead->link = tail_ptr;
			headConnectsTails = true;
		}
	}

	//list_piece will be done similarly to list_copy above
}


