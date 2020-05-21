#include <iostream>
#include "PriorityQueue.h"
using namespace std;

int main() {
	PriorityQueue<int> q;

	for (int i = 0; i < 100; i++) {
		q.insert((rand() % 19), (rand() % 19));
	}

	q.insert(21, 1);
	q.insert(20, 0);
	
	cout << "Current size: " << q.getSize() << endl;
	cout << "Removing highest priority elem: " << q.removeHighestElem() << endl;
	cout << "Current size: " << q.getSize() << endl;
	cout << "Elem w/ highest priority: " << q.getHighestElem() << endl;
	cout << "Current size: " << q.getSize() << endl;
	cout << "Highest priority in queue: " << q.getHighestPriority() << endl;



}
