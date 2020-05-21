/**************************************************************************************
* file name: Wolf_5_8.cpp
* programmer name: Kyle Wolf
* date created: 2/22/2018
* date of last revision: 3/1/18
* details of the revision: Changed from dynamic array attempt to fixed array size
* short description: Allow user to enter and manipulate list of students' courses
***************************************************************************************/
#include <iostream>    
#include <cstdlib> 
#include <fstream>
#include <iomanip>
#include <string>
#include "Courses.h" 
using namespace std;

void addStudent(int&, StudentList[], StudentList::Course*&);
// Postcondition: A new student has been added to the array with as many courses as desired
void removeStudent(int&, StudentList[]);
// Postcondition: A student has been removed from the array
void addCourse(int, StudentList[], StudentList::Course*&);
// Postcondition: A course has been added to an existing student's course list
void removeCourse(int, StudentList[], StudentList::Course*&);
// Postcondition: An existing course has been removed from a student's course list
void displayRecord(int, StudentList[], StudentList::Course*&);
// Postcondition: The course list of a student has been printed to the screen
void writeResults(int, StudentList[], StudentList::Course*&);
// Postcondition: The results of the user's inputs have been written to the file results.txt
void readResults(int&, int, StudentList[], StudentList::Course*&);
// Postcondition: The results of the user's inputs have been read from the file results.txt

int main()
{
	// Program description
	cout << "This program will allow the user to enter and manipulate." << endl
		<< "a list of students' courses." << endl;

	// Declaring the variables / objects
	StudentList::Course* coursePtr;
	const int maxSize = 10;
	StudentList list[maxSize];
	int selection, place = 0;

	// Selection menu
	while (1)
	{
		cout << "\n---------------------------------------" << endl
			<< setw(15) << ' ' << "MAIN MENU" << endl
			<< " 1. Add student's record" << endl
			<< " 2. Delete a student's record" << endl
			<< " 3. Add single course to a record" << endl
			<< " 4. Remove a single course from a record" << endl
			<< " 5. Display a student's record" << endl
			<< " 6. Write records to file" << endl
			<< " 7. Read records from a file" << endl
			<< " 8. Quit" << endl
			<< "---------------------------------------" << endl;

		// Variable initialization
		cout << "Enter selection: ";
		cin >> selection;

		switch (selection) {
		case 1:
			addStudent(place, list, coursePtr);
			break;
		case 2:
			removeStudent(place, list);
			break;
		case 3:
			addCourse(place, list, coursePtr);
			break;
		case 4:
			removeCourse(place, list, coursePtr);
			break;
		case 5:
			displayRecord(place, list, coursePtr);
			break;
		case 6:
			writeResults(place, list, coursePtr);
			break;
		case 7:
			readResults(place, maxSize, list, coursePtr);
			break;
		case 8:
			cout << "\nGoodbye!" << endl;
			return 0;
		default:
			cout << "\nInvalid entry." << endl;
		}
	}
}

void addStudent(int& i, StudentList list[], StudentList::Course*& coursePtr)
{
	string studentNameEntry, courseNameEntry;
	int unitsEntry;
	double gradeEntry;
	char moreCourses;

	cout << "\nEnter student's name: ";
	cin.ignore();
	getline(cin, studentNameEntry);
	cout << "Enter name of first course: ";
	getline(cin, courseNameEntry);
	cout << "Enter the number of units for the course: ";
	cin >> unitsEntry;
	cout << "Enter the grade for the course: ";
	cin >> gradeEntry;

	list[i].addNewStudent(coursePtr, studentNameEntry, courseNameEntry, unitsEntry, gradeEntry);

	while (1)
	{
		cout << "Continue entering courses? (Enter Y for Yes, N for No): ";
		cin >> moreCourses;
		
		if (moreCourses == 'Y' || moreCourses == 'y')
		{
			cout << "Enter name of course: ";
			cin.ignore();
			getline(cin, courseNameEntry);
			cout << "Enter the number of units for the course: ";
			cin >> unitsEntry;
			cout << "Enter the grade for the course: ";
			cin >> gradeEntry;

			list[i].listTailInsert(coursePtr, courseNameEntry, unitsEntry, gradeEntry);
		}

		else if (moreCourses == 'N' || moreCourses == 'n')
			break;

		else
			cout << "\nInvalid entry." << endl;
	}	

	// increment counter that keeps track of where the latest entry is in the array
	i++;
}

