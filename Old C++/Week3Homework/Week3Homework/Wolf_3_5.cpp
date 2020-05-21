/**************************************************************************************
* file name: Wolf_3_5
* programmer name: Kyle Wolf
* date created: 2/2/2018
* date of last revision:
* details of the revision:
* short description: User creates sets of ages and can perform operations on those sets
***************************************************************************************/

#include <iostream>   
#include <cstdlib>    
#include <iomanip>
#include "Set.h"      

using namespace std;
using namespace wolf_set;

void getAges(Set&);
// Postcondition: The user has been prompted to enter a range of ages,
// these ages have been entered into the ages set, stopping when the
// set is full or a negative number is entered
void eraseAges(Set&);
// Postcondition: The user has been prompted to enter ages,
// these ages have been erased from the set, stopping when
// the user enters a negative number
void addOn(Set&);
// Postcondition: The user has been prompted to enter ages for a new set,
// the age values in this set have been added on to the existing set
void subtractFrom(Set&);
// Postcondition: The user has been prompted to enter ages for a new set,
// the age values in this set have been subtracted from the existing set,
// new values introduced in the subtractor set are discarded
void addTwo(Set&);
// Postcondition: The user has been prompted to enter ages for two new sets,
// these ages have been added together to form a brand new set
void subtractTwo(Set&);
// Postcondition: The user has been prompted to enter ages for two new sets,
// the values of the first being subtracted by those of the second,
// new values introduced in the second set are discarded


int main( )
{
	// Program description
	cout << "This program will allow the user to enter" << endl
		<< "ages into a set and perform operations on those ages.\n";

	// Declaring the variables / objects
	Set ageSet;
	int selection;

	while (1) 
	{
		cout << "\n----------------------------------------------------------------------" << endl
			<< setw(35) << ' ' << "MAIN MENU" << endl
			<< " 1. Add ages to set" << endl
			<< " 2. View ages" << endl
			<< " 3. Erase ages from set " << endl
			<< " 4. Add contents of a new set to the existing set" << endl
			<< " 5. Subtract identical ages of a new set from the existing set" << endl
			<< " 6. Obtain a fresh set by adding two sets' values together" << endl
			<< " 7. Obtain a fresh set by subtracting one new set's ages from another's" << endl
			<< " 8. Quit" << endl
			<< "----------------------------------------------------------------------" << endl;

		// Variable initialization
		cout << "Enter selection: ";
		cin >> selection;

		// Switch statement for menu selection
		switch (selection) {
		case 1:
			getAges(ageSet);
			break;
		case 2:
			ageSet.displayData();
			break;
		case 3: 
			eraseAges(ageSet);
			break;
		case 4: 
			addOn(ageSet);
			break;
		case 5:
			subtractFrom(ageSet);
			break;
		case 6:
			addTwo(ageSet);
			break;
		case 7:
			subtractTwo(ageSet);
			break;
		case 8:
			cout << "\nGoodbye!" << endl;
				return EXIT_SUCCESS;
		default: 
			cout << "\nInvalid entry." << endl;
		}
	}
}

void getAges(Set& ages)
{
	// Declaring the variables / objects
    int user_input;

	// Variable initialization
    cout << "\nEnter the desired ages." << endl;
    cout << "Type a negative number when you are done:" << endl;
    cin >> user_input;
    
	// Check that capacity isn't gone over, then check if new value is a duplicate, otherwise, insert value
	while (user_input >= 0)
    {
		if (ages.size() < ages.CAPACITY) 
			if (!ages.contains(user_input)) 
				ages.insert(user_input);
			else 
				cout << "Duplicate ages cannot be entered." << endl;
        else 
            cout << "I have run out of room and can’t add that age." << endl;
        cin >> user_input;
    }
}

void eraseAges(Set& ages)
{
	// Declaring the variables / objects
    int user_input = 0;

	cout << "\nAt any point, enter a negative number to go back to the Main Menu." << endl;

	// Variable initialization, remove from set if present
	while (user_input >= 0) {
		cout << "Enter age to be deleted: ";
		cin >> user_input;

		if (ages.erase_one(user_input))
			cout << "Age removed." << endl;
		else if (user_input < 0)
			break;
		else
			cout << "Age does not occur." << endl;
	}
}

