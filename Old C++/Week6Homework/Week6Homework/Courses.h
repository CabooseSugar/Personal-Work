/**************************************************************************************
* file name: Wolf_5_8.cpp
* programmer name: Kyle Wolf
* date created: 2/22/2018
* date of last revision: 3/1/18
* details of the revision: Changed from dynamic array attempt to fixed array size
* short description: Declare Courses class and it's data members and functions
***************************************************************************************/

#ifndef COURSES_H
#define COURSES_H
#include <string>
#include <iostream>
using namespace std;

class StudentList
{
private:
	// Declaring variables
	string studentName;

public:
	// Linked list struct
	struct Course
	{
		string courseName;
		int courseUnits;
		double courseGrade;
		Course* link;
	};

	// Member function to add new student's information
	void StudentList::addNewStudent(Course*& headPtr, const string& sName, const string& cName, const int& units, const double& grade);

	// Linked list modification functions
	int listSize(Course* headPtr) const;
	void listHeadInsert(Course*& headPtr, const string& name, const int& units, const double& grade);
	void listTailInsert(Course*& headPtr, const string& name, const int& units, const double& grade);
	void listRemove(Course*& headPtr, const int& target);
	void listDisplay(Course* headPtr);
	
	// Read and write file functions
	void writeList(Course* headPtr);
	void readList(Course* headPtr, ifstream&);

	// Get function
	string getStudentName() { return studentName; };
};

#endif COURSES_H
