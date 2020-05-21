/*********************************************************
* file name: Wolf_9_6.cpp
* programmer name: Kyle Wolf
* date created: 4/20/18
* date of last revision: 4/20/18
* details of the revision: none
* short description: Use a recursive function to find the possible number of combinations 
					 to pick one object from a set of objects
**********************************************************/

#include <iostream>
#include <cctype>
using namespace std;

double getCombos(double r, double n);
// Postcondition: The possible amount of combinations to pick r objects from a set of n objects has been returned
double factorial(double x);
// Postcondition: The value of x! has been returned 

int main()
{
	// Variable declarations
	double numSelected, total, result;
	char more;

	// Program Description
	cout << "This program will calculate the number of ways to choose a number of objects from a set of objects." << endl;
	
	// Variable initialization 
	while (1)
	{
		while (1)
		{
			cout << "\nEnter the total number of objects in the set: ";
			cin >> total;
			if (total < 1)
			{
				cout << "\nEntry must be a number above 0." << endl;
				continue;
			}
			cout << "Enter the number of objects you wish to choose from the set: ";
			cin >> numSelected;

			if (numSelected > total)
				cout << "\nEntry must be less than or equal to the total number of objects in the set" << endl;
			else if (numSelected < 1)
				cout << "\nEntry must be a number above 0." << endl;
			else
				break;
		}

		// Function call
		result = getCombos(numSelected, total);

		// Display the result
		cout << "\nThe number of different ways to choose " << numSelected << " from a set of " << total << " is " << result << "." << endl;

		// Check to see if user wants to go again
		while (1)
		{
			cout << "\nEnter another set? (Y/y for Yes, N/n for No): ";
			cin >> more;

			more = toupper(more);
			if (more == 'Y')
				break;
			else if (more == 'N')
			{
				cout << "\nGoodbye!" << endl;
				return 0;
			}
			else
				cout << "\nInvalid entry." << endl;
		}
	}
}

double getCombos(double r, double n)
{
	double c;
	c = factorial(n) / (factorial(r) * factorial(n - r));
	
	return c;
}

// recursive function for finding the values of the factorials
double factorial(double x)
{
	// stop condition
	if (x == 1)
		return 1;
	// recursive call
	else
		return x * factorial(x - 1);
}

/*
This program will calculate the number of ways to choose a number of objects from a set of objects.

Enter the total number of objects in the set: 0

Entry must be a number above 0.

Enter the total number of objects in the set: 10
Enter the number of objects you wish to choose from the set: 13

Entry must be less than or equal to the total number of objects in the set

Enter the total number of objects in the set: 10
Enter the number of objects you wish to choose from the set: 0

Entry must be a number above 0.

Enter the total number of objects in the set: 10
Enter the number of objects you wish to choose from the set: 3

The number of different ways to choose 3 from a set of 10 is 120.

Enter another set? (Y/y for Yes, N/n for No): g

Invalid entry.

Enter another set? (Y/y for Yes, N/n for No): y

Enter the total number of objects in the set: 30
Enter the number of objects you wish to choose from the set: 2

The number of different ways to choose 2 from a set of 30 is 435.

Enter another set? (Y/y for Yes, N/n for No): Y

Enter the total number of objects in the set: 4
Enter the number of objects you wish to choose from the set: 3

The number of different ways to choose 3 from a set of 4 is 4.

Enter another set? (Y/y for Yes, N/n for No): n

Goodbye!
Press any key to continue . . .
*/