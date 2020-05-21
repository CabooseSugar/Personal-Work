#ifndef STRING_H
#define STRING_H
#include <cstring>

namespace wolf_string
{
	class string
	{
	private:
		char *characters; 
		size_t allocated; 
		size_t current_length;

	public:
		// CONSTRUCTORS AND DESTRUCTOR
		string(const char str[] = "");
		// Precondition: str is an ordinary null-terminated string. 
		// Postcondition: The string contains the sequence of chars from str.

		string(const string& source); 
		// Postcondition: The string source has been copied.
		
		~string();
		// Postcondition: The string has been deleted.

		// CONSTANT MEMBER FUNCTIONS
		size_t length() const;
		// Postcondition: The return value is the number of characters in the string.
		
		char operator [ ] (size_t position) const;
		// Precondition: position < length( ). 
		// Postcondition: The value returned is the character at the specified position of the 
		// string. A string’s positions start from 0 at the start of the sequence and go up to 
		// length( ) – 1 at the right end. 

		// MODIFICATION MEMBER FUNCTIONS
		void operator += (const string& addend);
		// Postcondition: addend has been catenated to the end of the string.

		void operator += (const char addend[ ]);
		// Precondition: addend is an ordinary null-terminated string.
		// Postcondition: addend has been catenated to the end of the string. 

		void operator += (char addend);
		// Postcondition: The single character addend has been catenated to the end of the string. 

		void operator =(const string& source);
		// Postcondition: The string now equals source. 

		void reserve(size_t n);
		// Postcondition: All functions will now work efficiently (without allocating new memory)
		// until n characters are in the string.

		// FRIEND FUNCTIONS
		friend bool operator ==(const string& s1, const string& s2);
		// Postcondition: The return value is true if s1 is identical to s2. 

	};

	// NONMEMBER FUNCTIONS
	string operator +(const string& s1, const string& s2);
	// Postcondition: The string returned is the catenation of s1 and s2. 

	std::istream& operator >> (std::istream& ins, string& target);
	// Postcondition: A string has been read from the istream ins, and the istream ins is then 
	// returned by the function. The reading operation skips white space (i.e., blanks, tabs, 
	// newlines) at the start of ins. Then the string is read up to the next white space or the end 
	// of the file. The white space character that terminates the string has not been read. 

	std::ostream& operator <<(std::ostream& outs, const string& source);
	// Postcondition: The sequence of characters in source has been written to outs.
	// The return value is the ostream outs. 

	std::istream& getline(std::istream& ins, string& target, char delimiter = '\n');
	// Postcondition: A string has been read from the istream ins. The reading operation reads 
	// all characters (including white space) until the delimiter is read and discarded (but not 
	// added to the end of the string). The return value is the istream ins.
}

#endif