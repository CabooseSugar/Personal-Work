/**************************************************************************************
* file name: Wolf_3_10Pt1.cpp
* programmer name: Kyle Wolf
* date created: 2/6/2018
* date of last revision:
* details of the revision:
* short description: Use Tictac class to play a game of Tic-Tac-Toe with program
***************************************************************************************/
#include <iostream>    
#include <cstdlib>   
#include <iomanip>
#include "Tictac.h"     
using namespace std;
using namespace wolf_tictac;

void changeSymbol(char&, char&);
// Postcondition: The symbol the user wants to use has been changed
void viewBoard(Tictac game);
// Postcondition: The board has been displayed
void takeTurn(Tictac& game, char, char, int&);
// Postcondition: A turn, either the player's or "computer's" has been taken
void spaceSelection(Tictac& game, char, int&);
// Postcondition: Called inside takeTurn, the player has chosen a space to put their symbol on their turn
void resetBoard(Tictac& game, int&);
// Postcondition: The board has been reset

int main()
{
	// Program description
	cout << "This program will allow the user to play" << endl
		<< "Tic Tac Toe.\n";

	// Declaring the variables / objects
	Tictac game;
	int selection, turnCount = 1;
	char currentSymbol = 'X', oppSymbol = 'O';

	// Menu
	while(1)
	{
		cout << "\n---------------------------------------" << endl
			<< setw(15) << ' ' << "MAIN MENU" << endl
			<< " 1. Change player symbol (defaults to X)" << endl
			<< " 2. View board" << endl
			<< " 3. Advance turn" << endl
			<< " 4. Restart game" << endl
			<< " 5. Quit" << endl
			<< "---------------------------------------" << endl;

		// Variable initialization
		cout << "Enter selection: ";
		cin >> selection;

		switch (selection) {
		case 1:
			changeSymbol(currentSymbol, oppSymbol);
			break;
		case 2:
			viewBoard(game);
			break;
		case 3:
			takeTurn(game, currentSymbol, oppSymbol, turnCount);
			break;
		case 4:
			resetBoard(game, turnCount);
			break;
		case 5:
			cout << "\nGoodbye!" << endl;
			return 0;
		default:
			cout << "\nInvalid entry." << endl;
		}
	} 
} 

void changeSymbol(char& playerSymbol, char& compSymbol)
{
	while (1)
	{
		// Assigning new value to variable
		cout << "\nEnter desired symbol to play as (X or O): ";
		cin >> playerSymbol;

		// Check for validity
		if (playerSymbol != 'X' && playerSymbol != 'O')
			cout << "\nInvalid entry." << endl;
		else
			break;
	}

	// Set computer's symbol in response to desired symbol of player
	if (playerSymbol == 'X')
		compSymbol = 'O';
	else
		compSymbol = 'X';
}

void viewBoard(Tictac game)
{
	game.display();
}

void takeTurn(Tictac& game, char playerSymbol, char compSymbol, int& turns)
{
	// X player always goes first. Checks if it is the second (or fourth, or sixth, etc) turn and whether player
	// should be going before or after the computer based on their desired symbol. Will call spaceSelection on
	// player's turn to read their move
	if (turns % 2 == 0)
		if (playerSymbol == 'O')
			spaceSelection(game, playerSymbol, turns);
		else
		{
			game.compTurn(compSymbol);
			cout << "\nComputer turn taken." << endl;
		}
	
	else 
		if (playerSymbol == 'X')
			spaceSelection(game, playerSymbol, turns);
		else
		{
			game.compTurn(compSymbol);
			cout << "\nComputer turn taken." << endl;
		}
	
	// Increments turns, but winCheck will reset to 1 if it detects a draw or victory
	turns++;
	game.winCheck(turns);
}

