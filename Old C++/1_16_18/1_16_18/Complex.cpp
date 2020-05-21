#include <iostream>
#include <cmath>
using namespace std;
#include "Complex.h"

// implementation section
Complex::Complex(float rl, float im)
{
	real = rl;
	imag = im;
}
void Complex::display()
{
	char sign = '+';
	if (imag < 0) sign = '-';
	cout << real << sign << fabs(imag) << 'i';
	return;
}
// friend implementations
float addreal(Complex &a, Complex &b)
{
	return(a.real + b.real);
}

float addimag(Complex &a, Complex &b)
{
	return(a.imag + b.imag);
}
