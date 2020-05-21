/**************************************************************************************
* file name: polytest1.cxx
* programmer name: Kyle Wolf
* date created: 3/29/2018
* date of last revision: 4/6/2018
* details of the revision: streamlined test file
* short description: Test the functions of the polynomial class template
***************************************************************************************/

// note in this program that coef[0] = the constant in the polynomial
// with coef[1] and so on increasing the exponent of the variable by 1.
// so where coef 1: is listed represents the constant value for
// evaluation purposes
#define _SCL_SECURE_NO_WARNINGS
#include <cctype>          // Provides toupper
#include <iostream>        // Provides cout and cin
#include <cstdlib>         // Provides EXIT_SUCCESS
#include "poly1.h"         // Provides the polynomial class
using namespace std;
using namespace main_savitch_4;

int main()
{
	polynomial<double> test, test2;
	double entry, expVal, entry2;

	// testing inputting coeffs
	for (int i = 0; i < 5; i++)
	{
		cout << "coef " <<  i + 1 << ": ";
		cin >> entry;
		test.assign_coef(entry, i);
	}

	cout << "\nCoefficients inputted: " << endl;
	for (unsigned int index = 0; index < 5; index++)
		cout << test.coefficient(index) << endl;

	// testing adding to coeff
	cout << "\nAdding 5 to 2nd coefficient" << endl;
	test.add_to_coef(5, 1);
	for (unsigned int index = 0; index < 5; index++)
		cout << test.coefficient(index) << endl;

	//  testing clear function then inputting new values
	cout << "\nClearing coefficients. Input new values." << endl;
	test.clear();
	for (int i = 0; i < 5; i++)
	{
		cout << "coef " << i + 1 << ": ";
		cin >> entry;
		test.assign_coef(entry, i);
	}

	cout << "\nCoefficients inputted: " << endl;
	for (unsigned int index = 0; index < 5; index++)
		cout << test.coefficient(index) << endl;

	// testing degree() function to find coeff of largest exponent with nonzero coef"
	if (test.degree() == -1)
		cout << "No nonzero coefficients." << endl;
	else
		cout << "\nHighest degree exponent w/ nonzero coeff is exponent " << test.degree() << "." << endl;

	// testing eval function with coef[0] being the constant coefficient, coef[1] is x^1 coefficient, coef[2] is x^2's and so on 
	cout << "Enter a value for the exponents to evaluate the polynomial: ";
	cin >> expVal;
	cout << "Value of expression: " << test.eval(expVal) << endl;

	// testing () operator - should produce same as eval
	cout << "\n( ) operator test for 2 as variable value: " << test(2) << endl;

	// testing -() operator, also tests assignment operator, first *+ operator, and copy constructor -() operator definition
	test = -(test);
	cout << "\nCoefficients made negative." << endl;
	cout << "\nCoefficients: " << endl;
	for (unsigned int index = 0; index < 5; index++)
		cout << test.coefficient(index) << endl;

	// testing second *= operator w/ a polynomial expression with less nonzero coeffs
	cout << "\nInput values for second polynomial." << endl;
	for (int i = 0; i < 3; i++)
	{
		cout << "coef " << i + 1 << ": ";
		cin >> entry;
		test2.assign_coef(entry, i);
	}

	test *= test2;
	cout << "\nAfter multiplying first polynomial by second, coefficients: " << endl;
	for (unsigned int index = 0; index < 5; index++)
		cout << test.coefficient(index) << endl;

	// testing second *= operator w/ a polynomial expression with more nonzero coeffs
	cout << "\nInput new values for second polynomial." << endl;
	for (int i = 0; i < 7; i++)
	{
		cout << "coef " << i + 1 << ": ";
		cin >> entry;
		test2.assign_coef(entry, i);
	}

	test *= test2;
	cout << "\nAfter multiplying first polynomial by second, coefficients: " << endl;
	for (unsigned int index = 0; index < 7; index++)
		cout << test.coefficient(index) << endl;

	// testing first += operator
	test += test2;
	cout << "\nAfter adding first polynomial by second, coefficients: " << endl;
	for (unsigned int index = 0; index < 7; index++)
		cout << test.coefficient(index) << endl;
	
	// testing second += operator
	cout << "\nEnter value to add to constant value in main polynomial: ";
	cin >> entry2;
	test += entry2;
	cout << "\nAfter operation: " << endl;
	for (unsigned int index = 0; index < 7; index++)
		cout << test.coefficient(index) << endl;

	// testing first -= operator
	test -= test2;
	cout << "\nAfter subtracting first polynomial by second, coefficients: " << endl;
	for (unsigned int index = 0; index < 7; index++)
		cout << test.coefficient(index) << endl;

	// testing second += operator
	cout << "\nEnter value to subtract to constant value in main polynomial: ";
	cin >> entry2;
	test -= entry2;
	cout << "\nAfter operation: " << endl;
	for (unsigned int index = 0; index < 7; index++)
		cout << test.coefficient(index) << endl;
		
	return 0;
}

/*
coef 1: 1
coef 2: 2
coef 3: 3
coef 4: 4
coef 5: 5

Coefficients inputted:
1
2
3
4
5

Adding 5 to 2nd coefficient
1
7
3
4
5

Clearing coefficients. Input new values.
coef 1: 3
coef 2: 3
coef 3: 3
coef 4: 3
coef 5: 3

Coefficients inputted:
3
3
3
3
3

Highest degree exponent w/ nonzero coeff is exponent 5.
Enter a value for the exponents to evaluate the polynomial: 2
Value of expression: 93

( ) operator test for 2 as variable value: 93

Coefficients made negative.

Coefficients:
-3
-3
-3
-3
-3

Input values for second polynomial.
coef 1: 4
coef 2: 4
coef 3: 4

After multiplying first polynomial by second, coefficients:
-12
-12
-12
-3
-3

Input new values for second polynomial.
coef 1: 4
coef 2: 5
coef 3: 6
coef 4: 7
coef 5: 8
coef 6: 9
coef 7: 10

After multiplying first polynomial by second, coefficients:
-48
-60
-72
-21
-24
0
0

After adding first polynomial by second, coefficients:
-44
-55
-66
-14
-16
9
10

Enter value to add to constant value in main polynomial: 8

After operation:
-36
-55
-66
-14
-16
9
10

After subtracting first polynomial by second, coefficients:
-40
-60
-72
-21
-24
0
0

Enter value to subtract to constant value in main polynomial: 4

After operation:
-44
-60
-72
-21
-24
0
0
Press any key to continue . . .
*/