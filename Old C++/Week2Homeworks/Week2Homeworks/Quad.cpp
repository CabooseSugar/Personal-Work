/***************************************************************************************
* file name: Quad.cpp
* programmer name: Kyle Wolf
* date created: 1/16/2018
* date of last revision: 1/30/2018
* details of the revision: Changed overload operators to function outside of public
* short description: Define the member functions and overload operators of Quad class
***************************************************************************************/

#include<iostream>
#include<cstdlib>
#include <cmath>
using namespace std;
#include "Quad.h"

namespace wolf_quadraticExpression 
{
	Quad::Quad(float a, float b, float c)
	{
		coeff_A = a;
		coeff_B = b;
		coeff_C = c;
	}
	void Quad::changeCoeffs(float a, float b, float c)
	{
		//precondition: Values passed for a, b, and c coefficients of type float
		//postcondition: The coefficients have been changed
		coeff_A = a;
		coeff_B = b;
		coeff_C = c;
	}
	float Quad::eval(float x)
	{
		//precondition: Values passed for a, b, and c coefficients of type float and a x variable value of type float
		//postcondition: The expression has been evaluated
		return ((coeff_A * pow(x, 2)) + (coeff_B * x) + coeff_C);
	}

	int Quad::findRoots() 
	{
		//precondition: None
		//postcondition: The number of real roots has been found
		if (coeff_A == 0)
			if (coeff_B == 0)
				if (coeff_C == 0)
					numRoots = 3;
				else
					numRoots = 0;
			else
				numRoots = 1;
		else if (pow(coeff_B, 2) < (4 * coeff_A * coeff_C))
			numRoots = 0;
		else if (pow(coeff_B, 2) == (4 * coeff_A * coeff_C))
			numRoots = 1;
		else
			numRoots = 2;

		if (numRoots == 1)
			smallRoot();
		if (numRoots == 2 || numRoots == 3) {
			smallRoot();
			largeRoot();
		}

		return numRoots;
	}
	float Quad::smallRoot() {
		//precondition: At least one real root exists
		//postcondition: The smaller real root value is returned (0 for infinite real roots)
		float rootVal;

		if (numRoots == 1) {
			if (coeff_A == 0) 
				rootVal = -(coeff_C) / coeff_B;
			else 
				rootVal = -(coeff_B) / (2 * coeff_A);

			return rootVal;
		}
		if (numRoots == 2) {
			rootVal = (-(coeff_B) - (sqrt((pow(coeff_B, 2) - (4 * coeff_A * coeff_C))) / (2 * coeff_A)));
			return rootVal;
		}
		if (numRoots == 3)
			return 0;
	}
	float Quad::largeRoot() {
		//precondition: At least two real roots exist
		//postcondition: The larger real root value is returned (0 for infinite real roots)
		float rootVal;

		if (numRoots == 2) {
			rootVal = (-(coeff_B) + (sqrt((pow(coeff_B, 2) - (4 * coeff_A * coeff_C))) / (2 * coeff_A)));
			return rootVal;
		}
		if (numRoots == 3) 
			return 0;
	}

	Quad operator+(const Quad& q1, const Quad& q2) {
		//precondition: Values passed for a, b, and c coefficients of type float for two expressions
		//postcondition: The expressions' coefficients have been added together
		float newA, newB, newC;
		Quad totals;
		newA = q1.aValue() + q2.aValue();  //use get functions
		newB = q1.bValue() + q2.bValue();
		newC = q1.cValue() + q2.cValue();
		
		totals.changeCoeffs(newA, newB, newC);
		return totals;
	}
	Quad operator *(double r, const Quad& q) {
		//precondition: Values passed for a, b, and c coefficients of type float and a mutliplication value r of type double
		//postcondition: The coefficients have been multiplied by r
		float newA, newB, newC;
		Quad totals;
		newA = q.aValue() * r;
		newB = q.bValue() * r;
		newC = q.cValue() * r;

		totals.changeCoeffs(newA, newB, newC);
		return totals;
	}
}