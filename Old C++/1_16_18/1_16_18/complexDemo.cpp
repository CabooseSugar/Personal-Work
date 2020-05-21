#include <iostream>
using namespace std;
#include "Complex.h"

int main()
{
	Complex a(3.2, 5.6), b(1.1, -8.4);
	float re, im;
	cout << "\nThe first complex number is ";
	a.display();
	cout << "\nThe second complex number is ";
	b.display();
	re = addreal(a, b);
	im = addimag(a, b);
	Complex c(re, im);  // create a new Complex object
	cout << "\n\nThe sum of these two complex numbers is ";
	c.display();
	cout << endl;
	return 0;
}
