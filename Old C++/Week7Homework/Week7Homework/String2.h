/**************************************************************************************
* file name: String2.h
* programmer name: Kyle Wolf
* date created: 3/15/2018
* date of last revision: 4/2/2018
* details of the revision: Fixed + operator declarations
* short description: Declare the data members and functions of the custom string class
***************************************************************************************/
#ifndef STRING2_H
#define STRING2_H
#include<iostream>

namespace string2
{
	class string
	{
	private:
		struct stringList
		{
			char character;
			stringList* link;
		};

		stringList* headPtr;
		
	public:
		// CONSTRUCTORS AND DESTRUCTOR
		string() { headPtr = NULL; };
		// Postcondition: The headPtr of the string object points to NULL.  (constructor)
		string(const string& source);
		// Precondition: source is a declared string object
		// Precondition: The contents of source are copied for creation of the new object (copy constructor)
		~string();
		// Precondition: The object has been destructed (destructor)

		// CONSTANT MEMBER FUNCTIONS
		char getChar(const size_t position) const;
		// Precondition: position is the node in the linked list where the desired character is found, starting from 1 for the first node
		// Precondition: The character in the desired node has been returned
		size_t length() const;
		// Precondition: The number of nodes in the linked list has been returned
		char operator [ ] (size_t position) const;
		// Precondition: position is the char in the string the user wants to return, starting at 0 for the first char to mimic the standard string class
		// Precondition: The char at the desired position has been returned. Can be used in place of getChar function.

		// MODIFICATION MEMBER FUNCTIONS
		void operator += (const string& addend);
		// Precondition: addend is a valid string object the user wants to add to the end of an existing string object
		// Precondition: addend has been put at the end of the original string object, the size of the linked list has been adjusted
		void operator += (const char addend[]);
		// Precondition: addend is a valid array of chars the user wants to add to the end of an existing string object
		// Precondition: addend has been put at the end of the original string object, the size of the linked list has been adjusted
		void operator += (char addend);
		// Precondition: addend is a valid char the user wants to add to the end of an existing string object
		// Precondition: addend has been put at the end of the original string object, the size of the linked list has been adjusted
		// the other two += operators rely on this to add one char at a time
		void operator =(const string& source);
		// Precondition: source is a valid string object
		// Precondition: the string object has been made identical to source

		// FRIEND FUNCTIONS
		friend bool operator ==(const string& s1, const string& s2);
		// Precondition: s1 and s2 are valid string objects
		// Precondition: true has been returned if the two strings were identical, otherwise, false has been returned
	};

	// NONMEMBER FUNCTIONS
	string operator +(const string& s1, const string& s2);
	// Precondition: s1 and s2 are valid string objects
	// Precondition: a new string has been returned that is composed of the contents of s1 followed by s2
	std::ostream& operator <<(std::ostream& outs, const string& source);	
	// Precondition: source is a valid string object
	// Precondition: source has been displayed
}

#endif
