/**************************************************************************************
* file name: Wolf_5_12.cpp
* programmer name: Kyle Wolf
* date created: 3/15/2018
* date of last revision: 4/2/2018
* details of the revision: Fixed + operator testing
* short description: Test the functions of the custom string class
***************************************************************************************/
#include "String2.h"
#include <iostream>
#include <fstream>
using namespace string2;

int main()
{
	string test, test2, test3, test4;

	std::cout << "Current length: " << test.length() << std::endl;
	char add[4] = { 'a', 'b', 'c', 'd' };
	test += 's'; // testing third (lowest) += operator
	std::cout << "First char in string: " << test.getChar(1) << std::endl;
	test += 'd';
	std::cout << "Current length: " << test.length() << std::endl;
	std::cout << "Second char in string:  " << test.getChar(2) << std::endl;
	std::cout << "Second char in string testing [] operator: " << test[1] << std::endl;
	std::cout << "Current string: " << test << std::endl;
	test += add; // testing second (middle) += operator
	std::cout << "Current length: " << test.length() << std::endl;
	std::cout << "Current string: " << test << std::endl;
	
	test2 += 'z';
	test2 += 'y';
	test += test2; // testing first (top) += operator
	std::cout << "Current string: " << test << std::endl;

	test = test2; // testing = operator
	std::cout << "\nCurrent string: " << test << std::endl;
	std::cout << "Compared to string: " << test2 << std::endl;
	if (test == test2) // testing == operator
		std::cout << "\nStrings are equal" << std::endl;
	else
		std::cout << "\nStrings are not equal." << std::endl;

	test += 'f';
	std::cout << "\nCurrent string: " << test << std::endl;
	std::cout << "Compared to string: " << test2 << std::endl;
	
	if (test == test2) // testing == operator
		std::cout << "\nStrings are equal" << std::endl;
	else
		std::cout << "\nStrings are not equal." << std::endl;


	test3 = test + test2;
	std::cout << "\nTwo strings added together: " << test3 << std::endl; // testing + operator

/*
Current length: 0
First char in string: s
Current length: 2
Second char in string:  d
Second char in string testing [] operator: d
Current string: sd
Current length: 6
Current string: sdabcd
Current string: sdabcdzy

Current string: zy
Compared to string: zy

Strings are equal

Current string: zyf
Compared to string: zy

Strings are not equal.

Two strings added together: zyfzy
Press any key to continue . . .
*/

	

	




	

}