void addOn(Set& ages)
{
	// Declaring the variables / objects
	Set addAges;
	
	cout << "\nADD-ON SET:";
	
	getAges(addAges);
	// Overload operator use
	ages += addAges;

	cout << "\nSet succesfully added on to original set." << endl;
}

void subtractFrom(Set& ages)
{
	// Declaring the variables / objects
	Set subtAges;

	cout << "\nSUBTRACTOR SET:";

	getAges(subtAges);
	// Overload operator use
	ages -= subtAges;

	cout << "\nSet succesfully subtracted from original set." << endl;
}

void addTwo(Set& ages)
{
	// Declaring the variables / objects
	Set ages1, ages2;

	cout << "\nFIRST SET:";
	getAges(ages1);
	cout << "\nSECOND SET:";
	getAges(ages2);
	// Overload operator use
	ages = ages1 + ages2;

	cout << "\nNew set succesfully created." << endl;
}

void subtractTwo(Set& ages)
{
	// Declaring the variables / objects
	Set ages1, ages2;

	cout << "\nBASE SET:";
	getAges(ages1);
	cout << "\nSUBTRACTOR:";
	getAges(ages2);
	// Overload operator use
	ages = ages1 - ages2;

	cout << "\nNew set succesfully created." << endl;
}

/*
This program will allow the user to enter
ages into a set and perform operations on those ages.

----------------------------------------------------------------------
MAIN MENU
1. Add ages to set
2. View ages
3. Erase ages from set
4. Add contents of a new set to the existing set
5. Subtract identical ages of a new set from the existing set
6. Obtain a fresh set by adding two sets' values together
7. Obtain a fresh set by subtracting one new set's ages from another's
8. Quit
----------------------------------------------------------------------
Enter selection: 10

Invalid entry.

----------------------------------------------------------------------
MAIN MENU
1. Add ages to set
2. View ages
3. Erase ages from set
4. Add contents of a new set to the existing set
5. Subtract identical ages of a new set from the existing set
6. Obtain a fresh set by adding two sets' values together
7. Obtain a fresh set by subtracting one new set's ages from another's
8. Quit
----------------------------------------------------------------------
Enter selection: -9

Invalid entry.

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 1

Enter the desired ages.
Type a negative number when you are done:
10
20
30
-1

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 3

At any point, enter a negative number to go back to the Main Menu.
Enter age to be deleted: 10
Age removed.
Enter age to be deleted: 30
Age removed.
Enter age to be deleted: -1

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 2
20

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 4

ADD-ON SET:
Enter the desired ages.
Type a negative number when you are done:
50
60
-1

Set succesfully added on to original set.

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 2
20 50 60

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 5

SUBTRACTOR SET:
Enter the desired ages.
Type a negative number when you are done:
50
60
70
-1

Set succesfully subtracted from original set.

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 2
20

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 6

FIRST SET:
Enter the desired ages.
Type a negative number when you are done:
10
20
30
40
-1

SECOND SET:
Enter the desired ages.
Type a negative number when you are done:
40
50
60
-1

New set succesfully created.

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 2
10 20 30 40 60 50

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 7

BASE SET:
Enter the desired ages.
Type a negative number when you are done:
90
80
70
60
-1

SUBTRACTOR:
Enter the desired ages.
Type a negative number when you are done:
70
60
-1

New set succesfully created.

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 2
90 80

----------------------------------------------------------------------
                                   MAIN MENU
 1. Add ages to set
 2. View ages
 3. Erase ages from set
 4. Add contents of a new set to the existing set
 5. Subtract identical ages of a new set from the existing set
 6. Obtain a fresh set by adding two sets' values together
 7. Obtain a fresh set by subtracting one new set's ages from another's
 8. Quit
----------------------------------------------------------------------
Enter selection: 8

Goodbye!
Press any key to continue . . .
*/