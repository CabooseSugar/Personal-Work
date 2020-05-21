/*********************************************************
* file name: Space.cpp
* programmer name: Kyle Wolf
* date created: 1/15/2018
* date of last revision:
* details of the revision:
* short description: Define member functions of Space class
**********************************************************/

#include<iostream>
#include <iomanip>
#include <cstdlib>
#include <cmath>
#include "Space.h"
using namespace std;
using namespace wolf_3Dpoint;

namespace wolf_3Dpoint
{
	Space::Space(float x, float y, float z)
	{
		position_x = x;
		position_y= y;
		position_z = z;
	}
	void Space::setSpace(float x, float y, float z)
	{
		//precondition: Values passed for x, y, and z position must be of type float
		//postcondition: The position is set
		position_x = x;
		position_y = y;
		position_z = z;
	}
	void Space::shiftX(float amount) {
		//precondition: Value for x axis position must exist and be of type float
		//postcondition: The position on the x axis is shifted the desired amount

		// Calculations
		position_x += amount;
	}
	void Space::shiftY(float amount) {
		//precondition: Value for y axis position must exist and be of type float
		//postcondition: The position on the y axis is shifted the desired amount

		// Calculations
		position_y += amount;
	}
	void Space::shiftZ(float amount) {
		//precondition: Value for z axis position must exist and be of type float
		//postcondition: The position on the z axis is shifted the desired amount

		// Calculations
		position_z += amount;
	}
	void Space::rotateOnX(float rads ) {
		//precondition: Values for y and z axis positions must exist and be of type float
		//postcondition: The point is rotated along the x axis the desired amount

		// Calculations
		position_y = (position_y * cos(rads)) - (position_z * sin(rads));
		position_z = (position_y * sin(rads)) + (position_z * cos(rads));
	}
	void Space::rotateOnY(float rads) {
		//precondition: Values for x and z axis positions must exist and be of type float
		//postcondition: The point is rotated along the y axis the desired amount

		// Calculations
		position_x = (position_x * cos(rads)) + (position_z * sin(rads));
		position_z = ( -(position_x) * sin(rads)) + (position_z * cos(rads));
	}
	void Space::rotateOnZ(float rads) {
		//precondition: Values for x and y axis positions must exist and be of type float
		//postcondition: The point is rotated along the z axis the desired amount

		// Calculations
		position_x = (position_x * cos(rads)) - (position_y * sin(rads));
		position_y = (position_x * sin(rads)) + (position_y * cos(rads));
	}
	void Space::showSpace()
	{
		//precondition: Values passed for x, y, and z position must exist and be of type float
		//postcondition: The position is displayed

		// Display the results
		cout << "\nThe position of the point is: " << endl
			<< "X: " << fixed << setprecision(1) << position_x << endl
			<< "Y: " << position_y << endl
			<< "Z: " << position_z << endl;
	}
}