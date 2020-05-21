/**************************************************************************************
* file name: Set.cpp
* programmer name: Kyle Wolf
* date created: 2/2/2018
* date of last revision:
* details of the revision:
* short description: Define the member and nonmember functions of the set class
***************************************************************************************/

// INVARIANT for the set class:
//   1. The number of items in the set is in the member variable used;
//   2. For an empty sag, we do not care what is stored in any of data; for a
//      non-empty set the items in the set are stored in data[0] through
//      data[used-1], and we don't care what's in the rest of data.

// needed circumvent security warning to compile
#define _SCL_SECURE_NO_WARNINGS  

#include <iostream>
#include <algorithm> 
#include <cassert>   
#include "Set.h"
using namespace std;

namespace wolf_set
{   
	void Set::insert(const value_type& entry)
	{
		// Postcondition: Passed entry has been added to set, space used has been adjusted
		assert(size() < CAPACITY);

		data[used] = entry;
		++used;				
	}						

	bool Set::erase_one(const value_type& target)
	{
		// Postcondition: Passed entry has been removed if in the set, then true was returned. Otherwise, false was.
		size_type index;   

		index = 0;
		while ((index < used) && (data[index] != target))
			++index;

		if (index == used)
			return false;
	
		--used;
		data[index] = data[used];
		return true;
	}

	void Set::cleanSet() 
	{
		// Postcondition: Duplicates have been removed from two added together sets, part of overload operator + definition
		value_type temp; 

		for (int index = 0; index < used - 1; index++)
			for (int check = index + 1; check < used; check++)
				if (data[index] == data[check]) {
					temp = data[used - 1];
					data[used - 1] = data[check];
					data[check] = temp;
					--used;
					// repeats last check to let function work if more than two sets are ever added together in the future
					check--;
				}
	}

    void Set::operator +=(const Set& addend)
    {
		// Postcondition: Second set has been added to the end of the original, used has been adjusted
		assert(size( ) + addend.size( ) <= CAPACITY);

		copy(addend.data, addend.data + addend.used, data + used);
		used += addend.used;
    }

	void Set::operator -=(const Set& subt)
	{
		// Postcondition: Second set has been subtracted from the original where duplicates exist, used has been adjusted
		for (int index = 0; index < used; index++)
			for (int subtIndex = 0; subtIndex < subt.used; subtIndex++)
				if (data[index] == subt.data[subtIndex]) {
					data[index] = data[used - 1];
					used--;
					// repeats last check in case age shifted would also have been a duplicate
					index--;
				}
	}

    bool Set::contains(const value_type& target) const
    {
		// Postcondition: True has been returned if passed value exists in set, false has been otherwise
        size_type i;

		for (i = 0; i < used; ++i)
			if (target == data[i])
				return true;
		
		return false;
    }

	void Set::displayData() const
	{
		// Postcondition: Ages have been displayed
		for (int i = 0; i < (int) size(); i++)
		{
			cout << data[i] << " ";
		}
		cout << endl;

	}
  
	Set operator +(const Set& b1, const Set& b2)
    {
		// Postcondition: Two seperate sets have been added together to produce a new one, this result has been returned
        Set answer;

        assert(b1.size( ) + b2.size( ) <= Set::CAPACITY);

        answer += b1; 
        answer += b2;
		answer.cleanSet();

        return answer;
    }

	Set operator -(const Set& b1, const Set& b2)
		// Postcondition: New set has been subtracted from another where duplicates exist to produce a fresh set, this result has been returned
	{
		Set answer;
		
		answer = b1;
		answer -= b2;
		
		return answer;
	}
}




