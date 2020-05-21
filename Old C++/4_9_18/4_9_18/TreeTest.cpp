#include <iostream>
using namespace std;

// Parent = [(i-1)/2]
// Left Child = [i*2+1]
// Right child = [i*2+2]

// fill in spots in the array with -1 representing missing nodes. Then you go 
// Root, left child, right, child, left child of that left child, right child of that left child
// then left child of that right child, right child of that right child, etc, etc...

int main()
{
	const int MAXSIZE = 9;
	int arr[MAXSIZE];
	int test, parent, leftChild, rightChild;

	for (int i = 0; i < MAXSIZE; i++)
	{
		cout << "Enter value " << i + 1 << ": ";
		cin >> arr[i];
	}
		
	cout << "\nEnter the value of a child to get its parent: ";
	cin >> test;

	for (int i = 0; i < MAXSIZE; i++)
	{
		if (test == arr[i])
		{
			parent = arr[((i - 1) / 2)];
			leftChild = arr[i * 2 + 1];
			rightChild = arr[i * 2 + 2];
			break;
		}
	}

	if (parent == -1)
		cout << "\nNo parent." << endl;
	else
		cout << "\nThe value of the parent is: " << parent << endl;
	
	if (leftChild == -1)
		cout << "No left child." << endl;
	else
		cout << "The value of the left child is: " << leftChild << endl;
	
	if (rightChild == -1)
		cout << "No right chld." << endl;
	else
		cout << "The value of the right child is: " << rightChild << endl;

	return 0;
}
