#include "Objective.h"
#include <algorithm>
#include <iostream>
using namespace std;

// Constructor
Objective::Objective(int initialCapacity)
{
	resources = new string[initialCapacity];
	capacity = initialCapacity;
	used = 0;
}

// Modification Functions
void Objective::changeStartDate(const int dayEntry, const int monthEntry, const int yearEntry)
{
	startDate.month = monthEntry;
	startDate.day = dayEntry;
	startDate.year = yearEntry;
}

void Objective::changeDueDate(const int dayEntry, const int monthEntry, const int yearEntry)
{
	dueDate.month = monthEntry;
	dueDate.day = dayEntry;
	dueDate.year = yearEntry;
}

void Objective::changeResources(const string entry)
{
	if (used == capacity)
		resourcesReserve(used + 1);
	resources[used] = entry; 
	used++;
}

void Objective::resourcesReserve(int newCapacity)
{
	string *largerArray;

	if (newCapacity == capacity)
		return; // The allocated memory is already the right size.

	if (newCapacity < used)
		newCapacity = used; // Can’t allocate less than we are using.

	largerArray = new string[newCapacity];
	copy(resources, resources + used, largerArray);
	delete[] resources;
	resources = largerArray;
	capacity = newCapacity;
}

void Objective::resourcesClear()
{
	int index = 0;

	while (used != 0)
	{
		used--;
		resources[index] == resources[used];
		index++;
	}
}

// Display Functions
void Objective::displayFull() const
{
	cout << "\nName: " << name << endl
		<< "Description: " << description << endl
		<< "Category: " << category << endl
		<< "Priority (1-5, 5 being the highest priority): " << priority << endl
		<< "Start Date: " << startDate.month << "/" << startDate.day << "/" << startDate.year << endl
		<< "Due Date: " << dueDate.month << "/" << dueDate.day << "/" << dueDate.year << endl
		<< "Time to complete: " << time << " hours" << endl;
	for (int index = 0; index < used; index++)
		cout << "Resource " << index + 1 << ": " << resources[index] << endl;
	cout << "Status (C/c for Complete, I/i for In Progress): " << status << endl;

	// display tasks
	objTasks.displayFull(taskPtr);
}

void Objective::displayCritical() const
{
	cout << "\nName: " << name << endl
		<< "Priority (1-5, 5 being the highest priority): " << priority << endl
		<< "Due Date: " << dueDate.month << "/" << dueDate.day << "/" << dueDate.year << endl
		<< "Time to complete: " << time << " hours" << endl
		<< "Status (C/c for Complete, I/i for In Progress): " << status << endl;
	
	// display tasks
	objTasks.displayCritical(taskPtr);
}

// Read and write functions
void Objective::writeTo(ofstream& file) 
{
	file << name << endl
		<< description << endl
		<< category << endl
		<< priority << endl
		<< startDate.day << endl 
		<< startDate.month << endl 
		<< startDate.year << endl
		<< dueDate.day << endl
		<< dueDate.month  << endl
		<< dueDate.year << endl
		<< time << endl
		<< status << endl;
	for (int index = 0; index < used; index++)
		file << resources[index] << endl;
	file << "--" << endl; // marks end of objective resources
	objTasks.writeTo(taskPtr, file); // writing tasks
	file << "??" << endl; // marks end of oberall objective
}

void Objective::readFrom(ifstream& file)
{
	int index = 0;
	string resourceContent;

	getline(file, name);
	getline(file, description);
	file >> category;
	file >> priority;
	file >> startDate.day;
	file >> startDate.month;
	file >> startDate.year;
	file >> dueDate.day;
	file >> dueDate.month;
	file >> dueDate.year;
	file >> time;
	file >> status;

	while (1)
	{
		getline(file, resourceContent);
		if (resourceContent == "--")
			break;
		if (used == capacity)
			resourcesReserve(used + 1);
		resources[used] = resourceContent;
		used++;
	}
}
