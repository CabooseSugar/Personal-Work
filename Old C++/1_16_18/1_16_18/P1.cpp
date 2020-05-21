#include <iostream>
#include <cmath>
using namespace std;
#include "P1.h"

// implementation section
Circle::Circle(int x, int y)
{
	xCent = x;
	yCent = y;
}

float Circle::scaleFactor = 0.75;

void Circle::setCenter()
{
	cout << "Enter x value for center: ";
	cin >> xCent;
	cout << "Enter y value for center: ";
	cin >> yCent;
}
void Circle::scale();
{

}
