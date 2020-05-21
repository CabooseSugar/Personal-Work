#include <cassert>
#include "ArrayQueue.h"

ArrayQueue::ArrayQueue()
{
	queue_in = 0;
}

void ArrayQueue::enqueue(int j)
{
	assert(isFull() == FALSE);

	storage[queue_in++] = j;
}

int ArrayQueue::dequeue()
{
	int first = storage[0];

	assert(isEmpty() == FALSE);

	for (int i = 0; i < queue_in; i++)
		storage[i] = storage[i+1];
	queue_in--;	

	return first;
}

int ArrayQueue::isEmpty()
{
	if (queue_in == 0)
		return TRUE;

	return FALSE;
}

int ArrayQueue::isFull()
{
	if (queue_in == MAXQUEUE)
		return TRUE;
	
	return FALSE;
}