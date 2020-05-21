/**************************************************************************************
* file name: chores.h
* programmer name: Kyle Wolf
* date created: 2/15/2018
* date of last revision:
* details of the revision:
* short description: Declare choreBag class, and its member functions and data members
***************************************************************************************/
#ifndef CHORES_H
#define CHORES_H

#include <cstdlib>
#include <string>
using namespace std;

namespace wolf_chores 
{
	class  choreBag
	{
	public:
		// TYPEDEFS AND MEMBER CONSTANTS
		typedef string value_type;
		typedef size_t size_type;
		static const size_type DEFAULT_CAPACITY = 3;
		// CONSTRUCTORS AND DESTRUCTOR
		choreBag(size_type initialCapacity = DEFAULT_CAPACITY);
		choreBag(const choreBag& source);
		~choreBag();
		// MODIFICATION MEMBER FUNCTIONS
		// Member function to change capacity of dynamic array when default would be exceeded
		void reserve(size_type new_capacity);
		// Member function to insert a chore into dynamic array of strings
		void insert(const value_type& entry);
		// Member function to erase a chore from the array
		bool eraseItem(const value_type& target);
		// CONSTANT MEMBER FUNCTIONS
		// Member function to check size of used space in dynamic array
		size_type size() const { return used; }
		// Member function to display the chores
		void viewItems() const;
		// Member function to check if a chore is already in the bag
		bool isInBag(const value_type entry) const;

	private:
		value_type* data;
		size_type used;
		size_type capacity;
	};
}

#endif
