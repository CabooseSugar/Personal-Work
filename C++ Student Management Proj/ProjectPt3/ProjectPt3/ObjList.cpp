// DEFINES THE FUNCTIONS OF THE LINKED LIST IN OBJLIST.H
#include "ObjList.h" 
using namespace std;

size_t listLength(ObjList* headPtr)
{
	size_t answer = 0;

	ObjList* cursor = headPtr;

	if (headPtr == NULL)
		return 0;

	for (cursor; cursor != NULL; cursor = cursor->link)
		answer++;

	return answer;
}

void addEmptyNode(ObjList*& headPtr)
{
	ObjList* cursor = headPtr;

	if (headPtr == NULL)
	{
		headPtr = new ObjList;
		headPtr->link = NULL;
		return;
	}

	while (cursor->link != NULL)
		cursor = cursor->link;

	cursor->link = new ObjList;
	cursor->link->link = NULL;
}

void deleteHeadNode(ObjList*& headPtr)
{
	ObjList* removePtr;

	removePtr = headPtr;
	headPtr = headPtr->link;
	delete removePtr;	
}

void deleteNode(ObjList* headPtr, ObjList* ptr)
{
	ObjList* previousPtr = headPtr;
	ObjList* removePtr = ptr;

	while (previousPtr->link != removePtr)
		previousPtr = previousPtr->link;

	previousPtr->link = removePtr->link;
	delete removePtr;
}

ObjList* goToNode(ObjList* headPtr, size_t position)
{
	ObjList* cursor = headPtr;

	if (headPtr == NULL)
		return NULL;

	if (position == 1)
		return cursor;

	for (int i = 1; i < position; i++)
		cursor = cursor->link;
	
	return cursor;
}

void swapNodes(ObjList* ptr1, ObjList* ptr2)
{
	string tempName, tempDesc;
	vector<string> tempResources;
	int tempCategory, tempPriority;
	double tempTime;
	char tempStatus;
	date tempStartDate;
	date tempDueDate;
	Task tempTask;

	tempName = ptr1->name;
	tempDesc = ptr1->description;
	tempResources = ptr1->resources;
	tempCategory = ptr1->category;
	tempPriority = ptr1->priority;
	tempTime = ptr1->time;
	tempStatus = ptr1->status;
	tempStartDate = ptr1->startDate;
	tempDueDate = ptr1->dueDate;
	tempTask = ptr1->task;

	ptr1->name = ptr2->name;
	ptr1->description = ptr2->description;
	ptr1->resources = ptr2->resources;
	ptr1->category = ptr2->category;
	ptr1->priority = ptr2->priority;
	ptr1->time = ptr2->time;
	ptr1->status = ptr2->status;
	ptr1->startDate = ptr2->startDate;
	ptr1->dueDate = ptr2->dueDate;
	ptr1->task = ptr2->task;

	ptr2->name = tempName;
	ptr2->description = tempDesc;
	ptr2->resources = tempResources;
	ptr2->category = tempCategory;
	ptr2->priority = tempPriority;
	ptr2->time = tempTime;
	ptr2->status = tempStatus;
	ptr2->startDate = tempStartDate;
	ptr2->dueDate = tempDueDate;
	ptr2->task = tempTask;
}