// idea here is to have each objective stored in a vector in main()

#ifndef OBJECTIVE_H
#define OBJECTIVE_H
#include "Task.h"
#include <string>
#include <fstream>
#include <vector>
using namespace std;

class Objective
{
private:
	struct Date {
		int day;
		int month;
		int year;
	} startDate, dueDate;	// this defines two distinct instances of Date structures that can be independently called like in the getStartDateDay() or getDueDateDay() functions

	Task objTasks;
	Task::TaskList *taskPtr = new Task::TaskList; // declares head pointer to linked list of tasks defined in Task.h

	static const int defaultResCapacity = 3; // default capacity of dynamic array of resources
	string *resources, name, description;
	int category, priority, used, capacity;
	double time;
	char status;

public:
	// Constructor
	Objective(int initialCapacity = defaultResCapacity);
	
	// Modification Functions
	void changeName(const string entry) { name = entry; };
	void changeDesc(const string entry) { description = entry; };
	void changeCategory(const int entry) { category = entry; };
	void changePrior(const int entry) { priority = entry; };
	void changeStartDate(const int dayEntry, const int monthEntry, const int yearEntry); // defined in .cpp
	void changeDueDate(const int dayEntry, const int monthEntry, const int yearEntry); // defined in .cpp
	void changeTime(const double entry) { time = entry; };
	void changeResources(const string entry); // defined in .cpp
	void resourcesReserve(int newCapacity); // adjust size of dynamic array of resources as needed, defined in .cpp
	void resourcesClear();	// clears array of resources so if you edit it, it starts from scratch, defined in .cpp
	void changeStatus(const char entry) { status = entry; };
	
	// Modificaton functions using Task class - all inline which just call functions defined in Task.h/cpp 
	void initializeTaskList() { objTasks.initializeList(taskPtr); };
	void increaseTaskListSize(const int taskNum) { objTasks.increaseListSize(taskPtr, taskNum); };
	void clearTaskList() { objTasks.clearList(taskPtr); };	
	void changeTaskName(const string entry, const int taskNum) { objTasks.changeName(taskPtr, entry, taskNum ); };
	void changeTaskDesc(const string entry, const int taskNum) { objTasks.changeDesc(taskPtr, entry, taskNum); };
	void changeTaskStartDate(const int monthEntry, const int dayEntry, const int yearEntry, const int taskNum) { objTasks.changeStartDate(taskPtr, monthEntry, dayEntry, yearEntry, taskNum); };
	void changeTaskDueDate(const int monthEntry, const int dayEntry, const int yearEntry, const int taskNum) { objTasks.changeDueDate(taskPtr, monthEntry, dayEntry, yearEntry, taskNum); };
	void changeTaskTime(const double entry, const int taskNum) { objTasks.changeTime(taskPtr, entry, taskNum); };
	void changeTaskResources(const string entry, const int taskNum, const int resourceNum) { objTasks.changeResources(taskPtr, entry, taskNum, resourceNum); };
	void changeTaskStatus(const char entry, const int taskNum) { objTasks.changeStatus(taskPtr, entry, taskNum); };

	// Get Functions
	string getName() const { return name; };
	string getDesc() const { return description; };
	int getCategory() const { return category; };
	int getPriority() const { return priority; };
	int getStartDateDay() const { return startDate.day; }; // these get StartDates and dueDates are the only get functions that the program is actually using so far
	int getStartDateMonth() const { return startDate.month; };
	int getStartDateYear() const { return startDate.year; };
	int getDueDateDay() const { return dueDate.day; };
	int getDueDateMonth() const { return dueDate.month; };
	int getDueDateYear() const { return dueDate.year; };
	double getTime() const { return time; };
	string getResources(const int target) const { return resources[target]; }; // can only return one element of dynamic array at a time, has to be controlled by for loop
	char getStatus() const { return status; };

	// Get Functions using Task class
	void getTaskName(const int taskNum) const { objTasks.getName(taskPtr, taskNum); };
	void getTaskDesc(const int taskNum) const { objTasks.getDesc(taskPtr, taskNum); };
	void getTaskStartDate(const int taskNum) const { objTasks.getStartDate(taskPtr, taskNum); };
	void getTaskDueDate(const int taskNum) const { objTasks.getDueDate(taskPtr, taskNum); };
	void getTaskTime(const int taskNum) const { objTasks.getTime(taskPtr, taskNum); };
	void getTaskResources(const int taskNum, const int taskResourceNum) const { objTasks.getResource(taskPtr, taskNum, taskResourceNum); };
	void getTaskStatus(const int taskNum) const { objTasks.getStatus(taskPtr, taskNum); };
	
	// Display functions
	void displayFull() const; // edit to include Task functions
	void displayCritical() const;

	// File Read + Write Functions
	void writeTo(ofstream& file); 
	void readFrom(ifstream& file);
};

#endif 