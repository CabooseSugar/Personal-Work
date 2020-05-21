/**************************************************************************************
* file name: Tictac.cpp
* programmer name: Kyle Wolf
* date created: 2/6/2018
* date of last revision: 2/9/19
* details of the revision: Added definition of += operator
* short description: Define member and nonmember functions of the Tictac class
***************************************************************************************/

// INVARIANT for the Tictac class:
//   1. The number of meaningful items in Tictac is in the member variable place;
//   2. An "empty" Tictac bag, is really stored with ' ' character; for a
//      non-empty Tictac bag, the items in the bag are stored in data[0] through
//      data[place] in no particular order as the 'X' or 'O' character,
//		and we don't care what's in the rest of data.

#define _SCL_SECURE_NO_WARNINGS  

#include <iostream>
#include "Tictac.h"
using namespace std;

namespace wolf_tictac
{
	Tictac::Tictac()
	{
		for (place = 0; place < CAPACITY; place++)
			data[place] = ' ';
	}
	
	void Tictac::display() const
	{
		// Postcondition: The tic tac toe board has been displayed
		int i;

		cout << "\n\t ";
		for (i = 0; i < 2; i++)
			cout << data[i] << " | ";
		cout << data[i] << endl
			<< "\t-----------" << endl;
		cout << "\t ";
		for (i = 3; i < 5; i++)
			cout << data[i] << " | ";
		cout << data[i] << endl
			<< "\t-----------" << endl;
		cout << "\t ";
		for (i = 6; i < 8; i++)
			cout << data[i] << " | ";
		cout << data[i] << endl;
	}
	
	bool Tictac::playerTurn(const char entry, const int location)
	{
		// Postcondition: The user's symbol has been put on to the board unless the space was occupied.
		// True or false was returned to let function in main know whether the user must
		// re-enter their desired location

		// Since location is based on what user sees on labelled 1 - 9 board, have to subtract one for array navigation to start at 0
		place = location - 1;

		// Check that space is empty, bool result is returned to spaceSelection function 
		if (data[place] != ' ')
		{
			cout << "\nSpace is already occupied." << endl;
			return false;
		}
		else
		{
			data[place] = entry;
			
			return true;
		}
	}
	
	void Tictac::compTurn(const char entry)
	{
		// Postcondition: The "computer' has put its symbol in a psuedorandom empty spot on the board
		while (1) {
			place = rand() % 9;

			if (data[place] == ' ')
				break;
		}

		data[place] = entry;
	}
	
	void Tictac::reset()
		// Postcondition: The board has been reset, the array filled back up with the ' ' character.
	{
		for (int i = 0; i < CAPACITY; i++)
			data[i] = ' ';
	}
	
	void Tictac::winCheck(value_type& turn) 
		// Postcondition: The board has been checked for all possible win conditions
		// or the possibility of a draw. If either a win or draw is detected,
		// resets game and sets number of turns back to 1.
	{
		int i;
		bool anyEmpty = false;

		// Checking for top 3 in a row
		i = 0;
		if (data[i] == 'X' && data[i + 1] == 'X' && data[i + 2] == 'X')
		{
			display();
			cout << "\nPlayer X has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		else if (data[i] == 'O' && data[i + 1] == 'O' && data[i + 2] == 'O')
		{
			display();
			cout << "\nPlayer O has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}

		// Checking for middle 3 row
		i = 3;
		if (data[i] == 'X' && data[i + 1] == 'X' && data[i + 2] == 'X')
		{
			display();
			cout << "\nPlayer X has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		else if (data[i] == 'O' && data[i + 1] == 'O' && data[i + 2] == 'O')
		{
			display();
			cout << "\nPlayer O has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		
		// Checking for bottom 3 row
		i = 6;
		if (data[i] == 'X' && data[i + 1] == 'X' && data[i + 2] == 'X')
		{
			display();
			cout << "\nPlayer X has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		else if (data[i] == 'O' && data[i + 1] == 'O' && data[i + 2] == 'O')
		{
			display();
			cout << "\nPlayer O has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		
		// Checking for leftmost 3 column
		i = 0;
		if (data[i] == 'X' && data[i + 3] == 'X' && data[i + 6] == 'X')
		{
			display();
			cout << "\nPlayer X has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		else if (data[i] == 'O' && data[i + 3] == 'O' && data[i + 6] == 'O')
		{
			display();
			cout << "\nPlayer O has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}

		// Checking for middle column
		i = 1;
		if (data[i] == 'X' && data[i + 3] == 'X' && data[i + 6] == 'X')
		{
			display();
			cout << "\nPlayer X has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		else if (data[i] == 'O' && data[i + 3] == 'O' && data[i + 6] == 'O')
		{
			display();
			cout << "\nPlayer O has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		
		// Checking for rightmost 3 column
		i = 2;
		if (data[i] == 'X' && data[i + 3] == 'X' && data[i + 6] == 'X')
		{
			display();
			cout << "\nPlayer X has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		else if (data[i] == 'O' && data[i + 3] == 'O' && data[i + 6] == 'O')
		{
			display();
			cout << "\nPlayer O has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		
		// Checking for top left to bottom right diagonal
		i = 0;
		if (data[i] == 'X' && data[i + 4] == 'X' && data[i + 8] == 'X')
		{
			display();
			cout << "\nPlayer X has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		else if (data[i] == 'O' && data[i + 4] == 'O' && data[i + 8] == 'O')
		{
			display();
			cout << "\nPlayer O has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		
		// Checking for top right to bottom left diagonal
		i = 2;
		if (data[i] == 'X' && data[i + 2] == 'X' && data[i + 4] == 'X')
		{
			display();
			cout << "\nPlayer X has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}
		else if (data[i] == 'O' && data[i + 2] == 'O' && data[i + 4] == 'O')
		{
			display();
			cout << "\nPlayer O has won! Resetting board..." << endl;
			reset();
			turn = 1;
		}

		// Checking for a draw
		for (i = 0; i < CAPACITY; i++)
			if (data[i] == ' ')
			{
				anyEmpty = true;
				break;
			}

		if (anyEmpty == false)
			{
				display();
				cout << "\nDraw. Resetting board..." << endl;
				reset();
				turn = 1;
			}
	}
	
	void Tictac::operator +=(const Tictac& add)
	{
		// Postcondition: The arrays of the two objects have been added together. That is,
		// any non-space character in one array is added to the other array. This works because 
		// of the way the += operations are staggered in takeTurn to work with the check to make 
		// sure things aren't overwritten in compTurn
		for (int i = 0; i < CAPACITY; i++)
			if (add.data[i] != ' ')
				data[i] = add.data[i];
	}
}
