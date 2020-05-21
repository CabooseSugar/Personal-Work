/**************************************************************************************
* file name: chores.cpp
* programmer name: Kyle Wolf
* date created: 2/15/2018
* date of last revision:
* details of the revision:
* short description: Define the member functions of the choreBag class
***************************************************************************************/
#define _SCL_SECURE_NO_WARNINGS  

#include "chores.h"
#include <iostream>
#include <string>

using namespace std;

namespace wolf_chores 
{
	choreBag::choreBag(size_type initialCapacity)
	{
		// Constructor
		data = new value_type[initialCapacity];
		capacity = initialCapacity;
		used = 0;
	}

	choreBag::choreBag(const choreBag& source)
	{
		// Copy constructor
		data = new value_type[source.capacity];
		capacity = source.capacity;
		used = source.used;
		copy(source.data, source.data + used, data);
	}

	choreBag::~choreBag()
	{
		// Destructor
		delete [ ] data;
	}
	
	void choreBag::reserve(size_type new_capacity)
	{
		// Postcondition: The capacity of the array has been increased
		// if it was exceeded because of insert member function
		value_type *larger_array;

		if (new_capacity == capacity)
			return; 

		if (new_capacity < used)
			new_capacity = used;

		larger_array = new value_type[new_capacity];
		copy(data, data + used, larger_array);
		delete[] data;
		data = larger_array;
		capacity = new_capacity;
	}

	void choreBag::insert(const value_type& entry)
	{
		// Postcondition: A new, original entry has been added to the 
		// dynamic array of strings, used has been adjusted to reflect
		// new size of array
		if (used == capacity)
			reserve(used + 1);
		data[used] = entry;
		++used;
	}

	bool choreBag::eraseItem(const value_type& target)
	{
		// Postcondition: An entry inside the dynamic array has been deleted
		// used has been adjusted to reflect new size of array
		size_type index; 

		index = 0;
		while ((index < used) && (data[index] != target))
			++index;

		if (index == used) 
			return false;

		// ASK HOW THIS WORKS AND WHY CAPACITY WON'T CHANGE AND BREAKS PROGRAM IF TOO MANY CHORES ENTERED
		--used;
		data[index] = data[used];
		
		return true;
	}

	void choreBag::viewItems() const
		// Postcondition: List of entries has been printed to the screen
	{
		if (used == 0)
		{
			cout << "\nList is empty." << endl;
			return;
		}

		cout << "\nCHORE LIST:" << endl;
		for (int i = 0; i < used; i++)
			cout << i + 1 << ") " << data[i] << endl;
	}

	bool choreBag::isInBag(const value_type entry) const
	{
		// Postcondition: If the entry is inside the array, true has been
		// returned, otherwise, false has
		size_type index;
		
		index = 0;
		while ((index < used) && (data[index] != entry))
			++index;

		if (data[index] == entry)
			return true;
		else
			return false;
	}
}