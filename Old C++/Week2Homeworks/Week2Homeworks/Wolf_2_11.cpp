/*********************************************************
* file name: Wolf_2_11.cpp
* programmer name: Kyle Wolf
* date created: 1/24/2018
* date of last revision: 1/24/2018
* details of the revision:
* short description:  Generate a psuedorandom sequence
**********************************************************/

#include <iostream>
#include <iomanip>
#include "Random.h"
using namespace std;
using namespace wolf_randomNum;

int main()
{
	// Program description
	cout << "This program will evaluate and allow the user to generate" << endl
		<< "a psuedorandom sequence.\n";

	// Declaring the variables: types and names
	int selection, seed;
	Random num;
	bool isDone = false	;

	while (!isDone) {
		cout << "\n------------------------------------------" << endl
			<< setw(10) << ' ' << "MAIN MENU" << endl
			<< " 1. Change the seed value (default to 0)" << endl
			<< " 2. View a random number sequence" << endl
			<< " 3. Quit" << endl
			<< "------------------------------------------" << endl;

		// Variable initialization: getting the input from the user
		cout << "Enter selection: ";
		cin >> selection;

		switch (selection) {
		case 1:
			cout << "\nEnter a seed value: ";
			cin >> seed;
			// Set seed value
			num.setSeed(seed);
			break;
		case 2:
			cout << "\nSequence: ";
			// Generate sequence of 10 psuedorandom numbers
			for (int i = 0; i < 10; i++)
				 cout << num.genRandNum() << ' ';
			cout << endl;
			break;
		case 3:
			isDone = true;
			break;
		default:
			cout << "\nInvalid entry." << endl;
		}
	}

	cout << "\nGoodbye!" << endl << endl;
		
		return 0;
	}

/*
This program will evaluate and allow the user to generate
a psuedorandom sequence.

------------------------------------------
          MAIN MENU
 1. Change the seed value (default to 0)
 2. View a random number sequence
 3. Quit
------------------------------------------
Enter selection: 8

Invalid entry.

------------------------------------------
          MAIN MENU
 1. Change the seed value (default to 0)
 2. View a random number sequence
 3. Quit
------------------------------------------
Enter selection: 2

Sequence: 725 565 726 605 139 453 620 10 396 527

------------------------------------------
          MAIN MENU
 1. Change the seed value (default to 0)
 2. View a random number sequence
 3. Quit
------------------------------------------
Enter selection: 2

Sequence: 664 312 83 400 687 503 433 549 86 520

------------------------------------------
          MAIN MENU
 1. Change the seed value (default to 0)
 2. View a random number sequence
 3. Quit
------------------------------------------
Enter selection: 1

Enter a seed value: 5

------------------------------------------
          MAIN MENU
 1. Change the seed value (default to 0)
 2. View a random number sequence
 3. Quit
------------------------------------------
Enter selection: 2

Sequence: 384 47 418 678 143 613 459 131 133 213

------------------------------------------
          MAIN MENU
 1. Change the seed value (default to 0)
 2. View a random number sequence
 3. Quit
------------------------------------------
Enter selection: 3

Goodbye!

Press any key to continue . . .
*/