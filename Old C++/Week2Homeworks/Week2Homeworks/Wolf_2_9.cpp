/*********************************************************************************************************************************************
* file name: Wolf_2_9.cpp
* programmer name: Kyle Wolf
* date created: 1/16/2018
* date of last revision: 1/30/2018
* details of the revision: Fixed output block comment
* short description:  Evaluate a quadratic expression
*********************************************************************************************************************************************/

#include <iostream>
#include <iomanip>
using namespace std;
#include "Quad.h"
using namespace wolf_quadraticExpression;

void changeCoeff(Quad&);
void viewCurA(Quad);
void viewCurB(Quad);
void viewCurC(Quad);
void evalForX(Quad);
void addTwo(Quad&);
void multiply(Quad&);
void roots(Quad);

int main()
{
	// Program description
	cout << "This program will evaluate and allow the user to modify" << endl
		<< "a quadratic expression.\n";

	// Declaring the variables: types and names
	Quad q;
	int selection;
	bool isDone = false;

	while (!isDone) {
		cout << "\n-----------------------------------------------------------------------------" << endl
			<< setw(36) << ' ' << "MAIN MENU" << endl
			<< " 1. Change the coefficients (default to 0)" << endl
			<< " 2. View current a coefficient value" << endl
			<< " 3. View current b coefficient value" << endl
			<< " 4. View current c coefficient value" << endl
			<< " 5. Evaluate the expression for a given x value" << endl
			<< " 6. Add two quadratic expressions' coefficients together for a new expression" << endl
			<< " 7. Multiply the coefficients of the expression by a given value" << endl
			<< " 8. Find the real roots of the expression" << endl
			<< " 9. Quit" << endl
			<< "-----------------------------------------------------------------------------" << endl;

		// Variable initialization: getting the input from the user
		cout << "Enter selection: ";
		cin >> selection;

		// Calling functions based on selection
		switch (selection) {
		case 1:
			changeCoeff(q);
			break;
		case 2:
			viewCurA(q);
			break;
		case 3:
			viewCurB(q);
			break;
		case 4:
			viewCurC(q);
			break;
		case 5:
			evalForX(q);
			break;
		case 6:
			addTwo(q);
			break;
		case 7:
			multiply(q);
			break;
		case 8:
			roots(q);
			break;
		case 9:
			isDone = true;
			break;
		default: 
			cout << "\nInvalid entry." << endl;
		}
	}

	cout << "\nGoodbye!" << endl << endl;

	return 0;
}

void changeCoeff(Quad& q) {
	// Declaring the variables: types and names
	float a, b, c;

	// Variable initialization: getting the input from the user
	cout << "\nEnter a value for a: ";
	cin >> a;
	cout << "Enter a value for b: ";
	cin >> b;
	cout << "Enter a value for c: ";
	cin >> c;

	// Member function call to change coefficients
	q.changeCoeffs(a, b, c);
}

void viewCurA(Quad q) {
	// Displaying a coefficient by calling member function
	cout << "\nThe current value of a is: " << fixed << setprecision(1) << q.aValue() << endl;
}

void viewCurB(Quad q) {
	// Displaying b coefficient by calling member function
	cout << "\nThe current value of b is: " << fixed << setprecision(1) << q.bValue() << endl;
}

void viewCurC(Quad q) {
	// Displaying c coefficient by calling member function
	cout << "\nThe current value of c is: " << fixed << setprecision(1) << q.cValue() << endl;
}

void evalForX(Quad q) {
	// Declaring the variables: types and names
	float x;

	// Variable initialization: getting the input from the user
	cout << "\nEnter a value for x: ";
	cin >> x;
	
	// Displaying the evaluation for x by calling member functions
	cout << "\n" << fixed << setprecision(1) << q.aValue() << "(" << x << "^2) + " 
		<< q.bValue() << "(" << x << ") + " 
		<< q.cValue() << " = " 
		<< fixed << setprecision(2) << q.eval(x) << endl;
}

