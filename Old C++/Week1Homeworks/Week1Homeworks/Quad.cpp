/*********************************************************
* file name: Quad.cpp
* programmer name: Kyle Wolf
* date created: 1/16/2018
* date of last revision: 1/30/2018
* details of the revision: Changed overload operators to function outside of public
* short description: Define the member functions and overload operators of Quad class
**********************************************************/

#include<iostream>
#include<cstdlib>
#include <cmath>
using namespace std;
#include "Quad.h"
using namespace wolf_quadraticExpression;

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
	Quad operator+(const Quad& q1, const Quad& q2) {
		//precondition: Values passed for a, b, and c coefficients of type float for two expressions
		//postcondition: The expressions' coefficients have been added together
		float newA, newB, newC;
		Quad totals;

		newA = q1.aValue() + q2.aValue();
		newB = q1.bValue() + q2.bValue();
		newC = q1.cValue() + q2.cValue();

		totals.changeCoeffs(newA, newB, newC);
		
		return totals;
	}
	Quad operator *(double r, const Quad& q) {
		//precondition: Values passed for a, b, and c coefficients of type float and a mutliplication value r of type float
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