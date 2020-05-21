#include "String.h"
#include <algorithm>
#include <cstring>
#include <iostream>

namespace wolf_string
{
	string::string(const char str[])
	{
		current_length = strlen(str); 
		allocated = current_length + 1;
		characters = new char[allocated];	
		strcpy(characters, str);
	}

	string::string(const string& source)
	{
		current_length = source.current_length;
		allocated = current_length + 1;
		characters = new char[source.allocated];
		std::copy(source.characters, source.characters + current_length, characters);
	}

	string::~string()
	{
		delete[] characters;
	}

	size_t string::length() const
	{
		return current_length;
	}

	char string::operator [ ] (size_t position) const
	{
		return characters[position];
	}

	void string::operator += (const string& addend)
	{
		characters += addend[addend.length()];
	}

	void string::operator += (const char addend[])
	{
		int numElements;

		if (addend[0] == NULL)
			return;

		numElements = sizeof(addend) / sizeof(addend[0]);

		for (int index = 0; index < numElements; index++)
			characters += addend[index];
	}

	void string::operator += (char addend)
	{
		if (current_length++ > allocated)
			reserve(current_length++);

		current_length++;
		characters[current_length] = addend;
	}

	void string::operator =(const string& source)
	{
		if (source.length() > allocated)
			reserve(source.length());

		current_length = source.length();
		
		for (int index = 0; index < current_length; index++)
			characters[index] = source[index];
	}

	void string::reserve(size_t n)
	{
		char *larger_array;

		if (n == allocated)
			return; 

		if (n < current_length)
			n = current_length; // Can’t allocate less than we are using.

		larger_array = new char[n];
		std::copy(characters, characters + current_length, larger_array);
		delete[] characters;
		characters = larger_array;
		allocated = n;
	}

	bool operator ==(const string& s1, const string& s2)
	{
		return (strcmp(s1.characters, s2.characters) == 0);
	}

	string operator +(const string& s1, const string& s2)
	{
		string combinedString;

		combinedString = s1 + s2;

		return combinedString;
	}

	std::istream& operator >> (std::istream& ins, string& target)
	{
		int index = 0;
		string s;

		for (index; index < target.length(); index++)
		{
			if (target[index] != ' ' && target[index] != '\t' && target[index] != '\n')
				break;
		}

		while (!ins.eof() && target[index] != ' ')
		{
			s += target[index];
			index++;
		}

		ins >> s;

		return ins;
	}

	std::ostream& operator <<(std::ostream& outs, const string& source)
	{
		string s;

		for (int index = 0; index < source.length(); index++)
		{
			s += source[index];
		}
		outs << s;

		return outs;
	}

	std::istream& getline(std::istream& ins, string& target, char delimiter = '\n')
	{
		string s;

		for (int index = 0; index < target.length(); index++)
		{
			if (target[index] == delimiter)
				break;

			s += target[index];
		}
		ins >> s;

		return ins;
	}
}

