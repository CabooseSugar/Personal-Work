/**************************************************************************************
* file name: Wolf_5_8.cpp
* programmer name: Kyle Wolf
* date created: 2/22/2018
* date of last revision: 3/1/18
* details of the revision: Changed from dynamic array attempt to fixed array size
* short description: Define functions in Courses class
***************************************************************************************/

#include <iostream>
#include <string>
#include <fstream>
#include "Courses.h"
using namespace std;

void StudentList::addNewStudent(Course*& headPtr, const string& sName, const string& cName, const int& units, const double& grade)
{
// Postcondition: A new student has been added to the array with one course included
	studentName = sName;
	listHeadInsert(headPtr, cName, units, grade);
}

int StudentList::listSize(Course* headPtr) const
// Postcondition: The size of the linked list of the object has been returned
{
	Course* index;
	int count = 0;

	index = headPtr;

	for (index; index != NULL; index->link)
		count++;

	return count;
}

void StudentList::listHeadInsert(Course*& headPtr, const string& name, const int& units, const double& grade)
{
// Postcondition: The first course has been added to the linked list as the head node
	Course* newHead = new Course;

	newHead->courseName = name;
	newHead->courseUnits = units;
	newHead->courseGrade = grade;
	headPtr = newHead;
	newHead->link = NULL;
}

void StudentList::listTailInsert(Course*& headPtr, const string& name, const int& units, const double& grade)
{
// Postcondition: A new course has been added to the linked list at the end of the list
	Course* index, *newCourse = new Course;

	newCourse->courseName = name;
	newCourse->courseUnits = units;
	newCourse->courseGrade = grade;

	index = headPtr;
	
	while (index->link != NULL)
		index = index->link;

	index->link = newCourse;
	newCourse->link = NULL;
}

void StudentList::listRemove(Course*& headPtr, const int& target)
{
// Postcondition: One course has been removed from the linked list
	int count;
	Course* removePtr, *previousPtr;

	if (target == 0)
	{
		removePtr = headPtr;
		headPtr = headPtr->link;
		delete removePtr;
		return;
	}

	previousPtr = headPtr;

	for (count = 0; count < target; count++)
	{
		previousPtr = previousPtr->link;
	}

	removePtr = previousPtr->link;
	previousPtr->link = removePtr->link;
	delete removePtr;
}

void StudentList::listDisplay(Course* headPtr)
// Postcondition: The contents of the linked list has been returned and the calculated GPA has been printed to the screen, name of student is handled in main function
{
	Course* cursor;
	int count = 1;
	double GPA = 0;

	for (cursor = headPtr; cursor != NULL; cursor = cursor->link)
	{
		cout << "Course " << count << ": " << cursor->courseName << endl;
		cout << "Units: " << cursor->courseUnits << endl;
		cout << "Grade: " << cursor->courseGrade << endl << endl;

		GPA += ((cursor->courseGrade / 20) - 1);

		count++;
	}

	GPA /= count - 1;
	cout << "GPA: " << GPA << endl;
}

void StudentList::writeList(Course* headPtr)
{
// Postcondition: The results of the user's inputs have been written to the file results.txt
	ofstream outFile;
	Course* cursor;

	outFile.open("results.txt", ios::app);

	if (outFile.fail()) {
		cout << "Failed to open file." << endl;
		exit(1);
	}

	outFile << studentName << endl;
	
	for (cursor = headPtr; cursor != NULL; cursor = cursor->link)
	{
		outFile << cursor->courseName << endl;
		outFile << cursor->courseUnits << endl;
		outFile << cursor->courseGrade << endl;
	}

	outFile << "-" << endl;
	outFile.close();
}

void StudentList::readList(Course* headPtr, ifstream& inFile)
{
// Postcondition: The results of the user's  inputs have been read from the file results.txt
	string name;
	int units;
	double grade;

	inFile >> studentName;

	inFile >> name;
	inFile >> units;
	inFile >> grade;

	listHeadInsert(headPtr, name, units, grade);

	while (name != "-") 
	{
		inFile >> name;
		inFile >> units;
		inFile >> grade;
		listTailInsert(headPtr, name, units, grade);
	}
}




