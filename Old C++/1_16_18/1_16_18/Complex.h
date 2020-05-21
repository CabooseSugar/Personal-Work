class Complex // class declaration
{
	// friends list
	friend float addreal(Complex&, Complex&);
	friend float addimag(Complex&, Complex&);
private:
	float real;
	float imag;
public:
	Complex(float = 0, float = 0);  // constructor
	void display();
};
#pragma once
