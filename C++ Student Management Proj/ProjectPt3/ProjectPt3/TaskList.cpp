// DEFINES THE FUNCTIONS OF THE LINKED LIST IN TASKLIST.H
#include "TaskList.h" 
using namespace std;

size_t listLength(TaskList* headPtr)
{
	size_t answer = 0;

	TaskList* cursor = headPtr;

	if (headPtr == NULL)
		return 0;

	for (cursor; cursor != NULL; cursor = cursor->link)
		answer++;

	return answer;
}

void addEmptyNode(TaskList*& headPtr)
{
	TaskList* cursor = headPtr;

	if (headPtr == NULL)
	{
		headPtr = new TaskList;
		headPtr->link = NULL;
		return;
	}

	while (cursor->link != NULL)
		cursor = cursor->link;

	cursor->link = new TaskList;
	cursor->link->link = NULL;
}

void deleteHeadNode(TaskList*& headPtr)
{
	TaskList* removePtr;

	removePtr = headPtr;
	headPtr = headPtr->link;
	delete removePtr;
}

void deleteNode(TaskList* headPtr, TaskList* ptr)
{
	TaskList* previousPtr = headPtr;
	TaskList* removePtr = ptr;

	while (previousPtr->link != removePtr)
		previousPtr = previousPtr->link;

	previousPtr->link = removePtr->link;
	delete removePtr;
}

TaskList* goToNode(TaskList* headPtr, size_t position)
{
	TaskList* cursor = headPtr;

	if (headPtr == NULL)
		return NULL;

	if (position == 1)
		return cursor;

	for (int i = 1; i < position; i++)
		cursor = cursor->link;

	return cursor;
	
}