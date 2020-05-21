/**************************************************************************************
* file name: Wolf_6_1
* programmer name: Kyle Wolf
* date created: 3/29/2018
* date of last revision: 4/29/18
* details of the revision: Put in test values for new sort function, adjusted to work for template
* short description: Fill two lists of different data types and sort them
***************************************************************************************/
#include "List.h"
#include <iostream>
using namespace std;

int main()
{
	// Program description
	cout << "This program will create two lists of that use different" << endl
		<< "data types for the value stored within a node, then sort the lists." << endl;

	// Declaring two lists - one for ints, one for doubles
	List<int> testList;
	List<int>::Node* headPtr = NULL;

	List<double> testList2;
	List<double>::Node* headPtr2 = NULL;

	// Filling the int list
	testList.list_head_insert(headPtr, 8);
	testList.list_head_insert(headPtr, 9);
	testList.list_tail_insert(headPtr, 4);
	testList.list_tail_insert(headPtr, 6);
	testList.list_tail_insert(headPtr, 1);
	
	// Displaying the int list
	cout << "\nLIST 1:" << endl;
	testList.listDisplay(headPtr);
	
	// Sorting and displaying the int list
	cout << "\nSORTED LIST 1:" << endl;
	testList.sort_list(headPtr);
	testList.listDisplay(headPtr);

	// Filling the double list
	testList2.list_head_insert(headPtr2, 2.5);
	testList2.list_tail_insert(headPtr2, 6);
	testList2.list_tail_insert(headPtr2, 8.99);
	testList2.list_tail_insert(headPtr2, 4.0);
	testList2.list_tail_insert(headPtr2, 4.0);
	testList2.list_tail_insert(headPtr2, 9.01);
	testList2.list_tail_insert(headPtr2, 3.33);

	// Displaying the double list
	cout << "\nLIST 2:" << endl;
	testList2.listDisplay(headPtr2);

	// Sorting and displaying the double list
	cout << "\nSORTED LIST 2:" << endl;
	testList2.sort_list(headPtr2);
	testList2.listDisplay(headPtr2);

	return 0;
}

/*
This program will create two lists of that use different
data types for the value stored within a node, then sort the lists.

LIST 1:
Item 1: 9
Item 2: 8
Item 3: 4
Item 4: 6
Item 5: 1

SORTED LIST 1:
Item 1: 1
Item 2: 4
Item 3: 6
Item 4: 8
Item 5: 9

LIST 2:
Item 1: 2.5
Item 2: 6
Item 3: 8.99
Item 4: 4
Item 5: 4
Item 6: 9.01
Item 7: 3.33

SORTED LIST 2:
Item 1: 2.5
Item 2: 3.33
Item 3: 4
Item 4: 4
Item 5: 6
Item 6: 8.99
Item 7: 9.01
Press any key to continue . . .
*/