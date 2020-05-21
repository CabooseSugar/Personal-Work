#include "Task.h"
#include <string>
#include <iostream>
using namespace std;

// Functions to edit list of tasks
void Task::increaseListSize(TaskList* headPtr, const int taskNum)
{
	Task::TaskList *newheadPtr = headPtr;

	if (headPtr == NULL)	// since headPtr is initialized as pointing to a node in Objective.h, need this bit for when ClearTaskList reduces list to 0 size
	{
		headPtr = new Task::TaskList;
		return;
	}

	for (int i = 0; i < taskNum - 1; i++)
	{
		newheadPtr = newheadPtr->link;
	}

	newheadPtr->link = new Task::TaskList;
	newheadPtr->link->link = NULL; // done this way so ptr->link != NULL checks work in other functions
}

void Task::clearList(TaskList* headPtr)
{
	while (headPtr != NULL)
	{
		Task::TaskList *removePtr;
		removePtr = headPtr;
		headPtr = headPtr->link;
		delete removePtr;
	}
}

// Functions to change each of the elements
void Task::changeName(TaskList* headPtr, const string entry, const int taskNum)
{
	for (int i = 0; i != taskNum - 1; i++)	// subtracted everything by one here, so in main() don't worry about starting from zero (including for resources vector)
		headPtr = headPtr->link;

	headPtr->name = entry;
}

void Task::changeDesc(TaskList* headPtr, const string entry, const int taskNum)
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	headPtr->description = entry;
}

void Task::changeStartDate(TaskList* headPtr, const int monthEntry, const int dayEntry, const int yearEntry, const int taskNum)
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	headPtr->startDate.setdate(monthEntry, dayEntry, yearEntry);
}

void Task::changeDueDate(TaskList* headPtr, const int monthEntry, const int dayEntry, const int yearEntry, const int taskNum)
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	headPtr->dueDate.setdate(monthEntry, dayEntry, yearEntry);
}

void Task::changeTime(TaskList* headPtr, const double entry, const int taskNum)
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	headPtr->time = entry;
}

void Task::changeResources(TaskList* headPtr, const string entry, const int taskNum, const int resourceNum)
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	if (resourceNum - 1 == headPtr->resources.size())
	{
		headPtr->resources.push_back(entry);
		return;
	}

	headPtr->resources[resourceNum - 1] = entry;
}

void Task::changeStatus(TaskList* headPtr, const char entry, const int taskNum)
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	headPtr->status = entry;
}

// get functions
string Task::getName(TaskList* headPtr, const int taskNum) const
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	return headPtr->name;
}
string Task::getDesc(TaskList* headPtr, const int taskNum) const
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	return headPtr->description;
}

date Task::getStartDate(TaskList* headPtr, const int taskNum) const
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	return headPtr->startDate;
}

date Task::getDueDate(TaskList* headPtr, const int taskNum) const
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	return headPtr->dueDate;
}

double Task::getTime(TaskList* headPtr, const int taskNum) const
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	return headPtr->time;
}

string Task::getResource(TaskList* headPtr, const int taskNum, const int resourceNum) const
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	return headPtr->resources[resourceNum - 1];
}

char Task::getStatus(TaskList* headPtr, const int taskNum) const
{
	for (int i = 0; i != taskNum - 1; i++)
		headPtr = headPtr->link;

	return headPtr->status;
}


// display functions
// TASK DESCRIPTIONS GETTING ONE LETTER CUTOFF 
void Task::displayFull(TaskList* headPtr) const
{
	int taskIndex = 1;

	for (headPtr; headPtr != NULL; headPtr = headPtr->link)
	{
		cout << "\n\tTASK " << taskIndex << ":" << endl
			<< "\tName: " << headPtr->name << endl
			<< "\tDescription: " << headPtr->description << endl
			<< "\tStart Date: " << headPtr->startDate.getMonth() << "/" << headPtr->startDate.getDay() << "/" << headPtr->startDate.getYear() << endl
			<< "\tDue Date: " << headPtr->dueDate.getMonth() << "/" << headPtr->dueDate.getDay() << "/" << headPtr->dueDate.getYear() << endl
			<< "\tTime to complete: " << headPtr->time << " hours" << endl;
		for (int resourceIndex = 0; resourceIndex < headPtr->resources.size(); resourceIndex++)
			cout << "\tResource " << resourceIndex + 1 << ": " << headPtr->resources[resourceIndex] << endl;
		cout << "\tStatus (C/c for Complete, I/i for In Progress): " << headPtr->status << endl;
		taskIndex++;
	}
}

void Task::displayCritical(TaskList* headPtr) const
{
	int taskIndex = 1;

	for (headPtr; headPtr != NULL; headPtr = headPtr->link)
	{
		cout << "\n\tTASK " << taskIndex << ":" << endl
			<< "\tName: " << headPtr->name << endl
			<< "\tDue Date: " << headPtr->dueDate.getMonth() << "/" << headPtr->dueDate.getDay() << "/" << headPtr->dueDate.getYear() << endl
			<< "\tTime to complete: " << headPtr->time << " hours" << endl
			<< "\tStatus (C/c for Complete, I/i for In Progress): " << headPtr->status << endl;
		taskIndex++;
	}
}

void Task::writeTo(TaskList* headPtr, ofstream& file)
{
	for (headPtr; headPtr != NULL; headPtr = headPtr->link)
	{
		file << headPtr->name << endl
			<< headPtr->description << endl
			<< headPtr->startDate.getMonth() << endl
			<< headPtr->startDate.getDay() << endl
			<< headPtr->startDate.getYear() << endl
			<< headPtr->dueDate.getMonth() << endl
			<< headPtr->dueDate.getDay() << endl
			<< headPtr->dueDate.getYear() << endl
			<< headPtr->time << endl
			<< headPtr->status << endl;
		for (int i = 0; i < headPtr->resources.size(); i++)
			file << headPtr->resources[i] << endl;
		file << "**" << endl; // marks end of task resources
	}
}

void Task::readFrom(TaskList* headPtr, ifstream& file)
{

}