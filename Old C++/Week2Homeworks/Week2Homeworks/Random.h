/*********************************************************
* file name: Random.h
* programmer name: Kyle Wolf
* date created: 1/24/2018
* date of last revision: 1/24/2018
* details of the revision:
* short description: Declare the Random class, its data members, and functions
**********************************************************/

#ifndef RANDOM_H
#define RANDOM_H

namespace wolf_randomNum 
{
	class Random 
	{
	private:
		int numSeed, numMulti, numIncrmnt, numMod;

	public:
		// constructor
		Random(int = 0, int = 40, int = 725, int = 729);
		// member function to change seed value
		void setSeed(int);
		// member function to generate a random number
		int genRandNum();
		
	};


}

#endif