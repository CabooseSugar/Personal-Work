/**************************************************************************************
* file name: poly1.h
* programmer name: Kyle Wolf
* date created: 3/29/2018
* date of last revision:
* details of the revision:
* short description: Declare the data members and functions of the polynomial class template
***************************************************************************************/

#ifndef POLY1_H
#define POLY1_H
#include <cstdlib>      // Provides size_t type
#include <iostream>   // Provides istream and ostream 
using namespace std;

namespace main_savitch_4
{
	template <class CoefType> 
	class polynomial
    {
    public:
	// CONSTRUCTORS and DESTRUCTOR
	polynomial( );
	// Postcondition: coef array has been initialized as object of polynomial class has been created (constructor)
	polynomial(CoefType c, unsigned int exponent = 0);
	// Precondition: c is any data type that works with the inherent +=, -=, etc operators
	// Postcondition: an object of the polynomial class has been created with only a 0 value for constant (constructor)
	polynomial(const polynomial& source);
	// Postcondition: The object of the polynomial class has been copied (copy constructor)
	~polynomial( );
	// Postcondition: The object has been deleted (destructor)

	// MODIFICATION MEMBER FUNCTIONS
	void add_to_coef(CoefType amount, unsigned int exponent);
	// Precondition: amount is any data type that works with the inherent +=, -=, etc operators
	// Postcondition: amount has been added to the coefficient of the variable with the desired exponent
	void assign_coef(CoefType coefficient, unsigned int exponent);
	// Precondition: coefficient is any data type that works with the inherent +=, -=, etc operators
	// Postcondition: coefficient has been added for the variable with the appropriate exponent
	void clear( );
	// Postcondition: The array of coefs has been cleared
	void reserve(size_t number);
	// Postcondition: The size of the array has been adjusted
	
	// MODIFICATION OPERATORS
	polynomial& operator =(const polynomial& source);
	// Postcondition: polynomial object has been set equal to source
	polynomial& operator =(CoefType c) { clear( ); assign_coef(c, 0); return *this; }
	// Postcondition: coef of object has been set equal to c
	polynomial& operator -=(const polynomial& p);
	// Postcondition: polynomial object has had p subtracted from it
	polynomial& operator -=(CoefType c)
	    { add_to_coef(-c, 0); return *this; };
	// Postcondition: constant value has been subtracted from other object's constant value
	polynomial& operator +=(const polynomial& p);
	// Postcondition: polynomial object has had p added to it
	polynomial& operator +=(CoefType c)
	    { add_to_coef(c, 0); return *this; };
	// Postcondition: constant value has been added to other object's constant value
	polynomial& operator *=(const polynomial& p);
	// Postcondition: polynomial object has been multiplied by p
	polynomial& operator *=(CoefType c);
	// Postcondition: constant value has been multiplied by other object's constant value
	
	// CONSTANT MEMBER FUNCTIONS
	CoefType coefficient(unsigned int exponent) const;
	// Postcondition: value of coef at variable with desired exponent has been returned
	unsigned int degree( ) const;
	// Postcondition: exponent value of largest variable with a nonzero coef has been returned
	CoefType eval(CoefType x) const;
	// Postcondition: The polynomial expression has been evaluated for the value of x for the variables
	
	// CONSTANT OPERATORS
	CoefType operator( ) (CoefType x) const { return eval(x); }
	// Postcondition: The polynomial expression has been evaluated for the value of x for the variables
	polynomial operator -( );
	// Postcondition: the value of all the coefficients have been multiplied by -1


    private:
	size_t current_array_size;
	CoefType *coef;
    };
}

#include "poly1.template"
#endif
