#include <iostream>
#include "Node.h"
using namespace std;

int main()
{
	Node a, b;                        //two Node objects
	a.set_data(10.21);                //set the data for the first
	Node *c = new Node(20.1);         //dynamic Node
	cout << a.data_in() << endl;      //display the data for a
	cout << b.data_in() << endl;      //display the data for b
	cout << c->data_in() << endl << endl;     //display the data for c
	
	Node *lists = new Node[2];        //set up a dynamic array 
	for (int i = 0; i < 2; i++)
		cout << lists[i].data_in() << endl;
	
	Node *current;                    // current pointer 
	Node *head_ptr;                   //head pointer
	head_ptr = &lists[0];             //set the head pointer
	current=head_ptr;                 //set the current pointer
	head_ptr->set_data(99.1);         //set the data for the first member
	head_ptr->set_link(&lists[1]);    //set the link address
	lists[1].set_data(99.2);          //set the data for the second member
	while (current != NULL)           //display the dynamic array
	{
		cout << current->data_in() << endl;
		current=current->link_to();
	}
	return 0;
}

/*
10.21
0
20.1
99.1
99.2
Press any key to continue . . .
*/