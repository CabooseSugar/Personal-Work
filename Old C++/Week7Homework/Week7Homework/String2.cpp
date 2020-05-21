/**************************************************************************************
* file name: String2.cpp
* programmer name: Kyle Wolf
* date created: 3/15/2018
* date of last revision: 4/2/2018
* details of the revision: Fixed + operator implementation
* short description: Define the functions of the custom string class
***************************************************************************************/
#include "String2.h"
#include <iostream>
#include <string>

namespace string2
{
	string::string(const string& source)
	{
		stringList* indexPtr, *sourceIndexPtr;

		if (source.headPtr == NULL)
		{
			headPtr = NULL;
			return;
		}

		headPtr = new stringList;
		headPtr->character = source.headPtr->character;
		headPtr->link = NULL;

		indexPtr = headPtr;
		sourceIndexPtr = source.headPtr->link;

		while (sourceIndexPtr!= NULL)
		{
			indexPtr->link = new stringList;
			indexPtr = indexPtr->link;
			indexPtr->character = sourceIndexPtr->character;
			indexPtr->link = NULL;

			sourceIndexPtr = sourceIndexPtr->link;
		}
	}

	string::~string()
	{
		stringList *removePtr;;
		
		while (headPtr != NULL)
		{
			removePtr = headPtr;
			headPtr = headPtr->link;
			delete removePtr;
		}
	}

	char string::getChar(const size_t position) const
	{
		stringList *indexPtr = headPtr;

		for (size_t i = 0; i < position - 1; i++)
		{
			indexPtr = indexPtr->link;
			if (indexPtr == NULL)
			{
				std::cout << "Outside of range.";
				return '\n';
			}
		}

		return indexPtr->character;
	}

	size_t string::length() const
	{
		size_t count = 0;
		stringList* indexPtr = headPtr;

		while (indexPtr != NULL)
		{
			count++;
			indexPtr = indexPtr->link;
		}

		return count;
	}

	char string::operator [ ] (size_t position) const
	{
		stringList* indexPtr = headPtr;

		for (size_t i = 0; i < position; i++)
			indexPtr = indexPtr->link;

		return indexPtr->character;
	}

	void string::operator += (const string& addend)
	{
		for (int index = 0; index < addend.length(); index++)
			(*this) += addend[index];
	}
	
	void string::operator += (const char addend[])
	{
		if (addend[0] == NULL)
			return;

		for (int index = 0; index < (sizeof(addend) / sizeof(addend[0])); index++)
			(*this) += addend[index];
	}

	void string::operator += (char addend)
	{
		stringList *indexPtr = headPtr;

		if (headPtr == NULL)
		{
			headPtr = new stringList;
			headPtr->character = addend;
			headPtr->link = NULL;
			return;
		}

		while (1)
		{
			if (indexPtr->link == NULL)
			{
				indexPtr->link = new stringList;
				indexPtr = indexPtr->link;
				indexPtr->character = addend;
				indexPtr->link = NULL;
				return;
			}
			indexPtr = indexPtr->link;
		}
	}

	void string::operator =(const string& source)
	{	
		if (headPtr != NULL)
		{
			delete headPtr;
			headPtr = NULL;
		}

		*this += source;
	}

	bool operator ==(const string& s1, const string& s2)
	{
		if (s1.length() != s2.length())
			return false;

		if (s1.headPtr == NULL && s2.headPtr == NULL)
			return true;

		for (int index = 0; index < s1.length(); index++)
		{
			if (s1.headPtr->character != s2.headPtr->character)
				return false;
		}

		return true;
	}

	string operator +(const string& s1, const string& s2)
	{
		string string1, string2, string3;
		
		string1 = s1;
		string2 = s2;
		string1 += string2;
		string3 = string1;
		return string3;
	}

	std::ostream& operator <<(std::ostream& outs, const string& source)
	{
		for (int index = 0; index < source.length(); index++)
				outs << source.getChar(index + 1);
		
		return outs;
	}
}

