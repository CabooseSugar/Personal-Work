#include <iostream>
#include <vector>
#include <stack>
#include <queue>
using namespace std;

int main()
{
	queue<int> q;
	stack<int> s;
	vector<int> v;

	v.push_back(3);
	v.push_back(6);
	v.push_back(4);
	
	cout << "Vector contents:" << endl;
	vector<int>::iterator vi;
	for (vi = v.begin(); vi != v.end(); vi++)
		cout << *vi << endl;

	v.pop_back();
	cout << "Vector contents:" << endl;
	
	for (vi = v.begin(); vi != v.end(); vi++)
		cout << *vi << endl;




	return 0;
};