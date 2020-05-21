/*******************************************************************************************************************
* file name: Set.h
* programmer name: Kyle Wolf
* date created: 2/2/2018
* date of last revision: 
* details of the revision:
* short description: Declare the Set class, its data members, member functions, and nonmember functions
********************************************************************************************************************/

#ifndef SET_H
#define SET_H
#include <cstdlib>  

namespace wolf_set
{
    class Set
    { 
    public:
        typedef int value_type;
        typedef size_t size_type;
		enum { CAPACITY = 30 }; 
        // Constructor
        Set( ) { used = 0; } 
        // Modification Member Functions
		void insert(const value_type& entry);
		bool erase_one(const value_type& target);
		void cleanSet();
        void operator +=(const Set& addend);
		void operator -=(const Set& addend);

        // Constant Member functions
        size_type size( ) const { return used; }
        bool contains(const value_type& target) const;
		void displayData() const;
	
    private:
		// array used to store items
        value_type data[CAPACITY];  
		// how much of array is used
        size_type used;            
    };

    // Nonmember Functions
    Set operator +(const Set& b1, const Set& b2);
	Set operator -(const Set& b1, const Set& b2);
}

#endif

