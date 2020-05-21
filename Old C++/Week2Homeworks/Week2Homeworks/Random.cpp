/*********************************************************
* file name: Random.cpp
* programmer name: Kyle Wolf
* date created: 1/24/2018
* date of last revision: 1/24/2018
* details of the revision:
* short description: Define the member functions of the Random class
**********************************************************/

#include <iostream>
#include "Random.h"
using namespace std;
using namespace wolf_randomNum;

namespace wolf_randomNum 
{
	Random::Random(int seed, int multi, int incrmnt, int mod) 
	{
		//precondition: Values passed for seed, multi, incrmnt, and mod variables of type int
		//postcondition: The variables have been set
		numSeed = seed;
		numMulti = multi;
		numIncrmnt = incrmnt;
		numMod = mod;
}
	void Random::setSeed(int seed)
	{
		//precondition: Value passed for seed variable of type int
		//postcondition: The seed variable has been changed
		seed = numSeed;
	}

	int Random::genRandNum()
	{
		//precondition: Called from Wolf_2_11.cpp
		//postcondition: The numSeed variable has been calculated and returned

		// Calculations
		numSeed = (numMulti * numSeed + numIncrmnt) % numMod;
		return numSeed;
	}
}