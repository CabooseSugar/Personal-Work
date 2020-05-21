#include "poly1.h"
#include <cmath>
using namespace std;	

namespace main_savitch_4
{
	template <class CoefType>
	polynomial<CoefType>::polynomial()
	{
		current_array_size = 1;
		coef = new <CoefType>[current_array_size];
		coef[i] = 0;
	}

	template <class CoefType>
	polynomial<CoefType>::polynomial(CoefType c, unsigned int exponent = 0)
	{
		coef = new <CoefType>[exponent + 1];
		coef[exponent] = c;
	}

	template <class CoefType>
	polynomial<CoefType>::polynomial(const polynomial& source)
	{
		current_array_size = source.current_array_size;
		coef = new <CoefType>[current_array_size];
		for (int i = 0; i < current_array_size; i++)
			coef[i] = source[i];
	}

	template <class CoefType>
	polynomial<CoefType>::~polynomial()
	{
		delete[] coef;
	}

	// MODIFICATION MEMBER FUNCTIONS
	template <class CoefType>
	void polynomial<CoefType>::add_to_coef(CoefType amount, unsigned int exponent)
	{
		coef[exponent] += amount;
	}

	template <class CoefType>
	void polynomial<CoefType>::assign_coef(CoefType coeffeicient, unsigned int exponent)
	{
		coef[exponent] = coeffeicient;
	}

	template <class CoefType>
	void polynomial<CoefType>::clear()
	{
		delete coef;
		current_array_size = 1;
		coef = new <CoefType>[current_array_size];
		coef[0] = 0;
	}

	template <class CoefType>
	void polynomial<CoefType>::reserve(size_t number)
	{
		<CoefType>* largerArray;

		if (number == current_array_size)
			return;

		if (number < current_array_size)
			number = current_array_size;

		largerArray = new <CoefType>[number];
		copy(coef, coef + current_array_size, largerArray);
		delete[] coef;
		coef = largerArray;
		capacity = new_capacity;
	}

	// MODIFICATION OPERATORS
	template <class CoefType>
	polynomial<CoefType>&  polynomial<CoefType>::operator =(const polynomial& source)
	{
		current_array_size = source.current_array_size;
		for (int i = 0; i < current_array_size; i++)
			coef[i] = source[i];
		return *this;
	}

	template <class CoefType>
	polynomial<CoefType>&  polynomial<CoefType>::operator -=(const polynomial& p)
	{
		if (p.current_array_size > current_array_size)
		{
			for (int i = 0; i < current_array_size; i++)
				coef[i] -= p.coef[i];
			current_array_size = p.current_array_size;
			for (int j = i; j < current_array_size; j++)
				coef[j] = -(p.coef[j]);
		}

		else
			for (int i = 0; i < p.current_array_size; i++)
				coef[i] -= p.coef[i];

		return *this;
	}

	template <class CoefType>
	polynomial<CoefType>&  polynomial<CoefType>::operator +=(const polynomial& p)
	{
		if (p.current_array_size > current_array_size)
		{
			for (int i = 0; i < current_array_size; i++)
				coef[i] += p.coef[i];
			current_array_size = p.current_array_size;
			for (int j = i; j < current_array_size; j++)
				coef[j] = p.coef[j];
		}

		else
			for (int i = 0; i < p.current_array_size; i++)
				coef[i] += p.coef[i];

		return *this;
	}

	template <class CoefType>
	polynomial<CoefType>&  polynomial<CoefType>::operator *=(const polynomial& p)
	{
		if (p.current_array_size > current_array_size)
			for (int i = 0; i < current_array_size; i++)
				coef[i] *= p.coef[i];

		else
			for (int i = 0; i < p.current_array_size; i++)
				coef[i] *= p.coef[i];

		return *this;
	}

	template <class CoefType>
	polynomial<CoefType>&  polynomial<CoefType>::operator *=(CoefType c)
	{
		for (int i = 0; i < current_array_size; i++)
			coef[i] *= c;
	}

	// CONSTANT MEMBER FUNCTIONS
	template <class CoefType>
	CoefType polynomial<CoefType>::coefficient(unsigned int exponent) const
	{
		return coef[exponent];
	}

	template <class CoefType>
	unsigned int polynomial<CoefType>::degree() const
	{
		int i = 0;

		while (i < current_array_size)
		{
			i++;

			if (coef[i] == 0)
			{
				current_array_size--;
				i = 0;
			}
			break;
		}
		return i;
	}

	template <class CoefType>
	double  polynomial<CoefType>::eval(double x) const
	{
		double answer = 0;
		int i = 0;
		
		answer += coef[i];
		for (i = 1; i < current_array_size; i++)
			answer += pow((coef[i]), i);

		return answer;
	}

	// CONSTANT OPERATORS
	template <class CoefType>
	polynomial<CoefType> polynomial<CoefType>::operator -() const
	{
		for (int i = 0; i < current_array_size; i++)
			eval[i] *= -1;

		return *this;
	}

	// NON-MEMBER BINARY OPERATORS
	
}
