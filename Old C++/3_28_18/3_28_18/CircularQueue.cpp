/* A circular queue is a Queue but a particular implementation of a queue. 
   It is very efficient. It is also quite useful in low level code, because insertion and 
   deletion are totally independent, which means that you don't have to worry about an 
   interrupt handler trying to do an insertion at the same time as your main code is doing 
   a deletion.

Algorithm for Insertion:-
Step-1: If "rear" of the queue is pointing to the last position then go to step-2 or else step-3
Step-2: make the "rear" value as 0
Step-3: increment the "rear" value by one
Step-4:

If the "front" points where "rear" is pointing and the queue holds a not NULL value for it, 
then its a "queue overflow" state, so quit; else go to step-4.2 
insert the new value for the queue position pointed by the "rear"

Algorithm for deletion:-
Step-1: If the queue is empty then say "empty queue" and quit; else continue
Step-2: Delete the "front" element
Step-3: If the "front" is pointing to the last position of the queue then step-4 else step-5
Step-4: Make the "front" point to the first position in the queue and quit
Step-5: Increment the "front" position by one
*/

/****** C Program For Implemetation Of Circular Queue *******/
#include <iostream>
#include <cstdlib>
using namespace std;

#define MAX 5

struct queue
{
	int arr[MAX];
	int rear, front;
};

int isempty(struct queue *p)
{
	if(p->front == p->rear)
	return 1;
	else
	return 0;
}

void insertq(struct queue *p,int v)
{
	int t;
	t = (p->rear+1) % MAX;
	if(t == p->front)
		cout << "\nQueue Overflow\n";
	else
	{
		p->rear = t;
		p->arr[p->rear] = v;
	}
}

int removeq(struct queue *p)
{
	if(isempty(p))
	{
		cout << "\nQueue Underflow";
		exit(0);
	}
	else
	{
		p->front = (p->front + 1) % MAX;
		return(p->arr[p->front]);
	}
}

void main()
{
	struct queue q;
	
	q.rear = q.front = 0;
	insertq(&q, 7);
	insertq(&q, 10);
	insertq(&q, 12);
	insertq(&q, 15);
	insertq(&q, 8);
	cout << endl << removeq(&q) << endl;
	cout << endl << removeq(&q) << endl;
	cout << endl << removeq(&q) << endl;
	cout << endl << removeq(&q) << endl;
	removeq(&q);

	cout << endl;
	
	return;
}
/************** OUTPUT ****************

Queue Overflow

7
10
12
15

Queue Underflow */
