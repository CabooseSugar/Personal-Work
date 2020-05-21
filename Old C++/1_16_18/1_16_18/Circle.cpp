#include <iostream>
using namespace std;
#include "Circle.h"

float Circle::scaleFactor = 2;

Circle::Circle(int x, int y, float r)
{
	xCent = x;
	yCent = y;
	radius = r;
}

void Circle::scaleRadius()
{
	radius *= scaleFactor;
}

void Circle::setRadius(float r)
{
	radius = r;
}

void Circle::setXCent(int x)
{
	xCent = x;
}

void Circle::setYCent(int y)
{
	yCent = y;
}

void Circle::setXYCent(int x, int y)
{
	xCent = x;
	yCent = y;
}

int Circle::getXCent() {
	return xCent;
}

void Circle::setScaleFactor(float f)
{
	scaleFactor = f;
}