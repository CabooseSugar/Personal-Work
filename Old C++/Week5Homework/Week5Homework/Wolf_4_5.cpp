/**************************************************************************************
* file name: Wolf_4_5.cpp
* programmer name: Kyle Wolf
* date created: 2/15/2018
* date of last revision:
* details of the revision:
* short description: Allow the user to edit a list of chores
***************************************************************************************/
#include <iostream>    
#include <cstdlib>   
#include <iomanip>
#include <string>
#include "chores.h"     
using namespace std;
using namespace wolf_chores;

void addChore(choreBag&);
// Postcondition: An original chore has been added to the list
void checkLength(choreBag);
// Postcondition: The length of the chore list has been printed to the screen
void seeList(choreBag);
// Postcondition: The list of chores has been printed to the screen
void removeChore(choreBag&);
// Postcondition: A chore has been removed from the list


int main()
{
	// Program description
	cout << "This program will allow the user to enter a list of chores." << endl;

	// Declaring the variables / objects
	choreBag choreList;
	int selection;

	// Selection menu
	while (1)
	{
		cout << "\n---------------------------------------" << endl
			<< setw(15) << ' ' << "MAIN MENU" << endl
			<< " 1. Add item to chore list" << endl
			<< " 2. Check number of chores on list" << endl
			<< " 3. View entered chores" << endl
			<< " 4. Delete chore" << endl
			<< " 5. Quit" << endl
			<< "---------------------------------------" << endl;

		// Variable initialization
		cout << "Enter selection: ";
		cin >> selection;

		switch (selection) {
		case 1:
			addChore(choreList);
			break;
		case 2:
			checkLength(choreList);
			break;
		case 3:
			seeList(choreList);
			break;
		case 4:
			removeChore(choreList);
			break;
		case 5:
			cout << "\nGoodbye!" << endl;
			return 0;
		default:
			cout << "\nInvalid entry." << endl;
		}
	}
}

void addChore(choreBag& choreList)
{
	// Declaring the variables
	string newChore;
	
	// Variable initialization
	cout << "\nEnter a new chore: ";
	cin.ignore();
	getline(cin, newChore);
	
	// Check if entry is already in the list
	if (choreList.isInBag(newChore) == true)
	{
		cout << "\nThat chore is already in the list." << endl;
		return;
	}

	// Insert entry into list if original
	choreList.insert(newChore);

	cout << "\nChore succesfully entered!" << endl;
}

void checkLength(choreBag choreList)
{
	// Display the results
	cout << "\nThe size of the chore list is: " << choreList.size() << endl;
}

void seeList(choreBag choreList)
{
	// Display the results
	choreList.viewItems();
}

void removeChore(choreBag& choreList)
{
	// Declaring the variables
	bool isInList;
	string removedChore;
	
	// Variable initialization
	cout << "\nEnter chore to be removed from list: ";
	cin.ignore();
	getline(cin, removedChore);

	// Check if entered chore is in list, if it is, deletes it
	isInList = choreList.eraseItem(removedChore);
	
	if (isInList == false)
		cout << "\nChore not in list." << endl;
	else
		cout << "\nChore successfully removed!" << endl;
}

/*
This program will allow the user to enter a list of chores.

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 2

The size of the chore list is: 0

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 3

List is empty.

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 4

Enter chore to be removed from list: Wash dishes

Chore not in list.

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 1

Enter a new chore: Wash dishes

Chore succesfully entered!

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 1

Enter a new chore: Wash dishes

That chore is already in the list.

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 1

Enter a new chore: Clean room

Chore succesfully entered!

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 1

Enter a new chore: Feed dog

Chore succesfully entered!

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 2

The size of the chore list is: 3

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 3

CHORE LIST:
1) Wash dishes
2) Clean room
3) Feed dog

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 4

Enter chore to be removed from list: Clean room

Chore successfully removed!

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 2

The size of the chore list is: 2

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 3

CHORE LIST:
1) Wash dishes
2) Feed dog

---------------------------------------
               MAIN MENU
 1. Add item to chore list
 2. Check number of chores on list
 3. View entered chores
 4. Delete chore
 5. Quit
---------------------------------------
Enter selection: 5

Goodbye!
Press any key to continue . . .
*/