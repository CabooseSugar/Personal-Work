// DEFINES THE FUNCTIONS OF THE LINKED LIST IN GoalList.H
#include "GoalList.h" 
using namespace std;

size_t listLength(GoalList* headPtr)
{
	size_t answer = 0;

	GoalList* cursor = headPtr;

	if (headPtr == NULL)
		return 0;

	for (cursor; cursor != NULL; cursor = cursor->link)
		answer++;

	return answer;
}

void addEmptyNode(GoalList*& headPtr)
{
	GoalList* cursor = headPtr;

	if (headPtr == NULL)
	{
		headPtr = new GoalList;
		headPtr->link = NULL;
		return;
	}

	while (cursor->link != NULL)
		cursor = cursor->link;

	cursor->link = new GoalList;
	cursor->link->link = NULL;
}

void deleteHeadNode(GoalList*& headPtr)
{
	GoalList* removePtr;

	removePtr = headPtr;
	headPtr = headPtr->link;
	delete removePtr;
}

void deleteNode(GoalList* headPtr, GoalList* ptr)
{
	GoalList* previousPtr = headPtr;
	GoalList* removePtr = ptr;

	while (previousPtr->link != removePtr)
		previousPtr = previousPtr->link;

	previousPtr->link = removePtr->link;
	delete removePtr;
}

GoalList* goToNode(GoalList* headPtr, size_t position)
{
	GoalList* cursor = headPtr;

	if (headPtr == NULL)
		return NULL;

	if (position == 1)
		return cursor;

	for (int i = 1; i < position; i++)
		cursor = cursor->link;

	return cursor;
}

void swapNodes(GoalList* ptr1, GoalList* ptr2)
{
	string tempName, tempDesc;
	int tempCategory, tempPriority;
	double tempTime;
	char tempStatus;
	date tempStartDate;
	date tempDueDate;
	Obj tempObj;

	tempName = ptr1->name;
	tempDesc = ptr1->description;
	tempPriority = ptr1->priority;
	tempStatus = ptr1->status;
	tempStartDate = ptr1->startDate;
	tempDueDate = ptr1->dueDate;
	tempObj = ptr1->objective;

	ptr1->name = ptr2->name;
	ptr1->description = ptr2->description;
	ptr1->priority = ptr2->priority;
	ptr1->status = ptr2->status;
	ptr1->startDate = ptr2->startDate;
	ptr1->dueDate = ptr2->dueDate;
	ptr1->objective = ptr2->objective;

	ptr2->name = tempName;
	ptr2->description = tempDesc;
	ptr2->priority = tempPriority;
	ptr2->status = tempStatus;
	ptr2->startDate = tempStartDate;
	ptr2->dueDate = tempDueDate;
	ptr2->objective = tempObj;
}