void addTwo(Quad& q) {
	// Declaring the variables: types and names
	Quad q1, q2;
	float a, b, c;

	// Variable initialization: getting the input from the user
	cout << "\n1ST EXPRESSION" << endl;
	cout << "Enter a value for a: ";
	cin >> a;
	cout << "Enter a value for b: ";
	cin >> b;
	cout << "Enter a value for c: ";
	cin >> c;

	// Member function call to change coefficients of first expression to be added
	q1.changeCoeffs(a, b, c);

	// Variable initialization: getting the input from the user
	cout << "\n2ND EXPRESSION" << endl;
	cout << "Enter a value for a: ";
	cin >> a;
	cout << "Enter a value for b: ";
	cin >> b;
	cout << "Enter a value for c: ";
	cin >> c;

	// Member function call to change coefficients of second expression to be added
	q2.changeCoeffs(a, b, c);

	// Calculations with overloaded operator to add both expressions for a new expression
	q = q1 + q2;
}

void multiply(Quad& q) {
	// Declaring the variables: types and names
	double multiFactor;
	// Variable initialization: getting the input from the user
	cout << "\nEnter value to multiply coefficients by: ";
	cin >> multiFactor;

	// Calculations with overloaded operator
	q = multiFactor * q;
}

void roots(Quad q) {
	// Declaring the variables: types and names
	int roots;
	float root1, root2;

	// Member function call to determine number of real roots
	roots = q.findRoots();
	
	// Member function calls to determine values of real roots + displaying results
	if (roots == 0)
		cout << "\nNo real roots exist for this expression." << endl;
	if (roots == 1) {
		root1 = q.smallRoot();
		// fix problem with getting -0 displayed value, not from rounding either
		if (root1 == 0)
			root1 = abs(root1);
		cout << "\nOne real root found with value: " << fixed << setprecision(1) << root1 << endl;
	}
	if (roots == 2 || roots == 3) {
		root1 = q.smallRoot();
		root2 = q.largeRoot();
		// again, fix problem with getting -0 as a result
		if (root1 == 0)
			root1 = abs(root1);
		if (root2 == 0)
			root2 = abs(root1);

		if (root1 == 0 && root2 == 0)
			cout << "\nInfinite number of real roots." << endl;
		else 
			cout << "\nTwo real roots found with values: " << fixed << setprecision(1) << root1 << " and " << root2 << endl;
	}
}

/*
This program will evaluate and allow the user to modify
a quadratic expression.

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 10

Invalid entry.

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: -2

Invalid entry.

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 2

The current value of a is: 0.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 3

The current value of b is: 0.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 4

The current value of c is: 0.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 1

Enter a value for a: 10
Enter a value for b: 20
Enter a value for c: 30

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 2

The current value of a is: 10.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 3

The current value of b is: 20.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 4

The current value of c is: 30.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 5

Enter a value for x: 3

10.0(3.0^2) + 20.0(3.0) + 30.0 = 180.00

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 6

1ST EXPRESSION
Enter a value for a: 5
Enter a value for b: 10
Enter a value for c: 15

2ND EXPRESSION
Enter a value for a: 20
Enter a value for b: 25
Enter a value for c: 30

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 2

The current value of a is: 25.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 3

The current value of b is: 35.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 4

The current value of c is: 45.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 7

Enter value to multiply coefficients by: 2

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 2

The current value of a is: 50.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 3

The current value of b is: 70.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 4

The current value of c is: 90.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 1

Enter a value for a: 0
Enter a value for b: 0
Enter a value for c: 0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 8

Infinite number of real roots.

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 1

Enter a value for a: 0
Enter a value for b: 0
Enter a value for c: 1

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 8

No real roots exist for this expression.

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 1

Enter a value for a: 0
Enter a value for b: 5
Enter a value for c: 10

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 8

One real root found with value: -2.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 1

Enter a value for a: 5
Enter a value for b: 1
Enter a value for c: 10

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 8

No real roots exist for this expression.

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 1

Enter a value for a: 1
Enter a value for b: 2
Enter a value for c: 1

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 8

One real root found with value: -1.0

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 1

Enter a value for a: 1
Enter a value for b: 10
Enter a value for c: 1

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 8

Two real roots found with values: -14.9 and -5.1

-----------------------------------------------------------------------------
                                    MAIN MENU
 1. Change the coefficients (default to 0)
 2. View current a coefficient value
 3. View current b coefficient value
 4. View current c coefficient value
 5. Evaluate the expression for a given x value
 6. Add two quadratic expressions' coefficients together for a new expression
 7. Multiply the coefficients of the expression by a given value
 8. Find the real roots of the expression
 9. Quit
-----------------------------------------------------------------------------
Enter selection: 9

Goodbye!

Press any key to continue . . .
*/