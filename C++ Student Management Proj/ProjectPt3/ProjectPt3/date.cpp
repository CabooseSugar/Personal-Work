#include<iostream>
#include <cstdlib>
#include "date.h"
using namespace std;

date::date(int mm, int dd, int yy)
{
	month = mm;
	day = dd;
	year = yy;
}
void date::setdate(int mm, int dd, int yy)
{
	//precondition: Values passed for month, day and year must be of type integer
	//postcondition: The date has been set
	month = mm;
	day = dd;
	year = yy;
}
void date::showdate()
{
	cout << "The date is " << month << "/" << day << "/" << year << "\n";
}