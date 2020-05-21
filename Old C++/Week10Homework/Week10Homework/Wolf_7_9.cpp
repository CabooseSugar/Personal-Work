/**************************************************************************************
* file name: Wolf_7_9
* programmer name: Kyle Wolf
* date created: 4/6/18
* date of last revision:
* details of the revision:
* short description: Convert a prefix expression to a postfix one
***************************************************************************************/
#include <iostream>;
#include <string>;
#include "stackClass.h"
using namespace std;

int main()
{
	Stack<char> test;
	string expression;
	int index, size;
	char entry, more;
	bool moreExpressions = true;

	while (moreExpressions == true)
	{
		index = 0;
		size = 0;

		cout << "Enter an expresson: ";
		getline(cin, expression);

		cout << "Postfix version: ";

		for (int i = 0; expression[i] != '\0'; i++)
			size++;

		do {
			if (expression[index] == '(')
				test.push(expression[index]);

			else if (expression[index] >= 48 && expression[index] <= 57) // uses ASCII conversion for 0 - 9
			{
				entry = expression[index] - '0';
				cout << expression[index];
			}

			else if ((expression[index] >= 'A' && expression[index] <= 'Z')
				|| (expression[index] >= 'a' && expression[index] <= 'z'))
			{
				cout << expression[index];
			}

			else if (expression[index] == '+' ||
				expression[index] == '-' ||
				expression[index] == '*' ||
				expression[index] == '/')
				test.push(expression[index]);

			else
			{
				if (test.peek() != '+' &&
					test.peek() != '-' &&
					test.peek() != '*' &&
					test.peek() != '/')
				{
					cout << "\nError, operator expected but not present." << endl;
					exit;
				}

				cout << test.peek();
				test.pop();

				if (test.peek() != '(')
				{
					cout << "\nError, expected left parenthesis." << endl;
					exit;
				}

				test.pop(); // discards left parenthesis
			}
			index++;
		} while (index < size);

		while (1)
		{
			cout << "\nEnter another expression? Y/y for Yes, N/n for No: ";
			cin >> more;
			if (more == 'Y' || more == 'y')
			{
				cin.ignore();
				break;
			}
			if (more == 'N' || more == 'n')
			{
				moreExpressions = false;
				break;
			}
			else
				cout << "Invalid entry." << endl;
		}
	}
	
	cout << endl;
	return 0;
}