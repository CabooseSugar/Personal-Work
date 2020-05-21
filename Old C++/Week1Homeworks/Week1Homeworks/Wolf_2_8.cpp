/*********************************************************
* file name: Wolf_2_8.cpp
* programmer name: Kyle Wolf
* date created: 1/16/2018
* date of last revision: 1/30/2018
* details of the revision: redid final block comment with updated code
* short description:  Evaluate and modify a quadratic expression 
**********************************************************/

#include <iostream>
#include <iomanip>
using namespace std;
#include "Quad.h"
using namespace wolf_quadraticExpression;

int main()
{
	// Program description
	cout << "This program will evaluate and allow the user to modify" << endl
		<< "a quadratic expression.\n";

	// Declaring the variables: types and names
	int selection;
	float a, b, c, x;
	double multiplicationFactor;
	Quad q, q1, q2;

	while (1) {
		cout << "\n-----------------------------------------------------------------------------" << endl
			<< setw(36) << ' ' << "MAIN MENU" << endl
			<< " 1. Change the coefficients (default to 0)" << endl
			<< " 2. View current a coefficient value" << endl
			<< " 3. View current b coefficient value" << endl
			<< " 4. View current c coefficient value" << endl
			<< " 5. Evaluate the expression for a given x value" << endl
			<< " 6. Add two quadratic expressions' coefficients together for a new expression" << endl
			<< " 7. Multiply the coefficients of the expression by a given value" << endl
			<< " 8. Quit" << endl
			<< "-----------------------------------------------------------------------------" << endl;

		// Variable initialization: getting the input from the user
		cout << "Enter selection: ";
		cin >> selection;

		if (selection < 1 || selection > 8) {
			cout << "\nInvalid entry." << endl;
			continue;
		}

		// Calling member functions based on selection
		if (selection == 1) {
			// Variable initialization: getting the input from the user
			cout << "\nEnter a value for a: ";
			cin >> a;
			cout << "Enter a value for b: ";
			cin >> b;
			cout << "Enter a value for c: ";
			cin >> c;

			// Member function call
			q.changeCoeffs(a, b, c);
		}

		// Displaying the results by calling member functions
		if (selection == 2) 
			cout << "\nThe current value of a is: " << fixed << setprecision(1) << q.aValue() << endl;
		if (selection == 3)
			cout << "\nThe current value of b is: " << fixed << setprecision(1) << q.bValue() << endl;
		if (selection == 4)
			cout << "\nThe current value of c is: " << fixed << setprecision(1) << q.cValue() << endl;

		if (selection == 5) {
			// Variable initialization: getting the input from the user
			cout << "\nEnter a value for x: ";
			cin >> x;
			// Displaying the results by calling member functions
			cout << "\n" << fixed << setprecision(1) << q.aValue() << "(" << x << "^2) + " << q.bValue() << "(" << x << ") + " << q.cValue() << " = " << fixed << setprecision(2) << q.eval(x) << endl;
		}
		
		if (selection == 6) {
			// Variable initialization: getting the input from the user
			cout << "\n1ST EXPRESSION" << endl;
			cout << "Enter a value for a: ";
				cin >> a;
			cout << "Enter a value for b: ";
			cin >> b;
			cout << "Enter a value for c: ";
			cin >> c;

			// Member function call
			q1.changeCoeffs(a, b, c);

			// Variable initialization: getting the input from the user
			cout << "\n2ND EXPRESSION" << endl;
			cout << "Enter a value for a: ";
			cin >> a;
			cout << "Enter a value for b: ";
			cin >> b;
			cout << "Enter a value for c: ";
			cin >> c;

			// Member function call
			q2.changeCoeffs(a, b, c);

			// Calculations with overloaded operator
			q = q1 + q2;
		}

		if (selection == 7) {
			// Variable initialization: getting the input from the user
			cout << "Enter value to multiply coefficients by: ";
			cin >> multiplicationFactor;

			// Calculations with overloaded operator
			q = multiplicationFactor * q;
		}

		if (selection == 8)
			break;
	}

	cout << "\nGoodbye!" << endl << endl;

	return 0;
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
 8. Quit
-----------------------------------------------------------------------------
Enter selection: 9

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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
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
 8. Quit
-----------------------------------------------------------------------------
Enter selection: 8

Goodbye!

Press any key to continue . . .
*/