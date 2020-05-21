// LINKED LIST FOR USE WITH OBJ.H
#ifndef OBJLIST_H
#define OBJLIST_H

#include "date.h"
#include "Task.h"
#include <vector>
#include <string>
using namespace std;

struct ObjList
{
	string name, description;
	vector <string> resources;
	int category, priority;
	double time;
	char status;
	date startDate, dueDate; // declaring objects of date class
	Task task;
	ObjList* link;
};

size_t listLength(ObjList* headPtr);
void addEmptyNode(ObjList*& headPtr);
void deleteHeadNode(ObjList*& headPtr);
void deleteNode(ObjList* headPtr, ObjList* ptr);
ObjList* goToNode(ObjList* headPtr, size_t position);
void swapNodes(ObjList* ptr1, ObjList* ptr2);

#endif // !OBJLIST_H
