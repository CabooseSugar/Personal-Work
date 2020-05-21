// HEADER FILE FOR THE TASK CLASS - FUNCTIONS TO POPULATE/EDIT/DISPLAY/DELETE/READ/WRITE LINKED LIST OF TASKS
#ifndef TASK_H
#define TASK_H

#include "TaskList.h"

class Task
{
private:
	TaskList* taskPtr;

public:
	Task() { taskPtr = NULL; };
	
	// Check that an empty node in TaskList exists if using change functions for a new task in main, makes one if needed
	void sizeCheck(const int taskMax);
	
	// FUNCTIONS TO CHANGE EACH OF THE ELEMENTS
	void changeName(const string entry, const int taskNum);
	void changeDesc(const string entry, const int taskNum);
	void changeStartDate(const date dateEntry, const int taskNum);
	void changeDueDate(const date dateEntry, const int taskNum);
	void changeTime(const double entry, const int taskNum);
	void changeResources(const vector<string> entryVector, const int taskNum);
	void changeStatus(const char entry, const int taskNum);

	// GET FUNCTIONS
	string getName(const int taskNum) const;
	string getDesc(const int taskNum) const;
	date getStartDate(const int taskNum) const;
	date getDueDate(const int taskNum) const;
	double getTime(const int taskNum) const;
	vector<string> getResources(const int taskNum) const;
	char getStatus(const int taskNum) const;
	int getTasksMax() const { return listLength(taskPtr); };
	
	// OBJECT MODIFICATION FUNCTIONS
	void deleteSelected(const int taskNum);
	
	// DISPLAY FUNCTIONS
	void displayFull(const int taskNum) const;
	void displayPriority(const int taskNum) const;

	// READ AND WRITE FUNCTIONS
	void write(const int taskMax, ofstream& file);
	void read(ifstream& file);
};

#endif