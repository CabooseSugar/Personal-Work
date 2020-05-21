/*********************************************************
* file name: Quad.h
* programmer name: Kyle Wolf
* date created: 1/16/2018
* date of last revision: 1/30/2018
* details of the revision: Moved overload operator declarations outside of public
* short description: Declare the Quad class, its data members, functions, and overload operators
**********************************************************/

#ifndef QUAD_H
#define QUAD_H

namespace wolf_quadraticExpression
{
	class Quad 
	{
	private:
		float coeff_A;
		float coeff_B;
		float coeff_C;
	public:
		// constructor
		Quad(float = 0, float = 0, float = 0);	
		// member function to change the coefficients
		void changeCoeffs(float, float, float);		
		// member function to evaluate the expression with a given x value
		float eval(float);							

		// member function to retrieve a coefficient value	
		float aValue() const { return coeff_A; }	
		// member function to retrieve b coefficient value
		float bValue() const { return coeff_B; }		
		// member function to retrieve c coefficient value	
		float cValue() const { return coeff_C; }	
	};

	Quad operator+(const Quad&, const Quad&); // overload operator to add two expressions' coefficient values together 
	Quad operator *(double, const Quad&);	// overload operator to multiply expression's coefficient values by a given value

}


#endif