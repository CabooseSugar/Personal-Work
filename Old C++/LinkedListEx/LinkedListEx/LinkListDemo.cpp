#include <iostream>
#include "LinkList.h"
using namespace std;

int main()
{
	double testData, searchValue;
	Node *testHeadPtr = new Node;	// creates the first node of the list, and makes testheadptr point to it in the process
	testHeadPtr->data = 9;			// fills data of first node
	testHeadPtr->link = NULL;		// makes first node not point to another. Has to be NULL or point somewhere or program will crash 
	cout << "List has been started with one node w/ data member = 9." << endl;
	cout << "List length: " << list_length(testHeadPtr) << endl;	// checks length of list, should = 1 since there's one node.

	cout << "\nEnter a value for new head node data: ";
	cin >> testData;
	
	list_head_insert(testHeadPtr, testData);	// inserts a new Node as the new first Node in the list, which the headptr (testHeadPtr) points to, and gives it data. Note testHeadPtr is still the head ptr.
	cout << "New head node succesfully created!" << endl;

	cout << "\nList length: " << list_length(testHeadPtr) << endl;	// length should now = 2

	cout << "\nCreating a new node with data member = 5.";
	testData = 5;

	list_insert(testHeadPtr, testData); // creates a new node after the previous node, in this case the one pointed to by testHeadPtr, sandwhiching it between the new first node and the original first node. Fills it with data.
	cout << "\nDone." << endl;

	cout << "\nList length: " << list_length(testHeadPtr) << endl;	// length should now = 3

	cout << "\nWill now search list for first Node containing 5 in data member.";
	searchValue = 5;

	Node *searchPtr; // initializing this ptr here just for demonstration purposes

	searchPtr = list_search(testHeadPtr, searchValue); // returns a pointer to the first Node encountered with the search value as its data member
	if (searchPtr == NULL)
		cout << "\nNot found." << endl;
	else
	{
		cout << "\nNode found containing " << searchValue << " found!" << endl
			<< "A new node will be added after this Node with data value of 6." << endl;
		testData = 6;
		list_insert(searchPtr, testData);
		cout << "... done!" << endl;
	}

	cout << "\nList length: " << list_length(testHeadPtr) << endl;	// length should now = 4, since searchPtr should != NULL.
	
	cout << "\nWill now search for the 3rd node in the linked list..." << endl;

	searchPtr = list_locate(testHeadPtr, 3); // searches list for desired node
	cout << "Found! Data in that node is = " << searchPtr->data << endl;
	
	cout << "\nThe linked list will now be copied, and a new list will be created from the copy." << endl;
	
	Node *newListHeadPtr1, *newListTailPtr1;

	list_copy(testHeadPtr, newListHeadPtr1, newListTailPtr1); // copies the list and makes newListHeadPtr and newListTailPtr the head and tail of the new list
	cout << "Done. If done correctly, the data member of the copied list's head node should = the first inputted number in the program" << endl
		<< "and the data member of the tail node should = 9 (the value of the original head node's data member, which became the tail node as we inserted nodes inbetween)." << endl;
	cout << "Head node data = " << newListHeadPtr1->data << endl;
	cout << "Tail node data = " << newListTailPtr1->data << endl;

	cout << "\nThe original list will now be deleted entirely." << endl;
	list_clear(testHeadPtr);
	cout << "...done!" << endl;

	cout << "\nA piece of the new list, the 1st node to the 3rd node, will now be copied to create another new list." << endl;

	Node *newListHeadPtr2, *newListTailPtr2;
	
	searchPtr = list_search(testHeadPtr, 6);

	list_piece(newListHeadPtr1, searchPtr, newListHeadPtr2, newListTailPtr2);
	
	cout << "Done. If done correctly, the data member of the copied list's head node should again = the first inputted number in the program" << endl
		<< "and the data member of the tail node should = 6 (the data member value that in the other list was in the 3rd node)." << endl;
	cout << "Head node data = " << newListHeadPtr2->data << endl;
	cout << "Tail node data = " << newListTailPtr2->data << endl;
	
		
	return 0;
}