void spaceSelection(Tictac& game, char playerSymbol, int& turns) {
	int i, locationSelect;
	bool inputSuccess = false;

	// Display a menu of choices of where to put symbol based on board labelled 1 - 9 
	cout << "\n\t ";
	for (i = 1; i < 3; i++)
		cout << i << " | ";
	cout << i << endl
		<< "\t-----------" << endl;
	cout << "\t ";
	for (i = 4; i < 6; i++)
		cout << i << " | ";
	cout << i << endl
		<< "\t-----------" << endl;
	cout << "\t ";
	for (i = 7; i < 9; i++)
		cout << i << " | ";
	cout << i << endl;
	
	// While this function will catch an entry outside of the 1 - 9 range, game.playerTurn will catch 
	// entries made to spots that are already filled. This is the purpose of playerTurn returning a bool,
	// which is assigned to inputSuccess
	do
	{
		// Variable initialization
		cout << "\nEnter location to put symbol: ";
		cin >> locationSelect;

		// Validity check
		if (locationSelect < 1 || locationSelect > 9)
		{
			cout << "\nInvalid entry." << endl;
			continue;
		}

		inputSuccess = game.playerTurn(playerSymbol, locationSelect);
	} while (inputSuccess == false);
}

void resetBoard(Tictac& game, int& turn)
{
	// Resets board and turn count manually
	game.reset();
	turn = 1;
	cout << "\nBoard has been reset." << endl;
}

/*
This program will allow the user to enter
ages into a set and perform operations on those ages.

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 0

Invalid entry.

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 6

Invalid entry.

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           |   |
        -----------
           |   |
        -----------
           |   |

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

         1 | 2 | 3
        -----------
         4 | 5 | 6
        -----------
         7 | 8 | 9

Enter location to put symbol:
9

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

Computer turn taken.

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           |   |
        -----------
           |   | O
        -----------
           |   | X

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

         1 | 2 | 3
        -----------
         4 | 5 | 6
        -----------
         7 | 8 | 9

Enter location to put symbol: 6

Space is already occupied.

Enter location to put symbol: 3

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           |   | X
        -----------
           |   | O
        -----------
           |   | X

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

Computer turn taken.

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           |   | X
        -----------
           |   | O
        -----------
           | O | X

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

         1 | 2 | 3
        -----------
         4 | 5 | 6
        -----------
         7 | 8 | 9

Enter location to put symbol: 2

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

Computer turn taken.

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           | X | X
        -----------
           | O | O
        -----------
           | O | X

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

         1 | 2 | 3
        -----------
         4 | 5 | 6
        -----------
         7 | 8 | 9

Enter location to put symbol: 7

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           | X | X
        -----------
           | O | O
        -----------
         X | O | X

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

Computer turn taken.

           | X | X
        -----------
         O | O | O
        -----------
         X | O | X

Player O has won! Resetting board...

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           |   |
        -----------
           |   |
        -----------
           |   |

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 1

Enter desired symbol to play as (X or O): g

Invalid entry.

Enter desired symbol to play as (X or O): O

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

Computer turn taken.

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           |   |
        -----------
           |   | X
        -----------
           |   |

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

         1 | 2 | 3
        -----------
         4 | 5 | 6
        -----------
         7 | 8 | 9

Enter location to put symbol: 8

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

Computer turn taken.

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           |   |
        -----------
           |   | X
        -----------
           | O | X

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

         1 | 2 | 3
        -----------
         4 | 5 | 6
        -----------
         7 | 8 | 9

Enter location to put symbol: 4

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

Computer turn taken.

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           |   |
        -----------
         O | X | X
        -----------
           | O | X

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

         1 | 2 | 3
        -----------
         4 | 5 | 6
        -----------
         7 | 8 | 9

Enter location to put symbol: 3

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

Computer turn taken.

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 2

           | X | O
        -----------
         O | X | X
        -----------
           | O | X

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

         1 | 2 | 3
        -----------
         4 | 5 | 6
        -----------
         7 | 8 | 9

Enter location to put symbol: 1

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 3

Computer turn taken.

         O | X | O
        -----------
         O | X | X
        -----------
         X | O | X

Draw. Resetting board...

---------------------------------------
               MAIN MENU
 1. Change player symbol (defaults to X)
 2. View board
 3. Advance turn
 4. Restart game
 5. Quit
---------------------------------------
Enter selection: 5

Goodbye!
Press any key to continue . . .
*/