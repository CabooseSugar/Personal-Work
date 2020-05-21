/*********************************************************
* file name: Wolf_2_5.cpp
* programmer name: Kyle Wolf
* date created: 1/15/2018
* date of last revision: 1/16/2018
* details of the revision: added more documentation and formatting
* short description:  Keep track of a point in 3D space
**********************************************************/

#include <iostream>
#include <iomanip>
using namespace std;
#include "Space.h"
using namespace wolf_3Dpoint;

const float radConvert = 0.0174533;

int main()
{
	// Program description
	cout << "This program will keep track" << endl
		<< "of a point in 3D space.\n";

	// Declaring the variables: types and names
	int selection;
	Space location;

	while (1) {
		cout << "\n-------------------------------------" << endl
			<< setw(12) << ' ' << "MAIN MENU" << endl
			<< " 1. Set location (defaults at 0)" << endl
			<< " 2. Shift point along X axis" << endl
			<< " 3. Shift point along Y axis" << endl
			<< " 4. Shift point along Z axis" << endl
			<< " 5. Rotate point around X axis" << endl
			<< " 6. Rotate point around Y axis" << endl
			<< " 7. Rotate point around Z axis" << endl
			<< " 8. Display point's location" << endl
			<< " 9. Quit" << endl
			<< "-------------------------------------" << endl;

		// Variable initialization: getting the input from the user
		cout << "Enter selection: ";
		cin >> selection;

		if (selection < 1 || selection > 9) {
			cout << "\nInvalid entry." << endl;
			continue;
		}

		if (selection == 1) {
			// Declaring the variables: types and names
			float x, y, z;
			// Variable initialization: getting the input from the user
			cout << "\nEnter X position: ";
			cin >> x;
			cout << "Enter y position: ";
			cin >> y;
			cout << "Enter z position: ";
			cin >> z;

			// Member function call
			location.setSpace(x, y, z);
		}
		
		if (selection == 2) {
			// Declaring the variables: types and names
			float amountShifted;
			// Variable initialization: getting the input from the user
			cout << "\nEnter amount to shift point on x axis: ";
			cin >> amountShifted;
			
			// Member function call
			location.shiftX(amountShifted);
		}
		
		if (selection == 3) {
			// Declaring the variables: types and names
			float amountShifted;
			// Variable initialization: getting the input from the user
			cout << "\nEnter amount to shift point on y axis: ";
			cin >> amountShifted;

			// Member function call
			location.shiftY(amountShifted);
		}
		
		if (selection == 4) {
			// Declaring the variables: types and names
			float amountShifted;
			// Variable initialization: getting the input from the user
			cout << "\nEnter amount to shift point on z axis: ";
			cin >> amountShifted;

			// Member function call
			location.shiftZ(amountShifted);
		}
		
		if (selection == 5) {
			// Declaring the variables: types and names
			float degrees, radians;
			// Variable initialization: getting the input from the user
			cout << "\nEnter degrees to rotate point along x axis: ";
			cin >> degrees;
			// Convert
			radians = degrees * radConvert;
			location.rotateOnX(radians);
		}
		if (selection == 6) {
			// Declaring the variables: types and names
			float degrees, radians;
			// Variable initialization: getting the input from the user
			cout << "\nEnter degrees to rotate point along y axis: ";
			cin >> degrees;
			// Convert
			radians = degrees * radConvert;
			location.rotateOnY(radians);
		}
			
		if (selection == 7) {
			// Declaring the variables: types and names
			float degrees, radians;
			// Variable initialization: getting the input from the user
			cout << "\nEnter degrees to rotate point along z axis: ";
			cin >> degrees;
			// Convert
			radians = degrees * radConvert;
			location.rotateOnZ(radians);
		}
			
		if (selection == 8)
			location.showSpace();

		if (selection == 9)
			break;

	}
		
	// Display the results
	cout << "\nGoodbye!" << endl << endl;

	return 0;
}

/*
	RUN 1

This program will keep track
of a point in 3D space.

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 0

Invalid entry.

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 10

Invalid entry.

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 9

Goodbye!

Press any key to continue . . .
*/



/*
	RUN 2

This program will keep track
of a point in 3D space.

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 8

The position of the point is:
X: 0.0
Y: 0.0
Z: 0.0

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 2

Enter amount to shift point on x axis: 90

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 3

Enter amount to shift point on y axis: 50

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 4

Enter amount to shift point on z axis: -10

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 8

The position of the point is:
X: 90.0
Y: 50.0
Z: -10.0

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 5

Enter degrees to rotate point along x axis: 20

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 8

The position of the point is:
X: 90.0
Y: 50.4
Z: 7.8

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 6

Enter degrees to rotate point along y axis: 30

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 8

The position of the point is:
X: 81.9
Y: 50.4
Z: -34.1

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 7

Degrees to rotate point along z axis: 90

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 8

The position of the point is:
X: -50.4
Y: -50.4
Z: -34.1

-------------------------------------
            MAIN MENU
 1. Set location (defaults at 0)
 2. Shift point along X axis
 3. Shift point along Y axis
 4. Shift point along Z axis
 5. Rotate point around X axis
 6. Rotate point around Y axis
 7. Rotate point around Z axis
 8. Display point's location
 9. Quit
-------------------------------------
Enter selection: 9

Goodbye!

Press any key to continue . . .
*/
