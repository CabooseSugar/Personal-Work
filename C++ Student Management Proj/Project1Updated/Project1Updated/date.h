#ifndef DATE_H
#define DATE_H
class date
{
private:
	int month;
	int day;
	int year;
public:
	date(int = 7, int = 4, int = 94);  // constructor
	void setdate(int, int, int); // member function to assign a date
	void showdate();            // member function to display a date

	int getMonth() const { return month; };
	int getDay() const { return day; };
	int getYear() const { return year; };
};

#endif
