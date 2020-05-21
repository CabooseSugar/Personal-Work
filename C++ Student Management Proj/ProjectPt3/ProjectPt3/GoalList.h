// LINKED LIST FOR USE WITH GOAL.H
#ifndef GOALLIST_H
#define GOALLIST_H

#include "date.h"
#include "Obj.h"
#include <vector>
#include <string>
using namespace std;

struct GoalList
{
	string name, description;
	int priority;
	char status;
	date startDate, dueDate; // declaring objects of date class
	Obj objective;
	GoalList* link;
};

size_t listLength(GoalList* headPtr);
void addEmptyNode(GoalList*& headPtr);
void deleteHeadNode(GoalList*& headPtr);
void deleteNode(GoalList* headPtr, GoalList* ptr);
GoalList* goToNode(GoalList* headPtr, size_t position);
void swapNodes(GoalList* ptr1, GoalList* ptr2);

#endif 