/*********************************************************
* file name: Space.h
* programmer name: Kyle Wolf
* date created: 1/15/2018
* date of last revision:
* details of the revision: 
* short description: Declare the Space class and its data members and functions
**********************************************************/


#ifndef SPACE_H
#define SPACE_H

namespace wolf_3Dpoint
{
	class Space
	{
	private:
		float position_x;
		float position_y;
		float position_z;
	public:
		Space(float = 0, float = 0, float = 0); // constructor
		void setSpace(float, float, float);						// member function to assign a position
		void shiftX(float);							// member function to shift the position on the x axis
		void shiftY(float);							// member function to shift the position on the y axis
		void shiftZ(float);							// member function to shift the position on the z axis
		void rotateOnX(float);						// member function to rotate the point around the x axis
		void rotateOnY(float);						// member function to rotate the point around the y axis
		void rotateOnZ(float);						// member function to rotate the point around the z axis
		void showSpace();							// member function to display position
	};
}

#endif