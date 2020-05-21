/* A circular queue is a Queue but a particular implementation of a queue. 
   It is very efficient. It is also quite useful in low level code, because insertion and 
   deletion are totally independent, which means that you don't have to worry about an 
   interrupt handler trying to do an insertion at the same time as your main code is doing 
   a deletion.
*/
#include <iostream>
using namespace std;
class cqueue
{
private:
	int *arr;
	int front, rear;
	int MAX;
public:
	cqueue(int maxsize = 10);
	void addq(int item);
	int delq();
	void display();
};
cqueue::cqueue(int maxsize)
{
	MAX = maxsize;
	arr = new int[MAX];
	front = rear = -1;
	for (int i = 0; i < MAX; i++)
		arr[i] = 0;
}
void cqueue::addq(int item)
{
	if ((rear + 1) % MAX == front)
	{
		cout << "\nQueue is full";
		return;
	}
	rear = (rear + 1) % MAX;
	arr[rear] = item;
	if (front == -1)
		front = 0;
}
int cqueue::delq()
{
	int data;
	if (front == -1)
	{
		cout << "\nQueue is empty";
		return NULL;
	}

	data = arr[front];
	arr[front] = 0;
	if (front == rear)
	{
		front = -1;
		rear = -1;
	}
	else
		front = (front + 1) % MAX;
	return data;
}
void cqueue::display()
{
	cout << endl;
	for (int i = 0; i < MAX; i++)
		cout << arr[i] << "  ";
	cout << endl;
}
void main()
{
	cqueue a(10);
	a.addq(14);
	a.addq(22);
	a.addq(13);
	a.addq(-6);
	a.addq(25);
	cout << "\nElements in the circular queue: ";
	a.display();
	int i = a.delq();
	cout << "Item deleted: " << i;
	i = a.delq();
	cout << "\nItem deleted: " << i;
	cout << "\nElements in the circular queue after deletion: ";
	a.display();
	a.addq(21);
	a.addq(17);
	a.addq(18);
	a.addq(9);
	a.addq(20);
	cout << "Elements in the circular queue after addition: ";
	a.display();
	a.addq(32);
	cout << "Elements in the circular queue after addition: ";
	a.display();
}

/*

Elements in the circular queue:
14  22  13  -6  25  0  0  0  0  0
Item deleted: 14
Item deleted: 22
Elements in the circular queue after deletion:
0  0  13  -6  25  0  0  0  0  0
Elements in the circular queue after addition:
0  0  13  -6  25  21  17  18  9  20
Elements in the circular queue after addition:
32  0  13  -6  25  21  17  18  9  20
Press any key to continue . . .
*/
