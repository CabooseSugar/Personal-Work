// stackClassDemo2.cpp

/*
Implement the Dynamically Linked Stack, the program should prompt the user to:
Enter as many names as you wish, one per line
To stop entering names, enter a single x
*/

#include <iostream>
#include <string>
#include "StackClass2.h"
using namespace std;

int main()
{
	char input[30] = "";
	char * ptr;
	Stack container;

	cout << "Type in as many names as you wish, one per line." << endl
		<< "To stop entering names, enter a single x on a line." << endl;

	while (input[0] != 'x' && input[0] != 'X')
	{
		cin >> input;
		if (input[0] == 'x' || input[0] == 'X')
			break;
		ptr = input;
		container.push(ptr);
	}

	container.printStack();

	cout << endl;

	while (!container.isEmpty())
	{
		cout << container.pop() << endl;
	}

	return 0;
}