void removeStudent(int& place, StudentList list[])
{
	int remove;

	while (1)
	{
		for (int i = 0; i < place; i++)
			cout << i + 1 << ") " << list[i].getStudentName() << endl;
		cout << "\nEnter number of student record to remove: ";
		cin >> remove;

		if (remove < 1 || remove > place)
			cout << "Invalid entry." << endl;

		else
			break;
	}

	if (remove == place)	
		place--;

	else
	{
		list[remove - 1] = list[place - 1];
		place--;
	}

	cout << "\nStudent removed." << endl;
}

void addCourse(int place, StudentList list[], StudentList::Course*& coursePtr)
{
	string studentNameEntry, courseNameEntry;
	int unitsEntry, edit;
	double gradeEntry;

	while (1)
	{
		for (int i = 0; i < place; i++)
			cout << i + 1 << ") " << list[i].getStudentName() << endl;
		cout << "\nEnter number of student to add course to: ";
		cin >> edit;

		if (edit < 1 || edit > place)
			cout << "Invalid entry." << endl;

		else
			break;
	}

	cout << "Enter name of course: ";
	cin.ignore();
	getline(cin, courseNameEntry);
	cout << "Enter the number of units for the course: ";
	cin >> unitsEntry;
	cout << "Enter the grade for the course: ";
	cin >> gradeEntry;

	list[edit - 1].listTailInsert(coursePtr, courseNameEntry, unitsEntry, gradeEntry);
}

void removeCourse(int place, StudentList list[], StudentList::Course*& coursePtr)
{
	int remove, courseRemove;

	while (1)
	{
		for (int i = 0; i < place; i++)
			cout << i + 1 << ") " << list[i].getStudentName() << endl;
		cout << "\nEnter number of student to remove course from: ";
		cin >> remove;

		if (remove < 1 || remove > place)
			cout << "Invalid entry." << endl;

		else
			break;
	}
	
	list[remove - 1].listDisplay(coursePtr);

	cout << "\nNow enter number of course to remove: ";
	cin >> courseRemove;

	list[remove - 1].listRemove(coursePtr, (courseRemove - 1));

	cout << "\nSuccesfully removed course." << endl;	
}

void displayRecord(int place, StudentList list[], StudentList::Course*& coursePtr)
{
	int view;

	if (place == 0)
	{
		cout << "\nNothing to display." << endl;
		return;
	}

	while (1)
	{
		for (int i = 0; i < place; i++)
			cout << i + 1 << ") " << list[i].getStudentName() << endl;
		cout << "\nEnter number of student to see info: ";
		cin >> view;

		if (view < 1 || view > place)
			cout << "Invalid entry." << endl;

		else
			break;
	}

	cout << endl << list[view - 1].getStudentName() << ":" << endl;
	list[view - 1].listDisplay(coursePtr);
}

void writeResults(int place, StudentList list[], StudentList::Course*& coursePtr)
{
	for (int i = 0; i < place; i++)
		list[i].writeList(coursePtr);

	cout << "Succesfully wrote records." << endl;
}

void readResults(int& place, int max, StudentList list[], StudentList::Course*& coursePtr)
{
	ifstream inFile;
	int i;
	
	inFile.open("results.txt");

	if (inFile.fail()) {
		cout << "Failed to open file." << endl;
		exit(1);
	}

	
	for (i = 0; i < max; i++)
		list[i].readList(coursePtr, inFile);

	place = i;

	inFile.close();
}

