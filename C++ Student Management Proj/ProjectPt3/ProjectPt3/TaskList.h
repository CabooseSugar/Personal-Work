// LINKED LIST FOR USE WITH TASK.H
#ifndef TASKLIST_H
#define TASKLIST_H

#include "date.h"
#include <vector>
#include <string>
using namespace std;

struct TaskList
{
	string name, description;	
	vector <string> resources;
	double time;
	char status;
	date startDate, dueDate; // declaring objects of date class
	TaskList* link;
};

size_t listLength(TaskList* headPtr);
void addEmptyNode(TaskList*& headPtr);
void deleteHeadNode(TaskList*& headPtr);
void deleteNode(TaskList* headPtr, TaskList* ptr);
TaskList* goToNode(TaskList* headPtr, size_t position);

#endif
