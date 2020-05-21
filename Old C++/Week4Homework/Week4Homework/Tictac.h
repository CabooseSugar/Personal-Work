/********************************************************************************************************
* file name: Tictac.h
* programmer name: Kyle Wolf
* date created: 2/6/2018
* date of last revision: 2/9/18
* details of the revision: Added += operator
* short description: Declare the data members, and member and nonmember functions of the Tictac class 
********************************************************************************************************/
#ifndef TICTAC_H
#define TICTAC_H
#include <cstdlib> 

namespace wolf_tictac
{
    class Tictac
    { 
    public:
        typedef int value_type;
        typedef size_t size_type;
		enum { CAPACITY = 9 }; 
        // Constructor
		Tictac();
        // MODIFICATION MEMBER FUNCTIONS
		// Member function to handle player's turns
		bool playerTurn(const char entry, const int place);
		// Member function to handle computer's turns
		void compTurn(const char entry);
		// Member function to reset board
		void reset();
		// Member function to check if a win / draw condition has been met
		void winCheck(value_type& turn);
		// Member function to add the arrays of two diff objects
		void operator += (const Tictac& add);
        // CONSTANT MEMBER FUNCTIONS
		// Member function to display board
		void display() const;
    private:
        char data[CAPACITY]; 
		value_type place;
    };
}

#endif