/*
	This program will allow the user to enter and manipulate.
a list of students' courses.

---------------------------------------
               MAIN MENU
 1. Add student's record
 2. Delete a student's record
 3. Add single course to a record
 4. Remove a single course from a record
 5. Display a student's record
 6. Write records to file
 7. Read records from a file
 8. Quit
---------------------------------------
Enter selection: 1

Enter student's name: Bob
Enter name of first course: Math
Enter the number of units for the course: 3
Enter the grade for the course: 100
Continue entering courses? (Enter Y for Yes, N for No): N

---------------------------------------
               MAIN MENU
 1. Add student's record
 2. Delete a student's record
 3. Add single course to a record
 4. Remove a single course from a record
 5. Display a student's record
 6. Write records to file
 7. Read records from a file
 8. Quit
---------------------------------------
Enter selection: 1

Enter student's name: Billy
Enter name of first course: Algebra
Enter the number of units for the course: 4
Enter the grade for the course: 95
Continue entering courses? (Enter Y for Yes, N for No): Y
Enter name of course: Literature
Enter the number of units for the course: 3
Enter the grade for the course: 75
Continue entering courses? (Enter Y for Yes, N for No): N

---------------------------------------
               MAIN MENU
 1. Add student's record
 2. Delete a student's record
 3. Add single course to a record
 4. Remove a single course from a record
 5. Display a student's record
 6. Write records to file
 7. Read records from a file
 8. Quit
---------------------------------------
Enter selection: 5
1) Bob
2) Billy

Enter number of student to see info: 1

Bob:
Course 1: Algebra
Units: 4
Grade: 95

Course 2: Literature
Units: 3
Grade: 75

GPA: 3.25

---------------------------------------
               MAIN MENU
 1. Add student's record
 2. Delete a student's record
 3. Add single course to a record
 4. Remove a single course from a record
 5. Display a student's record
 6. Write records to file
 7. Read records from a file
 8. Quit
---------------------------------------
Enter selection: 4
1) Bob
2) Billy

Enter number of student to remove course from: 2
Course 1: Algebra
Units: 4
Grade: 95

Course 2: Literature
Units: 3
Grade: 75

GPA: 3.25

Now enter number of course to remove: 1

Succesfully removed course.

---------------------------------------
               MAIN MENU
 1. Add student's record
 2. Delete a student's record
 3. Add single course to a record
 4. Remove a single course from a record
 5. Display a student's record
 6. Write records to file
 7. Read records from a file
 8. Quit
---------------------------------------
Enter selection: 3
1) Bob
2) Billy

Enter number of student to add course to: 2
Enter name of course: Gym
Enter the number of units for the course: 3
Enter the grade for the course: 100

---------------------------------------
               MAIN MENU
 1. Add student's record
 2. Delete a student's record
 3. Add single course to a record
 4. Remove a single course from a record
 5. Display a student's record
 6. Write records to file
 7. Read records from a file
 8. Quit
---------------------------------------
Enter selection: 9

Invalid entry.

---------------------------------------
               MAIN MENU
 1. Add student's record
 2. Delete a student's record
 3. Add single course to a record
 4. Remove a single course from a record
 5. Display a student's record
 6. Write records to file
 7. Read records from a file
 8. Quit
---------------------------------------
Enter selection: 6

Succesfully wrote records.

---------------------------------------
               MAIN MENU
 1. Add student's record
 2. Delete a student's record
 3. Add single course to a record
 4. Remove a single course from a record
 5. Display a student's record
 6. Write records to file
 7. Read records from a file
 8. Quit
---------------------------------------
Enter selection: 8

Goodbye!
Press any key to continue . . .


RESULTS.TXT CONTENTS:
	Bob
	Literature
	3
	75
	Gym
	3
	100
	-
	Billy
	Literature
	3
	75
	Gym
	3
	100
	-

*/