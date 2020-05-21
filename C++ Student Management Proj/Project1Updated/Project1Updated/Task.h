#ifndef TASK_H
#define TASK_H

#include <vector>
#include <string>
#include <fstream>
#include "date.h" // the date class is from an old lesson
using namespace std;

class Task
{
public:
	struct TaskList
	{
		int used, capacity;
		string name, description;
		vector <string> resources;
		double time;
		char status;
		date startDate, dueDate; // declaring objects of date class
		TaskList* link;
	};

	// Functions to edit list
	void initializeList(TaskList* headPtr) { headPtr->link = NULL; };	// this function is because I was having trouble making the constructor do it, sets first link to NULL for NULL checks in other functions. Calling increaseTaskList will handle NULLs from then on
	void increaseListSize(TaskList* headPtr, const int taskNum); // defined in .cpp
	void clearList(TaskList* headPtr);

	// Functions to change each of the elements
	void changeName(TaskList* headPtr, const string entry, const int taskNum);
	void changeDesc(TaskList* headPtr, const string entry, const int taskNum);
	void changeStartDate(TaskList* headPtr, const int monthEntry, const int dayEntry, const int yearEntry, const int taskNum);
	void changeDueDate(TaskList* headPtr, const int monthEntry, const int dayEntry, const int yearEntry, const int taskNum);
	void changeTime(TaskList* headPtr, const double entry, const int taskNum);
	void changeResources(TaskList* headPtr, const string entry, const int taskNum, const int resourceNum); // only changes one resources at a time, needs a for loop in main
	void changeStatus(TaskList* headPtr, const char entry, const int taskNum);

	// get functions
	string getName(TaskList* headPtr, const int taskNum) const;
	string getDesc(TaskList* headPtr, const int taskNum) const;
	date getStartDate(TaskList* headPtr, const int taskNum) const;
	date getDueDate(TaskList* headPtr, const int taskNum) const;
	double getTime(TaskList* headPtr, const int taskNum) const;
	string getResource(TaskList* headPtr, const int taskNum, const int resourceNum) const; // only returns one resources at a time, needs a for loop in main
	char getStatus(TaskList* headPtr, const int taskNum) const;
	
	// Display functions
	void displayFull(TaskList* headPtr) const;
	void displayCritical(TaskList* headPtr) const;

	// File Read + Write Functions
	void writeTo(TaskList* headPtr, ofstream& file);
	void readFrom(TaskList* headPtr, ifstream& file);
};

#endif