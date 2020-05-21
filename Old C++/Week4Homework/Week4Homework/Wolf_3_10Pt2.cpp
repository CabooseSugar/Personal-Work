/**************************************************************************************
* file name: Wolf_3_10Pt2.cpp
* programmer name: Kyle Wolf
* date created: 2/9/2018
* date of last revision:
* details of the revision:
* short description: Use Tictac class to have two objects play against each other
***************************************************************************************/
#include <iostream>    
#include <cstdlib>   
#include <iomanip>
#include "Tictac.h"     
using namespace std;
using namespace wolf_tictac;

void viewBoard(Tictac first);
// Postcondition: The board has been displayed
void takeTurn(Tictac& first, Tictac& second, int& turn);
// Postcondition: A turn by either the X or O player has been taken
void resetBoard(Tictac& first, Tictac& second, int&);
// Postcondition: The board has been reset

int main()
{
	// Program description
	cout << "This program will allow the user to have" << endl
		<< "two objects play Tic Tac Toe against each other.\n";

	// Declaring the variables / objects
	Tictac firstPlayer, secondPlayer;
	int selection, turnCount = 1;
	
	// Menu
	while (1)
	{
		cout << "\n------------------" << endl
			<< setw(4) << ' ' << "MAIN MENU" << endl
			<< " 1. View board" << endl
			<< " 2. Advance turn" << endl
			<< " 3. Restart game" << endl
			<< " 4. Quit" << endl
			<< "------------------" << endl;

		// Variable initialization
		cout << "Enter selection: ";
		cin >> selection;

		switch (selection) {
		case 1:
			viewBoard(firstPlayer);
			break;
		case 2:
			takeTurn(firstPlayer, secondPlayer, turnCount);
			break;
		case 3:
			resetBoard(firstPlayer, secondPlayer, turnCount);
			break;
		case 4:
			cout << "\nGoodbye!" << endl;
			return 0;
		default:
			cout << "\nInvalid entry." << endl;
		}
	}
}

void viewBoard(Tictac first)
{
	first.display();
}

void takeTurn(Tictac& firstPlayer, Tictac& secondPlayer, int& turns)
{
	char firstSymbol = 'X', secondSymbol = 'O';

	// Since X always goes first (so the order of turns is predetermined) as long as the obect
	// with the base array in the += operation is also the one being updated next, the compTurn 
	// member function will stop any overwrites from happening
	
	if (turns % 2 == 0)
	{
		secondPlayer.compTurn('O');
		firstPlayer += secondPlayer;
		cout << "\nO Player turn complete." << endl;
	}
	else
	{
		firstPlayer.compTurn(firstSymbol);
		secondPlayer += firstPlayer;
		cout << "\nX Player turn complete." << endl;
	}

	turns++;
	firstPlayer.winCheck(turns);
}

void resetBoard(Tictac& first, Tictac& second, int& turn)
{
	// Resets board and turn count manually
	first.reset();
	second.reset();
	turn = 1;
	cout << "\nBoard has been reset." << endl;
}

/*
This program will allow the user to have
two objects play Tic Tac Toe against each other.

------------------
MAIN MENU
1. View board
2. Advance turn
3. Restart game
4. Quit
------------------
Enter selection: 0

Invalid entry.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 5

Invalid entry.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

           |   |
        -----------
           |   |
        -----------
           |   |

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

           |   |
        -----------
           |   | X
        -----------
           |   |

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

O Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

           |   |
        -----------
           |   | X
        -----------
           |   | O

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 3

Board has been reset.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

O Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

           |   |
        -----------
           | O |
        -----------
           | X | X

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

O Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

           | O |
        -----------
           | O |
        -----------
           | X | X

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

           | O |
        -----------
         X | O |
        -----------
           | X | X

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

O Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

         O | O |
        -----------
         X | O |
        -----------
           | X | X

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

         O | O | X
        -----------
         X | O |
        -----------
           | X | X

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

O Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

         O | O | X
        -----------
         X | O |
        -----------
         O | X | X

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

         O | O | X
        -----------
         X | O | X
        -----------
         O | X | X

Player X has won! Resetting board...

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

O Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

O Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

O Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

         X | X |
        -----------
         O | O | X
        -----------
           | X | O

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

O Player turn complete.

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 1

         X | X | O
        -----------
         O | O | X
        -----------
           | X | O

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 2

X Player turn complete.

         X | X | O
        -----------
         O | O | X
        -----------
         X | X | O

Draw. Resetting board...

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection:

------------------
    MAIN MENU
 1. View board
 2. Advance turn
 3. Restart game
 4. Quit
------------------
Enter selection: 4

Goodbye!
Press any key to continue . . .
*/